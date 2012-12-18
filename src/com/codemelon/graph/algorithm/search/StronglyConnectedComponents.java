package com.codemelon.graph.algorithm.search;

import java.util.Iterator;
import java.util.Map;

import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.graph.GraphFactory;
import com.codemelon.graph.graph.Transposer;
import com.codemelon.graph.algorithm.search.OrderedDepthFirstSearch;
import com.codemelon.graph.vertex.ComponentVertex;
import com.codemelon.graph.vertex.DfsVertex;
import com.codemelon.graph.vertex.OrderedDfsVertex;
import com.codemelon.graph.vertex.VertexFactory;
import com.codemelon.graph.vertex.ReverseSearchOrderComparator;

/**
 * Identify the strongly connected components in a graph using an int value
 * to mark the component to which each vertex belongs.
 * Cf. <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, p. 617.
 * The run() method of StronglyConnectedComponents creates a Transposer object
 * in which the target graph has vertices of type U, which must be a subclass
 * of OrderedDfsVertex. The vertices of the input graph must be subclasses
 * of DfsVertex and must support component labeling but need not themselves
 * support ordered depth-first search.
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public class StronglyConnectedComponents<T extends DfsVertex & ComponentVertex, 
		U extends OrderedDfsVertex> {
	private AbstractGraph<T> graph;
	private VertexFactory<U> vertexFactory;
	private GraphFactory<U> graphFactory;
	
	/**
	 * Prepare to mark the graph for strongly connected components.
	 * No changes to the graph are made when the graph is passed into the constructor.
	 * @param graph graph for which strongly connected components are to be determined.
	 */
	public StronglyConnectedComponents(AbstractGraph<T> graph, VertexFactory<U> vertexFactory,
			GraphFactory<U> graphFactory) {
		this.graph = graph;
		this.vertexFactory = vertexFactory;
		this.graphFactory = graphFactory;
	}
	/**
	 * Marks the strongly connected components in the graph by setting
	 * the treeNumber field of each vertex accordingly. Vertices in the
	 * same strongly connected component will have the same tree number, 
	 * and vertices belonging to different components will have different
	 * tree numbers
	 * @return the Transposer object created when setting the vertex tree numbers.
	 * This object contains both the transpose graph that was created and
	 * a map from vertices of the original graph to the transpose graph.
	 */
	public Transposer<T, U> run() {
		new DepthFirstSearch<T>(graph).search();
		Transposer<T, U> transposer = new Transposer<T, U>(graph, vertexFactory, graphFactory);
		AbstractGraph<U> transposeGraph = transposer.getTransposeGraph();
		Map<T, U> vertexMap = transposer.getVertexMap();
		// set searchOrder field in transpose graph to finish time in depth-first search
		Iterator<T> it = graph.vertexIterator();
		T v;
		while (it.hasNext()) {
			v = it.next();
			vertexMap.get(v).setSearchOrder(v.getFinishTime());
		}
		new OrderedDepthFirstSearch<U>(transposeGraph, new ReverseSearchOrderComparator()).search();
		// Finally, set the appropriate tree numbers in the original graph
		it = graph.vertexIterator();
		while (it.hasNext()) {
			v = it.next();
			v.setComponent(vertexMap.get(v).getComponent());
		}
		return transposer;
	}
}
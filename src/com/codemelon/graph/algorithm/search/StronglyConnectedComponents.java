package com.codemelon.graph.algorithm.search;

import java.util.Iterator;
import java.util.Map;

import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.vertex.ComponentVertex;
import com.codemelon.graph.vertex.DfsVertex;
import com.codemelon.graph.vertex.OrderedDfsVertex;
import com.codemelon.graph.vertex.VertexFactory;

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
	
	/**
	 * Prepare to mark the graph for strongly connected components.
	 * No changes to the graph are made when the graph is passed into the constructor.
	 * @param graph graph for which strongly connected components are to be determined.
	 */
	public StronglyConnectedComponents(AbstractGraph<T> graph, VertexFactory<U> vertexFactory) {
		this.graph = graph;
		this.vertexFactory = vertexFactory;
	}
}

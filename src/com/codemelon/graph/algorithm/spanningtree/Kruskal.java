package com.codemelon.graph.algorithm.spanningtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.common.DisjointSet;
import com.codemelon.graph.graph.UndirectedWeightedEdgeGraph;
import com.codemelon.graph.graph.EdgeResetter;
import com.codemelon.graph.vertex.UndirectedKruskalVertex;
import com.codemelon.graph.vertex.VertexFactory;
import com.codemelon.graph.edge.SpanningTreeEdgeData;
import com.codemelon.graph.edge.UndirectedWeightedEdge;

/**
 * Implementation of Kruskal's algorithm for growing a minimum spanning
 * tree. Follows
 * <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, pp. 631ff.
 * This implementation allows clients to retrieve a minimum spanning tree
 * in either of 2 ways:
 * <ol>
 * <li>Mark all edges belonging to the minimum spanning tree black and all other edges
 * white, or</li>
 * <li>Produce a new graph which is a minimum spanning tree for the input graph.</li>
 * </ol>
 * @author Marshall Farrier
 * @my.created Dec 20, 2012
 * @my.edited Dec 20, 2012
 */
public class Kruskal<E extends SpanningTreeEdgeData, V extends UndirectedKruskalVertex<E>> {
	private UndirectedWeightedEdgeGraph<E, V> graph;
	private DisjointSet<V> vertexDisjointSet;
	private ArrayList<UndirectedWeightedEdge<E, V>> edges;
	private HashMap<V, V> vertexMap;
	private UndirectedWeightedEdgeGraph<E, V> spanningTree;
	private VertexFactory<V> vertexFactory;
	private final Comparator<UndirectedWeightedEdge<E, V>> COMPARATOR = new Comparator<UndirectedWeightedEdge<E, V>>() {
		@Override
		public int compare(UndirectedWeightedEdge<E, V> e1, UndirectedWeightedEdge<E, V> e2) {
			if (e1.weight() < e2.weight()) { return -1; }
			if (e2.weight() < e1.weight()) { return 1; }
			return 0;
		}		
	};
	/**
	 * Create a new object for generating a minimum spanning tree using Kruskal's
	 * algorithm. If a separate spanning tree will not be needed (i.e., the 
	 * relevant edges only need to be marked in the original graph), null may be
	 * passed as vertex factory. If null is passed, a <code>NullPointerException</code> will
	 * result if generateTree() is called.
	 * @param graph graph for which a minimum spanning tree is to be determined
	 * @param vertexFactory factory method for creating new vertices for the spanning
	 * tree graph that can be generated by calling generateTree()
	 */
	public Kruskal(UndirectedWeightedEdgeGraph<E, V> graph, VertexFactory<V> vertexFactory) {
		this.graph = graph;
		this.vertexFactory = vertexFactory;
		edges = null;
		vertexDisjointSet = null;
		vertexMap = null;
		spanningTree = null;		
	}
	/**
	 * Set edges in minimum spanning tree to BLACK, all other edges are 
	 * set to WHITE
	 */
	public void markEdges() {
		initForMarking();
		for (UndirectedWeightedEdge<E, V> edge : edges) {
			if (vertexDisjointSet.findSet(edge.from()) 
					!= vertexDisjointSet.findSet(edge.to())) {
				edge.from().setEdgeColor(edge.to(), Color.BLACK);
				vertexDisjointSet.union(edge.from(), edge.to());				
			}
		}
	}
	/**
	 * Creates and returns a minimum spanning tree. Running this method does not modify
	 * the original graph. Corresponding vertices can be determined by running getVertexMap().
	 * The 2 graphs will have the same weight epsilon for
	 * determining the accuracy used for weight equality, and the weights of edges between
	 * corresponding vertices will be the same. With the exception of edge weights and weight epsilon,
	 * however, all vertex and edge data in the spanning tree will be set to the default value,
	 * regardless of the corresponding value in the original graph.
	 * @return a spanning tree of the original graph.
	 */
	public UndirectedWeightedEdgeGraph<E, V> generateTree() {
		initForGenerateTree();
		for (UndirectedWeightedEdge<E, V> edge : edges) {
			if (vertexDisjointSet.findSet(edge.from()) != vertexDisjointSet.findSet(edge.to())) {
				vertexMap.get(edge.from()).addAdjacency(vertexMap.get(edge.to()));
				vertexMap.get(edge.from()).setEdgeWeight(vertexMap.get(edge.to()), edge.weight());
				vertexDisjointSet.union(edge.from(), edge.to());
			}		
		}
		return spanningTree;
	}
	/**
	 * Returns a map showing which vertex in the spanning tree corresponds to a given
	 * vertex in the original graph. Edges between corresponding vertices in the 2 graphs
	 * will have the same weight. The keys of this map are the vertices in the original
	 * graph, and the values are vertices in the spanning tree generated when generateTree()
	 * is called.
	 * @return map from vertices in the original graph to vertices in the spanning tree
	 * @throws IllegalStateException if this method is called before generateTree(). In this case, the map
	 * has not been created yet.
	 */
	public Map<V, V> getVertexMap() {
		if (vertexMap == null) {
			throw new IllegalStateException("Map must first be created by running generateTree()!");
		}
		return vertexMap;		
	}
	private void initForMarking() {
		EdgeResetter.resetColors(graph);
		initForAll();
	}
	private void initForGenerateTree() {
		vertexMap = new HashMap<V, V>(graph.vertexCount());
		spanningTree = new UndirectedWeightedEdgeGraph<E, V>(graph.vertexCount(), graph.getWeightEpsilon());
		Iterator<V> it = graph.vertexIterator();
		V v;
		while (it.hasNext()) {
			v = it.next();
			vertexMap.put(v, vertexFactory.newVertex());
			spanningTree.addVertex(vertexMap.get(v));
		}
		initForAll();
	}
	private void initForAll() {
		vertexDisjointSet = new DisjointSet<V>(graph.getVertices());
		edges = new ArrayList<UndirectedWeightedEdge<E, V>>(graph.getWeightedEdges());
		Collections.sort(edges, COMPARATOR);
	}
}

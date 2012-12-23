package com.codemelon.graph.algorithm.spanningtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.common.DisjointSet;
import com.codemelon.graph.graph.UndirectedWeightedEdgeGraph;
import com.codemelon.graph.graph.EdgeResetter;
import com.codemelon.graph.vertex.UndirectedKruskalVertex;
import com.codemelon.graph.edge.EdgeDataFactory;
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
public class Kruskal<E extends SpanningTreeEdgeData, U extends EdgeDataFactory<E>, V extends UndirectedKruskalVertex<E, U>> {
	private UndirectedWeightedEdgeGraph<E, U, V> graph;
	private DisjointSet<V> vertexDisjointSet;
	private ArrayList<UndirectedWeightedEdge<E, V>> edges;
	private HashMap<V, V> vertexMap;
	private UndirectedWeightedEdgeGraph<E, U, V> spanningTree;
	private final Comparator<UndirectedWeightedEdge<E, V>> COMPARATOR = new Comparator<UndirectedWeightedEdge<E, V>>() {
		@Override
		public int compare(UndirectedWeightedEdge<E, V> e1, UndirectedWeightedEdge<E, V> e2) {
			if (e1.weight() < e2.weight()) { return -1; }
			if (e2.weight() < e1.weight()) { return 1; }
			return 0;
		}		
	};
	
	public Kruskal(UndirectedWeightedEdgeGraph<E, U, V> graph) {
		this.graph = graph;
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
		initializeForMarking();
		for (UndirectedWeightedEdge<E, V> edge : edges) {
			if (vertexDisjointSet.findSet(edge.from()) 
					!= vertexDisjointSet.findSet(edge.to())) {
				edge.from().setEdgeColor(edge.to(), Color.BLACK);
				vertexDisjointSet.union(edge.from(), edge.to());				
			}
		}
	}
	private void initializeForMarking() {
		EdgeResetter.resetColors(graph);
		vertexDisjointSet = new DisjointSet<V>(graph.getVertices());
		edges = new ArrayList<UndirectedWeightedEdge<E, V>>(graph.getWeightedEdges());
		Collections.sort(edges, COMPARATOR);
	}
}

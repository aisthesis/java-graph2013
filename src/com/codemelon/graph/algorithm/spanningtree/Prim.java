package com.codemelon.graph.algorithm.spanningtree;

import java.util.PriorityQueue;

import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.edge.SpanningTreeEdgeData;
import com.codemelon.graph.graph.UndirectedWeightedEdgeGraph;
import com.codemelon.graph.vertex.UndirectedPrimVertex;
import com.codemelon.graph.vertex.VertexFactory;

/**
 * @author Marshall Farrier
 * @my.created Dec 24, 2012
 * @my.edited Dec 24, 2012
 */
public class Prim<E extends SpanningTreeEdgeData, U extends EdgeDataFactory<E>, V extends UndirectedPrimVertex<E, U>, 
		T extends VertexFactory<V>> {
	private UndirectedWeightedEdgeGraph<E, U, V> graph;
	private PriorityQueue<V> queue;
	
	public Prim(UndirectedWeightedEdgeGraph<E, U, V> graph) {
		this.graph = graph;
		queue = null;
	}
	
	private void initForMarking(V root) {
		
	}
}

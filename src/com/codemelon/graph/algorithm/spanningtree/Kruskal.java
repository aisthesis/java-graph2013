package com.codemelon.graph.algorithm.spanningtree;

import com.codemelon.graph.common.DisjointSet;
import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.vertex.KruskalVertex;
import com.codemelon.graph.edge.SpanningTreeEdgeData;

/**
 * Implementation of Kruskal's algorithm for growing a minimum spanning
 * tree. Follows
 * <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, pp. 631ff.
 * @author Marshall Farrier
 * @my.created Dec 20, 2012
 * @my.edited Dec 20, 2012
 */
public class Kruskal<E extends SpanningTreeEdgeData, V extends KruskalVertex<E>> {
	private AbstractGraph<V> graph;
	private DisjointSet<V> vertexDisjointSet;
}

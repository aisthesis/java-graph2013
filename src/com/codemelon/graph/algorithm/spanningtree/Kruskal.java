package com.codemelon.graph.algorithm.spanningtree;

import com.codemelon.graph.common.DisjointSet;
import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.vertex.KruskalVertex;

/**
 * Implementation of Kruskal's algorithm for growing a minimum spanning
 * tree. Follows
 * <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, pp. 631ff.
 * @author Marshall Farrier
 * @my.created Dec 20, 2012
 * @my.edited Dec 20, 2012
 */
public class Kruskal<T extends KruskalVertex> {
	private AbstractGraph<T> graph;
	private DisjointSet<T> vertexDisjointSet;
}

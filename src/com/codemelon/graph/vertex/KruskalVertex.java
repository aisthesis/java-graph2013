package com.codemelon.graph.vertex;

import com.codemelon.graph.edge.SpanningTreeEdgeData;

/**
 * Interface specifying the necessary characteristics of vertices for graphs on which Kruskal's algorithm
 * can run.
 * @author Marshall Farrier
 * @my.created Dec 20, 2012
 * @my.edited Dec 20, 2012
 */
public interface KruskalVertex<E extends SpanningTreeEdgeData> extends EdgeWeightVertex<E>, EdgeColorVertex<E> {
}

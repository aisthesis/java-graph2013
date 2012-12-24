package com.codemelon.graph.vertex;

import com.codemelon.graph.edge.SpanningTreeEdgeData;

/**
 * Interface specifying the necessary characteristics of vertices for graphs on which Prim's algorithm
 * can run.
 * @author Marshall Farrier
 * @my.created Dec 24, 2012
 * @my.edited Dec 24, 2012
 */
public interface PrimVertex<E extends SpanningTreeEdgeData> extends KruskalVertex<E>, WeightedVertex, ColoredVertex, ChildVertex {
}

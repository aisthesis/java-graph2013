package com.codemelon.graph.vertex;

/**
 * Utility interface used as shorthand for vertices that implement ChildVertex, ColoredVertex,
 * and DistanceVertex, as needed for breadth-first search
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public interface BfsVertex extends Vertex, ChildVertex, ColoredVertex,
		DistanceVertex {
}

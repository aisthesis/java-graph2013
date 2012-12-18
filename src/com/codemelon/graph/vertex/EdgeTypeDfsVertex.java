package com.codemelon.graph.vertex;

/**
 * Utility interface used as shorthand for vertices that implement DfsVertex, ChildVertex
 * and EdgeTypeVertex, as needed for a depth-first search in which edge type is to be
 * determined.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public interface EdgeTypeDfsVertex extends DfsVertex, ChildVertex, EdgeTypeVertex {
}

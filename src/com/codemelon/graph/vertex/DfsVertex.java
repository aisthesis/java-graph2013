package com.codemelon.graph.vertex;

/**
 * Utility interface used as shorthand for vertices that implement ChildVertex, ColoredVertex, 
 * EdgeTypeVertex and VisitedVertex, as needed for depth-first search
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public interface DfsVertex extends ChildVertex, ColoredVertex, EdgeTypeVertex,
		VisitedVertex {
}

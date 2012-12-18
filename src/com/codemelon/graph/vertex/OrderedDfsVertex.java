package com.codemelon.graph.vertex;

/**
 * Utility interface used as shorthand for vertices that implement ColoredVertex, VisitedVertex,
 * OrderedSearchVertex and ComponentVertex, as needed for ordered depth-first search.
 * Note that ordered depth-first search doesn't assign parents or edge types, so those
 * fields (required for basic depth-first search) are not included in the specification
 * for this vertex type.
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public interface OrderedDfsVertex extends DfsVertex, OrderedSearchVertex, ComponentVertex {
}

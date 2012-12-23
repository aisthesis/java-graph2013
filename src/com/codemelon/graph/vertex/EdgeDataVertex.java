package com.codemelon.graph.vertex;

/**
 * Specification for vertices supporting edge data. We shouldn't really need a setter here,
 * since access to the pre-existing edge-data object ensures that we can modify the data
 * it contains.
 * @author Marshall Farrier
 * @my.created Dec 22, 2012
 * @my.edited Dec 22, 2012
 */
public interface EdgeDataVertex<T> extends Vertex {
	/**
	 * Get data for a particular edge.
	 * @param to head of the edge for which to retrieve data
	 * @return the data for the given edge
	 */
	public T getEdgeData(EdgeDataVertex<T> to);
}

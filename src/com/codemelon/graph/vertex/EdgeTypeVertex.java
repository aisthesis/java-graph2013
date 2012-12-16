package com.codemelon.graph.vertex;

import com.codemelon.graph.edge.EdgeType;

/**
 * Vertex that maintains an EdgeType for its adjacencies
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public interface EdgeTypeVertex extends Vertex {
	/**
	 * Set the type of the edge from the calling vertex to the vertex passed
	 * as parameter
	 * @param to head of the edge for which to set the type
	 * @param edgeType type to which to set the edge (TREE, BACK, FORWARD, CROSS, UNKNOWN)
	 */
	public void setEdgeType(EdgeTypeVertex to, EdgeType edgeType);
	/**
	 * Retrieve the type of the edge from the calling vertex to the vertex passed
	 * as parameter.
	 * @param to head of the edge for which to retrieve the type
	 * @return the type of the given edge (TREE, BACK, FORWARD, CROSS, UNKNOWN)
	 */
	public EdgeType getEdgeType(EdgeTypeVertex to);
}

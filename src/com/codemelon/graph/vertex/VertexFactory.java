package com.codemelon.graph.vertex;

/**
 * Requires a factory method for creating new vertices of the given type.
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public interface VertexFactory<V extends Vertex> {
	/**
	 * Creates an instance of the given type of vertex
	 * @return a new instance of the given vertex type
	 */
	public V newVertex();
}

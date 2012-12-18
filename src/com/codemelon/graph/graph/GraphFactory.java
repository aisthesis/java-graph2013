package com.codemelon.graph.graph;

import java.util.Collection;

import com.codemelon.graph.vertex.Vertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public interface GraphFactory<T extends Vertex> {
	/**
	 * Creates a graph with the default initial capacity.
	 * @return a new graph having the given vertex type
	 */
	public AbstractGraph<T> newGraph();/**
	 * Creates a graph with the specified initial capacity.
	 * @param initialVertices the initial vertex capacity of the graph
	 * @return a new graph having the given vertex type and with the specified initial
	 * vertex capacity
	 */
	public AbstractGraph<T> newGraph(int initialVertices);
	/**
	 * Creates a graph whose initial vertices are those contained in the given collection.
	 * @param vertices collection of vertices which are to belong to the given graph
	 * @return a graph containing the vertices in the collection (and no edges)
	 */
	public AbstractGraph<T> newGraph(Collection<T> vertices);
}

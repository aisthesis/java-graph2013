package com.codemelon.graph.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.codemelon.graph.vertex.Vertex;
/**
 * @author Marshall Farrier
 * @my.created Dec 13, 2012
 * @my.edited Dec 13, 2012
 */
public abstract class AbstractGraph<T extends Vertex> {
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private Set<T> vertices;
	/**
	 * Initialize graph to a default initial capacity of 16 vertices
	 */
	public AbstractGraph() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	/**
	 * Initialize graph to have capacity for the given number of vertices
	 * @param initialCapacity expected number of vertices
	 */
	public AbstractGraph(int initialCapacity) {
		vertices = new HashSet<T>(initialCapacity);
	}
	/**
	 * Use the vertices in a collection as the initial vertices in the graph
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 */
	public AbstractGraph(Collection<T> vertices) {
		this.vertices = new HashSet<T>(vertices);
		for (T v : vertices) {
			v.clearAdjacencies();
			v.setGraph(this);
		}		
	}
	/**
	 * Inserts vertex if it is not already present.
	 * @param vertex vertex to be inserted
	 * @return true if the graph did not already contained the specified vertex
	 */
	public final boolean addVertex(T vertex) {
		if (vertices.add(vertex)) {
			// vertex was not already present
			vertex.clearAdjacencies();
			vertex.setGraph(this);
			return true;
		}
		return false;		
	}
	/**
	 * Shows whether or not the graph contains the given vertex
	 * @param vertex the vertex whose presence in the graph is to be tested
	 * @return true if the vertex is present in the graph
	 */
	public final boolean containsVertex(Vertex vertex) {
		return vertices.contains(vertex);
	}
	/**
	 * Remove a vertex from the graph. The vertex is removed along with
	 * its adjacency list, and it is also removed from the adjacency set of the
	 * other vertices in the graph. After this method call, not only will
	 * the vertex not belong to the graph, but the adjacency list of the 
	 * vertex will also be cleared.
	 * @param vertex vertex to be removed from the graph
	 * @return true iff the vertex was found in the graph
	 */
	public final boolean removeVertex(Vertex vertex) {
		if (vertices.remove(vertex)) {
			vertex.clearAdjacencies();
			for (T u : vertices) {
				u.removeAdjacency(vertex);
			}
			vertex.setGraph(null);
			return true;
		}
		return false;		
	}
	/**
	 * Number of vertices in the graph
	 * @return number of vertices in the graph
	 */
	public final int vertexCount() {
		return vertices.size();
	}
	/**
	 * Returns a set containing the vertices in the graph.
	 * @return the set of vertices in the graph
	 */
	public final Set<T> getVertices() {
		return vertices;
	}
	/**
	 * Returns an iterator over the vertices in the graph
	 * @return iterator over the graph's vertices
	 */
	public final Iterator<T> vertexIterator() {
		return vertices.iterator();		
	}
	/**
	 * Shows whether or not the graph contains the specified edge
	 * @param from the tail or source vertex of the edge for which we are testing
	 * @param to the head or target vertex of the edge for which we are testing
	 * @return true if the edge from the given tail to the given head exists in the graph.
	 * @throws IllegalArgumentException if either vertex is not present in the graph
	 */
	public final boolean containsEdge(T from, T to) {
		if (!vertices.contains(from) || !vertices.contains(to)) {
			throw new IllegalArgumentException("Vertex not present in graph!");
		}
		return from.containsAdjacency(to);		
	}
	/**
	 * Returns the number of edges in the graph. This method is abstract because the
	 * implementation will differ in directed and undirected graphs.
	 * @return the number of edges in the graph
	 */
	public abstract int edgeCount();
}

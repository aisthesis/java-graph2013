/**
 * In this implementation the various graph types are mainly just wrappers
 * for vertices. Edges and edge data are contained in the vertices, whose
 * graph only guarantees that the head and tail of an edge belong to the
 * same graph.
 * <P>At the top of the class hierarchy is AbstractGraph<T extends Vertex>, which has 4 direct subclasses:
 * <ol>
 * <li>DirectedSimpleGraph<T extends DirectedSimpleVertex>, and</li>
 * <li>DirectedEdgeDataGraph<T, U extends EdgeDataFactory<T>, V extends DirectedEdgeDataVertex<T, U>> 
		extends AbstractGraph<V></li>
 * <li>UndirectedSimpleGraph<T extends UndirectedSimpleVertex>, and</li>
 * <li>UndirectedEdgeDataGraph<T, U extends EdgeDataFactory<T>, V extends UndirectedEdgeDataVertex<T, U>> 
		extends AbstractGraph<V></li>
 * </ol>
 * The reason for the extensive parameterization of an EdgeDataGraph is that its vertices
 * require 2 type parameters: One representing the type of the edge data it maintains and the other
 * a factory for creating such edge data objects. We need the factory because we need to create a new
 * edge data object whenever we add a new edge to the adjacency list of the vertex. As a result,
 * the parameterization of an EdgeData graph is much more elaborate than that for a SimpleGraph,
 * where the vertex only maintains information about the vertices to which it is adjacent but doesn't
 * map each vertex to an edge data object.
 * <P>The reason for not making the undirected graphs subclasses of directed graphs is that the
 * only method the graph actually contains is the edgeCount() method, which really needs to be final
 * in all cases: For an undirected graph it will return half of the number of directed edges
 * in the graph, and for a directed graph, all edges will be counted.
 * @author Marshall Farrier
 * @my.created Dec 13, 2012
 * @my.edited Dec 20, 2012
 */
package com.codemelon.graph.graph;

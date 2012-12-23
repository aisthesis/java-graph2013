package com.codemelon.graph.graph;

import java.util.Iterator;
import java.util.Set;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.EdgeColorData;
import com.codemelon.graph.vertex.EdgeColorVertex;
import com.codemelon.graph.vertex.Vertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 23, 2012
 * @my.edited Dec 23, 2012
 */
public class EdgeResetter {
	/**
	 * Reset the color of all edges in the graph to WHITE.
	 * @param graph graph whose edge colors are to be reset
	 */
	public static <E extends EdgeColorData, V extends EdgeColorVertex<E>> void resetColors(AbstractGraph<V> graph) {
		resetColors(graph, Color.WHITE);
	}
	/**
	 * Reset the color of all edges in the graph to the given value.
	 * @param graph graph whose edge colors are to be reset
	 * @param color value to which to set the color of all edges in the graph
	 */
	@SuppressWarnings("unchecked")
	public static <E extends EdgeColorData, V extends EdgeColorVertex<E>> void resetColors(AbstractGraph<V> graph, Color color) {
		Iterator<V> it = graph.vertexIterator();
		Set<? extends Vertex> adj;
		V from;
		while (it.hasNext()) {
			from = it.next();
			adj = from.getAdjacencies();
			for (Vertex to : adj) {
				from.setEdgeColor((EdgeColorVertex<E>) to, color);
			}
		}		
	}
	private EdgeResetter() {}
}

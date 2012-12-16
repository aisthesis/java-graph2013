package com.codemelon.graph.graph;

import java.util.Iterator;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.vertex.ChildVertex;
import com.codemelon.graph.vertex.DistanceVertex;
import com.codemelon.graph.vertex.VertexConstants;
import com.codemelon.graph.vertex.ColoredVertex;

/**
 * Static methods for resetting all vertices in a graph
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class VertexResetter {
	/**
	 * Reset the vertex properties used in breadth-first search
	 * @param graph graph whose vertices are to be reset
	 */
	public static <T extends ColoredVertex & ChildVertex & DistanceVertex> 
			void resetForBfs(AbstractGraph<T> graph) {
		resetColors(graph);
		resetParents(graph);
		resetDistances(graph);		
	}
	/**
	 * Reset the color of all vertices in the graph to white (typically signifies that the vertex
	 * has not yet been explored).
	 * @param graph graph whose vertices are to be reset
	 */
	public static void resetColors(AbstractGraph<? extends ColoredVertex> graph) {
		resetColors(graph, Color.WHITE);
	}
	/**
	 * Reset the color of all vertices in the graph to the given value.
	 * @param graph graph whose vertices are to be reset
	 * @param color value to which the color of all vertices is to be reset
	 */
	public static void resetColors(AbstractGraph<? extends ColoredVertex> graph, Color color) {
		Iterator<? extends ColoredVertex> it = graph.vertexIterator();
		while (it.hasNext()) {
			it.next().setColor(color);
		}
	}
	/**
	 * Reset the distance property of all vertices in the graph to the default value.
	 * @param graph graph whose vertices are to be reset
	 */
	public static void resetDistances(AbstractGraph<? extends DistanceVertex> graph) {
		resetDistances(graph, VertexConstants.DEFAULT_DISTANCE);
	}
	/**
	 * Reset the distance property of all vertices in the graph to the given value.
	 * @param graph graph whose vertices are to be reset
	 * @param distance value to which the distance property of all vertices is to be reset
	 */
	public static void resetDistances(AbstractGraph<? extends DistanceVertex> graph, int distance) {
		Iterator<? extends DistanceVertex> it = graph.vertexIterator();
		while (it.hasNext()) {
			it.next().setDistance(distance);
		}
	}
	/**
	 * Reset the parent of all vertices in the graph to null
	 * @param graph graph whose vertices are to be reset to have parent null
	 */
	public static void resetParents(AbstractGraph<? extends ChildVertex> graph) {
		Iterator<? extends ChildVertex> it = graph.vertexIterator();
		while (it.hasNext()) {
			it.next().setParent(null);
		}
	}
	private VertexResetter() {}
}

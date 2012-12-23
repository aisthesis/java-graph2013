package com.codemelon.graph.vertex;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.EdgeColorData;

/**
 * Vertex that maintains a Color for its adjacencies
 * @author Marshall Farrier
 * @my.created Dec 20, 2012
 * @my.edited Dec 20, 2012
 */
public interface EdgeColorVertex<T extends EdgeColorData> extends EdgeDataVertex<T> {
	/**
	 * Set the color of the edge whose head is the given vertex.
	 * @param to head of the edge whose color is to be set
	 * @param color value to which to set the edge's color
	 */
	public void setEdgeColor(EdgeColorVertex<T> to, Color color);
	/**
	 * Retrieve the color of the edge whose head is the given vertex
	 * @param to head of the edge whose color is to be retrieved
	 * @return color of the specified edge
	 */
	public Color getEdgeColor(EdgeColorVertex<T> to);
}

package com.codemelon.graph.vertex;

import com.codemelon.graph.common.Color;

/**
 * Vertex that supports coloring.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public interface ColoredVertex extends Vertex {
	/**
	 * Set the vertex color
	 * @param color value to which to set the color
	 */
	public void setColor(Color color);
	/**
	 * Get the vertex color
	 * @return the color of the vertex
	 */
	public Color getColor();
}

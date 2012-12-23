package com.codemelon.graph.vertex;

/**
 * Vertex supporting a field for distinguishing different components
 * of a graph.
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public interface ComponentVertex extends Vertex {
	/**
	 * Default value for vertices' component field.
	 */
	public static final int DEFAULT_COMPONENT = -1;
	/**
	 * The starting number when numbering components.
	 */
	public static final int FIRST_COMPONENT_NUMBER = 0;
	/**
	 * Set the number of the component to which the vertex belongs
	 * @param componentNumber value to which to set the component number
	 */
	public void setComponent(int componentNumber);
	/**
	 * Get the number of the component to which the vertex belongs
	 * @return the number of the component to which the vertex belongs
	 */
	public int getComponent();
}

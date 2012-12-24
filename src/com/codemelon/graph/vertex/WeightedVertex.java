package com.codemelon.graph.vertex;

/**
 * Vertex that maintains a floating point weight.
 * @author Marshall Farrier
 * @my.created Dec 24, 2012
 * @my.edited Dec 24, 2012
 */
public interface WeightedVertex extends Vertex {
	/**
	 * Default vertex weight.
	 */
	public static final double DEFAULT_WEIGHT = 0.0;
	/**
	 * Set vertex weight to the specified value.
	 * @param weight value to which to set the vertex weight
	 */
	public void setWeight(double weight);
	/**
	 * Retrieve a vertex's weight.
	 * @return the vertex's weight
	 */
	public double getWeight();
}

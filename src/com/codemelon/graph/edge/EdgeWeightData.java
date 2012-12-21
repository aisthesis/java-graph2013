package com.codemelon.graph.edge;

/**
 * Requires that an EdgeData object maintain a floating point weight value.
 * @author Marshall Farrier
 * @my.created Dec 20, 2012
 * @my.edited Dec 20, 2012
 */
public interface EdgeWeightData {
	/**
	 * Set the weight contained in this EdgeData object
	 * @param weight value to which to set the weight
	 */
	public void setWeight(double weight);
	/**
	 * Retrieve the weight contained in this EdgeData object
	 * @return weight stored in this EdgeData object
	 */
	public double getWeight();
}

package com.codemelon.graph.graph;

/**
 * @author Marshall Farrier
 * @my.created Dec 23, 2012
 * @my.edited Dec 23, 2012
 */
public interface WeightedEdgeGraph {
	/**
	 * Default value for the epsilon below which weights are to be considered
	 * equal.
	 */
	public static final double DEFAULT_WEIGHT_EPSILON = 0.000001;
	/**
	 * Determine if 2 floating point weights are to be considered equal in the given graph.
	 * @param w1 one of the weights to be tested for equality
	 * @param w2 the other weight to be tested for equality
	 * @return true if the absolute value of the difference between the 2 weights is below the 
	 * a threshold
	 */
	public boolean areEqualWeights(double w1, double w2);
}

package com.codemelon.graph.vertex;

import com.codemelon.graph.edge.EdgeWeightData;

/**
 * Vertex that maintains an edge weight for its adjacencies
 * @author Marshall Farrier
 * @my.created Dec 20, 2012
 * @my.edited Dec 20, 2012
 */
public interface EdgeWeightVertex<T extends EdgeWeightData> extends EdgeDataVertex<T> {
	/**
	 * Set the weight of the edge from the calling vertex to the vertex passed
	 * as parameter.
	 * @param to head of the edge for which to set the weight
	 * @param weight value to which the edge's weight is to be set
	 */
	public void setEdgeWeight(EdgeWeightVertex<T> to, double weight);
	/**
	 * Retrieve the weight of the edge from the calling vertex to the vertex passed
	 * as parameter.
	 * @param to head of the edge for which to get the weight
	 * @return weight of the given edge
	 */
	public double getEdgeWeight(EdgeWeightVertex<T> to);
}

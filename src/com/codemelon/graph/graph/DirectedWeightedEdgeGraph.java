package com.codemelon.graph.graph;

import java.util.Collection;

import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.edge.EdgeWeightData;
import com.codemelon.graph.vertex.DirectedEdgeDataVertex;
import com.codemelon.graph.vertex.EdgeWeightVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 23, 2012
 * @my.edited Dec 23, 2012
 */
public class DirectedWeightedEdgeGraph<E extends EdgeWeightData, U extends EdgeDataFactory<E>, 
		V extends DirectedEdgeDataVertex<E, U> & EdgeWeightVertex<E>> extends DirectedEdgeDataGraph<E, U, V>
		implements WeightedEdgeGraph {
	private double weightEpsilon;
	
	/**
	 * Initialize an empty graph using the default values for weightEpsilon and initial capacity. 
	 */
	public DirectedWeightedEdgeGraph() {
		this(WeightedEdgeGraph.DEFAULT_WEIGHT_EPSILON);
	}

	/**
	 * Initialize an empty graph using the given value for weightEpsilon and default initial capacity. 
	 * The input value must be greater than 0.
	 * @param weightEpsilon weight epsilon to be used to determine weight equality
	 * in this graph
	 */
	public DirectedWeightedEdgeGraph(double weightEpsilon) {
		super();
		if (weightEpsilon <= 0.0) {
			throw new IllegalArgumentException("Weight epsilon must be greater than 0!");
		}
		this.weightEpsilon = weightEpsilon;
	}
	
	/**
	 * Use the vertices in a collection as the initial vertices in the graph and
	 * set weight epsilon to the default value.
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 */
	public DirectedWeightedEdgeGraph(Collection<V> vertices) {
		this(vertices, WeightedEdgeGraph.DEFAULT_WEIGHT_EPSILON);
	}

	/**
	 * Use the vertices in a collection as the initial vertices in the graph and
	 * set weight epsilon to the specified value.
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 * @param weightEpsilon weight epsilon to be used to determine weight equality
	 * in this graph
	 */
	public DirectedWeightedEdgeGraph(Collection<V> vertices, double weightEpsilon) {
		super(vertices);
		if (weightEpsilon <= 0.0) {
			throw new IllegalArgumentException("Weight epsilon must be greater than 0!");
		}
		this.weightEpsilon = weightEpsilon;
	}

	/**
	 * Initialize an empty graph to have capacity for the given number of vertices and
	 * the default weight epsilon.
	 * @param initialCapacity expected number of vertices in the graph
	 */
	public DirectedWeightedEdgeGraph(int initialCapacity) {
		this(initialCapacity, WeightedEdgeGraph.DEFAULT_WEIGHT_EPSILON);
	}
	/**
	 * Initialize an empty graph to have capacity for the given number of vertices and
	 * the specified weight epsilon.
	 * @param initialCapacity expected number of vertices in the graph
	 * @param weightEpsilon weight epsilon to be used to determine weight equality
	 * in this graph
	 */
	public DirectedWeightedEdgeGraph(int initialCapacity, double weightEpsilon) {
		super(initialCapacity);
		if (weightEpsilon <= 0.0) {
			throw new IllegalArgumentException("Weight epsilon must be greater than 0!");
		}
		this.weightEpsilon = weightEpsilon;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.graph.WeightedEdgeGraph#areEqualWeights(double, double)
	 */
	@Override
	public boolean areEqualWeights(double w1, double w2) {
		return Math.abs(w1 - w2) < weightEpsilon;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.graph.WeightedEdgeGraph#getWeightEpsilon()
	 */
	@Override
	public double getWeightEpsilon() {
		return weightEpsilon;
	}
}
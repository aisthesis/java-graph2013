package com.codemelon.graph.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.codemelon.graph.edge.EdgeWeightData;
import com.codemelon.graph.edge.UndirectedWeightedEdge;
import com.codemelon.graph.vertex.EdgeWeightVertex;
import com.codemelon.graph.vertex.UndirectedEdgeDataVertex;
import com.codemelon.graph.vertex.Vertex;

/**
 * Undirected graph supporting floating point edge weight. This graph also has
 * a method for determining floating point equality between weights by determining
 * whether or not the difference lies below a certain epsilon value defined for
 * the graph at the time of its creation. 
 * @author Marshall Farrier
 * @my.created Dec 23, 2012
 * @my.edited Dec 23, 2012
 */
public class UndirectedWeightedEdgeGraph<E extends EdgeWeightData, 
		V extends UndirectedEdgeDataVertex<E> & EdgeWeightVertex<E>> extends
		UndirectedEdgeDataGraph<E, V> implements WeightedEdgeGraph {
	private double weightEpsilon;
	
	/**
	 * Initialize an empty graph using the default values for weightEpsilon and initial capacity. 
	 */
	public UndirectedWeightedEdgeGraph() {
		this(WeightedEdgeGraph.DEFAULT_WEIGHT_EPSILON);
	}

	/**
	 * Initialize an empty graph using the given value for weightEpsilon and default initial capacity. 
	 * The input value must be greater than 0.
	 * @param weightEpsilon weight epsilon to be used to determine weight equality
	 * in this graph
	 */
	public UndirectedWeightedEdgeGraph(double weightEpsilon) {
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
	public UndirectedWeightedEdgeGraph(Collection<V> vertices) {
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
	public UndirectedWeightedEdgeGraph(Collection<V> vertices, double weightEpsilon) {
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
	public UndirectedWeightedEdgeGraph(int initialCapacity) {
		this(initialCapacity, WeightedEdgeGraph.DEFAULT_WEIGHT_EPSILON);
	}
	/**
	 * Initialize an empty graph to have capacity for the given number of vertices and
	 * the specified weight epsilon.
	 * @param initialCapacity expected number of vertices in the graph
	 * @param weightEpsilon weight epsilon to be used to determine weight equality
	 * in this graph
	 */
	public UndirectedWeightedEdgeGraph(int initialCapacity, double weightEpsilon) {
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
	/**
	 * Return a set containing all weighted edges in the graph.
	 * @return a set containing all weighted edges in the graph
	 */
	@SuppressWarnings("unchecked")
	public Set<UndirectedWeightedEdge<E, V>> getWeightedEdges() {
		HashSet<UndirectedWeightedEdge<E, V>> result = new HashSet<UndirectedWeightedEdge<E, V>>(edgeCount());
		Iterator<V> vertexIterator = this.vertexIterator();
		V from;
		Set<? extends Vertex> adjacencySet;
		while (vertexIterator.hasNext()) {
			from = vertexIterator.next();
			adjacencySet = from.getAdjacencies();
			for (Vertex to : adjacencySet) {
				result.add(new UndirectedWeightedEdge<E, V>(from, (V) to));
			}
		}
		return result;
	}
}

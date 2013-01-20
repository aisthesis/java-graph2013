/*
 * Copyright 2013 Marshall Farrier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codemelon.graph.algorithm.path;

import java.util.Iterator;
import java.util.Set;

import com.codemelon.graph.edge.EdgeWeightData;
import com.codemelon.graph.graph.DirectedWeightedEdgeGraph;
import com.codemelon.graph.vertex.DirectedEdgeDataVertex;
import com.codemelon.graph.vertex.EdgeWeightVertex;
import com.codemelon.graph.vertex.ShortestPathVertex;
import com.codemelon.graph.vertex.Vertex;
import com.codemelon.graph.vertex.WeightedVertex;

/**
 * Implementation of Bellman-Ford algorithm following <a
 * href="http://mitpress.mit.edu/algorithms/">CLRS</a>, pp. 651ff.
 * 
 * @author Marshall Farrier
 * @my.created Jan 19, 2013
 * @my.edited Jan 19, 2013
 */
public class BellmanFord<E extends EdgeWeightData, V extends DirectedEdgeDataVertex<E> & ShortestPathVertex<E>> {
	private DirectedWeightedEdgeGraph<E, V> graph;

	/**
	 * Constructor from the graph for which shortest paths are to be found.
	 * @param graph graph for which shortest paths are to be found
	 */
	public BellmanFord(DirectedWeightedEdgeGraph<E, V> graph) {
		this.graph = graph;
	}

	/**
	 * Find shortest paths to all vertices reachable from a given source vertex s.
	 * Returns true iff there is no negative-weight cycle reachable from the source,
	 * false if there is such a cycle. In case of a negative-weight cycle, the return
	 * value of false indicates that there is no solution to the shortest path problem.
	 * @param s source vertex from which shortest paths are to be determined
	 * @return true iff there is no negative-weight cycle reachable from s
	 */
	@SuppressWarnings("unchecked")
	public boolean findShortestPaths(V s) {
		PathUtils.initializeSingleSource(graph, s);
		Iterator<V> it;
		V u;
		Set<? extends Vertex> adjacencies;
		// graph.vertexCount() - 1 iterations
		for (int i = 1; i < graph.vertexCount(); i++) {
			it = graph.vertexIterator();
			while (it.hasNext()) {
				u = it.next();
				adjacencies = u.getAdjacencies();
				for (Vertex v : adjacencies) {
					PathUtils.relax(u, (V) v);
				}
			}
		}
		it = graph.vertexIterator();
		while (it.hasNext()) {
			u = it.next();
			adjacencies = u.getAdjacencies();
			for (Vertex v : adjacencies) {
				if (((WeightedVertex) v).getWeight() > u.getWeight()
						+ u.getEdgeWeight((EdgeWeightVertex<E>) v)) {
					return false;
				}
			}
		}
		return true;
	}
}

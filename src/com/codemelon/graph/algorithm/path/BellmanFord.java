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

import com.codemelon.graph.edge.EdgeWeightData;
import com.codemelon.graph.graph.DirectedWeightedEdgeGraph;
import com.codemelon.graph.vertex.DirectedEdgeDataVertex;
import com.codemelon.graph.vertex.EdgeWeightVertex;
import com.codemelon.graph.vertex.WeightedVertex;

/**
 * Implementation of Bellman-Ford algorithm following <a
 * href="http://mitpress.mit.edu/algorithms/">CLRS</a>, pp. 651ff.
 * 
 * @author Marshall Farrier
 * @my.created Jan 19, 2013
 * @my.edited Jan 19, 2013
 */
public class BellmanFord<E extends EdgeWeightData, V extends DirectedEdgeDataVertex<E> & EdgeWeightVertex<E> & WeightedVertex> {
	private DirectedWeightedEdgeGraph<E, V> graph;

	public BellmanFord(DirectedWeightedEdgeGraph<E, V> graph) {
		this.graph = graph;
	}

}

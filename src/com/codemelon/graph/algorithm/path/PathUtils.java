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

import com.codemelon.graph.edge.EdgeWeightData;
import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.vertex.ChildVertex;
import com.codemelon.graph.vertex.EdgeWeightVertex;
import com.codemelon.graph.vertex.WeightedVertex;

/**
 * @author Marshall Farrier
 * @my.created Jan 19, 2013
 * @my.edited Jan 19, 2013
 */
public class PathUtils {
	private PathUtils() {
	}

	/**
	 * <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, p. 648
	 * 
	 * @param graph
	 *            graph on whose vertex the operation is to be performed
	 * @param source
	 *            vertex whose initial distance is to be set to 0
	 */
	public static final <V extends WeightedVertex & ChildVertex> void initializeSingleSource(
			AbstractGraph<V> graph, V source) {
		Iterator<V> it = graph.vertexIterator();
		V vertex;
		while (it.hasNext()) {
			vertex = it.next();
			vertex.setWeight(Double.MAX_VALUE);
			vertex.setParent(null);
		}
		source.setWeight(0.0);
	}

	/**
	 * <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, p. 649
	 * 
	 * @param u
	 * @param v
	 */
	public static final <E extends EdgeWeightData, V extends WeightedVertex & ChildVertex & EdgeWeightVertex<E>> void relax(
			V u, V v) {
		if (v.getWeight() > u.getWeight() + u.getEdgeWeight(v)) {
			v.setWeight(u.getWeight() + u.getEdgeWeight(v));
			v.setParent(u);
		}
	}
}

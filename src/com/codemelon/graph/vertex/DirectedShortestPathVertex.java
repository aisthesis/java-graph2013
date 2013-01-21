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
package com.codemelon.graph.vertex;

import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.edge.ShortestPathEdgeData;

/**
 * @author Marshall Farrier
 * @my.created Jan 20, 2013
 * @my.edited Jan 20, 2013
 */
public class DirectedShortestPathVertex<E extends ShortestPathEdgeData> extends
		DirectedEdgeDataVertex<E> implements ShortestPathVertex<E> {
	private ChildVertex parent;
	private double weight;

	public DirectedShortestPathVertex(EdgeDataFactory<E> edgeDataFactory) {
		super(edgeDataFactory);
		parent = null;
		weight = WeightedVertex.DEFAULT_WEIGHT;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.EdgeWeightVertex#setEdgeWeight(com.codemelon.graph.vertex.EdgeWeightVertex, double)
	 */
	@Override
	public void setEdgeWeight(EdgeWeightVertex<E> to, double weight) {
		getEdgeData(to).setWeight(weight);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.EdgeWeightVertex#getEdgeWeight(com.codemelon.graph.vertex.EdgeWeightVertex)
	 */
	@Override
	public final double getEdgeWeight(EdgeWeightVertex<E> to) {
		return getEdgeData(to).getWeight();
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ChildVertex#setParent(com.codemelon.graph.vertex.ChildVertex)
	 */
	@Override
	public final void setParent(ChildVertex parent) {
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ChildVertex#getParent()
	 */
	@Override
	public final ChildVertex getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.WeightedVertex#setWeight(double)
	 */
	@Override
	public final void setWeight(double weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.WeightedVertex#getWeight()
	 */
	@Override
	public final double getWeight() {
		return weight;
	}

}

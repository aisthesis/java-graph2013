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
package com.codemelon.graph.edge;

/**
 * @author Marshall Farrier
 * @my.created Jan 20, 2013
 * @my.edited Jan 20, 2013
 */
public class ShortestPathEdgeData implements EdgeWeightData {
	private double weight;
	
	public ShortestPathEdgeData() {
		this(EdgeWeightData.DEFAULT_EDGE_WEIGHT);
	}
	
	public ShortestPathEdgeData(double weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.edge.EdgeWeightData#setWeight(double)
	 */
	@Override
	public final void setWeight(double weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.edge.EdgeWeightData#getWeight()
	 */
	@Override
	public final double getWeight() {
		return weight;
	}

	public enum Factory implements EdgeDataFactory<ShortestPathEdgeData> {
		INSTANCE;
		
		/**
		 * Factory method for creating new ShortestPathEdgeData objects by calling the default constructor.
		 */
		@Override
		public ShortestPathEdgeData newEdgeData() {
			return new ShortestPathEdgeData();
		}		
	}
}

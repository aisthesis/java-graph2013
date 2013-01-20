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

import com.codemelon.graph.edge.EdgeWeightData;

/**
 * @author Marshall Farrier
 * @my.created Jan 20, 2013
 * @my.edited Jan 20, 2013
 */
public interface ShortestPathVertex<E extends EdgeWeightData> extends EdgeWeightVertex<E>, ChildVertex, WeightedVertex {

}

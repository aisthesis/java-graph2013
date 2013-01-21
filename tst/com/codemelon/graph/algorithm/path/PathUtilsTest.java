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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.After;
import org.junit.Test;

import com.codemelon.graph.edge.ShortestPathEdgeData;
import com.codemelon.graph.graph.DirectedWeightedEdgeGraph;
import com.codemelon.graph.vertex.DirectedShortestPathVertex;

/**
 * @author Marshall Farrier
 * @my.created Jan 20, 2013
 * @my.edited Jan 20, 2013
 */
public class PathUtilsTest {
	private DirectedWeightedEdgeGraph<ShortestPathEdgeData, DirectedShortestPathVertex<ShortestPathEdgeData>> graph;
	private BellmanFord<ShortestPathEdgeData, DirectedShortestPathVertex<ShortestPathEdgeData>> bellmanFord;
	private HashMap<Character, DirectedShortestPathVertex<ShortestPathEdgeData>> vertices;

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		graph = null;
		bellmanFord = null;
		vertices = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.path.PathUtils#initializeSingleSource(com.codemelon.graph.graph.AbstractGraph, com.codemelon.graph.vertex.WeightedVertex)}.
	 */
	@Test
	public void testInitializeSingleSource() {
		// run Bellman-Ford so that vertices have parents and weights
		setupCLRSGraph();
		initBellmanFord();
		bellmanFord.findShortestPaths(vertices.get('s'));
		// initialize using vertex 'z'
		PathUtils.initializeSingleSource(graph, vertices.get('z'));
		
		assertTrue("s has correct weight", graph.areEqualWeights(Double.MAX_VALUE, vertices.get('s').getWeight()));		
		assertTrue("t has correct weight", graph.areEqualWeights(Double.MAX_VALUE, vertices.get('t').getWeight()));		
		assertTrue("x has correct weight", graph.areEqualWeights(Double.MAX_VALUE, vertices.get('x').getWeight()));		
		assertTrue("y has correct weight", graph.areEqualWeights(Double.MAX_VALUE, vertices.get('y').getWeight()));		
		assertTrue("z has correct weight", graph.areEqualWeights(0.0, vertices.get('z').getWeight()));
		
		assertNull("s has no parent", vertices.get('s').getParent());		
		assertNull("t has no parent", vertices.get('t').getParent());		
		assertNull("x has no parent", vertices.get('x').getParent());		
		assertNull("y has no parent", vertices.get('y').getParent());		
		assertNull("z has no parent", vertices.get('z').getParent());
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.path.PathUtils#relax(com.codemelon.graph.vertex.WeightedVertex, com.codemelon.graph.vertex.WeightedVertex)}.
	 */
	@Test
	public void testRelax() {
		setupCLRSGraph();
		// initialize using vertex 's'
		PathUtils.initializeSingleSource(graph, vertices.get('s'));
		PathUtils.relax(vertices.get('s'), vertices.get('t'));		
		assertTrue("s has correct weight", graph.areEqualWeights(0.0, vertices.get('s').getWeight()));	
		assertTrue("t has correct weight", graph.areEqualWeights(6.0, vertices.get('t').getWeight()));	
	}/**
	 * Graph from CLRS, p. 652
	 */
	private void setupCLRSGraph() {
		vertices = new HashMap<Character, DirectedShortestPathVertex<ShortestPathEdgeData>>();
		for (char i = 's'; i <= 'z'; i++) {
			if (i <= 't' || 'x' <= i) {
				vertices.put(i,
						new DirectedShortestPathVertex<ShortestPathEdgeData>(
								ShortestPathEdgeData.Factory.INSTANCE));
			}
		}
		graph = new DirectedWeightedEdgeGraph<ShortestPathEdgeData, DirectedShortestPathVertex<ShortestPathEdgeData>>(
				vertices.values());
		vertices.get('s').addAdjacency(vertices.get('t'));
		vertices.get('s').addAdjacency(vertices.get('y'));
		vertices.get('t').addAdjacency(vertices.get('x'));
		vertices.get('t').addAdjacency(vertices.get('y'));
		vertices.get('t').addAdjacency(vertices.get('z'));
		vertices.get('x').addAdjacency(vertices.get('t'));
		vertices.get('y').addAdjacency(vertices.get('x'));
		vertices.get('y').addAdjacency(vertices.get('z'));
		vertices.get('z').addAdjacency(vertices.get('s'));
		vertices.get('z').addAdjacency(vertices.get('x'));
		
		vertices.get('s').setEdgeWeight(vertices.get('t'), 6.0);
		vertices.get('s').setEdgeWeight(vertices.get('y'), 7.0);
		vertices.get('t').setEdgeWeight(vertices.get('x'), 5.0);
		vertices.get('t').setEdgeWeight(vertices.get('y'), 8.0);
		vertices.get('t').setEdgeWeight(vertices.get('z'), -4.0);
		vertices.get('x').setEdgeWeight(vertices.get('t'), -2.0);
		vertices.get('y').setEdgeWeight(vertices.get('x'), -3.0);
		vertices.get('y').setEdgeWeight(vertices.get('z'), 9.0);
		vertices.get('z').setEdgeWeight(vertices.get('s'), 2.0);
		vertices.get('z').setEdgeWeight(vertices.get('x'), 7.0);
	}
	
	private void initBellmanFord() {
		bellmanFord = new BellmanFord<ShortestPathEdgeData, DirectedShortestPathVertex<ShortestPathEdgeData>>(graph);
	}

}

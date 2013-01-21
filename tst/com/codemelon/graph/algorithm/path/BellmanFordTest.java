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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codemelon.graph.edge.ShortestPathEdgeData;
import com.codemelon.graph.graph.DirectedWeightedEdgeGraph;
import com.codemelon.graph.vertex.DirectedShortestPathVertex;

/**
 * @author Marshall Farrier
 * @my.created Jan 20, 2013
 * @my.edited Jan 20, 2013
 */
public class BellmanFordTest {
	private DirectedWeightedEdgeGraph<ShortestPathEdgeData, DirectedShortestPathVertex<ShortestPathEdgeData>> graph;
	private BellmanFord<ShortestPathEdgeData, DirectedShortestPathVertex<ShortestPathEdgeData>> bellmanFord;
	private HashMap<Character, DirectedShortestPathVertex<ShortestPathEdgeData>> vertices;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

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
	 * Test method for
	 * {@link com.codemelon.graph.algorithm.path.BellmanFord#findShortestPaths(com.codemelon.graph.vertex.DirectedEdgeDataVertex)}
	 * .
	 */
	@Test
	public void testNoNegativeCycleGraph() {
		setupNoNegativeCycleCLRSGraph();
		initBellmanFord();
		assertTrue("no negative weight cycle", bellmanFord.findShortestPaths(vertices.get('s')));
		
		assertTrue("s has correct weight", graph.areEqualWeights(0.0, vertices.get('s').getWeight()));
		assertTrue("t has correct weight", graph.areEqualWeights(2.0, vertices.get('t').getWeight()));
		assertTrue("x has correct weight", graph.areEqualWeights(4.0, vertices.get('x').getWeight()));
		assertTrue("y has correct weight", graph.areEqualWeights(7.0, vertices.get('y').getWeight()));
		assertTrue("z has correct weight", graph.areEqualWeights(-2.0, vertices.get('z').getWeight()));
		
		assertEquals("s has no parent", null, vertices.get('s').getParent());		
		assertEquals("t has parent x", vertices.get('x'), vertices.get('t').getParent());		
		assertEquals("x has parent y", vertices.get('y'), vertices.get('x').getParent());		
		assertEquals("y has parent s", vertices.get('s'), vertices.get('y').getParent());		
		assertEquals("z has parent t", vertices.get('t'), vertices.get('z').getParent());
	}
	/**
	 * Test method for
	 * {@link com.codemelon.graph.algorithm.path.BellmanFord#findShortestPaths(com.codemelon.graph.vertex.DirectedEdgeDataVertex)}
	 * .
	 */
	@Test
	public void testNegativeCycleGraph() {
		setupNoNegativeCycleCLRSGraph();
		// create negative weight cycle
		vertices.get('x').setEdgeWeight(vertices.get('t'), -6.0);
		initBellmanFord();
		assertFalse("negative weight cycle found", bellmanFord.findShortestPaths(vertices.get('s')));
	}

	/**
	 * Graph from CLRS, p. 652
	 */
	private void setupNoNegativeCycleCLRSGraph() {
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

package com.codemelon.graph.algorithm.search;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Test;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.graph.DirectedSimpleGraph;
import com.codemelon.graph.vertex.DirectedOrderedDfsVertex;
import com.codemelon.graph.vertex.VisitedVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public class OrderedDepthFirstSearchTest {
	private static final int CIRCULAR_GRAPH_SIZE = 1000;
	private DirectedSimpleGraph<DirectedOrderedDfsVertex> graph;
	
	@After
	public void tearDown() {
		graph = null;
	}

	/**
	 * Graph from CLRS, p. 605
	 * Test method for {@link com.codemelon.graph.algorithm.search.OrderedDepthFirstSearch#search()}.
	 */
	@Test
	public void testSmallCLRSGraph() {
		HashMap<Character, DirectedOrderedDfsVertex> vertices = setUpSmallCLRSGraph();
		new OrderedDepthFirstSearch<DirectedOrderedDfsVertex>(graph).search();
		// all vertices are black
		for (char i = 'u'; i <= 'z'; i++) {
			assertEquals("Vertex is black", Color.BLACK, vertices.get(i).getColor());
			assertTrue("Discovery time is before finish time", vertices.get(i).getDiscoveryTime() 
					< vertices.get(i).getFinishTime());
		}
		assertEquals("Discovery time is correct", 0, vertices.get('u').getDiscoveryTime());
		assertEquals("Finish time is correct", 7, vertices.get('u').getFinishTime());
		assertEquals("Discovery time is correct", 1, vertices.get('v').getDiscoveryTime());
		assertEquals("Finish time is correct", 6, vertices.get('v').getFinishTime());
		assertEquals("Discovery time is correct", 8, vertices.get('w').getDiscoveryTime());
		assertEquals("Finish time is correct", 11, vertices.get('w').getFinishTime());
		assertEquals("Discovery time is correct", 3, vertices.get('x').getDiscoveryTime());
		assertEquals("Finish time is correct", 4, vertices.get('x').getFinishTime());
		assertEquals("Discovery time is correct", 2, vertices.get('y').getDiscoveryTime());
		assertEquals("Finish time is correct", 5, vertices.get('y').getFinishTime());
		assertEquals("Discovery time is correct", 9, vertices.get('z').getDiscoveryTime());
		assertEquals("Finish time is correct", 10, vertices.get('z').getFinishTime());
	}
	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.OrderedDepthFirstSearch#search()}.
	 */
	@Test
	public void testBiggerCircularGraph() {
		ArrayList<DirectedOrderedDfsVertex> vertices = setUpBiggerCircularGraph();
		new OrderedDepthFirstSearch<DirectedOrderedDfsVertex>(graph).search();	
		for (int i = 0; i < CIRCULAR_GRAPH_SIZE; i++) {
			assertEquals("Color is black", Color.BLACK, vertices.get(i).getColor());
			assertEquals("Correct discovery time", i, vertices.get(i).getDiscoveryTime());
			assertEquals("Correct finish time", 2 * CIRCULAR_GRAPH_SIZE - i - 1 - 
					VisitedVertex.FIRST_DISCOVERY_TIME, vertices.get(i).getFinishTime());
		}
	}

	/**
	 * Graph from CLRS, p. 605
	 */
	private HashMap<Character, DirectedOrderedDfsVertex> setUpSmallCLRSGraph() {
		HashMap<Character, DirectedOrderedDfsVertex> vertices = 
				new HashMap<Character, DirectedOrderedDfsVertex>();
		for (char i = 'u'; i <= 'z'; i++) {
			vertices.put(i, new DirectedOrderedDfsVertex());
			vertices.get(i).setSearchOrder(i);
		}
		graph = new DirectedSimpleGraph<DirectedOrderedDfsVertex>(vertices.values());
		vertices.get('u').addAdjacency(vertices.get('v'));
		vertices.get('u').addAdjacency(vertices.get('x'));
		vertices.get('v').addAdjacency(vertices.get('y'));
		vertices.get('w').addAdjacency(vertices.get('y'));
		vertices.get('w').addAdjacency(vertices.get('z'));
		vertices.get('x').addAdjacency(vertices.get('v'));
		vertices.get('y').addAdjacency(vertices.get('x'));
		vertices.get('z').addAdjacency(vertices.get('z'));
		return vertices;
	}
	
	private ArrayList<DirectedOrderedDfsVertex> setUpBiggerCircularGraph() {
		ArrayList<DirectedOrderedDfsVertex> vertices = 
				new ArrayList<DirectedOrderedDfsVertex>(CIRCULAR_GRAPH_SIZE);
		for (int i = 0; i < CIRCULAR_GRAPH_SIZE; i++) {
			// vertex label will be the same as index in the array
			vertices.add(new DirectedOrderedDfsVertex());
			vertices.get(i).setSearchOrder(i);
		}
		graph = new DirectedSimpleGraph<DirectedOrderedDfsVertex>(vertices);
		for (int i = 0; i < CIRCULAR_GRAPH_SIZE - 1; i++) {
			vertices.get(i).addAdjacency(vertices.get(i + 1));
		}
		// now close the circle
		vertices.get(CIRCULAR_GRAPH_SIZE - 1).addAdjacency(vertices.get(0));
		return vertices;
	}
}

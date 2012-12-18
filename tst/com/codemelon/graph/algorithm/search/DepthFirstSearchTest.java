package com.codemelon.graph.algorithm.search;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Test;

import com.codemelon.graph.vertex.DirectedOrderedDfsVertex;
import com.codemelon.graph.vertex.VisitedVertex;
import com.codemelon.graph.common.Color;
import com.codemelon.graph.graph.DirectedSimpleGraph;

/**
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public class DepthFirstSearchTest {
	private static final int CIRCULAR_GRAPH_SIZE = 1000;
	
	private DirectedSimpleGraph<DirectedOrderedDfsVertex> graph;

	@After
	public void tearDown() {
		graph = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.DepthFirstSearch#search()}.
	 */
	@Test
	public void testSmallCLRSGraph() {
		HashMap<Character, DirectedOrderedDfsVertex> vertices = 
				setUpSmallCLRSGraph();
		assertFalse("Graph contains a cycle", new DepthFirstSearch<DirectedOrderedDfsVertex>(graph).search());
		// all vertices are black
		for (char i = 'u'; i <= 'z'; i++) {
			assertEquals("Vertex is black", Color.BLACK, vertices.get(i).getColor());
			assertTrue("Discovery time is before finish time", vertices.get(i).getDiscoveryTime() 
					< vertices.get(i).getFinishTime());
		}
	}
	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.DepthFirstSearch#search()}.
	 */
	@Test
	public void testBiggerCircularGraph() {
		ArrayList<DirectedOrderedDfsVertex> vertices = setUpBiggerCircularGraph();
		assertFalse("Graph is not acyclic", new DepthFirstSearch<DirectedOrderedDfsVertex>(graph).search());		
		//vertex first discovered will be vertex last finished in this case
		int indexOfFirstDiscovery = -1;
		for (int i = 0; i < CIRCULAR_GRAPH_SIZE; i++) {
			if (vertices.get(i).getDiscoveryTime() == VisitedVertex.FIRST_DISCOVERY_TIME) {
				indexOfFirstDiscovery = i;
			}
		}
		assertEquals("Vertex first discovered has last finish time", 
				CIRCULAR_GRAPH_SIZE * 2 - 1 + VisitedVertex.FIRST_DISCOVERY_TIME, 
				vertices.get(indexOfFirstDiscovery).getFinishTime());
	}
	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.DepthFirstSearch#search()}.
	 */
	@Test
	public void testAcyclicGraph() {
		ArrayList<DirectedOrderedDfsVertex> vertices = setUpBiggerCircularGraph();
		// break the cycle by clearing 1 adjacency list
		vertices.get(0).clearAdjacencies();
		assertTrue("Graph is acyclic", new DepthFirstSearch<DirectedOrderedDfsVertex>(graph).search());
	}
	/**
	 * Graph from CLRS, p. 605
	 */
	private HashMap<Character, DirectedOrderedDfsVertex> setUpSmallCLRSGraph() {
		HashMap<Character, DirectedOrderedDfsVertex> vertices = 
				new HashMap<Character, DirectedOrderedDfsVertex>();
		for (char i = 'u'; i <= 'z'; i++) {
			vertices.put(i, new DirectedOrderedDfsVertex()); 
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
		ArrayList<DirectedOrderedDfsVertex> vertices = new ArrayList<DirectedOrderedDfsVertex>(CIRCULAR_GRAPH_SIZE);
		for (int i = 0; i < CIRCULAR_GRAPH_SIZE; i++) {
			// vertex label will be the same as index in the array
			vertices.add(new DirectedOrderedDfsVertex());
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

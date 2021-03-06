package com.codemelon.graph.algorithm.search;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Test;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.EdgeType;
import com.codemelon.graph.edge.DfsEdgeData;
import com.codemelon.graph.graph.DfsGraph;
import com.codemelon.graph.vertex.DirectedDfsVertex;
import com.codemelon.graph.vertex.VisitedVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class EdgeTypeDepthFirstSearchTest {
	private DfsGraph<DfsEdgeData> graph;
	private static final int CIRCULAR_GRAPH_SIZE = 1000;
	
	@After
	public void tearDown() {
		graph = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.EdgeTypeDepthFirstSearch#search()}.
	 */
	@Test
	public void testSmallCLRSGraph() {
		HashMap<Character, DirectedDfsVertex<DfsEdgeData>> vertices = 
				setUpSmallCLRSGraph();
		assertFalse("Graph contains a cycle", new EdgeTypeDepthFirstSearch<DfsEdgeData, 
				DirectedDfsVertex<DfsEdgeData>>(graph).search());
		// all vertices are black
		for (char i = 'u'; i <= 'z'; i++) {
			assertEquals("Vertex is black", Color.BLACK, vertices.get(i).getColor());
			assertTrue("Discovery time is before finish time", vertices.get(i).getDiscoveryTime() 
					< vertices.get(i).getFinishTime());
		}
	}
	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.EdgeTypeDepthFirstSearch#search()}.
	 */
	@Test
	public void testBiggerCircularGraph() {
		ArrayList<DirectedDfsVertex<DfsEdgeData>> vertices = setUpBiggerCircularGraph();
		assertFalse("Graph is not acyclic", new EdgeTypeDepthFirstSearch<DfsEdgeData, 
				DirectedDfsVertex<DfsEdgeData>>(graph).search());		
		//vertex first discovered will be vertex last finished in this case
		int indexOfFirstDiscovery = -1;
		for (int i = 0; i < CIRCULAR_GRAPH_SIZE; i++) {
			if (vertices.get(i).getDiscoveryTime() == VisitedVertex.FIRST_DISCOVERY_TIME) {
				indexOfFirstDiscovery = i;
			}
			else if (i > 0) {
				assertEquals("All but one edge is a tree edge", EdgeType.TREE,
						vertices.get(i - 1).getEdgeType(vertices.get(i)));
			}
		}
		assertEquals("Vertex first discovered has last finish time", 
				CIRCULAR_GRAPH_SIZE * 2 - 1 + VisitedVertex.FIRST_DISCOVERY_TIME, 
				vertices.get(indexOfFirstDiscovery).getFinishTime());
		int indexOfLastDiscovery = (indexOfFirstDiscovery == 
				0 ? CIRCULAR_GRAPH_SIZE - 1 : indexOfFirstDiscovery - 1);
		assertEquals("Edge from last to first is a back edge", EdgeType.BACK,
				vertices.get(indexOfLastDiscovery).getEdgeType(vertices.get(indexOfFirstDiscovery)));
	}
	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.EdgeTypeDepthFirstSearch#search()}.
	 */
	@Test
	public void testAcyclicGraph() {
		ArrayList<DirectedDfsVertex<DfsEdgeData>> vertices = setUpBiggerCircularGraph();
		// break the cycle by clearing 1 adjacency list
		vertices.get(0).clearAdjacencies();
		assertTrue("Graph is acyclic", new EdgeTypeDepthFirstSearch<DfsEdgeData, 
				DirectedDfsVertex<DfsEdgeData>>(graph).search());
	}
	/**
	 * Graph from CLRS, p. 605
	 */
	private HashMap<Character, DirectedDfsVertex<DfsEdgeData>> setUpSmallCLRSGraph() {
		HashMap<Character, DirectedDfsVertex<DfsEdgeData>> vertices = 
				new HashMap<Character, DirectedDfsVertex<DfsEdgeData>>();
		for (char i = 'u'; i <= 'z'; i++) {
			vertices.put(i, new DirectedDfsVertex<DfsEdgeData>(DfsEdgeData.Factory.INSTANCE));
		}
		graph = new DfsGraph<DfsEdgeData>(vertices.values());
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
	private ArrayList<DirectedDfsVertex<DfsEdgeData>> setUpBiggerCircularGraph() {
		ArrayList<DirectedDfsVertex<DfsEdgeData>> vertices = 
				new ArrayList<DirectedDfsVertex<DfsEdgeData>>(CIRCULAR_GRAPH_SIZE);
		for (int i = 0; i < CIRCULAR_GRAPH_SIZE; i++) {
			// vertex label will be the same as index in the array
			vertices.add(new DirectedDfsVertex<DfsEdgeData>(DfsEdgeData.Factory.INSTANCE));
		}
		graph = new DfsGraph<DfsEdgeData>(vertices);
		for (int i = 0; i < CIRCULAR_GRAPH_SIZE - 1; i++) {
			vertices.get(i).addAdjacency(vertices.get(i + 1));
		}
		// now close the circle
		vertices.get(CIRCULAR_GRAPH_SIZE - 1).addAdjacency(vertices.get(0));
		return vertices;
	}
}

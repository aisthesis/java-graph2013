package com.codemelon.graph.vertex;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codemelon.graph.graph.DirectedSimpleGraph;

/**
 * @author Marshall Farrier
 * @my.created Dec 14, 2012
 * @my.edited Dec 14, 2012
 */
public class DirectedSimpleVertexTest {
	private static final int VERTICES_IN_TEST_GRAPH = 10;
	private HashMap<Integer, DirectedSimpleVertex> vertices;
	private DirectedSimpleGraph graph;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		vertices = new HashMap<Integer, DirectedSimpleVertex>(VERTICES_IN_TEST_GRAPH);
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			vertices.put(i, new DirectedSimpleVertex());
		}
		graph = new DirectedSimpleGraph(vertices.values());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		vertices = null;
		graph = null;
	}

	@Test
	public void testAddAdjacency() {
		vertices.get(0).addAdjacency(vertices.get(1));
		assertEquals("Graph has 1 adjacency", 1, graph.edgeCount());
		assertTrue("Graph contains edge (0, 1)", graph.containsEdge(vertices.get(0), vertices.get(1)));
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			for (int j = 0; j < VERTICES_IN_TEST_GRAPH; j++) {
				if (i != 0 || j != 1) {
					assertFalse("Graph doesn't contain edge (" + i + ", " + j + ")", 
							graph.containsEdge(vertices.get(i), vertices.get(j)));
				}
			}
		}
	}
}

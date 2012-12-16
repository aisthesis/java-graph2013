package com.codemelon.graph.graph;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codemelon.graph.vertex.UndirectedBfsVertex;

public class BfsGraphTest {
	private static final int VERTICES_IN_TEST_GRAPH = 12;
	private BfsGraph<UndirectedBfsVertex> graph;
	private HashMap<Integer, UndirectedBfsVertex> vertices;

	@Before
	public void setUp() {
		vertices = new HashMap<Integer, UndirectedBfsVertex>(VERTICES_IN_TEST_GRAPH);
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			vertices.put(i, new UndirectedBfsVertex());
		}
		graph = new BfsGraph<UndirectedBfsVertex>(vertices.values());
	}

	@After
	public void tearDown() {
		graph = null;
		vertices = null;
	}

	@Test
	public void testEdgeCount() {
		vertices.get(0).addAdjacency(vertices.get(1));
		assertTrue("Adjacency (0, 1) present", graph.containsEdge(vertices.get(0), vertices.get(1)));
		assertTrue("Adjacency (1, 0) present", graph.containsEdge(vertices.get(1), vertices.get(0)));
		assertEquals("graph has 1 edge", 1, graph.edgeCount());
	}

}

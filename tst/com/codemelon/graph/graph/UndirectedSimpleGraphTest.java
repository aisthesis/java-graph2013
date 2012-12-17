package com.codemelon.graph.graph;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codemelon.graph.vertex.UndirectedSimpleVertex;

public class UndirectedSimpleGraphTest {
	private static final int VERTICES_IN_TEST_GRAPH = 1000;
	private HashMap<Integer, UndirectedSimpleVertex> vertices;
	private UndirectedSimpleGraph<UndirectedSimpleVertex> graph;
	
	@Before
	public void setUp() {
		vertices = new HashMap<Integer, UndirectedSimpleVertex>(VERTICES_IN_TEST_GRAPH);
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			vertices.put(i, new UndirectedSimpleVertex());
		}
		graph = new UndirectedSimpleGraph<UndirectedSimpleVertex>(vertices.values());
		vertices.get(0).addAdjacency(vertices.get(1));
	}

	@After
	public void tearDown() {
		vertices = null;
		graph = null;
	}
	/**
	 * Test method for {@link com.codemelon.graph.graph.UndirectedSimpleGraph#edgeCount()}.
	 */
	@Test
	public void testEdgeCount() {
		assertEquals("Graph has 1 adjacency", 1, graph.edgeCount());
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.UndirectedSimpleGraph#DirectedSimpleGraph()}.
	 */
	@Test
	public void testUndirectedSimpleGraph() {
		graph = new UndirectedSimpleGraph<UndirectedSimpleVertex>();
		UndirectedSimpleVertex u = new UndirectedSimpleVertex();
		UndirectedSimpleVertex v = new UndirectedSimpleVertex();
		graph.addVertex(u);
		graph.addVertex(v);
		u.addAdjacency(v);
		assertTrue("Vertex u in graph", graph.containsVertex(u));
		assertTrue("Vertex v in graph", graph.containsVertex(v));
		assertTrue("Graph contains edge (u, v)", graph.containsEdge(u, v));
		assertTrue("Graph contains edge (v, u)", graph.containsEdge(v, u));
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.UndirectedSimpleGraph#DirectedSimpleGraph(int)}.
	 */
	@Test
	public void testUndirectedSimpleGraphInt() {
		graph = new UndirectedSimpleGraph<UndirectedSimpleVertex>(12);
		UndirectedSimpleVertex u = new UndirectedSimpleVertex();
		UndirectedSimpleVertex v = new UndirectedSimpleVertex();
		graph.addVertex(u);
		graph.addVertex(v);
		u.addAdjacency(v);
		assertTrue("Vertex u in graph", graph.containsVertex(u));
		assertTrue("Vertex v in graph", graph.containsVertex(v));
		assertTrue("Graph contains edge (u, v)", graph.containsEdge(u, v));
		assertTrue("Graph contains edge (v, u)", graph.containsEdge(v, u));
	}
}

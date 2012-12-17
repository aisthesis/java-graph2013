package com.codemelon.graph.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codemelon.graph.vertex.DirectedSimpleVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 14, 2012
 * @my.edited Dec 14, 2012
 */
public class DirectedSimpleGraphTest {
	private static final int VERTICES_IN_TEST_GRAPH = 1000;
	private HashMap<Integer, DirectedSimpleVertex> vertices;
	private DirectedSimpleGraph<DirectedSimpleVertex> graph;

	@Before
	public void setUp() {
		vertices = new HashMap<Integer, DirectedSimpleVertex>(VERTICES_IN_TEST_GRAPH);
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			vertices.put(i, new DirectedSimpleVertex());
		}
		graph = new DirectedSimpleGraph<DirectedSimpleVertex>(vertices.values());
		vertices.get(0).addAdjacency(vertices.get(1));
	}

	@After
	public void tearDown() {
		vertices = null;
		graph = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.DirectedSimpleGraph#edgeCount()}.
	 */
	@Test
	public void testEdgeCount() {
		assertEquals("Graph has 1 adjacency", 1, graph.edgeCount());
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.DirectedSimpleGraph#DirectedSimpleGraph()}.
	 */
	@Test
	public void testDirectedSimpleGraph() {
		graph = new DirectedSimpleGraph<DirectedSimpleVertex>();
		DirectedSimpleVertex u = new DirectedSimpleVertex();
		DirectedSimpleVertex v = new DirectedSimpleVertex();
		graph.addVertex(u);
		graph.addVertex(v);
		u.addAdjacency(v);
		assertTrue("Vertex u in graph", graph.containsVertex(u));
		assertTrue("Vertex v in graph", graph.containsVertex(v));
		assertTrue("Graph contains edge (u, v)", graph.containsEdge(u, v));
		assertFalse("Graph doesn't contain edge (v, u)", graph.containsEdge(v, u));
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.DirectedSimpleGraph#DirectedSimpleGraph(int)}.
	 */
	@Test
	public void testDirectedSimpleGraphInt() {
		graph = new DirectedSimpleGraph<DirectedSimpleVertex>(12);
		DirectedSimpleVertex u = new DirectedSimpleVertex();
		DirectedSimpleVertex v = new DirectedSimpleVertex();
		graph.addVertex(u);
		graph.addVertex(v);
		u.addAdjacency(v);
		assertTrue("Vertex u in graph", graph.containsVertex(u));
		assertTrue("Vertex v in graph", graph.containsVertex(v));
		assertTrue("Graph contains edge (u, v)", graph.containsEdge(u, v));
		assertFalse("Graph doesn't contain edge (v, u)", graph.containsEdge(v, u));
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.AbstractGraph#removeVertex(com.codemelon.graph.vertex.Vertex)}.
	 */
	@Test
	public void testRemoveVertex() {
		graph.removeVertex(vertices.get(0));
		assertEquals((VERTICES_IN_TEST_GRAPH - 1) + " vertices in graph after removal", 
				VERTICES_IN_TEST_GRAPH - 1, graph.vertexCount());
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.AbstractGraph#vertexCount()}.
	 */
	@Test
	public void testVertexCount() {
		assertEquals(VERTICES_IN_TEST_GRAPH + " vertices in graph", VERTICES_IN_TEST_GRAPH,
				graph.vertexCount());
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.AbstractGraph#getVertices()}.
	 */
	@Test
	public void testGetVertices() {
		Set<DirectedSimpleVertex> vertexSet = graph.getVertices();
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			assertTrue("Vertex contained in set", vertexSet.contains(vertices.get(i)));
		}
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.AbstractGraph#vertexIterator()}.
	 */
	@Test
	public void testVertexIterator() {
		Iterator<DirectedSimpleVertex> it = graph.vertexIterator();
		while (it.hasNext()) {
			if (it.next() == vertices.get(0)) {
				return;
			}
		}
		fail("We shouldn't make it this far!");
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.AbstractGraph#containsEdge(com.codemelon.graph.vertex.Vertex, com.codemelon.graph.vertex.Vertex)}.
	 */
	@Test
	public void testContainsEdge() {
		assertTrue("Graph contains edge (0, 1)", graph.containsEdge(vertices.get(0), 
				vertices.get(1)));
	}
}

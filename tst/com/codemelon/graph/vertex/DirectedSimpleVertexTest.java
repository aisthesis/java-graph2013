package com.codemelon.graph.vertex;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Set;

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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		vertices = new HashMap<Integer, DirectedSimpleVertex>(VERTICES_IN_TEST_GRAPH);
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			vertices.put(i, new DirectedSimpleVertex());
		}
		new DirectedSimpleGraph(vertices.values());
		vertices.get(0).addAdjacency(vertices.get(1));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() {
		vertices = null;
	}
	/**
	 * Test method for {@link com.codemelon.graph.vertex.DirectedSimpleVertex#addAdjacency(T extends com.codemelon.graph.vertex.Vertex)}.
	 */
	@Test
	public void testAddAdjacency() {
		assertEquals("Vertex 0 has 1 adjacency", 1, vertices.get(0).adjacencyCount());
		assertTrue("Vertex 0 contains adjacency to 1", vertices.get(0).containsAdjacency(vertices.get(1)));
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			for (int j = 0; j < VERTICES_IN_TEST_GRAPH; j++) {
				if (i != 0 || j != 1) {
					assertFalse("No adjacency from vertex " + i + " to vertex " + j, 
							vertices.get(i).containsAdjacency(vertices.get(j)));
				}
			}
		}
	}
	/**
	 * Test method for {@link com.codemelon.graph.vertex.DirectedSimpleVertex#addAdjacency(T extends com.codemelon.graph.vertex.Vertex)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddFromDifferentGraph() {
		Vertex v = new DirectedSimpleVertex();
		vertices.get(2).addAdjacency(v);
	}
	/**
	 * Test method for {@link com.codemelon.graph.vertex.DirectedSimpleVertex#removeAdjacency(T extends com.codemelon.graph.vertex.Vertex)}.
	 */
	@Test
	public void testRemoveAdjacency() {
		assertFalse("Returns false when adjacency not present", 
				vertices.get(0).removeAdjacency(vertices.get(2)));
		assertEquals("Adjacency count still the same", 1, vertices.get(0).adjacencyCount());
		assertTrue("Returns true when adjacency is present",
				vertices.get(0).removeAdjacency(vertices.get(1)));
		assertEquals("Adjacency count is 0 after removal", 0, vertices.get(0).adjacencyCount());
		assertFalse("Adjacency set is empty", vertices.get(0).hasAdjacencies());
	}

	/**
	 * Test method for {@link com.codemelon.graph.vertex.DirectedSimpleVertex#clearAdjacencies()}.
	 */
	@Test
	public void testClearAdjacencies() {
		vertices.get(0).addAdjacency(vertices.get(2));
		vertices.get(0).addAdjacency(vertices.get(3));
		assertEquals("3 adjacencies before clear() operation", 3, vertices.get(0).adjacencyCount());
		vertices.get(0).clearAdjacencies();
		assertEquals("0 adjacencies after clear() operation", 0, vertices.get(0).adjacencyCount());
		assertFalse("Adjacency set is empty", vertices.get(0).hasAdjacencies());
	}
	/**
	 * Test method for {@link com.codemelon.graph.vertex.DirectedSimpleVertex#getAdjacencies()}.
	 */
	@Test
	public void testGetAdjacencies() {
		Set<? extends Vertex> adjacencies = vertices.get(0).getAdjacencies();
		assertTrue("Adjacency set for vertex 0 contains vertex 1", adjacencies.contains(vertices.get(1)));
		assertEquals("Adjacency set for vertex 0 has size 1", 1, adjacencies.size());
		for (int i = 1; i < VERTICES_IN_TEST_GRAPH; i++) {
			assertTrue("Adjacency set for vertex " + i + " is empty", 
					vertices.get(i).getAdjacencies().isEmpty());
		}
	}
}

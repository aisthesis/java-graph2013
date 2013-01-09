package com.codemelon.graph.vertex;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codemelon.graph.edge.DfsEdgeData;
import com.codemelon.graph.graph.UndirectedEdgeDataGraph;

public class UndirectedEdgeDataVertexTest {
	private static final int VERTICES_IN_TEST_GRAPH = 10;
	private HashMap<Integer, UndirectedEdgeDataVertex<DfsEdgeData>> vertices;

	@Before
	public void setUp() {
		vertices = new HashMap<Integer, UndirectedEdgeDataVertex<DfsEdgeData>>(VERTICES_IN_TEST_GRAPH);
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			vertices.put(i, new UndirectedEdgeDataVertex<DfsEdgeData>(DfsEdgeData.Factory.INSTANCE));
		}
		new UndirectedEdgeDataGraph<DfsEdgeData, UndirectedEdgeDataVertex<DfsEdgeData>>(vertices.values());
		vertices.get(0).addAdjacency(vertices.get(1));
	}

	@After
	public void tearDown() {
		vertices = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.vertex.UndirectedEdgeDataVertex#addAdjacency(com.codemelon.graph.vertex.Vertex)}.
	 */
	@Test
	public void testAddAdjacency() {
		assertEquals("Vertex 0 has 1 adjacency", 1, vertices.get(0).adjacencyCount());
		assertTrue("Vertex 0 contains adjacency to 1", vertices.get(0).containsAdjacency(vertices.get(1)));
		assertEquals("Vertex 1 has 1 adjacency", 1, vertices.get(1).adjacencyCount());
		assertTrue("Vertex 1 contains adjacency to 0", vertices.get(1).containsAdjacency(vertices.get(0)));
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			for (int j = 0; j < VERTICES_IN_TEST_GRAPH; j++) {
				if (!(i == 0 && j == 1) && !(i == 1 && j == 0)) {
					assertFalse("No adjacency from vertex " + i + " to vertex " + j, 
							vertices.get(i).containsAdjacency(vertices.get(j)));
				}
			}
		}
	}
	/**
	 * Test method for {@link com.codemelon.graph.vertex.UndirectedEdgeDataVertex#addAdjacency(com.codemelon.graph.vertex.Vertex)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddFromDifferentGraph() {
		Vertex v = new UndirectedEdgeDataVertex<DfsEdgeData>(DfsEdgeData.Factory.INSTANCE);
		vertices.get(2).addAdjacency(v);
	}

	@Test
	public void testRemoveAdjacency() {
		assertFalse("Returns false when adjacency not present", 
				vertices.get(0).removeAdjacency(vertices.get(2)));
		assertEquals("Adjacency count still the same", 1, vertices.get(0).adjacencyCount());
		assertTrue("Returns true when adjacency is present",
				vertices.get(1).removeAdjacency(vertices.get(0)));
		assertEquals("Adjacency count is 0 after removal", 0, vertices.get(0).adjacencyCount());
		assertFalse("Adjacency set is empty", vertices.get(0).hasAdjacencies());
	}

	@Test
	public void testClearAdjacencies() {
		vertices.get(2).addAdjacency(vertices.get(0));
		vertices.get(3).addAdjacency(vertices.get(0));
		assertEquals("3 adjacencies before clear() operation", 3, vertices.get(0).adjacencyCount());
		vertices.get(2).clearAdjacencies();
		assertEquals("0 adjacencies after clear() operation", 0, vertices.get(2).adjacencyCount());
		assertFalse("Adjacency set is empty", vertices.get(2).hasAdjacencies());
		assertEquals("Vertex 0 still has 2 adjacencies", 2, vertices.get(0).adjacencyCount());
	}
	/**
	 * Test method for {@link com.codemelon.graph.vertex.DirectedEdgeDataVertex#getAdjacencies()}.
	 */
	@Test
	public void testGetAdjacencies() {
		Set<? extends Vertex> adjacencies0 = vertices.get(0).getAdjacencies();
		Set<? extends Vertex> adjacencies1 = vertices.get(1).getAdjacencies();
		assertTrue("Adjacency set for vertex 0 contains vertex 1", adjacencies0.contains(vertices.get(1)));
		assertTrue("Adjacency set for vertex 1 contains vertex 0", adjacencies1.contains(vertices.get(0)));
		assertEquals("Adjacency set for vertex 0 has size 1", 1, adjacencies0.size());
		assertEquals("Adjacency set for vertex 1 has size 1", 1, adjacencies1.size());
		for (int i = 2; i < VERTICES_IN_TEST_GRAPH; i++) {
			assertTrue("Adjacency set for vertex " + i + " is empty", 
					vertices.get(i).getAdjacencies().isEmpty());
		}
	}
}

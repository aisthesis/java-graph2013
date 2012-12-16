package com.codemelon.graph.algorithm.search;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Test;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.graph.BfsGraph;
import com.codemelon.graph.vertex.BfsVertex;
import com.codemelon.graph.vertex.UndirectedBfsVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class BreadthFirstSearchTest {
	private static final int VERTICES_IN_TEST_GRAPH = 1000;
	private BfsGraph<UndirectedBfsVertex> graph;
	
	@After
	public void tearDown() {
		graph = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.BreadthFirstSearch#search(com.codemelon.graph.vertex.BfsVertex)}.
	 */
	@Test
	public void testBigSparseGraph() {
		HashMap<Integer, UndirectedBfsVertex> vertices = setUpBigSparseGraph();
		new BreadthFirstSearch<UndirectedBfsVertex>(graph).search(vertices.get(1));
		// vertex 0 is unreachable and hence white, etc.
		assertEquals("Vertex 0 is white", Color.WHITE, vertices.get(0).getColor());
		assertEquals("Vertex 0 has distance -1", -1, vertices.get(0).getDistance());
		assertNull("Vertex 0 has null parent", vertices.get(0).getParent());
		// vertices 1 through VERTICES_IN_TEST_GRAPH / 2 + 1 are black
		for (int i = 1; i < VERTICES_IN_TEST_GRAPH / 2 + 1; i++) {
			assertEquals("Reachable vertices are black", Color.BLACK, vertices.get(i).getColor());
		}
		// vertices have correct distance
		for (int i = 1; i < VERTICES_IN_TEST_GRAPH / 2; i++) {
			assertEquals("Correct distance for reachable vertices", i - 1, vertices.get(i).getDistance());
		}
		assertEquals("Correct distance for fork", VERTICES_IN_TEST_GRAPH / 4, 
				vertices.get(VERTICES_IN_TEST_GRAPH / 2 + 1).getDistance());
		for (int i = VERTICES_IN_TEST_GRAPH / 2 + 2; i < VERTICES_IN_TEST_GRAPH; i++) {
			assertEquals("Correct distances for unreachable vertices", -1, vertices.get(i).getDistance());
		}
		// vertices have correct parents
		assertNull("Source vertex has null parent", vertices.get(1).getParent());
		for (int i = 2; i < VERTICES_IN_TEST_GRAPH / 2; i++) {
			assertEquals("Correct parents for reachable vertices", vertices.get(i - 1), 
					vertices.get(i).getParent());
		}
		assertEquals("Correct parent for fork", vertices.get(VERTICES_IN_TEST_GRAPH / 4), 
				vertices.get(VERTICES_IN_TEST_GRAPH / 2 + 1).getParent());
		for (int i = VERTICES_IN_TEST_GRAPH / 2 + 2; i < VERTICES_IN_TEST_GRAPH; i++) {
			assertNull("Null parent for unreachable vertices", vertices.get(i).getParent());
		}
	}
	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.BreadthFirstSearch#search(com.codemelon.graph.vertex.BfsVertex)}.
	 */
	@Test
	public void testSmallCLRSGraph() {
		HashMap<Character, UndirectedBfsVertex> vertices = setUpSmallCLRSGraph();
		new BreadthFirstSearch<UndirectedBfsVertex>(graph).search(vertices.get('s'));
		for (char i = 'r'; i <= 'y'; i++) {
			assertEquals("All vertices are black", Color.BLACK, vertices.get(i).getColor());
		}
		// each vertex has correct parent and distance
		assertEquals("Vertex r has correct distance", 1, vertices.get('r').getDistance());
		assertEquals("Vertex r has correct parent", vertices.get('s'), vertices.get('r').getParent());
		assertEquals("Vertex s has correct distance", 0, vertices.get('s').getDistance());
		assertEquals("Vertex s has correct parent", null, vertices.get('s').getParent());
		assertEquals("Vertex t has correct distance", 2, vertices.get('t').getDistance());
		assertEquals("Vertex t has correct parent", vertices.get('w'), vertices.get('t').getParent());
		assertEquals("Vertex u has correct distance", 3, vertices.get('u').getDistance());
		// parent for u can be either t or x
		assertEquals("Vertex v has correct distance", 2, vertices.get('v').getDistance());
		assertEquals("Vertex v has correct parent", vertices.get('r'), vertices.get('v').getParent());
		assertEquals("Vertex w has correct distance", 1, vertices.get('w').getDistance());
		assertEquals("Vertex w has correct parent", vertices.get('s'), vertices.get('w').getParent());
		assertEquals("Vertex x has correct distance", 2, vertices.get('x').getDistance());
		assertEquals("Vertex x has correct parent", vertices.get('w'), vertices.get('x').getParent());
		assertEquals("Vertex y has correct distance", 3, vertices.get('y').getDistance());
		assertEquals("Vertex y has correct parent", vertices.get('x'), vertices.get('y').getParent());		
	}
	
	/**
	 * throw an exception if path() called before search()
	 * Test method for {@link com.codemelon.graph.algorithm.search.BreadthFirstSearch#path(com.codemelon.graph.vertex.CompleteVertex)}.
	 */
	@Test(expected=IllegalStateException.class)
	public void testPathBeforeSearch() {
		HashMap<Character, UndirectedBfsVertex> vertices = setUpSmallCLRSGraph();
		new BreadthFirstSearch<UndirectedBfsVertex>(graph).path(vertices.get('t'));
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.BreadthFirstSearch#getSourceVertex()}.
	 */
	@Test
	public void testGetSourceVertex() {
		HashMap<Character, UndirectedBfsVertex> vertices = setUpSmallCLRSGraph();
		BreadthFirstSearch<UndirectedBfsVertex> bfs = new BreadthFirstSearch<UndirectedBfsVertex>(graph);
		bfs.search(vertices.get('s'));
		assertEquals("Correct source vertex", vertices.get('s'), bfs.getSourceVertex());
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.BreadthFirstSearch#path(com.codemelon.graph.vertex.BfsVertex)}.
	 */
	@Test
	public void testPath() {
		HashMap<Character, UndirectedBfsVertex> vertices = setUpSmallCLRSGraph();
		BreadthFirstSearch<UndirectedBfsVertex> bfs = new BreadthFirstSearch<UndirectedBfsVertex>(graph);
		bfs.search(vertices.get('s'));
		LinkedList<BfsVertex> path = bfs.path(vertices.get('y'));
		Iterator<BfsVertex> it = path.listIterator();
		assertEquals("Start of path is 's'", vertices.get('s'), it.next());
		assertEquals("Next in path is 'w'", vertices.get('w'), it.next());
		assertEquals("Next in path is 'x'", vertices.get('x'), it.next());
		assertEquals("Next in path is 'y'", vertices.get('y'), it.next());
		assertFalse("Nothing else in list", it.hasNext());
	}
	/**
	 * Graph with sequential (from vertex i to i + 1) edges on the lower-numbered vertices,
	 * no edges on higher-numbered vertices, and one forked edge.
	 */
	private HashMap<Integer, UndirectedBfsVertex> setUpBigSparseGraph() {
		HashMap<Integer, UndirectedBfsVertex> vertices = new HashMap<Integer, UndirectedBfsVertex>(VERTICES_IN_TEST_GRAPH);
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			vertices.put(i, new UndirectedBfsVertex());
		}
		graph = new BfsGraph<UndirectedBfsVertex>(vertices.values());
		for (int i = 1; i < VERTICES_IN_TEST_GRAPH / 2; i++) {
			vertices.get(i).addAdjacency(vertices.get(i + 1));
		}
		vertices.get(VERTICES_IN_TEST_GRAPH / 4).addAdjacency(vertices.get(VERTICES_IN_TEST_GRAPH / 2 + 1));
		return vertices;
	}
	
	/**
	 * Graph from CLRS, p. 596
	 */
	private HashMap<Character, UndirectedBfsVertex> setUpSmallCLRSGraph() {
		HashMap<Character, UndirectedBfsVertex> vertices = new HashMap<Character, UndirectedBfsVertex>();
		for (char i = 'r'; i <= 'y'; i++) {
			vertices.put(i, new UndirectedBfsVertex());
		}
		graph = new BfsGraph<UndirectedBfsVertex>(vertices.values());
		vertices.get('r').addAdjacency(vertices.get('s'));
		vertices.get('r').addAdjacency(vertices.get('v'));
		vertices.get('s').addAdjacency(vertices.get('w'));
		vertices.get('t').addAdjacency(vertices.get('u'));
		vertices.get('t').addAdjacency(vertices.get('w'));
		vertices.get('t').addAdjacency(vertices.get('x'));
		vertices.get('u').addAdjacency(vertices.get('x'));
		vertices.get('u').addAdjacency(vertices.get('y'));
		vertices.get('w').addAdjacency(vertices.get('x'));
		vertices.get('x').addAdjacency(vertices.get('y'));
		return vertices;
	}
}

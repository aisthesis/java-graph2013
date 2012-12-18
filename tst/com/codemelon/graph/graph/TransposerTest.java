package com.codemelon.graph.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codemelon.graph.vertex.DirectedOrderedDfsVertex;
import com.codemelon.graph.vertex.VertexFactory;

/**
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public class TransposerTest {
	private static final int VERTICES_IN_TEST_GRAPH = 1000;
	
	private DirectedSimpleGraph<DirectedOrderedDfsVertex> graph;
	private ArrayList<DirectedOrderedDfsVertex> vertices;
	private VertexFactory<DirectedOrderedDfsVertex> vertexFactory;
	private GraphFactory<DirectedOrderedDfsVertex> graphFactory;
	private Map<DirectedOrderedDfsVertex, DirectedOrderedDfsVertex> vertexMap;

	@Before
	public void setUp() {
		vertices = new ArrayList<DirectedOrderedDfsVertex>(VERTICES_IN_TEST_GRAPH);
		vertexFactory = DirectedOrderedDfsVertex.Factory.INSTANCE;
		graphFactory = OrderedDfsGraphFactory.INSTANCE;
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			vertices.add(vertexFactory.newVertex());
		}
		graph = new DirectedSimpleGraph<DirectedOrderedDfsVertex>(vertices);
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH - 1; i++) {
			vertices.get(i).addAdjacency(vertices.get(i + 1));
		}
		vertexMap = null;
	}
	@After
	public void tearDown() {
		graph = null;
		vertices = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.graph.Transposer#Transposer(com.codemelon.graph.graph.AbstractGraph, com.codemelon.graph.vertex.VertexFactory, com.codemelon.graph.graph.GraphFactory)}.
	 */
	@Test
	public void testTransposer() {
		Transposer<DirectedOrderedDfsVertex, DirectedOrderedDfsVertex> transposer = 
				new Transposer<DirectedOrderedDfsVertex, DirectedOrderedDfsVertex>(graph, 
				vertexFactory, graphFactory);
		AbstractGraph<DirectedOrderedDfsVertex> transposeGraph = transposer.getTransposeGraph();
		vertexMap = transposer.getVertexMap();
		assertEquals("Correct number of edges in transposed graph", 
				VERTICES_IN_TEST_GRAPH - 1, transposeGraph.edgeCount());
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH - 1; i++) {
			assertTrue("Transpose graph contains edge (" + (i + 1) + ", " + i + ")", 
					transposeGraph.containsEdge(vertexMap.get(vertices.get(i + 1)), 
					vertexMap.get(vertices.get(i))));
			assertFalse("Transpose graph doesn't contain edge (" + i + ", " + (i + 1) + ")", 
					transposeGraph.containsEdge(vertexMap.get(vertices.get(i)), 
					vertexMap.get(vertices.get(i + 1))));
		}
	}
}

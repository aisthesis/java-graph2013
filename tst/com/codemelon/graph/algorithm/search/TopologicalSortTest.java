package com.codemelon.graph.algorithm.search;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Test;

import com.codemelon.graph.graph.DirectedSimpleGraph;
import com.codemelon.graph.vertex.DirectedSimpleColoredVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public class TopologicalSortTest {
	private DirectedSimpleGraph<DirectedSimpleColoredVertex> graph;
	
	@After
	public void tearDown() {
		graph = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.TopologicalSort#precedes(com.codemelon.graph.vertex.ColoredVertex, com.codemelon.graph.vertex.ColoredVertex)}.
	 */
	@Test
	public void testPrecedes() {
		HashMap<String, DirectedSimpleColoredVertex> vertices = setUpSmallCLRSGraph();
		TopologicalSort<DirectedSimpleColoredVertex> topSort = 
				new TopologicalSort<DirectedSimpleColoredVertex>(graph);
		assertTrue("Proper precedences", topSort.precedes(vertices.get("undershorts"), 
				vertices.get("pants")));
		assertTrue("Proper precedences", topSort.precedes(vertices.get("socks"), 
				vertices.get("shoes")));
		assertTrue("Proper precedences", topSort.precedes(vertices.get("pants"), 
				vertices.get("belt")));
		assertTrue("Proper precedences", topSort.precedes(vertices.get("undershorts"), 
				vertices.get("shoes")));
		assertTrue("Proper precedences", topSort.precedes(vertices.get("pants"), 
				vertices.get("shoes")));
		assertTrue("Proper precedences", topSort.precedes(vertices.get("shirt"), 
				vertices.get("belt")));
		assertTrue("Proper precedences", topSort.precedes(vertices.get("shirt"), 
				vertices.get("tie")));
		assertTrue("Proper precedences", topSort.precedes(vertices.get("tie"), 
				vertices.get("jacket")));
	}

	/**
	 * Graph from CLRS, p. 613
	 */
	private HashMap<String, DirectedSimpleColoredVertex> setUpSmallCLRSGraph() {
		HashMap<String, DirectedSimpleColoredVertex> vertices = 
				new HashMap<String, DirectedSimpleColoredVertex>();
		vertices.put("undershorts", new DirectedSimpleColoredVertex());
		vertices.put("pants", new DirectedSimpleColoredVertex());
		vertices.put("belt", new DirectedSimpleColoredVertex());
		vertices.put("shirt", new DirectedSimpleColoredVertex());
		vertices.put("tie", new DirectedSimpleColoredVertex());
		vertices.put("jacket", new DirectedSimpleColoredVertex());
		vertices.put("socks", new DirectedSimpleColoredVertex());
		vertices.put("shoes", new DirectedSimpleColoredVertex());
		vertices.put("watch", new DirectedSimpleColoredVertex());
		graph = new DirectedSimpleGraph<DirectedSimpleColoredVertex>(vertices.values());
		vertices.get("undershorts").addAdjacency(vertices.get("pants"));
		vertices.get("undershorts").addAdjacency(vertices.get("shoes"));
		vertices.get("pants").addAdjacency(vertices.get("belt"));
		vertices.get("pants").addAdjacency(vertices.get("shoes"));
		vertices.get("socks").addAdjacency(vertices.get("shoes"));
		vertices.get("shirt").addAdjacency(vertices.get("belt"));
		vertices.get("shirt").addAdjacency(vertices.get("tie"));
		vertices.get("belt").addAdjacency(vertices.get("jacket"));
		vertices.get("tie").addAdjacency(vertices.get("jacket"));
		return vertices;
	}
}

package com.codemelon.graph.edge;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.junit.rules.ExpectedException;

import com.codemelon.graph.graph.KruskalGraph;
import com.codemelon.graph.vertex.UndirectedKruskalVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 22, 2012
 * @my.edited Dec 22, 2012
 */
public class UndirectedWeightedEdgeTest {
	private static final double CUSTOM_WEIGHT = 2.71828;
	private static final int VERTICES_IN_TEST_GRAPH = 10;
	private HashMap<Integer, UndirectedKruskalVertex<SpanningTreeEdgeData>> vertices;
	private KruskalGraph<SpanningTreeEdgeData> graph;

	@Before
	public void setUp() {
		vertices = new HashMap<Integer, UndirectedKruskalVertex<SpanningTreeEdgeData>>(VERTICES_IN_TEST_GRAPH);
		for (int i = 0; i < VERTICES_IN_TEST_GRAPH; i++) {
			vertices.put(i, new UndirectedKruskalVertex<SpanningTreeEdgeData>(SpanningTreeEdgeData.Factory.INSTANCE));
		}
		graph = new KruskalGraph<SpanningTreeEdgeData>(vertices.values());
		vertices.get(0).addAdjacency(vertices.get(1));
		vertices.get(0).setEdgeWeight(vertices.get(1), CUSTOM_WEIGHT);
		vertices.get(2).addAdjacency(vertices.get(3));
	}

	@After
	public void tearDown() {
		vertices = null;
		graph = null;
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * An exception should be thrown if the constructor is called on vertices that don't belong
	 * to a graph.
	 * Test method for {@link com.codemelon.graph.edge.UndirectedWeightedEdge#UndirectedWeightedEdge(Vertex, Vertex)}.
	 */
	@Test
	public void testUndirectedWeightedEdgeNullGraph() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(JUnitMatchers.containsString("does not exist"));
		UndirectedKruskalVertex<SpanningTreeEdgeData> u = new UndirectedKruskalVertex<SpanningTreeEdgeData>(SpanningTreeEdgeData.Factory.INSTANCE);
		UndirectedKruskalVertex<SpanningTreeEdgeData> v = new UndirectedKruskalVertex<SpanningTreeEdgeData>(SpanningTreeEdgeData.Factory.INSTANCE);
		UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>> e = 
				new UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>>(u, v);
		e.from();	
	}
	/**
	 * An exception should be thrown if the constructor is called on vertices belonging to different graphs.
	 * Test method for {@link com.codemelon.graph.edge.UndirectedWeightedEdge#UndirectedWeightedEdge(Vertex, Vertex)}.
	 */
	@Test
	public void testUndirectedWeightedEdgeDifferentGraphs() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(JUnitMatchers.containsString("does not exist"));
		UndirectedKruskalVertex<SpanningTreeEdgeData> u = new UndirectedKruskalVertex<SpanningTreeEdgeData>(SpanningTreeEdgeData.Factory.INSTANCE);
		KruskalGraph<SpanningTreeEdgeData> g2 = 
				new KruskalGraph<SpanningTreeEdgeData>();
		g2.addVertex(u);
		assertEquals("u belongs to g2", g2, u.getGraph());
		assertEquals("0 vertex belongs to graph", graph, vertices.get(0).getGraph());
		UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>> e = 
				new UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>>(u, vertices.get(0));
		e.from();		
	}
	/**
	 * An exception should be thrown if the constructor is called on vertices belonging to the same graph but
	 * not connected by an edge.
	 * Test method for {@link com.codemelon.graph.edge.UndirectedWeightedEdge#UndirectedWeightedEdge(Vertex, Vertex)}.
	 */
	@Test
	public void testUndirectedWeightedEdgeNoSuchEdge() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(JUnitMatchers.containsString("does not exist"));
		UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>> e = 
				new UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>>(vertices.get(2), 
				vertices.get(0));
		e.from();
	}
	/**
	 * Test method for {@link com.codemelon.graph.edge.UndirectedWeightedEdge#from()}.
	 */
	@Test
	public void testFrom() {
		UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>> e 
				= new UndirectedWeightedEdge<SpanningTreeEdgeData, 
				UndirectedKruskalVertex<SpanningTreeEdgeData>>(vertices.get(1), vertices.get(0));
		assertEquals("correct tail", vertices.get(1), e.from());
	}

	/**
	 * Test method for {@link com.codemelon.graph.edge.UndirectedWeightedEdge#to()}.
	 */
	@Test
	public void testTo() {
		UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>> e = 
				new UndirectedWeightedEdge<SpanningTreeEdgeData, 
				UndirectedKruskalVertex<SpanningTreeEdgeData>>(vertices.get(0), vertices.get(1));
		assertEquals("correct head", vertices.get(1), e.to());
	}

	/**
	 * Test method for {@link com.codemelon.graph.edge.UndirectedWeightedEdge#weight()}.
	 */
	@Test
	public void testWeight() {
		UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>> e = 
				new UndirectedWeightedEdge<SpanningTreeEdgeData, 
				UndirectedKruskalVertex<SpanningTreeEdgeData>>(vertices.get(1), vertices.get(0));
		assertTrue("correct weight", graph.areEqualWeights(e.weight(), 
				vertices.get(0).getEdgeWeight(vertices.get(1))));
	}
	/**
	 * Test method for {@link com.codemelon.graph.edge.UndirectedWeightedEdge#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>> e1 = 
				new UndirectedWeightedEdge<SpanningTreeEdgeData, 
				UndirectedKruskalVertex<SpanningTreeEdgeData>>(vertices.get(1), vertices.get(0));
		UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>> e2 = 
				new UndirectedWeightedEdge<SpanningTreeEdgeData, 
				UndirectedKruskalVertex<SpanningTreeEdgeData>>(vertices.get(0), vertices.get(1));
		UndirectedWeightedEdge<SpanningTreeEdgeData, UndirectedKruskalVertex<SpanningTreeEdgeData>> e3 = 
				new UndirectedWeightedEdge<SpanningTreeEdgeData, 
				UndirectedKruskalVertex<SpanningTreeEdgeData>>(vertices.get(2), vertices.get(3));
		assertEquals("equals if same edge", e1, e1);
		assertEquals("equals if same vertices but opposite direction", e1, e2);
		assertFalse("Not equal if different edge", e1.equals(e3));
	}
}

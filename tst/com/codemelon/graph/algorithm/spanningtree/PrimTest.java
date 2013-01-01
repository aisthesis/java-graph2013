package com.codemelon.graph.algorithm.spanningtree;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.SpanningTreeEdgeData;
import com.codemelon.graph.graph.UndirectedWeightedEdgeGraph;
import com.codemelon.graph.vertex.UndirectedPrimVertex;

/**
 * @author Marshall Farrier
 * @my.created Jan 1, 2013
 * @my.edited Jan 1, 2013
 */
public class PrimTest {
	private UndirectedWeightedEdgeGraph<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
			UndirectedPrimVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>> graph;
	private Prim<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
			UndirectedPrimVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>> prim;
	private HashMap<Character, UndirectedPrimVertex<SpanningTreeEdgeData, 
			SpanningTreeEdgeData.Factory>> vertices;

	@Before
	public void setUp() {
		setUpCLRSGraph();
	}
	
	@After
	public void tearDown() {
		graph = null;
		prim = null;
		vertices = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.spanningtree.Prim#markEdges(com.codemelon.graph.vertex.UndirectedPrimVertex)}.
	 */
	@Test
	public void testMarkEdges() {
		prim = new Prim<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
				UndirectedPrimVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>>(graph);
		for (char i = 'a'; i <= 'i'; i++) {
			prim.markEdges(vertices.get(i));
			assertEquals("Edge a-b marked", Color.BLACK, vertices.get('a').getEdgeColor(vertices.get('b')));
			assertEquals("Edge h-g marked", Color.BLACK, vertices.get('h').getEdgeColor(vertices.get('g')));
			assertEquals("Edge c-i marked", Color.BLACK, vertices.get('c').getEdgeColor(vertices.get('i')));
			assertEquals("Edge f-g marked", Color.BLACK, vertices.get('f').getEdgeColor(vertices.get('g')));
			assertEquals("Edge c-f marked", Color.BLACK, vertices.get('c').getEdgeColor(vertices.get('f')));
			assertEquals("Edge c-d marked", Color.BLACK, vertices.get('c').getEdgeColor(vertices.get('d')));
			assertEquals("Edge d-e marked", Color.BLACK, vertices.get('d').getEdgeColor(vertices.get('e')));
			assertEquals("Edge b-h unmarked", Color.WHITE, vertices.get('b').getEdgeColor(vertices.get('h')));
			assertEquals("Edge i-h unmarked", Color.WHITE, vertices.get('i').getEdgeColor(vertices.get('h')));
			assertEquals("Edge g-i unmarked", Color.WHITE, vertices.get('g').getEdgeColor(vertices.get('i')));
			assertEquals("Edge d-f unmarked", Color.WHITE, vertices.get('d').getEdgeColor(vertices.get('f')));
			assertEquals("Edge e-f unmarked", Color.WHITE, vertices.get('e').getEdgeColor(vertices.get('f')));			
		}
	}
	
	/**
	 * Graph from CLRS, p. 596
	 */
	private void setUpCLRSGraph() {
		vertices = new HashMap<Character, UndirectedPrimVertex<SpanningTreeEdgeData, 
				SpanningTreeEdgeData.Factory>>();
		for (char i = 'a'; i <= 'i'; i++) {
			vertices.put(i, new UndirectedPrimVertex<SpanningTreeEdgeData, 
					SpanningTreeEdgeData.Factory>(SpanningTreeEdgeData.Factory.INSTANCE));
		}
		graph = new UndirectedWeightedEdgeGraph<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
				UndirectedPrimVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>>(vertices.values());
		vertices.get('a').addAdjacency(vertices.get('b'));
		vertices.get('a').setEdgeWeight(vertices.get('b'), 4.0);
		vertices.get('a').addAdjacency(vertices.get('h'));
		vertices.get('a').setEdgeWeight(vertices.get('h'), 8.0);
		vertices.get('b').addAdjacency(vertices.get('h'));
		vertices.get('h').setEdgeWeight(vertices.get('b'), 11.0);
		vertices.get('b').addAdjacency(vertices.get('c'));
		vertices.get('c').setEdgeWeight(vertices.get('b'), 8.0);
		vertices.get('c').addAdjacency(vertices.get('d'));
		vertices.get('c').setEdgeWeight(vertices.get('d'), 7.0);
		vertices.get('c').addAdjacency(vertices.get('f'));
		vertices.get('c').setEdgeWeight(vertices.get('f'), 4.0);
		vertices.get('c').addAdjacency(vertices.get('i'));
		vertices.get('c').setEdgeWeight(vertices.get('i'), 2.0);
		vertices.get('d').addAdjacency(vertices.get('e'));
		vertices.get('d').setEdgeWeight(vertices.get('e'), 9.0);
		vertices.get('d').addAdjacency(vertices.get('f'));
		vertices.get('d').setEdgeWeight(vertices.get('f'), 14.0);
		vertices.get('e').addAdjacency(vertices.get('f'));
		vertices.get('e').setEdgeWeight(vertices.get('f'), 10.0);
		vertices.get('f').addAdjacency(vertices.get('g'));
		vertices.get('g').setEdgeWeight(vertices.get('f'), 2.0);
		vertices.get('g').addAdjacency(vertices.get('h'));
		vertices.get('g').setEdgeWeight(vertices.get('h'), 1.0);
		vertices.get('g').addAdjacency(vertices.get('i'));
		vertices.get('g').setEdgeWeight(vertices.get('i'), 6.0);
		vertices.get('h').addAdjacency(vertices.get('i'));
		vertices.get('h').setEdgeWeight(vertices.get('i'), 7.0);
	}
}
package com.codemelon.graph.algorithm.spanningtree;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.SpanningTreeEdgeData;
import com.codemelon.graph.graph.UndirectedWeightedEdgeGraph;
import com.codemelon.graph.vertex.UndirectedKruskalVertex;
import com.codemelon.graph.vertex.UndirectedKruskalVertexBuilder;

/**
 * @author Marshall Farrier
 * @my.created Dec 24, 2012
 * @my.edited Dec 24, 2012
 */
public class KruskalTest {
	private static final double CUSTOM_EPSILON = 0.001;
	private static final double MAX_EPSILON_DIFF = 0.000000000000001;
	private static final UndirectedKruskalVertexBuilder<SpanningTreeEdgeData, 
			SpanningTreeEdgeData.Factory> VERTEX_FACTORY = new UndirectedKruskalVertexBuilder<SpanningTreeEdgeData, 
			SpanningTreeEdgeData.Factory>(SpanningTreeEdgeData.Factory.INSTANCE);
	
	private UndirectedWeightedEdgeGraph<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
			UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>> graph;
	private Kruskal<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
			UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>,
			UndirectedKruskalVertexBuilder<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>> kruskal;
	private HashMap<Character, UndirectedKruskalVertex<SpanningTreeEdgeData, 
			SpanningTreeEdgeData.Factory>> vertices;
	/**
	 * Set up graph from CLRS, p. 632
	 */
	@Before
	public void setUp() {
		setUpCLRSGraph();
	}
	@After
	public void tearDown() {
		graph = null;
		kruskal = null;
		vertices = null;
	}

	/**
	 * Also tests the constructor when passing in a null value for vertexFactory.
	 * Test method for {@link com.codemelon.graph.algorithm.spanningtree.Kruskal#markEdges()}.
	 */
	@Test
	public void testMarkEdges() {
		kruskal = new Kruskal<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
				UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>,
				UndirectedKruskalVertexBuilder<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>>(graph, null);
		kruskal.markEdges();
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

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.spanningtree.Kruskal#generateTree()}.
	 */
	@Test
	public void testGenerateTree() {
		kruskal = new Kruskal<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
				UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>,
				UndirectedKruskalVertexBuilder<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>>(graph, VERTEX_FACTORY);
		UndirectedWeightedEdgeGraph<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
		UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>> spanningTree = kruskal.generateTree();
		Map<UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>,
				UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>> vertexMap = kruskal.getVertexMap();
		assertTrue("Edge a-b in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('a')),
				vertexMap.get(vertices.get('b'))));
		assertTrue("a-b copy has correct weight", spanningTree.areEqualWeights(4.0, 
				vertexMap.get(vertices.get('a')).getEdgeWeight(vertexMap.get(vertices.get('b')))));
		assertTrue("Edge h-g in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('h')),
				vertexMap.get(vertices.get('g'))));
		assertTrue("h-g copy has correct weight", spanningTree.areEqualWeights(1.0,
				vertexMap.get(vertices.get('h')).getEdgeWeight(vertexMap.get(vertices.get('g')))));
		assertTrue("Edge c-i in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('c')),
				vertexMap.get(vertices.get('i'))));
		assertTrue("c-i copy has correct weight", spanningTree.areEqualWeights(2.0,
				vertexMap.get(vertices.get('c')).getEdgeWeight(vertexMap.get(vertices.get('i')))));		
		assertTrue("Edge f-g in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('f')),
				vertexMap.get(vertices.get('g'))));
		assertTrue("f-g copy has correct weight", spanningTree.areEqualWeights(2.0,
				vertexMap.get(vertices.get('f')).getEdgeWeight(vertexMap.get(vertices.get('g')))));
		assertTrue("Edge c-f in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('c')),
				vertexMap.get(vertices.get('f'))));
		assertTrue("c-f copy has correct weight", spanningTree.areEqualWeights(4.0,
				vertexMap.get(vertices.get('c')).getEdgeWeight(vertexMap.get(vertices.get('f')))));
		assertTrue("Edge c-d in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('c')),
				vertexMap.get(vertices.get('d'))));
		assertTrue("c-d copy has correct weight", spanningTree.areEqualWeights(7.0,
				vertexMap.get(vertices.get('c')).getEdgeWeight(vertexMap.get(vertices.get('d')))));
		assertTrue("Edge d-e in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('d')),
				vertexMap.get(vertices.get('e'))));
		assertTrue("d-e copy has correct weight", spanningTree.areEqualWeights(9.0,
				vertexMap.get(vertices.get('d')).getEdgeWeight(vertexMap.get(vertices.get('e')))));
		assertFalse("Edge b-h not in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('b')),
				vertexMap.get(vertices.get('h'))));
		assertFalse("Edge i-h not in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('i')),
				vertexMap.get(vertices.get('h'))));
		assertFalse("Edge g-i not in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('g')),
				vertexMap.get(vertices.get('i'))));
		assertFalse("Edge d-f not in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('d')),
				vertexMap.get(vertices.get('f'))));
		assertFalse("Edge e-f not in graph", spanningTree.containsEdge(vertexMap.get(vertices.get('e')),
				vertexMap.get(vertices.get('f'))));
		assertTrue("Weight epsilons equal", Math.abs(spanningTree.getWeightEpsilon() 
				- graph.getWeightEpsilon()) < MAX_EPSILON_DIFF);
	}

	/**
	 * Test getting vertex map prior to running generateTree()
	 * Test method for {@link com.codemelon.graph.algorithm.spanningtree.Kruskal#getVertexMap()}.
	 */
	@Test(expected=IllegalStateException.class)
	public void testGetVertexMap() {
		kruskal = new Kruskal<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
				UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>,
				UndirectedKruskalVertexBuilder<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>>(graph, VERTEX_FACTORY);
		Map<UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>,
				UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>> vertexMap = kruskal.getVertexMap();
		vertexMap.get(vertices.get('a'));
	}

	/**
	 * Graph from CLRS, p. 596
	 */
	private void setUpCLRSGraph() {
		vertices = new HashMap<Character, UndirectedKruskalVertex<SpanningTreeEdgeData, 
				SpanningTreeEdgeData.Factory>>();
		for (char i = 'a'; i <= 'i'; i++) {
			vertices.put(i, new UndirectedKruskalVertex<SpanningTreeEdgeData, 
					SpanningTreeEdgeData.Factory>(SpanningTreeEdgeData.Factory.INSTANCE));
		}
		graph = new UndirectedWeightedEdgeGraph<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory,
				UndirectedKruskalVertex<SpanningTreeEdgeData, SpanningTreeEdgeData.Factory>>(vertices.values(),
				CUSTOM_EPSILON);
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

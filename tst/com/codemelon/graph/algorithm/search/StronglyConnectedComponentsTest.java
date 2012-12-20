package com.codemelon.graph.algorithm.search;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Test;

import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.graph.DirectedSimpleGraph;
import com.codemelon.graph.graph.OrderedDfsGraphFactory;
import com.codemelon.graph.graph.Transposer;
import com.codemelon.graph.vertex.DirectedOrderedDfsVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 19, 2012
 * @my.edited Dec 19, 2012
 */
public class StronglyConnectedComponentsTest {
	private StronglyConnectedComponents<DirectedOrderedDfsVertex, 
			DirectedOrderedDfsVertex> stronglyConnectedComponents;
	private DirectedSimpleGraph<DirectedOrderedDfsVertex> graph;
	private HashMap<Character, DirectedOrderedDfsVertex> vertices;
	
	@After
	public void tearDown() {
		stronglyConnectedComponents = null;
		graph = null;
		vertices = null;
	}

	/**
	 * Test method for {@link com.codemelon.graph.algorithm.search.StronglyConnectedComponents#run()}.
	 */
	@Test
	public void testRun() {
		setUpCLRSGraph();
		stronglyConnectedComponents = new StronglyConnectedComponents<DirectedOrderedDfsVertex, 
				DirectedOrderedDfsVertex>(graph, DirectedOrderedDfsVertex.Factory.INSTANCE, 
				OrderedDfsGraphFactory.INSTANCE);
		Transposer<DirectedOrderedDfsVertex, DirectedOrderedDfsVertex> transposer = stronglyConnectedComponents.run();
		// component abe
		assertEquals("a and b belong to same tree", vertices.get('a').getComponent(), 
				vertices.get('b').getComponent());
		assertEquals("a and e belong to same tree", vertices.get('a').getComponent(), 
				vertices.get('e').getComponent());
		// component cd
		assertEquals("c and d belong to same tree", vertices.get('c').getComponent(), 
				vertices.get('d').getComponent());
		// component fg
		assertEquals("f and g belong to same tree", vertices.get('f').getComponent(), 
				vertices.get('g').getComponent());
		// distinguish different components
		assertThat(vertices.get('a').getComponent(), is(not(vertices.get('c').getComponent())));
		assertThat(vertices.get('a').getComponent(), is(not(vertices.get('f').getComponent())));
		assertThat(vertices.get('a').getComponent(), is(not(vertices.get('h').getComponent())));
		assertThat(vertices.get('c').getComponent(), is(not(vertices.get('f').getComponent())));
		assertThat(vertices.get('c').getComponent(), is(not(vertices.get('h').getComponent())));
		assertThat(vertices.get('f').getComponent(), is(not(vertices.get('h').getComponent())));
		
		// transposer is correct
		AbstractGraph<DirectedOrderedDfsVertex> transposeGraph = transposer.getTransposeGraph();
		Map<DirectedOrderedDfsVertex, DirectedOrderedDfsVertex> mapToTransposeVertices = transposer.getVertexMap();
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('b')), 
				mapToTransposeVertices.get(vertices.get('a'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('e')), 
				mapToTransposeVertices.get(vertices.get('b'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('f')), 
				mapToTransposeVertices.get(vertices.get('b'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('c')), 
				mapToTransposeVertices.get(vertices.get('b'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('g')), 
				mapToTransposeVertices.get(vertices.get('c'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('d')), 
				mapToTransposeVertices.get(vertices.get('c'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('c')), 
				mapToTransposeVertices.get(vertices.get('d'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('h')), 
				mapToTransposeVertices.get(vertices.get('d'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('a')), 
				mapToTransposeVertices.get(vertices.get('e'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('f')), 
				mapToTransposeVertices.get(vertices.get('e'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('g')), 
				mapToTransposeVertices.get(vertices.get('f'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('f')), 
				mapToTransposeVertices.get(vertices.get('g'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('h')), 
				mapToTransposeVertices.get(vertices.get('g'))));
		assertTrue("Correct edges in transpose graph", transposeGraph
				.containsEdge(mapToTransposeVertices.get(vertices.get('h')), 
				mapToTransposeVertices.get(vertices.get('h'))));
	}

	/**
	 * Graph from CLRS, p. 616
	 */
	private void setUpCLRSGraph() {
		vertices = new HashMap<Character, DirectedOrderedDfsVertex>();
		for (char i = 'a'; i <= 'h'; i++) {
			vertices.put(i, new DirectedOrderedDfsVertex());
		}
		graph = new DirectedSimpleGraph<DirectedOrderedDfsVertex>(vertices.values());
		vertices.get('a').addAdjacency(vertices.get('b'));
		vertices.get('b').addAdjacency(vertices.get('f'));
		vertices.get('b').addAdjacency(vertices.get('e'));
		vertices.get('b').addAdjacency(vertices.get('c'));
		vertices.get('c').addAdjacency(vertices.get('d'));
		vertices.get('c').addAdjacency(vertices.get('g'));
		vertices.get('d').addAdjacency(vertices.get('c'));
		vertices.get('d').addAdjacency(vertices.get('h'));
		vertices.get('e').addAdjacency(vertices.get('a'));
		vertices.get('e').addAdjacency(vertices.get('f'));
		vertices.get('f').addAdjacency(vertices.get('g'));
		vertices.get('g').addAdjacency(vertices.get('f'));
		vertices.get('g').addAdjacency(vertices.get('h'));
		vertices.get('h').addAdjacency(vertices.get('h'));
	}
}

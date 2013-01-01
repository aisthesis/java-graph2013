package com.codemelon.graph.algorithm.spanningtree;

import java.util.PriorityQueue;
import java.util.Set;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.edge.SpanningTreeEdgeData;
import com.codemelon.graph.graph.UndirectedWeightedEdgeGraph;
import com.codemelon.graph.graph.VertexResetter;
import com.codemelon.graph.vertex.UndirectedPrimVertex;
import com.codemelon.graph.vertex.Vertex;
import com.codemelon.graph.vertex.WeightComparator;
import com.codemelon.graph.vertex.ColoredVertex;
import com.codemelon.graph.vertex.WeightedVertex;
import com.codemelon.graph.vertex.EdgeWeightVertex;
import com.codemelon.graph.vertex.ChildVertex;

/**
 * Implementation of Kruskal's algorithm for growing a minimum spanning
 * tree. Follows
 * <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, pp. 634ff.
 * In this implementation, the markEdges() method does 2 things:
 * <ol>
 * <li>Marks the edges belonging to the minimum spanning tree as
 * BLACK and all other edges WHITE, and</li>
 * <li>Specifies the parents of all vertices so that the specified
 * root vertex is the root node in the minimum spanning tree marked
 * by BLACK edges.</li>
 * </ol>
 * @author Marshall Farrier
 * @my.created Dec 24, 2012
 * @my.edited Dec 24, 2012
 */
public class Prim<E extends SpanningTreeEdgeData, U extends EdgeDataFactory<E>, V extends UndirectedPrimVertex<E, U>> {
	private UndirectedWeightedEdgeGraph<E, U, V> graph;
	private PriorityQueue<V> queue;
	
	public Prim(UndirectedWeightedEdgeGraph<E, U, V> graph) {
		this.graph = graph;
		queue = null;
	}
	
	/**
	 * Set edges in minimum spanning tree to BLACK, all other edges are 
	 * set to WHITE. Parents of all vertices in the graph are also modified
	 * to show a path leading back to the specified root.
	 * @param root source vertex for minimum spanning tree
	 */
	@SuppressWarnings("unchecked")
	public void markEdges(V root) {
		initForMarking(root);
		V u;
		Set<? extends Vertex> adj;
		while (!queue.isEmpty()) {
			u = queue.poll();
			u.setColor(Color.BLACK);
			adj = u.getAdjacencies();
			for (Vertex v : adj) {
				// initial color means that v is still in the queue
				if (((ColoredVertex) v).getColor() == Color.WHITE && 
						u.getEdgeWeight((EdgeWeightVertex<E>) v) < ((WeightedVertex) v).getWeight()) {
					((ChildVertex) v).setParent(u);
					queue.remove(v);
					((WeightedVertex) v).setWeight(u.getEdgeWeight((EdgeWeightVertex<E>) v));
					queue.add((V) v);
				}
			}
		}
	}
	
	private void initForMarking(V root) {
		VertexResetter.resetForPrim(graph);
		root.setWeight(0.0);
		queue = new PriorityQueue<V>(graph.vertexCount(), new WeightComparator());
		Set<V> vertices = graph.getVertices();
		for (V vertex : vertices) {
			queue.add(vertex);
		}
	}
}

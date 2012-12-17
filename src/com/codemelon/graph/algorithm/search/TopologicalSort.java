package com.codemelon.graph.algorithm.search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.vertex.ColoredVertex;
import com.codemelon.graph.vertex.Vertex;
import com.codemelon.graph.graph.VertexResetter;

/**
 * Assuming that there is no cycle in the graph, this algorithm creates
 * a linked list representing an ordering that respects the edges in the graph.
 * That is, for any 2 distinct vertices u and v, if the graph contains the edge
 * (u, v), then u < v in the given ordering.
 * If the graph contains a cycle, then no such ordering exists.
 * Cf. <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, pp. 612ff.
 * In order to allow the application of this algorithm to both DirectedEdgeDataGraph
 * and DirectedSimpleGraph, the algorithm is implemented for AbstractGraph.
 * This means that it can also in principle be run on undirected graphs, although
 * in such cases the algorithm produces no useful results, since all such graphs
 * contain a cycle if they contain any edges at all.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class TopologicalSort<T extends ColoredVertex> {
	private AbstractGraph<T> graph;
	private LinkedList<ColoredVertex> orderedVertices;
	
	/**
	 * This constructor modifies the colors of the vertices in the graph.
	 * @param graph graph whose vertices are to be topologically sorted
	 */
	public TopologicalSort(AbstractGraph<T> graph) {
		this.graph = graph;
		sort();
	}
	/**
	 * Returns a linked list of vertices in topologically sorted order.
	 * That is, for any 2 distinct vertices u and v, if the graph contains the edge
	 * (u, v) and if the graph doesn't contain a cycle, then u precedes v in the list.
	 * If the graph contains a cycle, the list will be meaningless.
	 * @return a linked list of vertices in topologically sorted order
	 */
	public LinkedList<ColoredVertex> getSortedVertices() {
		return orderedVertices;
	}
	/**
	 * Returns true if earlier precedes later in the topologically sorted list.
	 * Returns false for equal vertices and for all other cases where earlier
	 * does not precede later in the list.
	 * @param earlier vertex tested for being earlier
	 * @param later vertex tested for being later
	 * @return true if earlier precedes later
	 */
	public boolean precedes(ColoredVertex earlier, ColoredVertex later) {
		ListIterator<ColoredVertex> it = orderedVertices.listIterator();
		boolean earlierHasBeenFound = false;
		ColoredVertex tmp;
		while (it.hasNext()) {
			tmp = it.next();
			if (tmp == later) {
				if (earlierHasBeenFound) { return true; }
				return false;
			}
			else if (tmp == earlier) {
				earlierHasBeenFound = true;
			}
		}
		return false;
	}
	/**
	 * <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, p. 613
	 */
	private void sort() {
		orderedVertices = new LinkedList<ColoredVertex>();
		VertexResetter.resetColors(graph);
		Iterator<T> it = graph.vertexIterator();
		T u;
		while (it.hasNext()) {
			u = it.next();
			if (u.getColor() == Color.WHITE) {
				visit(u);
			}
		}		
	}
	private void visit(ColoredVertex u) {
		u.setColor(Color.GRAY);
		Set<? extends Vertex> adjacentVertices = u.getAdjacencies();
		for (Vertex v : adjacentVertices) {
			if (((ColoredVertex) v).getColor() == Color.WHITE) {
				visit((ColoredVertex) v);
			}
		}
		u.setColor(Color.BLACK);
		orderedVertices.addFirst(u);
	}
}
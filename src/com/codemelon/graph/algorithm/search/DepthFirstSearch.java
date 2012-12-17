package com.codemelon.graph.algorithm.search;

import java.util.Iterator;
import java.util.Set;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.EdgeType;
import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.vertex.DfsVertex;
import com.codemelon.graph.vertex.Vertex;
import com.codemelon.graph.vertex.ColoredVertex;
import com.codemelon.graph.vertex.ChildVertex;
import com.codemelon.graph.vertex.VisitedVertex;
import com.codemelon.graph.vertex.EdgeTypeVertex;
import com.codemelon.graph.graph.VertexResetter;

/**
 * Implementation of depth-first search following 
 * <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, p. 604.
 * The graph to be searched may be directed or undirected.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class DepthFirstSearch<T extends DfsVertex> {
	/**
	 * The discovery time shown for the vertex first visited in the search
	 */
	public static final int FIRST_DISCOVERY_TIME = 0;
	
	private AbstractGraph<T> graph;
	private int t;	// time in CLRS
	private boolean isAcyclic;
	
	/**
	 * Prepare the depth-first search.
	 * No changes are made to the graph when it is passed into the constructor.
	 * @param graph graph on which the search will be run
	 */
	public DepthFirstSearch(AbstractGraph<T> graph) {
		this.graph = graph;
		isAcyclic = true;
	}
	/**
	 * Conduct a depth-first search on the graph, visiting vertices
	 * in no predetermined order.
	 * This method modifies the graph in the following ways:
	 * <ol>
	 * <li>All vertices will be colored black after this method call.</li>
	 * <li>All vertices will have discoveryTime and finishTime set according
	 * to the order in which they were first discovered and finished. The first
	 * discovery time will be 0.</li>
	 * <li>Vertices will have parent fields set as determined by the search.</li>
	 * <li>Edges will be classified as TREE, BACK, FORWARD or CROSS</li>
	 * </ol>
	 * The search() method returns a boolean value which is true iff the graph
	 * is acyclic.
	 * @return true iff the graph is acyclic.
	 */
	public boolean search() {
		VertexResetter.resetForDfs(graph);
		t = FIRST_DISCOVERY_TIME - 1;	// first discovery time will be FIRST_DISCOVERY_TIME
		Iterator<T> it = graph.vertexIterator();
		DfsVertex u;
		while (it.hasNext()) {
			u = it.next();
			if (u.getColor() == Color.WHITE) {
				visit(u);
			}
		}
		return isAcyclic;
	}
	private void visit(DfsVertex u) {
		u.setDiscoveryTime(++t);
		u.setColor(Color.GRAY);
		Set<? extends Vertex> adjacencies = u.getAdjacencies();
		for (Vertex v : adjacencies) {
			switch(((ColoredVertex) v).getColor()) {
			case WHITE:
				((ChildVertex) v).setParent(u);
				u.setEdgeType((EdgeTypeVertex) v, EdgeType.TREE);
				visit(((DfsVertex) v));
				break;
			case GRAY:
				u.setEdgeType(((EdgeTypeVertex) v), EdgeType.BACK);
				isAcyclic = false;
				break;
			case BLACK:
				if (u.getDiscoveryTime() < ((VisitedVertex) v).getDiscoveryTime()) {
					u.setEdgeType((EdgeTypeVertex) v, EdgeType.FORWARD);
				}
				else {
					u.setEdgeType((EdgeTypeVertex) v, EdgeType.CROSS);					
				}
			}
		}
		u.setColor(Color.BLACK);
		u.setFinishTime(++t);		
	}
}
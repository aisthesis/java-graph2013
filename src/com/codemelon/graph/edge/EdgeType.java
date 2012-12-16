package com.codemelon.graph.edge;

/**
 * Enumeration of different edge types, as are determined in depth-first search.
 * Cf. <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, p. 609
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public enum EdgeType {
	/**
	 * Default edge type
	 */
	UNKNOWN,
	/**
	 * Edges in a depth-first forest. Edge (u, v) is a tree edge if v was first diescovered
	 * by exploring edge (u, v)
	 */
	TREE, 
	/**
	 * Those edges (u, v) connecting a vertex u to an ancestor v in a depth-first tree.
	 * We consider self-loops, which may occur in directed graphs, to be back edges.
	 */
	BACK, 
	/**
	 * Those nontree edges (u, v) connecting a vertex u to a descendant v in a depth-first
	 * tree.
	 */
	FORWARD,
	/**
	 * All other edges. They can go between vertices in the same depth-first tree, as
	 * long as one vertex is not an ancestor of the other, or they can go between vertices
	 * in different depth-first trees.
	 */
	CROSS;
}
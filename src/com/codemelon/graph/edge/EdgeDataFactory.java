package com.codemelon.graph.edge;

/**
 * @author Marshall Farrier
 * @my.created Dec 13, 2012
 * @my.edited Dec 13, 2012
 */
public interface EdgeDataFactory<T> {
	/**
	 * Factory method for creating new EdgeData objects of a particular type
	 * @return new EdgeData object
	 */
	public T newEdgeData();

}

package com.codemelon.graph.vertex;

/**
 * Vertex that supports a field for conducting searches in a specific order
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public interface OrderedSearchVertex extends Vertex {
	/**
	 * Default value to which vertices' search order fields are initialized unless otherwise specified.
	 */
	public static final int DEFAULT_SEARCH_ORDER_VALUE = -1;
	/**
	 * Set the value of the searchOrder field
	 * @param searchOrder value to which to set the searchOrder field
	 */
	public void setSearchOrder(int searchOrder);
	/**
	 * Get the value of the searchOrder field
	 * @return the value of the searchOrder field
	 */
	public int getSearchOrder();
}

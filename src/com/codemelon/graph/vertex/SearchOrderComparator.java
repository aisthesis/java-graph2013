package com.codemelon.graph.vertex;

import java.util.Comparator;

/**
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public class SearchOrderComparator implements Comparator<OrderedSearchVertex> {
	public SearchOrderComparator() {}
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(OrderedSearchVertex v1, OrderedSearchVertex v2) {
		return v1.getSearchOrder() - v2.getSearchOrder();
	}
}

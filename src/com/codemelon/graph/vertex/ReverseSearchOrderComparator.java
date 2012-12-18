package com.codemelon.graph.vertex;

import java.util.Comparator;

/**
 * @author Marshall Farrier
 * @my.created Dec 18, 2012
 * @my.edited Dec 18, 2012
 */
public class ReverseSearchOrderComparator implements Comparator<OrderedSearchVertex> {
	public ReverseSearchOrderComparator() {}
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(OrderedSearchVertex v1, OrderedSearchVertex v2) {
		return v2.getSearchOrder() - v1.getSearchOrder();
	}
}

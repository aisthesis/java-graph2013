package com.codemelon.graph.vertex;

import java.util.Comparator;

/**
 * @author Marshall Farrier
 * @my.created Dec 24, 2012
 * @my.edited Dec 24, 2012
 */
public class WeightComparator implements Comparator<WeightedVertex> {
	public WeightComparator() {}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(WeightedVertex v1, WeightedVertex v2) {
		if (v1.getWeight() < v2.getWeight()) { return -1; }
		if (v2.getWeight() < v1.getWeight()) { return 1; }
		return 0;
	}
}

package com.codemelon.graph.vertex;

/**
 * Vertex that supports fields for marking discovery and finish times, as required
 * in depth=first search
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public interface VisitedVertex extends Vertex {
	/**
	 * Set the time at which the vertex was discovered
	 * @param discoveryTime value to which to set the discovery time
	 */
	public void setDiscoveryTime(int discoveryTime);
	/**
	 * Set the time at which the vertex visit was finished
	 * @param finishTime value to which to set the finish time
	 */
	public void setFinishTime(int finishTime);
	/**
	 * Get the vertex's discovery time
	 * @return discovery time set using setDiscoveryTime()
	 */
	public int getDiscoveryTime();
	/**
	 * Get the vertex's finish time
	 * @return finish time set using setFinishTime()
	 */
	public int getFinishTime();
}

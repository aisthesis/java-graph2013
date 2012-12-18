package com.codemelon.graph.vertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public class DirectedOrderedDfsVertex extends DirectedSimpleColoredVertex
		implements OrderedDfsVertex {
	private int discoveryTime;
	private int finishTime;
	private int searchOrder;
	private int component;

	/**
	 * 
	 */
	public DirectedOrderedDfsVertex() {
		super();
		discoveryTime = VertexConstants.DEFAULT_DISCOVERY_TIME;
		finishTime = VertexConstants.DEFAULT_FINISH_TIME;
		searchOrder = VertexConstants.DEFAULT_SEARCH_ORDER_VALUE;
		component = VertexConstants.DEFAULT_COMPONENT;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.VisitedVertex#setDiscoveryTime(int)
	 */
	@Override
	public void setDiscoveryTime(int discoveryTime) {
		this.discoveryTime = discoveryTime;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.VisitedVertex#setFinishTime(int)
	 */
	@Override
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.VisitedVertex#getDiscoveryTime()
	 */
	@Override
	public int getDiscoveryTime() {
		return discoveryTime;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.VisitedVertex#getFinishTime()
	 */
	@Override
	public int getFinishTime() {
		return finishTime;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.OrderedSearchVertex#setSearchOrder(int)
	 */
	@Override
	public void setSearchOrder(int searchOrder) {
		this.searchOrder = searchOrder;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.OrderedSearchVertex#getSearchOrder()
	 */
	@Override
	public int getSearchOrder() {
		return searchOrder;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ComponentVertex#setComponent(int)
	 */
	@Override
	public void setComponent(int componentNumber) {
		this.component = componentNumber;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ComponentVertex#getComponent()
	 */
	@Override
	public int getComponent() {
		return component;
	}
}
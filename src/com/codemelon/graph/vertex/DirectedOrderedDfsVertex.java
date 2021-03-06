package com.codemelon.graph.vertex;

/**
 * Simple vertex class supporting ordered depth-first search.
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
		discoveryTime = VisitedVertex.DEFAULT_DISCOVERY_TIME;
		finishTime = VisitedVertex.DEFAULT_FINISH_TIME;
		searchOrder = OrderedSearchVertex.DEFAULT_SEARCH_ORDER_VALUE;
		component = ComponentVertex.DEFAULT_COMPONENT;
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
	
	public static enum Factory implements VertexFactory<DirectedOrderedDfsVertex> {
		INSTANCE;

		/* (non-Javadoc)
		 * @see com.codemelon.graph.vertex.VertexFactory#newVertex()
		 */
		@Override
		public DirectedOrderedDfsVertex newVertex() {
			return new DirectedOrderedDfsVertex();
		}
	}
}
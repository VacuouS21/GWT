package com.events;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class GetAllEvent extends GwtEvent<GetAllHandler> {

	public static Type<GetAllHandler> TYPE = new Type<GetAllHandler>();
	
	@Override
	public Type<GetAllHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(GetAllHandler handler) {
		// TODO Auto-generated method stub
		handler.showModal(this);
	}

}

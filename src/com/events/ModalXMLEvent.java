package com.events;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ModalXMLEvent extends GwtEvent<ModalXMLHandler>{
	public static Type<ModalXMLHandler> TYPE = new Type<ModalXMLHandler>();
	
	@Override
	public Type<ModalXMLHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(ModalXMLHandler handler) {
		// TODO Auto-generated method stub
		handler.showModal(this);
	}

}

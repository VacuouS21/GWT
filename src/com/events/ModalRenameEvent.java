package com.events;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ModalRenameEvent extends GwtEvent<ModalRenameHandler>{
	
	public static Type<ModalRenameHandler> TYPE = new Type<ModalRenameHandler>();
	
	@Override
	public Type<ModalRenameHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(ModalRenameHandler handler) {
		// TODO Auto-generated method stub
		handler.showModal(this);
	}

}

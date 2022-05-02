package com.events;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ModalNewEquipmentEvent extends GwtEvent<ModalNewEquipmentHandler>{
	
	public static Type<ModalNewEquipmentHandler> TYPE = new Type<ModalNewEquipmentHandler>();
	
	@Override
	public Type<ModalNewEquipmentHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(ModalNewEquipmentHandler handler) {
		// TODO Auto-generated method stub
		handler.showModal(this);
	}

}

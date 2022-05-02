package com.events;

import com.google.gwt.event.shared.GwtEvent;

public class ModalGetEquipmantEvent extends GwtEvent<ModalGetEquipmentHandler> {

	public static Type<ModalGetEquipmentHandler> TYPE = new Type<ModalGetEquipmentHandler>();
	@Override
	public Type<ModalGetEquipmentHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(ModalGetEquipmentHandler handler) {
		// TODO Auto-generated method stub
		handler.showModal(this);
	}

}

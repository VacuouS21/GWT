package com.events;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.model.InputText;

public class ClickOkEvent  extends GwtEvent<ClickOkHandler> {

	public static Type<ClickOkHandler> TYPE = new Type<ClickOkHandler>();
	public static int caseButton;
	public static InputText input;
	public ClickOkEvent(int caseButton,InputText input) {
		this.caseButton=caseButton;
		this.input=input;
	}

	@Override
	protected void dispatch(ClickOkHandler handler) {
		// TODO Auto-generated method stub
		handler.clickOk(this, caseButton,input);
	}


	@Override
	public Type<ClickOkHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

}

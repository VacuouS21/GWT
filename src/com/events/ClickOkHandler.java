package com.events;

import com.google.gwt.event.shared.EventHandler;
import com.model.InputText;

public interface ClickOkHandler extends EventHandler {
 public void clickOk(ClickOkEvent event, int caseButton,InputText input);
}

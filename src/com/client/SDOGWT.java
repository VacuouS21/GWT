package com.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

import com.google.gwt.user.client.ui.RootPanel;




/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
/*
<button>Вывод общей информации об оборудовании на скважинах.</button>
<br>
<br>
<button>Экспорт всех данных в xml файл.</button>
<br>
<br>
<button>Изменить имя скважины(sdo)</button>
<br>
<br>
<button>Вывести все названия скважин(sdo)</button>
*/
public class SDOGWT implements EntryPoint {
	
	
	EventBus eventBus = new SimpleEventBus();
	AppController appViewer;

	
	public void onModuleLoad() {
		
		
		final InputServicesAsync inputServices=GWT.create(InputServices.class);
		 appViewer = new AppController(inputServices, eventBus);
		 appViewer.goTo(RootPanel.get());
		
	}
		
}
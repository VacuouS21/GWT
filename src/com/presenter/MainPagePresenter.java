package com.presenter;

import com.events.ClickOkEvent;
import com.events.GetAllEvent;
import com.events.ModalGetEquipmantEvent;
import com.events.ModalNewEquipmentEvent;
import com.events.ModalRenameEvent;
import com.events.ModalXMLEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.view.MainPage;

public class MainPagePresenter {
	 public interface Display{
	 
	  Widget asWidget();
	  MainPage getViewInstance();
	  Button buttonNewEquipment();
	  Button buttonGetEquipment();
	  Button buttonXML();
	  Button buttonRename();
	  Button buttonGetAll();
	  void setTextArea(String text);
	 }
	 
	 final Display display;
	 final EventBus eventBus;
	 
	 public MainPagePresenter(Display display, EventBus eventBus){
	  this.display = display;
	  this.eventBus = eventBus;
	 }
	 
	 public void init(){
	  display.buttonNewEquipment().addClickHandler(new ClickHandler(){
	   @Override
	   public void onClick(ClickEvent event) {
	    // use the event bus to trigger the event
		   eventBus.fireEvent(new ModalNewEquipmentEvent());
	    //eventBus.fireEvent(new LogoutEvent());
	   }
	  });
	  display.buttonGetEquipment().addClickHandler(new ClickHandler(){
		   @Override
		   public void onClick(ClickEvent event) {
		    // use the event bus to trigger the event
			   eventBus.fireEvent(new ModalGetEquipmantEvent());
		    //eventBus.fireEvent(new LogoutEvent());
		   }
		  });
	  display.buttonXML().addClickHandler(new ClickHandler(){
		   @Override
		   public void onClick(ClickEvent event) {
		    // use the event bus to trigger the event
			   eventBus.fireEvent(new ModalXMLEvent());
		    //eventBus.fireEvent(new LogoutEvent());
		   }
		  });
	  display.buttonRename().addClickHandler(new ClickHandler(){
		   @Override
		   public void onClick(ClickEvent event) {
		    // use the event bus to trigger the event
			   eventBus.fireEvent(new ModalRenameEvent());
		    //eventBus.fireEvent(new LogoutEvent());
		   }
		  });
	  display.buttonGetAll().addClickHandler(new ClickHandler(){
		   @Override
		   public void onClick(ClickEvent event) {
		    // use the event bus to trigger the event
			  eventBus.fireEvent(new GetAllEvent());
		    //eventBus.fireEvent(new LogoutEvent());
		   }
		  });
	 }
	 
	 public void go(final HasWidgets container){
	  init();
	  container.clear();
	  RootPanel.get("mainContainer").add(display.asWidget());
	  
	 }
	 
	 public void setResult(String result) {
		 display.setTextArea(result);
	 }
	 
	 public Display getView(){
	  
	  return display;
	 }
	 
	}

package com.client;

import com.client.InputServicesAsync;
import com.view.ModalGetEquipment;
import com.view.ModalNewEquipmant;
import com.view.ModalRename;
import com.view.ModalXML;
import com.events.ClickOkEvent;
import com.events.ClickOkHandler;
import com.events.GetAllEvent;
import com.events.GetAllHandler;
import com.events.ModalGetEquipmantEvent;
import com.events.ModalGetEquipmentHandler;
import com.events.ModalNewEquipmentEvent;
import com.events.ModalNewEquipmentHandler;
import com.events.ModalRenameEvent;
import com.events.ModalRenameHandler;
import com.events.ModalXMLEvent;
import com.events.ModalXMLHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.model.InputText;
import com.view.MainPage;
import com.presenter.MainPagePresenter;
import com.shared.FieldVerifier;

public class AppController  {
	final InputServicesAsync inputServices;
	EventBus eventBus;
	MainPagePresenter mainPage;
	 HasWidgets container;
	
	public AppController(final InputServicesAsync inputServices, EventBus eventBus) {
		this.inputServices=inputServices;
		this.eventBus=eventBus;
		this.mainPage=new MainPagePresenter(new MainPage(), eventBus);
		 bindEvents();
		// TODO Auto-generated constructor stub
	}

    private void mainPageShow(HasWidgets page) {
    	  this.container = page;
    	  
    }
    
    public void bindEvents(){
    	//Первая кнопка
    	eventBus.addHandler(ModalNewEquipmentEvent.TYPE,new ModalNewEquipmentHandler() {
			
    		
			@Override
			public void showModal(ModalNewEquipmentEvent event) {
				final ModalNewEquipmant modal=new ModalNewEquipmant();
			    modal.show();
			    modal.ok.addClickHandler(new ClickHandler(){
					   @Override
					   public void onClick(ClickEvent event) {
					    // use the event bus to trigger the event
						  
						   String nameWell=modal.getNameWell();
						   String count=modal.getCountEquipment();
						   if(FieldVerifier.isValidName(nameWell) && FieldVerifier.isValidName(count) && FieldVerifier.isNumeric(count)) {
							   InputText input=new InputText(nameWell,count);
							   eventBus.fireEvent(new ClickOkEvent(1,input));
						   }
						   else eventBus.fireEvent(new ClickOkEvent(-1,null));
					    //eventBus.fireEvent(new LogoutEvent());
						   modal.hide();
					   }
					  
					  });
				// TODO Auto-generated method stub
				
			}
		});
    	//Вторая кнопка
    	eventBus.addHandler(ModalGetEquipmantEvent.TYPE, new ModalGetEquipmentHandler() {
			
			@Override
			public void showModal(ModalGetEquipmantEvent event) {
				final ModalGetEquipment modal=new ModalGetEquipment();
				modal.show();
				modal.ok.addClickHandler(new ClickHandler(){
					   @Override
					   public void onClick(ClickEvent event) {
					    // use the event bus to trigger the event
						   String well=modal.getNameWell();
						   
						   if(FieldVerifier.isValidName(well))
						   {
							   InputText input=new InputText(well);
							   eventBus.fireEvent(new ClickOkEvent(2,input));
						   }
						   else eventBus.fireEvent(new ClickOkEvent(-1,null));
						   modal.hide();
					    //eventBus.fireEvent(new LogoutEvent());
					   }
					  });
				// TODO Auto-generated method stub
			
			}
		});
    	//Третья кнопка
    	eventBus.addHandler(ModalXMLEvent.TYPE, new ModalXMLHandler() {
			
			@Override
			public void showModal(ModalXMLEvent event) {
				final ModalXML modal = new ModalXML();
				modal.show();
				modal.ok.addClickHandler(new ClickHandler(){
					   @Override
					   public void onClick(ClickEvent event) {
						   String file=modal.getFile();
						   if(FieldVerifier.isValidName(file))
						   {
							   InputText input=new InputText(file);
							   eventBus.fireEvent(new ClickOkEvent(3,input));
						   }
						   else eventBus.fireEvent(new ClickOkEvent(-1,null));
					    // use the event bus to trigger the event
						   modal.hide();
					    //eventBus.fireEvent(new LogoutEvent());
					   }
					   
					  });
				// TODO Auto-generated method stub
				
			}
		});
    	//Четвёртая кнопка
    	eventBus.addHandler(ModalRenameEvent.TYPE, new ModalRenameHandler() {
			
			@Override
			public void showModal(ModalRenameEvent event) {
				final ModalRename modal=new ModalRename();
				modal.show();
				modal.ok.addClickHandler(new ClickHandler(){
					   @Override
					   public void onClick(ClickEvent event) {
					    // use the event bus to trigger the event
						   String oldName=modal.getOldName();
						   String newName=modal.getNewName();
						   
						   if(FieldVerifier.isValidName(oldName) && FieldVerifier.isValidName(newName))
						   {
							   InputText input=new InputText(oldName,newName);
							   eventBus.fireEvent(new ClickOkEvent(4,input));
						   }
						   else eventBus.fireEvent(new ClickOkEvent(-1,null));
					    //eventBus.fireEvent(new LogoutEvent());
						   modal.hide();
					   }
					  });
				// TODO Auto-generated method stub
		
			}
		});
    	//Пятая кнопка
    	eventBus.addHandler(GetAllEvent.TYPE, new GetAllHandler() {
			
			@Override
			public void showModal(GetAllEvent event) {
				// TODO Auto-generated method stub
				
				  eventBus.fireEvent(new ClickOkEvent(5,null));
			}
		});
    	//По нажатию Ок
            eventBus.addHandler(ClickOkEvent.TYPE,new ClickOkHandler() {
				@Override
				public void clickOk(ClickOkEvent event, int caseButton, InputText input) {
					// TODO Auto-generated method stub
					System.out.println(caseButton);
					switch(caseButton){
					case 1:
						inputServices.newEquipment(input.getFirstString(),Integer.valueOf(input.getSecondString()),new AsyncCallback<String>() {
		                       
	    	        		public void onFailure(Throwable caught) {
	    	        			mainPage.setResult("Возникла ошибка");
	                           }

	                           public void onSuccess(String result) {
	                        	   mainPage.setResult(result);         
	                           }});
						break;
					case 2:
						inputServices.getCountEquipment(input.getFirstString(),new AsyncCallback<String>() {
		                       
	    	        		public void onFailure(Throwable caught) {
	    	        			mainPage.setResult("Возникла ошибка");
	                           }

	                           public void onSuccess(String result) {
	                        	   mainPage.setResult(result);         
	                           }});
						break;
					case 3:
						inputServices.createXML(input.getFirstString(),new AsyncCallback<String>() {
		                       
	    	        		public void onFailure(Throwable caught) {
	    	        			mainPage.setResult("Возникла ошибка");
	                           }

	                           public void onSuccess(String result) {
	                        	   mainPage.setResult(result);         
	                           }});
						break;
					case 4:
						inputServices.renameWell(input.getFirstString(),input.getSecondString(),new AsyncCallback<String>() {
		                       
	    	        		public void onFailure(Throwable caught) {
	    	        			mainPage.setResult("Возникла ошибка");
	                           }

	                           public void onSuccess(String result) {
	                        	   mainPage.setResult(result);         
	                           }});
						break;
					case 5: 
						inputServices.getAllWell(null,new AsyncCallback<String>() {
		                       
	    	        		public void onFailure(Throwable caught) {
	    	        			mainPage.setResult("Возникла ошибка");
	                           }

	                           public void onSuccess(String result) {
	                        	   mainPage.setResult(result);         
	                           }});
						break;
					case -1:
						mainPage.setResult("Ошибка ввода!");
						break;
					};
				}
		});
    }
    public void goTo(HasWidgets page){
    	  this.container = page;
    	  mainPage.go(page);
    	 }
}

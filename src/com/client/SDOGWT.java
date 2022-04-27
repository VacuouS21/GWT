package com.client;

import com.client.modal.ModalGetEquipment;
import com.client.modal.ModalNewEquipmant;
import com.client.modal.ModalRename;
import com.client.modal.ModalXML;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.server.com.utility.NewDatabase;
import com.server.com.utility.NewFile;
import com.shared.FieldVerifier;


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
	
	 final InputServicesAsync inputServices=GWT.create(InputServices.class);
	
	public final VerticalPanel mainPanel = new VerticalPanel();
	private final Button button1=new Button("Создание N кол-ва оборудования на скважине.");
	private final Button button2=new Button("Вывод общей информации об оборудовании на скважинах.");
	private final Button button3=new Button("Экспорт всех данных в xml файл.");
	private final Button button4=new Button("Изменить имя скважины(sdo)");
	private final Button button5=new Button("Вывести все названия скважин(sdo)");
	public  final TextArea textArea=new TextArea();

	
	
	
	/**
	 * This is the entry point method.
	 */
	
	public void onModuleLoad() {
		
		
		textArea.setPixelSize(500, 500);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
		mainPanel.add(button4);
		mainPanel.add(button5);
		mainPanel.add(textArea);
		
		RootPanel.get("mainContainer").add(mainPanel);
		
		
		inputServices.createFile(new AsyncCallback<String>() {
            
    		public void onFailure(Throwable caught) {
               }
               public void onSuccess(String result) {
               }
           });
		//Обработка кнопки по созданию новых оборудований
		button1.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {	
		    	   final ModalNewEquipmant modalButton1=new ModalNewEquipmant();
		    	  
	               modalButton1.center();
	               modalButton1.show();
	               modalButton1.ok.addClickHandler(new ClickHandler() {
	       	        public void onClick(ClickEvent event) {
	       	        	
	    	        
	       	        	String nameWell=modalButton1.nameWell.getText();
	       	        	String countEquipment=modalButton1.countEquipment.getText();
	       	        	
	       	        	
	    	        	if(FieldVerifier.isValidName(nameWell) && FieldVerifier.isNumeric(countEquipment)) {
	    	        	inputServices.newEquipment(nameWell,Integer.valueOf(countEquipment),new AsyncCallback<String>() {
	                       
	    	        		public void onFailure(Throwable caught) {
	    	        			textArea.setText("Возникла ошибка");
	                           }

	                           public void onSuccess(String result) {
	                            textArea.setText(result);         
	                           }
	                       });
	    	        	}
	    	        	else textArea.setText("Ошибка ввода, неверные данные");
	    	        	 modalButton1.hide();
	    	        	
	    	        }
	    	      });
		        
		        }
		      });
		//Вывод кол-во оборудования
		button2.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  final ModalGetEquipment modalButton2=new ModalGetEquipment();
		    	
		    	   modalButton2.center();
	               modalButton2.show();
	               modalButton2.ok.addClickHandler(new ClickHandler() {
	       	        public void onClick(ClickEvent event) {
	       	        	
	    	            String stringNameWell=modalButton2.nameWell.getText();
	    	            
	    	        	inputServices.getCountEquipment(stringNameWell,  new AsyncCallback<String>() {
	                       
	    	        		public void onFailure(Throwable caught) {
	    	        			textArea.setText("Возникла ошибка");
	                           }

	                           public void onSuccess(String result) {
	                            textArea.setText(result);         
	                           }
	                       });
	    	        	 modalButton2.hide();
	    	        	
	    	        }
	    	      });
		        
		        }
		      });
		//Создание .xml
		button3.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  final ModalXML modalButton3=new ModalXML();
		    	   modalButton3.center();
	               modalButton3.show();
	               modalButton3.ok.addClickHandler(new ClickHandler() {
	       	        public void onClick(ClickEvent event) {
	       	        	
	       	        	String nameFile=modalButton3.nameFile.getText();
	    	        	
	    	        	inputServices.createXML(nameFile,  new AsyncCallback<String>() {
	                       
	    	        		public void onFailure(Throwable caught) {
	    	        			textArea.setText("Возникла ошибка");
	                           }

	                           public void onSuccess(String result) {
	                            textArea.setText(result);         
	                           }
	                       });
	    	        	 modalButton3.hide();
	    	        	
	    	        }
	    	      });
		        
		        }
		      });
		
		//Переименовать Well
		button4.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    		
		    	 final ModalRename modalButton4=new ModalRename();
		    	   modalButton4.center();
	               modalButton4.show();
	               modalButton4.ok.addClickHandler(new ClickHandler() {
	       	        public void onClick(ClickEvent event) {
	       	        	
	       	        	String oldName=modalButton4.oldName.getText();
	       	        	String newName=modalButton4.newName.getText();
	    	       	
	    	        	inputServices.renameWell(oldName,newName,  new AsyncCallback<String>() {
	                       
	    	        		public void onFailure(Throwable caught) {
	    	        			textArea.setText("Возникла ошибка");
	                           }

	                           public void onSuccess(String result) {
	                            textArea.setText(result);         
	                           }
	                       });
	    	        	 modalButton4.hide();
	    	        	
	    	        }
	    	      });
		        
		        }
		      });
		//Вывод всех well
		button5.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		      
		    	  inputServices.getAllWell("HELLO",  new AsyncCallback<String>() {
		    	  
	                    public void onFailure(Throwable caught) {
	                    	textArea.setText("Возникла ошибка");
	                       }

	                       public void onSuccess(String result) {
	                    	   textArea.setText(result);
	                                 
	                       }
	                   });
		        }
		      });

		}
	



}
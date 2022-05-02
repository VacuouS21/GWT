package com.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ModalXML extends DialogBox{
	private VerticalPanel panel=new VerticalPanel();
	private HorizontalPanel buttonPanel=new HorizontalPanel();
    public TextBox nameFile=new TextBox();
    public Button ok = new Button("Ок");
    public Button cancel=new Button("Отмена");
	private Label wellText = new Label("Введите имя файла(без .xml)");
	public ModalXML() {
		
		 panel.add(wellText);
		 panel.add(nameFile);
		 buttonPanel.add(cancel);
		 buttonPanel.add(ok);
		 panel.add(buttonPanel);
	      // Set the dialog box's caption.
	      setText("Создать скважину");
	     
	      // Enable animation.
	      setAnimationEnabled(true);
	     
	      // Enable glass background.
	      setGlassEnabled(true);
	      center();
	      cancel.addClickHandler(new ClickHandler() {
   	        public void onClick(ClickEvent event) {
   	        	ModalXML.this.hide();
   	        }
	      });
	
	      setWidget(panel);
	      
	    }

	public String getFile() {
		return nameFile.getText();
	}
}

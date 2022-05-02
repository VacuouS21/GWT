package com.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ModalRename extends DialogBox{
	
	private VerticalPanel panel=new VerticalPanel();
	private HorizontalPanel buttonPanel=new HorizontalPanel();
    public TextBox oldName=new TextBox();
    public TextBox newName= new TextBox();
    public Button ok = new Button("Ок");
    public Button cancel=new Button("Отмена");
	private Label oldText = new Label("Старое имя скважины");
	private Label newText = new Label("Новое имя скважины");
	
	public ModalRename() {
		 panel.add(oldText);
		 panel.add(oldName);
		 panel.add(newText);
		 panel.add(newName);
		 buttonPanel.add(cancel);
		 buttonPanel.add(ok);
		 panel.add(buttonPanel);
	      // Set the dialog box's caption.
	      setText("Создать скважину");

	      // Enable animation.
	      setAnimationEnabled(true);
	     
	      // Enablcenter();e glass background.
	      setGlassEnabled(true);
	      center();
	      cancel.addClickHandler(new ClickHandler() {
   	        public void onClick(ClickEvent event) {
   	        	ModalRename.this.hide();
   	        }
	      });
	  
	      setWidget(panel);
	      
	    }
	    public String getOldName() {
	    	return oldName.getText();
	    }
	    public String getNewName() {
	    	return newName.getText();
	    }
}

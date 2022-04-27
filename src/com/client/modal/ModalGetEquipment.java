package com.client.modal;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ModalGetEquipment extends DialogBox{
	private VerticalPanel panel=new VerticalPanel();
    public TextBox nameWell=new TextBox();
    private HorizontalPanel buttonPanel=new HorizontalPanel();
    public Button ok = new Button("Ок");
    public Button cancel=new Button("Отмена");
	private Label wellText = new Label("Имена скважин через \",\"");
	public ModalGetEquipment() {
		 panel.add(wellText);
		 panel.add(nameWell);
		 buttonPanel.add(cancel);
		 buttonPanel.add(ok);
		 panel.add(buttonPanel);
	      // Set the dialog box's caption.
	      setText("Создать скважину");

	      // Enable animation.
	      setAnimationEnabled(true);

	      // Enable glass background.
	      setGlassEnabled(true);
	      
	     
	      cancel.addClickHandler(new ClickHandler() {
   	        public void onClick(ClickEvent event) {
   	        	ModalGetEquipment.this.hide();
   	        }
	      });
	      setWidget(panel);
	      
     	        }
	    }
	

package com.view;

import java.util.Iterator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ModalGetEquipment extends DialogBox{
	DialogBox modal=new DialogBox();
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
		 modal.add(panel);
	      // Set the dialog box's caption.
		 setText("Кол-во оборудований");

	      // Enable animation.
	      setAnimationEnabled(true);

	      // Enable glass background.
	      setGlassEnabled(true);
	      center();
	      // DialogBox is a SimplePanel, so you have to set its widget property to
	      // whatever you want its contents to be.
	     
	      //53545556`
	      cancel.addClickHandler(new ClickHandler() {
  	        public void onClick(ClickEvent event) {
  	        	ModalGetEquipment.this.hide();
  	        }
	      });
	      setWidget(panel);
     	        }
	     public String getNameWell() {
	    	 return nameWell.getText();
	     }
	    }
	

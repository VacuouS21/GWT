package com.view;


import com.client.InputServicesAsync;
import com.client.SDOGWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public final class ModalNewEquipmant extends DialogBox{
	public final VerticalPanel panel=new VerticalPanel();
	private HorizontalPanel buttonPanel=new HorizontalPanel();
    public final TextBox nameWell=new TextBox();
    public final TextBox countEquipment= new TextBox();
    public Button ok = new Button("Ок");
    public Button cancel=new Button("Отмена");
	private final  Label wellText = new Label("Имя скважины");
	private final Label countText = new Label("Кол-во оборудования");
    
	 public ModalNewEquipmant() {
		 panel.add(wellText);
		 panel.add(nameWell);
		 panel.add(countText);
		 panel.add(countEquipment);
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
	      // DialogBox is a SimplePanel, so you have to set its widget property to
	      // whatever you want its contents to be.
	     
	      //53545556`
	      cancel.addClickHandler(new ClickHandler() {
   	        public void onClick(ClickEvent event) {
   	        	ModalNewEquipmant.this.hide();
   	        }
	      });
	      setWidget(panel);
	      
	    }
	
	 public String getNameWell() {
		 return nameWell.getText();
	 }
	 public String getCountEquipment() {
		 return countEquipment.getText();
	 }
}

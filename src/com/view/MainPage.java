package com.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.presenter.*;

public class MainPage implements MainPagePresenter.Display{
	private static MainPage instance;
	public final VerticalPanel mainPanel = new VerticalPanel();
	public final Button button1=new Button("Создание N кол-ва оборудования на скважине.");
    public final Button button2=new Button("Вывод общей информации об оборудовании на скважинах.");
    public final Button button3=new Button("Экспорт всех данных в xml файл.");
    public final Button button4=new Button("Изменить имя скважины(sdo)");
    public final Button button5=new Button("Вывести все названия скважин(sdo)");
	public final TextArea textArea=new TextArea();
	public MainPage(){
		textArea.setPixelSize(500, 500);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
		mainPanel.add(button4);
		mainPanel.add(button5);
		mainPanel.add(textArea);
	  
	}
	@Override
	public void setTextArea(String text) {
		this.textArea.setText(text);
	}
	
	@Override
	public Widget asWidget(){
		// TODO Auto-generated method stub
		return mainPanel;
	}
	@Override
	public  MainPage getViewInstance() {
		if(instance == null)
			   return new MainPage();
			  else
			   return instance;
	}
	@Override
	public Button buttonNewEquipment() {
		// TODO Auto-generated method stub
		return button1;
	}
	@Override
	public Button buttonGetEquipment() {
		// TODO Auto-generated method stub
		return button2;
	}
	@Override
	public Button buttonXML() {
		// TODO Auto-generated method stub
		return button3;
	}
	@Override
	public Button buttonRename() {
		// TODO Auto-generated method stub
		return button4;
	}
	@Override
	public Button buttonGetAll() {
		// TODO Auto-generated method stub
		return button5;
	}
}

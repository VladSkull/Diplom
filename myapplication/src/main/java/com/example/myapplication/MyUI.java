package com.example.myapplication;



import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
class SignView extends VerticalLayout implements View {
	
	SignView(Navigator navigator){
		this.setSizeFull();
		this.setSpacing(false);
    	this.setMargin(false);
    	
    	final Styles styles=Page.getCurrent().getStyles();
		String header_css=".header\n"+
				 "{\n"+			 	    	            
	    	"background: rgb(180,255,211);\n"+
	   	"}\n";
		styles.add(header_css);
		 String content_css=".my_content\n"+
				 "{\n"+			 	    	            
	    	"background: rgb(235,235,235);\n"+
	   	"}\n";
		 styles.add(content_css);
		 String menu_css=".my_menu\n"+
				 "{\n"+			 	    	            
	    	"background: rgb(200,200,200);\n"+
	   	"}\n";
		 styles.add(menu_css);
		 String welcome_css=".my_welcome\n"+
				 "{\n"+			 	    	            
	    	"background: rgb(170,200,200);\n"+
	   	"}\n";
		 styles.add(welcome_css);
		 
    	AbsoluteLayout header = new AbsoluteLayout();    	
    	header.setWidth("100%");
    	header.setHeight("100%");
    	header.addStyleName("header");
    	Label title=new Label();
    	title.setCaption("Шахматы.org");
    	header.addComponent(title, "left: 50%; top: 50%;");
    	
    	HorizontalLayout content=new HorizontalLayout();
    	content.setWidth("60%");
    	content.setHeight("100%");
    	content.setSpacing(false);
    	content.setMargin(false);
    	content.addStyleName("my_content");
    	
    	VerticalLayout menu=new VerticalLayout();
    	menu.setWidth("100%");
    	menu.setHeight("100%");    	
    	menu.addStyleName("my_menu");
    	Button BackButton=new Button("На главную");
    	menu.addComponent(BackButton);
    	
    	VerticalLayout welcome=new VerticalLayout();   	
    	welcome.setHeight("100%");
    	welcome.setWidth("100%");
    	welcome.addStyleName("my_welcome");
    	
    	Label welcome_label=new Label("Зарегистрируйтесь на нашем сайте");
    	TextField log_field=new TextField("Введите логин");
    	TextField pass_field=new TextField("Введите пароль");	
    	TextField confpass_field=new TextField("Повторно введите пароль для подтверждения");
    	Button Confirm = new Button("Зарегистрироваться");
    	log_field.setWidth("100%");
    	pass_field.setWidth("100%");
    	confpass_field.setWidth("100%");
    	log_field.setHeight("75%");
    	pass_field.setHeight("75%");
    	confpass_field.setHeight("75%");
    	
    	welcome.addComponents(welcome_label,log_field,pass_field,confpass_field,Confirm);
    	welcome.setExpandRatio(welcome_label, 0.5f);
    	welcome.setExpandRatio(log_field, 0.5f);
    	welcome.setExpandRatio(pass_field, 0.5f);
    	welcome.setExpandRatio(confpass_field, 0.5f);
    	welcome.setExpandRatio(Confirm, 2.0f);
    	welcome.setComponentAlignment(welcome_label, Alignment.MIDDLE_CENTER);
    	welcome.setComponentAlignment(Confirm, Alignment.TOP_CENTER);
    	welcome.setSpacing(false);
    	
    	Confirm.addClickListener(new Button.ClickListener() {
    		@Override
    		public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
    			//Connection con=null;
			    //Statement stmt=null;
			    //ResultSet rs=null;
    			if(log_field.isEmpty() || pass_field.isEmpty() || confpass_field.isEmpty())
    			{
    				return;
    			}
    			
    			
    		}	
    		
    	});
    	
    	
    	this.addComponents(header,content);    	
    	this.setExpandRatio(header, 1.2f);
    	this.setExpandRatio(content, 8.8f);
    	this.setComponentAlignment(content, Alignment.TOP_CENTER);
    	
    	content.addComponents(menu,welcome);
    	content.setExpandRatio(menu, 2.5f);
    	content.setExpandRatio(welcome, 7.5f);
    	
    	BackButton.addClickListener(new Button.ClickListener() {
    		@Override
    		public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
    			navigator.navigateTo("");			
    		}
    	   
    		
    	});

	}
	 @Override
	    public void enter(ViewChangeEvent event) {
	        Notification.show("Добро пожаловать на вкладку Регистрация");
	    }
}

@Theme("mytheme")
class MainView extends VerticalLayout implements View {

	MainView(Navigator navigator)
	{
	
	this.setSizeFull();
	this.setSpacing(false);
	this.setMargin(false);
	
	final Styles styles=Page.getCurrent().getStyles();
	String header_css=".header\n"+
			 "{\n"+			 	    	            
    	"background: rgb(180,255,211);\n"+
   	"}\n";
	styles.add(header_css);
	 String content_css=".my_content\n"+
			 "{\n"+			 	    	            
    	"background: rgb(235,235,235);\n"+
   	"}\n";
	 styles.add(content_css);
	 String menu_css=".my_menu\n"+
			 "{\n"+			 	    	            
    	"background: rgb(200,200,200);\n"+
   	"}\n";
	 styles.add(menu_css);
	 String welcome_css=".my_welcome\n"+
			 "{\n"+			 	    	            
    	"background: rgb(170,200,200);\n"+
   	"}\n";
	 styles.add(welcome_css);
	 
	
	
	AbsoluteLayout header=new AbsoluteLayout();    	
	header.setWidth("100%");
	header.setHeight("100%");
	header.addStyleName("header");
	Label title=new Label();
	title.setCaption("Шахматы.org");
	header.addComponent(title, "left: 50%; top: 50%;");
	
	HorizontalLayout content=new HorizontalLayout();
	content.setWidth("60%");
	content.setHeight("100%");
	content.setSpacing(false);
	content.setMargin(false);
	content.addStyleName("my_content");
	
	VerticalLayout menu=new VerticalLayout();
	menu.setWidth("100%");
	menu.setHeight("100%");    	
	menu.addStyleName("my_menu");
	Button RegButton=new Button("Регистрация");
	
	
	VerticalLayout welcome=new VerticalLayout();   	
	welcome.setHeight("100%");
	welcome.setWidth("100%");
	welcome.addStyleName("my_welcome");
	welcome.addComponent(new Label("Приветствуем Вас на сайте Шахматы.org, где вы сможете сыграть в разные виды шахмат с живыми игроками"));
	    	
	this.addComponents(header,content);
	this.setExpandRatio(header, 1.2f);
	this.setExpandRatio(content, 8.8f);
	this.setComponentAlignment(content, Alignment.TOP_CENTER);
	
	content.addComponents(menu,welcome);
	content.setExpandRatio(menu, 2.5f);
	content.setExpandRatio(welcome, 7.5f);
	
	RegButton.addClickListener(new Button.ClickListener() {
		@Override
		public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
			
			navigator.navigateTo("SignUP");			
		}
	   
		
	});
	}
}

@Theme("mytheme")
public class MyUI extends UI {

    public Navigator navigator;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	navigator=new Navigator(this, this);
    	navigator.addView("SignUP", new SignView(navigator));
    	navigator.addView("", new MainView(navigator));
    	navigator.navigateTo("");
    	
    	
        
    }
	

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}



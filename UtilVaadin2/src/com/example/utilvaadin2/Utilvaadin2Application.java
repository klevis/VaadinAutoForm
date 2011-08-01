package com.example.utilvaadin2;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class Utilvaadin2Application extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Utilvaadin2 Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}

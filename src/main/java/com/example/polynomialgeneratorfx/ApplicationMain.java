package com.example.polynomialgeneratorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ApplicationMain extends Application
{
	private double xOffset = 0;
	private double yOffset = 0;

	@Override
	public void start(Stage stage) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("polyHome.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 500, 400);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.setResizable(false);

		//grab your root here
		scene.setOnMousePressed(event -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});

		//move around here
		scene.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - xOffset);
			stage.setY(event.getScreenY() - yOffset);
		});

		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}

	public static void main(String[] args)
	{
		launch();
	}
}
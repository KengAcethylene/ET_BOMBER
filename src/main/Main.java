package main;

import controller.GameController;
import controller.StartPageController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {
	private GameController gameController;
	private StartPageController startPageController;
	public static void main(String[] args) {
		try {
		launch(args);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@SuppressWarnings("exports")
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		startPageController = new StartPageController();
		gameController = new GameController();
	
		startPageController.setOtherController(gameController);
		startPageController.setStage(primaryStage);
		gameController.setOtherController(startPageController);
		gameController.setStage(primaryStage);
	
		primaryStage.setScene(startPageController.getScene());
		primaryStage.setResizable(false);
		primaryStage.show();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void stop() throws Exception {
		Platform.exit();
		System.exit(0);
	}

}

package controllers;

import java.io.IOException;

import data.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Controller for the Level Select menu.
 * @author William King
 */
public class LevelSelectController {
	/** Title for the Main Menu. */
	private final String MAIN_MENU_TITLE = "Main Menu";
	/** Holds the User to get the maximum level they can play. */
	private User currentUser;
	
	/** A button that opens level 1. */
	@FXML private Button btnLevel1;
	/** A button that opens level 2. */
	@FXML private Button btnLevel2;
	/** A button that opens level 3. */
	@FXML private Button btnLevel3;
	/** A button that opens level 4. */
	@FXML private Button btnLevel4;
	/** A button that opens level 5. */
	@FXML private Button btnLevel5;
	/** The back button for the level select menu. */
	@FXML private Button btnBack;
	
	/**
	 * Gets the button pressed, then opens the level based on the button that was pressed.
	 * @param event The button that was pressed.
	 */
	public void getButtonPress(ActionEvent event) {
		// Get the button, then its variable name.
		Button buttonPressed = (Button) event.getSource();
		String buttonName = buttonPressed.getId();
		
		// Get the level number based on the button pressed.
		// Set if game completion time should be saved.
		int levelNumber = -1;
		boolean isTotalTimeValid = false;
		switch (buttonName) {
			case "btnLevel1":
				levelNumber = 1;
				isTotalTimeValid = true;
				break;
			case "btnLevel2":
				levelNumber = 2;
				break;
			case "btnLevel3":
				levelNumber = 3;
				break;
			case "btnLevel4":
				levelNumber = 4;
				break;
			case "btnLevel5":
				levelNumber = 5;
				break;
		}
		
		// Open the level.
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass()
					.getResource(Main.FXML_FILE_PATH + "GameWindow.fxml"));
			BorderPane root = (BorderPane) fxmlLoader.load();
			
			// Gets the controller for the FXML file.
			GameController gameWindow = fxmlLoader.<GameController> getController();
			
			// Adjust the level number parameter and pass down the user.
			gameWindow.setCurrentUser(currentUser);
			gameWindow.setLevelNumber(levelNumber);
			gameWindow.setTotalTimeValid(isTotalTimeValid);
			gameWindow.setGameController(gameWindow);
			gameWindow.startGame();
			
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			// primaryStage.setTitle(THE_GAME_TITLE);
			primaryStage.show();
			
			// Close the level select menu.
			Stage stage = (Stage) buttonPressed.getScene().getWindow();
			stage.close();
		} catch (IOException e) {
			// Catches an IO exception such as that where the FXML
			// file is not found.
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	/**
	 * Adjusts the level buttons' availability based on the 
	 * maximum level the user has completed.
	 */
	public void adjustAvailableLevels() {
		// Enable level buttons if the player can play them.
		int userLevel = currentUser.getCurrentLevel();
		switch (userLevel) {
			case 2:
				btnLevel2.setDisable(false);
				break;
			case 3:
				btnLevel2.setDisable(false);
				btnLevel3.setDisable(false);
				break;
			case 4:
				btnLevel2.setDisable(false);
				btnLevel3.setDisable(false);
				btnLevel4.setDisable(false);
				break;
			case 5:
				btnLevel2.setDisable(false);
				btnLevel3.setDisable(false);
				btnLevel4.setDisable(false);
				btnLevel5.setDisable(false);
				break;
		}
	}
	
	/**
	 * Sets the user who is playing the game.
	 * @param user The user to be set.
	 */
	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
	
	/**
	 * Closes this page, then opens the main menu.
	 */
	public void backButtonAction() {
		// Closes the window.
		Stage stage = (Stage) btnBack.getScene().getWindow();
		stage.close();
		
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass()
					.getResource(Main.FXML_FILE_PATH + "MainMenu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle(MAIN_MENU_TITLE);
			primaryStage.show(); // Displays the new stage.
		} catch (IOException e) {
			// Catches an IO exception such as that where the FXML
			// file is not found.
			e.printStackTrace();
			System.exit(-1);
		}
	}	
}
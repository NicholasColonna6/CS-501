package application;

/*
 * Nicholas Colonna & Evan Gutch
 * Group 12
 * Assignment 7
 * Exercise 14.1
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets; 

public class C14E1DisplayImages extends Application{
	@Override
	public void start(Stage primaryStage) {
		//creates image objects
		Image got = new Image("https://99designs-blog.imgix.net/wp-content/uploads/2016/04/got-title.jpg?auto=format&q=60&fit=max&w=930", 250, 250, false, false);
		Image stark = new Image("https://vignette.wikia.nocookie.net/gameofthrones/images/8/8a/House-Stark-Main-Shield.PNG/revision/latest?cb=20170101103142", 250, 250, false, false);
		Image targ = new Image("https://vignette.wikia.nocookie.net/gameofthrones/images/4/43/House-Targaryen-Main-Shield.PNG/revision/latest/scale-to-width-down/350?cb=20181113055101", 250, 250, false, false);
		Image lannister = new Image("https://vignette.wikia.nocookie.net/gameofthrones/images/8/8a/House-Lannister-Main-Shield.PNG/revision/latest?cb=20170101095357", 250, 250, false, false);
		
		//creates imageview objects
		ImageView gotView = new ImageView(got);
		ImageView starkView = new ImageView(stark);
		ImageView targView = new ImageView(targ);
		ImageView lannisterView = new ImageView(lannister);
		
		//creates grid for images to be displayed correctly
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));	//gives a little padding on outside edges of images
		grid.add(gotView, 0, 0);		//top left of grid
		grid.add(starkView, 1, 0);		//top right of grid
		grid.add(targView, 0, 1);		//bottom left of grid
		grid.add(lannisterView, 1, 1);	//bottom right of grid
		
		//display the images
		Scene scene = new Scene(grid);
		primaryStage.setTitle("Exercise 14.1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		System.out.print("This program displays 4 images in a grid pane using JavaFX.");
		
		Application.launch(args);
	}

}

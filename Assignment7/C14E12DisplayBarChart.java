package application;

/*
 * Nicholas Colonna & Evan Gutch
 * Group 12
 * Assignment 7
 * Exercise 14.12
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class C14E12DisplayBarChart extends Application {
	@Override
	public void start(Stage primaryStage) {
		//initialize assignments
		int projects = 20;
		int quizzes = 10;
		int midterm = 30;
		int final_exam = 40;
		
		//color of assignments
		Color projects_c = Color.RED;
		Color quizzes_c = Color.BLUE;
		Color midterm_c = Color.GREEN;
		Color final_c = Color.ORANGE;
		
		
		Pane pane = new Pane();	  //create pane for objects and text to be added
		
		//creates bar for projects
		Rectangle projects_bar = new Rectangle(10, 175-2*projects, 100, 2*projects);
		projects_bar.setStroke(projects_c);
		projects_bar.setFill(projects_c);
		pane.getChildren().add(new Text(15, 170-2*projects, "Projects -- 20%"));
		pane.getChildren().add(projects_bar);
		
		//creates bar for quizzes
		Rectangle quizzes_bar = new Rectangle(120, 175-2*quizzes, 100, 2*quizzes);
		quizzes_bar.setStroke(quizzes_c);
		quizzes_bar.setFill(quizzes_c);
		pane.getChildren().add(new Text(130, 170-2*quizzes, "Quizzes -- 10%"));
		pane.getChildren().add(quizzes_bar);
		
		//creates bar for midterm
		Rectangle midterm_bar = new Rectangle(230, 175-2*midterm, 100, 2*midterm);
		midterm_bar.setStroke(midterm_c);
		midterm_bar.setFill(midterm_c);
		pane.getChildren().add(new Text(235, 170-2*midterm, "Midterm -- 30%"));
		pane.getChildren().add(midterm_bar);
		
		//creates bar for final exam
		Rectangle final_bar = new Rectangle(340, 175-2*final_exam, 100, 2*final_exam);
		final_bar.setStroke(final_c);
		final_bar.setFill(final_c);
		pane.getChildren().add(new Text(355, 170-2*final_exam, "Final -- 40%"));
		pane.getChildren().add(final_bar);
		
		//Display the bar chart
		Scene scene = new Scene(pane, 450, 182);	//sets size of window
		primaryStage.setTitle("Exercise 14.12");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		System.out.print("This program displays a bar chart for class grade breakdown using JavaFX.");
		
		Application.launch(args);
	}

}

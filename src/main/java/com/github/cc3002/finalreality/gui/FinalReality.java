package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.gui.views.IView;
import com.github.cc3002.finalreality.gui.views.MakeCharactersView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;


/**
 * Main entry point for the application.
 * The game starts with a screen to make characters and then play the battle.
 * Here are methods to show the game and update it.
 * @author Ignacio Slater Muñoz.
 * @author Cristóbal Torres Gutiérre.
 */
public class FinalReality extends Application {
  Controller controller;
  IView actualView;
  Group root;

  /**
   * Initializes a controller and a root, sets a first view.
   */
  public FinalReality () {
    controller = new Controller(new Random());
    root = new Group();
    setActualView(new MakeCharactersView());
  }

  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Sets an actual view for this game.
   * @param newView new view.
   */
  public void setActualView(IView newView) {
    Group viewRoot = new Group();
    actualView = newView;
    actualView.setRoot(viewRoot);
    root.getChildren().add(viewRoot);
    actualView.setController(controller);
    actualView.setGame(this);
    actualView.initialize();
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);

    Scene mainScene = new Scene(root, 700, 650);

    setupTimer();
    primaryStage.setScene(mainScene);
    primaryStage.show();
  }

  /**
   * Sets a timer, the timer calls the update method from the actual view.
   */
  private void setupTimer () {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle (long now) {
        actualView.update();
      }
    };
    timer.start();
  }

}
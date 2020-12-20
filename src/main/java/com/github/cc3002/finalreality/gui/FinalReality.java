package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class FinalReality extends Application {
  Controller controller;
  IView actualView;
  Group root;



  public FinalReality () {
    controller = new Controller(10);
    //controller.makeKnight("Pepe",70,1);
    //controller.makeKnight("Pepaa",30,1);

    //controller.makeSword("Espade",3,23);
    //controller.makeSword("Espadea",3,54);
    //controller.makeSword("Espaweadea",3,64);
    //controller.makeSword("E231spaweadea",4,100);
    //controller.makeSword("E2adad31spaweadea",3,232);
    //controller.makeAxe("Esxa",3,232);
    //controller.makeAxe("Ea",3,232);
    //controller.makeAxe("E23a",3,232);
    //controller.makeAxe("313Ea",3,232);
    //controller.makeAxe("1Ea",53,232);

    //controller.makeEnemy("Juan",2,0,33,10);
    //controller.makeEnemy("Juae",1,0,77,10);
    //controller.makeEnemy("Juae",3,0,147,10);

    root = new Group();


    setActualView(new MakeCharactersView());

  }



  public static void main(String[] args) {
    launch(args);
  }

  protected void setActualView (IView newView) {
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
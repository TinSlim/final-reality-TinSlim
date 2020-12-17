package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
  Group battleButtons;
  BattleView battle;



  //Group bagView = new Group();


  public void setBattleButtons () {
    battleButtons = new Group();

    Button leftEnemyButton = new Button("Point Left");
    leftEnemyButton.setOnAction(event -> controller.moveTargetLeft());
    leftEnemyButton.setLayoutY(580);

    Button rightEnemyButton = new Button("Point Right");
    rightEnemyButton.setOnAction(event -> controller.moveTargetRight());
    rightEnemyButton.setLayoutY(580);
    rightEnemyButton.setLayoutX(90);

    Button attackButton = new Button("Attack");
    attackButton.setLayoutY(580);
    attackButton.setLayoutX(200);

    Button leftWeapon = new Button("Left Weapon");
    leftWeapon.setLayoutY(580);
    leftWeapon.setLayoutX(300);

    Button equipWeapon = new Button("Equip");
    equipWeapon.setLayoutY(580);
    equipWeapon.setLayoutX(395);

    Button rightWeapon = new Button("Right Weapon");
    rightWeapon.setLayoutY(580);
    rightWeapon.setLayoutX(450);

    Button upWeapon = new Button("Up Weapon");
    upWeapon.setLayoutY(550);
    upWeapon.setLayoutX(375);

    Button downWeapon = new Button("Down Weapon");
    downWeapon.setLayoutY(610);
    downWeapon.setLayoutX(370);



    battleButtons.getChildren().add(leftEnemyButton);
    battleButtons.getChildren().add(rightEnemyButton);
    battleButtons.getChildren().add(attackButton);
    battleButtons.getChildren().add(downWeapon);
    battleButtons.getChildren().add(upWeapon);
    battleButtons.getChildren().add(leftWeapon);
    battleButtons.getChildren().add(rightWeapon);
    battleButtons.getChildren().add(equipWeapon);
  }

  public FinalReality () {
    controller = new Controller(10);
    controller.makeKnight("Pepe",1,1);
    controller.makeKnight("Pepa",1,1);
    controller.makeKnight("Pepy",1,1);
    controller.makeKnight("Pepaa",1,1);

    controller.makeEnemy("Juan",2,2,2,2);
    controller.makeEnemy("Juae",2,2,2,2);

    battle = new BattleView();
    battle.setController(controller);
  }
  public void addWeapons () {

  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    setBattleButtons();
    battle.setPlayerValues();
    battle.setEquipment();

    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);

    Group root = new Group();
    Scene mainScene = new Scene(root, 700, 650);


    String imageUrl = "https://docs.oracle.com/javafx/javafx/images/javafx-documentation.png";
    Image image = new Image(imageUrl,160,60,false,true);
    ImageView imageView = new ImageView(image);
    root.getChildren().add(imageView);

    root.getChildren().add(battle.getActualPlayers());
    root.getChildren().add(battleButtons);
    //equipButton.setOnAction(event -> funcion;
    //playerAttack.getChildren().add(leftEnemyButton);
    //playerAttack.getChildren().add(rightEnemyButton);
    //playerAttack.getChildren().add(attackButton);
    //playerAttack.getChildren().add(equipButton);


    Group playerEquipment = new Group();

    //btn.setLayoutY(10);


    //label.setAlignment(Pos.CENTER);


    //battlePhase();
    //root.getChildren().add(playerAttack);
    //attackButton.setOnAction(event -> root.getChildren().remove(playerAttack));
    primaryStage.setScene(mainScene);

    primaryStage.show();
  }

}
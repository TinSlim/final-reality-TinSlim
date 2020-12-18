package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;


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
    leftEnemyButton.setLayoutX(10);

    Button rightEnemyButton = new Button("Point Right");
    rightEnemyButton.setOnAction(event -> controller.moveTargetRight());
    rightEnemyButton.setLayoutY(580);
    rightEnemyButton.setLayoutX(100);

    Button attackButton = new Button("Attack");
    attackButton.setOnAction(event -> controller.doAttack());
    attackButton.setLayoutY(580);
    attackButton.setLayoutX(200);

    Button leftWeapon = new Button("Left Weapon");
    leftWeapon.setOnAction(event -> controller.leftMoveInventory());
    leftWeapon.setLayoutY(580);
    leftWeapon.setLayoutX(300);

    Button equipWeapon = new Button("Equip");
    equipWeapon.setOnAction(event -> controller.equipWeapon());
    equipWeapon.setLayoutY(580);
    equipWeapon.setLayoutX(395);

    Button rightWeapon = new Button("Right Weapon");
    rightWeapon.setOnAction(event -> controller.rightMoveInventory());
    rightWeapon.setLayoutY(580);
    rightWeapon.setLayoutX(450);

    Button upWeapon = new Button("Up Weapon");
    upWeapon.setOnAction(event -> controller.upMoveInventory());
    upWeapon.setLayoutY(550);
    upWeapon.setLayoutX(375);

    Button downWeapon = new Button("Down Weapon");
    downWeapon.setOnAction(event -> controller.downMoveInventory());
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
    controller.makeKnight("Pepe",100,1);
    controller.makeKnight("Pepa",100,1);
    controller.makeKnight("Pepy",100,1);

    controller.makeSword("Espade",3,23);
    controller.makeSword("Espadea",3,54);
    controller.makeSword("Espaweadea",3,64);
    controller.makeSword("E231spaweadea",4,100);
    controller.makeSword("E2adad31spaweadea",3,232);

    controller.equipWeaponTo(controller.getPlayerCharacter(0));
    controller.equipWeaponTo(controller.getPlayerCharacter(1));
    controller.equipWeaponTo(controller.getPlayerCharacter(2));

    controller.makeEnemy("Juan",2,2,33,2);
    controller.makeEnemy("Juae",2,2,77,2);
    controller.makeEnemy("Juae",2,2,77,2);

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
    controller.startGame();
    setBattleButtons();
    battle.setPlayerValues();
    battle.initializeTargetPointer();
    battle.initializeEquipmentPointer();
    battle.setEnemyValues();
    battle.setEquipment();


    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);

    Group root = new Group();
    Scene mainScene = new Scene(root, 700, 650);

    //File file = new File("src...");
    //String imageUrl = file.toURI().toString();


    //Image image = new Image(imageUrl,160,60,false,true);
    //ImageView imageView = new ImageView(image);
    //root.getChildren().add(imageView);

    Group grupo = new Group();

    grupo.getChildren().add(battle.targetPointer);
    grupo.getChildren().add(battle.equipmentPointer);
    root.getChildren().add(grupo);

    root.getChildren().add(battle.getActualPlayers());
    root.getChildren().add(battle.getActualWeapons());
    root.getChildren().add(battle.getActualEnemies());
    root.getChildren().add(battleButtons);
    //root.getChildren().add(battle.targetPointer);



    Group playerEquipment = new Group();

    //btn.setLayoutY(10);


    //label.setAlignment(Pos.CENTER);


    //battlePhase();
    //root.getChildren().add(playerAttack);
    //attackButton.setOnAction(event -> root.getChildren().remove(playerAttack));
    setupTimer();
    primaryStage.setScene(mainScene);
    primaryStage.show();
    System.out.println(controller.getEnemy(0).getName());
  }

  private void setupTimer () {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle (long now) {
        battle.updateHp();
        battle.updateAttackPointer();
        battle.updateEquipmentPointer();
        controller.getPhase().doPhase();
      }
    };
    timer.start();
  }

}
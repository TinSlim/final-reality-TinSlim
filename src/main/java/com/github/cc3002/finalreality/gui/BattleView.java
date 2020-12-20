package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

public class BattleView extends View {
  Group battleButtons;
  Group actualPlayers;
  ArrayList<Label> playerHpVisible;
  ArrayList<Label> playerDamageVisible;
  ArrayList<Label> playerWeightVisible;
  ArrayList<Label> enemyHpVisible;
  Group actualEnemies;
  Group actualWeapons;
  Controller controller;
  ImageView targetPointer;
  ImageView equipmentPointer;
  ImageView attackerPointer;

  private FinalReality actualGame;

  public BattleView() {
    playerHpVisible = new ArrayList<>();
    playerDamageVisible = new ArrayList<>();
    playerWeightVisible = new ArrayList<>();
    enemyHpVisible = new ArrayList<>();
  }

  public void setRoot (Group newRoot) {
    this.root = newRoot;
  }

  public void setGame (FinalReality newGame) {
    actualGame = newGame;
  }

  public void initializeTargetPointer () {
    File file = new File("src\\resources\\targetEnemy.png");
    String imageUrl = file.toURI().toString();
    Image image = new Image(imageUrl,160,60,false,true);
    targetPointer = new ImageView(image);
    targetPointer.setLayoutX(200);
    targetPointer.setLayoutY(130);
  }

  public void initializeAttackerPointer () {
    File file = new File("src\\resources\\targetWeapon.png");
    String imageUrl = file.toURI().toString();
    Image image = new Image(imageUrl,150,70,false,true);
    attackerPointer = new ImageView(image);
    attackerPointer.setLayoutX(200);
    attackerPointer.setLayoutY(130);
  }

  public void initializeEquipmentPointer () {
    File file = new File("src\\resources\\targetWeapon.png");
    String imageUrl = file.toURI().toString();
    Image image = new Image(imageUrl,150,70,false,true);
    equipmentPointer = new ImageView(image);
    equipmentPointer.setLayoutX(200);
    equipmentPointer.setLayoutY(130);
  }

  public void setController (Controller controller) {
    this.controller = controller;
  }

  public void setPlayerValues () {
    int i = 20;
    int j = 10;
    Group players = new Group();
    for (IPlayerCharacter player : controller.getPlayerCharacters()) {
      Group actualPlayer = new Group();
      Label name = new Label(controller.getPlayerCharacterName(player));
      Label hp = new Label("HP:"+controller.getPlayerCharacterMaxHp(player)+"/"+controller.getPlayerCharacterHp(player));
      playerHpVisible.add(hp);
      Label defense = new Label("Def:"+controller.getPlayerCharacterDefense(player));
      Label damage = new Label("Atk:"+player.getEquippedWeapon().getDamage());
      playerDamageVisible.add(damage);
      Label weight = new Label("Wgt:"+player.getEquippedWeapon().getWeight());
      playerWeightVisible.add(weight);

      Image image = new Image(controller.getImage((ICharacter) player),160,60,false,
              true);
      ImageView imageView = new ImageView(image);

      actualPlayer.getChildren().add(imageView);
      actualPlayer.getChildren().add(name);
      actualPlayer.getChildren().add(hp);
      actualPlayer.getChildren().add(damage);
      actualPlayer.getChildren().add(weight);
      name.setLayoutY(0);
      hp.setLayoutY(12);
      defense.setLayoutY(24);
      damage.setLayoutY(36);
      weight.setLayoutY(48);
      imageView.setLayoutX(5);
      actualPlayer.setLayoutY(i);
      i += 70;


      actualPlayer.getChildren().add(defense);
      players.getChildren().add(actualPlayer);
    }
    actualPlayers = players;
  }

  public void setEnemyValues () {
    int i = 20;
    int j = 200;
    Group enemies = new Group();
    for (Enemy enemy : controller.getEnemyCharacters()) {
      Group actualEnemy = new Group();
      Label name = new Label(controller.getEnemyName(enemy));
      Label hp = new Label("HP:"+controller.getEnemyMaxHp(enemy)+"/"+controller.getEnemyHp(enemy));
      enemyHpVisible.add(hp);
      Label defense = new Label("Def:"+controller.getEnemyDefense(enemy));
      Label damage = new Label("Damage:"+controller.getEnemyDamage(enemy));

      Image image = new Image(controller.getImage(enemy),160,60,false,
              true);
      ImageView imageView = new ImageView(image);

      actualEnemy.getChildren().add(imageView);
      actualEnemy.getChildren().add(name);
      actualEnemy.getChildren().add(hp);
      actualEnemy.getChildren().add(damage);
      name.setLayoutY(0);
      hp.setLayoutY(12);
      defense.setLayoutY(24);
      damage.setLayoutY(36);
      imageView.setLayoutX(5);
      actualEnemy.setLayoutY(i);
      i += 70;
      actualEnemy.setLayoutX(j);
      actualEnemy.getChildren().add(defense);
      enemies.getChildren().add(actualEnemy);
    }
    actualEnemies = enemies;
  }

  public Group getActualEnemies () {
    return actualEnemies;
  }

  public void updatePlayerAttackingPointer () {

  }

  public void updateHp () {
    for (int i = 0; i < controller.getPlayerCharacters().size(); i++) {
      playerHpVisible.get(i).setText("HP:"+controller.getPlayerCharacterMaxHp(controller.getPlayerCharacter(i))+"/"+
              controller.getPlayerCharacterHp(controller.getPlayerCharacter(i)));
    }
    for (int i = 0; i < controller.getEnemyCharacters().size(); i++) {
      enemyHpVisible.get(i).setText("HP:"+controller.getEnemyMaxHp(controller.getEnemy(i))+"/"+
              controller.getEnemyHp(controller.getEnemy(i)));
    }
  }

  public void updatePlayerDamageWeight () {
    for (int i = 0; i < controller.getPlayerCharacters().size(); i++) {
      playerDamageVisible.get(i).setText("Atk:"+controller.getPlayerCharacter(i).getEquippedWeapon().getDamage());
      playerWeightVisible.get(i).setText("Wgt:"+controller.getPlayerCharacter(i).getEquippedWeapon().getWeight());
    }
  }

  public Group getActualPlayers () {
    return actualPlayers;
  }

  public void setEquipment () {
    int i = 10;
    int j = 320;

    Group weapons = new Group();
    for (IWeapon weapon : controller.getInventory().getWeaponsInventory()) {
      Group actualWeapon = new Group();
      Label name = new Label(weapon.getName());
      Label damage = new Label("Damage:"+weapon.getDamage());
      damage.setLayoutY(10);
      Label weight = new Label("Weight:"+weapon.getWeight());
      weight.setLayoutY(20);

      File file = new File(weapon.getImage());
      String imageUrl = file.toURI().toString();

      Image image = new Image(imageUrl,60,60,false,
              true);
      ImageView imageView = new ImageView(image);
      imageView.setLayoutX(65);
      imageView.setLayoutY(12);

      actualWeapon.getChildren().add(imageView);
      actualWeapon.getChildren().add(name);
      actualWeapon.getChildren().add(damage);
      actualWeapon.getChildren().add(weight);
      actualWeapon.setLayoutX(i);
      actualWeapon.setLayoutY(j);
      i += 165; // 165 * 4 =  680 + 10
      if (i % (165 * 4 + 10) == 0) {
        j += 70;
        i = 10;
      }
      weapons.getChildren().add(actualWeapon);
    }
    actualWeapons = weapons;
  }

  public Group getActualWeapons () {
    return actualWeapons;
  }


  public void updateAttackPointer() {
    targetPointer.setLayoutY(30 + 70 * controller.getAttackPointer());
  }

  public void updateEquipmentPointer() {
    int value = controller.getEquipmentPointer();
    equipmentPointer.setLayoutY(320 + (value / 4) * 70);
    equipmentPointer.setLayoutX(5 + (value % 4) * 165);
  }

  public void updateAttacker() {
    int value = controller.getPlayerAttackingPointer();
    attackerPointer.setLayoutY(20 + (value) * 70);
    attackerPointer.setLayoutX(20);
  }

  public void initialize() {
    setPlayerValues();
    initializeTargetPointer();
    initializeEquipmentPointer();
    initializeAttackerPointer();
    setEnemyValues();
    setEquipment();

    root.getChildren().add(targetPointer);
    root.getChildren().add(equipmentPointer);
    root.getChildren().add(attackerPointer);

    root.getChildren().add(getActualPlayers());
    root.getChildren().add(getActualWeapons());
    root.getChildren().add(getActualEnemies());
    setBattleButtons();
    root.getChildren().add(battleButtons);
    controller.startGame();
  }

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

  public void update() {
    updateHp();
    updateAttackPointer();
    updateEquipmentPointer();
    updatePlayerDamageWeight();
    updateAttacker();
    controller.getPhase().doPhase();
  }


}

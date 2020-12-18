package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

public class BattleView {
  Group actualPlayers;
  ArrayList<Label> playerHpVisible;
  ArrayList<Label> enemyHpVisible;
  Group actualEnemies;
  Group actualWeapons;
  Controller controller;
  ImageView targetPointer;
  ImageView equipmentPointer;

  public BattleView () {
    playerHpVisible = new ArrayList<>();
    enemyHpVisible = new ArrayList<>();
  }

  public void initializeTargetPointer () {
    File file = new File("src\\resources\\targetEnemy.png");
    String imageUrl = file.toURI().toString();
    Image image = new Image(imageUrl,160,60,false,true);
    targetPointer = new ImageView(image);
    targetPointer.setLayoutX(200);
    targetPointer.setLayoutY(130);
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

      File file = new File(controller.getImage((ICharacter) player));
      String imageUrl = file.toURI().toString();

      Image image = new Image(imageUrl,160,60,false,
              true);
      ImageView imageView = new ImageView(image);

      actualPlayer.getChildren().add(imageView);
      actualPlayer.getChildren().add(name);
      actualPlayer.getChildren().add(hp);
      name.setLayoutY(0);
      hp.setLayoutY(12);
      defense.setLayoutY(24);
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

      File file = new File(controller.getImage(enemy));
      String imageUrl = file.toURI().toString();

      Image image = new Image(imageUrl,160,60,false,
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
}

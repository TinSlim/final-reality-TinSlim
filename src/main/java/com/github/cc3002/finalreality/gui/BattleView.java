package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BattleView {
  Group actualPlayers;
  ArrayList<Label> hpVisible;
  Group actualEnemies;
  Group actualWeapons;

  Controller controller;

  public BattleView () {
    hpVisible = new ArrayList<>();
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
      hpVisible.add(hp);
      Label defense = new Label("Def:"+controller.getPlayerCharacterDefense(player));

      Image image = new Image(controller.getImage((ICharacter) player),160,60,false,
              true);
      ImageView imageView = new ImageView(image);

      actualPlayer.getChildren().add(imageView);
      actualPlayer.getChildren().add(name);
      actualPlayer.getChildren().add(hp);
      name.setLayoutY(0);
      hp.setLayoutY(0+12);
      defense.setLayoutY(0+24);
      imageView.setLayoutX(5);
      actualPlayer.setLayoutY(i);
      i += 70;


      actualPlayer.getChildren().add(defense);
      players.getChildren().add(actualPlayer);
    }
    actualPlayers = players;
  }

  public void updateHp () {
    for (int i = 0; i < controller.getPlayerCharacters().size(); i++) {
      hpVisible.get(i).setText("HP:"+controller.getPlayerCharacterMaxHp(controller.getPlayerCharacter(i))+"/"+
              controller.getPlayerCharacter(i));
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
      Image image = new Image(weapon.getImage(),160,60,false,
              true);
      ImageView imageView = new ImageView(image);
      imageView.setLayoutX(30);

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
}

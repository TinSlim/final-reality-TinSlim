package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MakeCharactersView extends View {
  Group buttons;
  Group playerCharacters;
  Controller controller;
  FinalReality game;

  int i = 20;
  int j = 10;
  int playerNmb = 0;

  public MakeCharactersView () {
    Button leftEnemyButton = new Button("MakeKnight");
    leftEnemyButton.setOnAction(event -> makeKnight());
    leftEnemyButton.setLayoutY(580);
    leftEnemyButton.setLayoutX(10);
    buttons.getChildren().add(leftEnemyButton);

  }

  public void makeKnight() {
    controller.makeKnight("a", 2, 2);
    setPlayerValues();
  }

  public void updateView () {
  }

  public void setPlayerValues () {
    Group actualPlayer = new Group();
    IPlayerCharacter aCharacter = controller.getPlayerCharacter(playerNmb);
    Label name = new Label(aCharacter.getName());
    Label hp = new Label("MaxHP:"+aCharacter.getMaxHp());
    Label defense = new Label("Def:"+aCharacter.getDefense());
    Image image = new Image(controller.getImage((ICharacter) aCharacter),160,60,false,
            true);
    ImageView imageView = new ImageView(image);
    actualPlayer.getChildren().add(imageView);
    actualPlayer.getChildren().add(name);
    actualPlayer.getChildren().add(hp);
    actualPlayer.getChildren().add(defense);
    name.setLayoutY(0);
    hp.setLayoutY(12);
    defense.setLayoutY(24);
    imageView.setLayoutX(5);
    actualPlayer.setLayoutY(i);
    i += 70;
    playerNmb += 1;
    playerCharacters.getChildren().add(actualPlayer);
  }

  public void nextView () {
    game.battle = new BattleView();
  }
}

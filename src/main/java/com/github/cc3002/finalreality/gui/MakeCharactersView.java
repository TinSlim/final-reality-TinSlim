package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;


public class MakeCharactersView extends View {
  Group buttons;
  Group playerCharacters;

  int i = 20;
  int j = 10;
  int playerNmb = 0;

  TextField nameField;
  TextField hpField;
  TextField defenseField;
  TextField damageField;
  TextField weightField;

  public MakeCharactersView ( ) {
    buttons = new Group();
    playerCharacters = new Group();
  }

  public void setButtons () {
    Button startGameButton = new Button("Start");
    startGameButton.setOnAction(event -> startGame());

    makeCharacterButtons();
    makeWeaponButtons();
    makeInputs();

    buttons.getChildren().add(startGameButton);
  }

  public void makeInputs () {
    Label nameLabel = new Label("Name:    ");
    nameField = new TextField ();
    HBox nameBox = new HBox();
    nameBox.getChildren().addAll(nameLabel,nameField);
    nameBox.setSpacing(10);

    Label hpLabel = new Label("MaxHp:  ");
    hpField = new TextField ();
    HBox hpBox = new HBox();
    hpBox.getChildren().addAll(hpLabel,hpField);
    hpBox.setSpacing(10);

    Label defenseLabel = new Label("Defense: ");
    defenseField = new TextField ();
    HBox defenseBox = new HBox();
    defenseBox.getChildren().addAll(defenseLabel,defenseField);
    defenseBox.setSpacing(10);

    Label damageLabel = new Label("Damage:");
    damageField = new TextField ();
    HBox damageBox = new HBox();
    damageBox.getChildren().addAll(damageLabel,damageField);
    damageBox.setSpacing(10);

    Label weightLabel = new Label("Weight:  ");
    weightField = new TextField ();
    HBox weightBox = new HBox();
    weightBox.getChildren().addAll(weightLabel,weightField);
    weightBox.setSpacing(10);

    VBox valueBox = new VBox();
    valueBox.getChildren().addAll(nameBox,hpBox,defenseBox,damageBox,weightBox);
    valueBox.setLayoutY(100);
    valueBox.setLayoutX(250);

    buttons.getChildren().addAll(valueBox);
  }

  public void makeCharacterButtons () {
    Label title = new Label("Make Characters: ");

    Button makeThiefButton = new Button("MakeThief");
    makeThiefButton.setOnAction(event -> makeThief());

    Button makeBlackMageButton = new Button("MakeBlackMage");
    makeBlackMageButton.setOnAction(event -> makeBlackMage());

    Button makeWhiteMageButton = new Button("MakeWhiteMage");
    makeWhiteMageButton.setOnAction(event -> makeWhiteMage());

    Button makeKnightButton = new Button("MakeKnight");
    makeKnightButton.setOnAction(event -> makeKnight());

    Button makeEngineerButton = new Button("MakeEngineer");
    makeEngineerButton.setOnAction(event -> makeEngineer());

    Button makeEnemyButton = new Button("MakeEnemy");
    makeEnemyButton.setOnAction(event -> makeEnemy());

    HBox charactersBox = new HBox();
    charactersBox.getChildren().addAll(title, makeKnightButton,makeEngineerButton, makeThiefButton,
            makeWhiteMageButton, makeBlackMageButton, makeEnemyButton);
    charactersBox.setSpacing(10);
    charactersBox.setLayoutY(520);

    buttons.getChildren().add(charactersBox);
  }

  public void makeWeaponButtons () {
    Label title = new Label("Make Weaponss: ");

    Button makeSwordButton = new Button("MakeSword");
    makeSwordButton.setOnAction(event -> makeSword());

    Button makeKnifeButton = new Button("MakeKnife");
    makeKnifeButton.setOnAction(event -> makeKnife());


    Button makeBowButton = new Button("MakeBow");
    makeBowButton.setOnAction(event -> makeBow());


    Button makeStaffButton = new Button("MakeStaff");
    makeStaffButton.setOnAction(event -> makeStaff());


    Button makeAxeButton = new Button("MakeAxe");
    makeAxeButton.setOnAction(event -> makeAxe());

    HBox weaponsBox = new HBox();
    weaponsBox.getChildren().addAll(title, makeSwordButton, makeKnifeButton, makeAxeButton, makeBowButton,
            makeStaffButton);
    weaponsBox.setSpacing(10);
    weaponsBox.setLayoutY(600);

    buttons.getChildren().add(weaponsBox);
  }

  private void makeSword () {
    controller.makeSword(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()));
  }

  private void makeAxe () {
    controller.makeAxe(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()));
  }

  private void makeKnife () {
    controller.makeKnife(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()));
  }

  private void makeBow () {
    controller.makeBow(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()));
  }

  private void makeStaff () {
    controller.makeStaff(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()),2);
  }

  public void startGame () {
    root.getChildren().remove(0,root.getChildren().size());
    aGame.setActualView(new BattleView());
  }

  public void makeKnight() {
    controller.makeKnight(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()));
    setPlayerValues();
  }

  public void makeEngineer() {
    controller.makeEngineer(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()));
    setPlayerValues();
  }

  public void makeThief() {
    controller.makeThief(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()));
    setPlayerValues();
  }

  public void makeWhiteMage() {
    controller.makeWhiteMage(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()),2);
    setPlayerValues();
  }

  public void makeBlackMage() {
    controller.makeBlackMage(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()),2);
    setPlayerValues();
  }

  public void makeEnemy() {
    controller.makeEnemy(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()),Integer.parseInt(weightField.getText()),
            Integer.parseInt(damageField.getText()));
    setEnemyValues();
  }

  public void setPlayerValues () {
    if (playerNmb < 4) {
      Group actualPlayer = new Group();
      IPlayerCharacter aCharacter = controller.getPlayerCharacter(playerNmb);
      Label name = new Label(aCharacter.getName());
      Label hp = new Label("MaxHP:" + aCharacter.getMaxHp());
      Label defense = new Label("Def:" + aCharacter.getDefense());
      Image image = new Image(controller.getImage((ICharacter) aCharacter), 160, 60, false,
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
  }

  public void setEnemyValues () {
    /**
    Group actualPlayer = new Group();
    Enemy aCharacter = controller.getEnemy(playerNmb);
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
     */
  }

  @Override
  public void initialize() {
    root.getChildren().add(playerCharacters);
    root.getChildren().add(buttons);
    setButtons();
  }

  @Override
  public void update() {
  }
}

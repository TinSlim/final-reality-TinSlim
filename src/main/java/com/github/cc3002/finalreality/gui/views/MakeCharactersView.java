package com.github.cc3002.finalreality.gui.views;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;

/**
 * Main view, here you can make items and start a game.
 */
public class MakeCharactersView extends AbstractView {
  Group buttons;
  Group playerCharacters;

  int playerNmb = 0;
  int enemyNmb = 0;
  int weaponsNmb = 0;

  TextField nameField;
  TextField hpField;
  TextField defenseField;
  TextField damageField;
  TextField weightField;

  ImageView backGround;

  Label playersQuantity;
  Label enemiesQuantity;
  Label weaponsQuantity;

  /**
   * Initializes background and nodes.
   */
  public MakeCharactersView ( ) {
    buttons = new Group();
    playerCharacters = new Group();
    File fileBackGround = new File("src\\resources\\menuBackGround.png");
    String imageCodeBackGround = fileBackGround.toURI().toString();
    Image imageBGround = new Image(imageCodeBackGround,700,650,false,true);
    backGround =  new ImageView(imageBGround);
    backGround.setLayoutY(0);
  }

  /**
   * Sets the buttons to start a game or a default game.
   */
  public void setPlayButtons () {
    Button startGameButton = new Button("Start");
    startGameButton.setOnAction(event -> startGame());
    startGameButton.setLayoutX(580);
    startGameButton.setLayoutY(260);

    Button playNow = new Button("Play with default configurations");
    playNow.setOnAction(event -> startDefaultGame());
    playNow.setLayoutX(390);
    playNow.setLayoutY(260);
    makeCharacterButtons();
    makeWeaponButtons();
    makeInputs();
    makeCounterLabels();

    buttons.getChildren().addAll(startGameButton,playNow);
  }

  /**
   * Makes default items and start a game.
   */
  private void startDefaultGame() {
    controller.makeKnight("Joshua",26,8);
    controller.makeBlackMage("Roberto",20,3,30);
    controller.makeThief("Santiago",16,6);
    controller.makeEngineer("James",23,7);

    controller.makeEnemy("Esqueletito",5,1,10,6);
    controller.makeEnemy("Esqueletoso",30,3,65,14);
    controller.makeEnemy("Esqueleton",15,2,25,9);

    controller.makeSword("Scalibur",11,60);
    controller.makeStaff("Palito",3,5,10);
    controller.makeKnife("Mahete",6,15);
    controller.makeBow("Arquito",8,24);
    controller.makeAxe("Hachita",9,45);

    startGame();
  }

  /**
   * Makes labels to count items.
   */
  private void makeCounterLabels() {
    Label playersValue = new Label("Players:");
    playersQuantity = new Label("0");
    VBox playersBox = new VBox();
    playersBox.getChildren().addAll(playersValue,playersQuantity);

    Label enemiesValue = new Label("Enemies:");
    enemiesQuantity = new Label("0");
    VBox enemiesBox = new VBox();
    enemiesBox.getChildren().addAll(enemiesValue,enemiesQuantity);

    Label weaponsValue = new Label("Weapons:");
    weaponsQuantity = new Label("0");
    VBox weaponsBox = new VBox();
    weaponsBox.getChildren().addAll(weaponsValue,weaponsQuantity);

    HBox allValues = new HBox();
    allValues.setSpacing(10);
    allValues.setLayoutX(400);
    allValues.setLayoutY(50);
    allValues.getChildren().addAll(playersBox,enemiesBox,weaponsBox);
    getRoot().getChildren().add(allValues);
  }

  /**
   * Makes inputs to make new items using those inputs.
   */
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
    valueBox.setLayoutX(400);

    buttons.getChildren().addAll(valueBox);
  }

  /**
   * Makes buttons to add characters.
   */
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

  /**
   * Makes buttons to add weapons.
   */
  public void makeWeaponButtons () {
    Label title = new Label("Make Weapons: ");

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

  /**
   * Makes a sword.
   */
  private void makeSword () {
    controller.makeSword(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()));
    setWeaponValues();
  }

  /**
   * Makes an axe.
   */
  private void makeAxe () {
    controller.makeAxe(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()));
    setWeaponValues();
  }

  /**
   * Makes a knife.
   */
  private void makeKnife () {
    controller.makeKnife(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()));
    setWeaponValues();
  }

  /**
   * Makes a bow.
   */
  private void makeBow () {
    controller.makeBow(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()));
    setWeaponValues();
  }

  /**
   * Makes a staff.
   */
  private void makeStaff () {
    controller.makeStaff(nameField.getText(), Integer.parseInt(damageField.getText()),
            Integer.parseInt(weightField.getText()),2);
    setWeaponValues();
  }

  /**
   * Makes a knight.
   */
  public void makeKnight() {
    controller.makeKnight(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()));
    setPlayerValues();
  }

  /**
   * Makes a engineer.
   */
  public void makeEngineer() {
    controller.makeEngineer(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()));
    setPlayerValues();
  }

  /**
   * Makes a thief.
   */
  public void makeThief() {
    controller.makeThief(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()));
    setPlayerValues();
  }

  /**
   * Makes a whiteMage.
   */
  public void makeWhiteMage() {
    controller.makeWhiteMage(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()),2);
    setPlayerValues();
  }

  /**
   * Makes a blackMage.
   */
  public void makeBlackMage() {
    controller.makeBlackMage(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()),2);
    setPlayerValues();
  }

  /**
   * Makes an enemy.
   */
  public void makeEnemy() {
    controller.makeEnemy(nameField.getText(), Integer.parseInt(hpField.getText()),
            Integer.parseInt(defenseField.getText()),Integer.parseInt(weightField.getText()),
            Integer.parseInt(damageField.getText()));
    setEnemyValues();
  }

  /**
   * Updates the player characters counter label.
   */
  public void setPlayerValues () {
    if (playerNmb < 4) {
      playerNmb += 1;
      playersQuantity.setText(String.valueOf(playerNmb));
    }
  }

  /**
   * Updates the enemies counter label.
   */
  public void setEnemyValues () {
    if (enemyNmb < 8) {
      enemyNmb += 1;
      enemiesQuantity.setText(String.valueOf(enemyNmb));
    }
  }

  /**
   * Updates the weapon counter label.
   */
  public void setWeaponValues () {
    if (weaponsNmb < 12) {
      weaponsNmb += 1;
      weaponsQuantity.setText(String.valueOf(weaponsNmb));
    }
  }

  /**
   * If the game can start, changes the view and removes the actual root from the principal game.
   */
  public void startGame () {
    if (controller.gameCanStart()) {
      root.getChildren().remove(0,root.getChildren().size());
      aGame.setActualView(new BattleView());
    }
  }

  @Override
  public void initialize() {
    root.getChildren().add(backGround);
    root.getChildren().add(playerCharacters);
    root.getChildren().add(buttons);
    setPlayButtons();
  }

  @Override
  public void update() {
  }
}

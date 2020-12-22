package com.github.cc3002.finalreality.gui.views;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

/**
 * View that shows the characters info, weapons info and buttons to play the game.
 */
public class BattleView extends AbstractView {
  protected Group battleButtons;
  protected Group actualPlayers;
  protected ArrayList<Label> playerHpVisible;
  protected ArrayList<Label> playerDamageVisible;
  protected ArrayList<Label> playerWeightVisible;
  protected ArrayList<Label> enemyHpVisible;
  protected Group actualEnemies;
  protected Group actualWeapons;
  protected ImageView targetPointer;
  protected ImageView equipmentPointer;
  protected ImageView attackerPointer;
  protected Label endGame;

  /**
   * Initializes arrays of labels and labels that will be updated while the game continues.
   */
  public BattleView() {
    playerHpVisible = new ArrayList<>();
    playerDamageVisible = new ArrayList<>();
    playerWeightVisible = new ArrayList<>();
    enemyHpVisible = new ArrayList<>();
    endGame = new Label("");
    endGame.setLayoutY(270);
    endGame.setLayoutX(300);
    endGame.setScaleX(5);
    endGame.setScaleY(5);
    endGame.setScaleZ(5);
    endGame.setRotate(5);
  }

  @Override
  public void setRoot (Group newRoot) {
    this.root = newRoot;
  }

  /**
   * Initializes the target pointer.
   */
  public void initializeTargetPointer () {
    File file = new File("src\\resources\\targetEnemy.png");
    String imageUrl = file.toURI().toString();
    Image image = new Image(imageUrl,160,30,false,true);
    targetPointer = new ImageView(image);
    targetPointer.setLayoutX(260);
    targetPointer.setLayoutY(130);
  }

  /**
   * Initializes the attacker pointer.
   */
  public void initializeAttackerPointer () {
    File file = new File("src\\resources\\targetWeapon.png");
    String imageUrl = file.toURI().toString();
    Image image = new Image(imageUrl,150,70,false,true);
    attackerPointer = new ImageView(image);
    equipmentPointer = new ImageView(image);
    equipmentPointer.setLayoutX(200);
    equipmentPointer.setLayoutY(130);
    attackerPointer.setLayoutX(-200);
    attackerPointer.setLayoutY(130);
  }

  /**
   * Initializes player characters values (name,image, hp , def, weight).
   */
  public void initializePlayerValues() {
    int i = 0;
    Group players = new Group();
    for (int index = 0; index < controller.getPlayersQuantity(); index++) {
      Group actualPlayer = new Group();
      Label name = new Label(controller.getPlayerCharacterName(index));
      Label hp = new Label("HP:" + controller.getPlayerCharacterHp(index) + "/" +
              controller.getPlayerCharacterMaxHp(index));
      playerHpVisible.add(hp);
      Label defense = new Label("Def:" + controller.getPlayerCharacterDefense(index));
      Label damage = new Label("Atk:" + controller.getPlayerCharacterDamage(index));
      playerDamageVisible.add(damage);
      Label weight = new Label("Wgt:"+controller.getPlayerCharacterWeight(index));
      playerWeightVisible.add(weight);

      String imageString = controller.getPlayerImage(index);
      File file = new File(imageString);
      String imageFile = file.toURI().toString();

      Image newImage = new Image(imageFile,160,60,false,true);
      ImageView newImageView = new ImageView(newImage);

      labelSetUp(actualPlayer, name, hp, defense, damage, weight, newImageView);
      newImageView.setLayoutX(30);
      newImageView.setLayoutY(10);
      actualPlayer.setLayoutY(10 + i*70);
      actualPlayer.setLayoutX(70);
      i += 1;


      actualPlayer.getChildren().add(defense);
      players.getChildren().add(actualPlayer);
    }
    actualPlayers = players;
  }

  /**
   * Common set up for character nodes.
   * @param actualCharacter character node.
   * @param name name of the character.
   * @param hp hp of the character.
   * @param defense defense of the character.
   * @param damage damage of the character.
   * @param weight weight of the character.
   * @param newImageView image of the character.
   */
  private void labelSetUp(Group actualCharacter, Label name, Label hp, Label defense, Label damage, Label weight, ImageView newImageView) {
    actualCharacter.getChildren().add(newImageView);
    actualCharacter.getChildren().add(name);
    actualCharacter.getChildren().add(hp);
    actualCharacter.getChildren().add(damage);
    actualCharacter.getChildren().add(weight);
    name.setLayoutY(0);
    hp.setLayoutY(12);
    defense.setLayoutY(24);
    damage.setLayoutY(36);
    weight.setLayoutY(48);
  }

  /**
   * Sets background and bag image.
   */
  public void setBackgrounds () {
    File fileBackGround = new File("src\\resources\\background.png");
    String imageCodeBackGround = fileBackGround.toURI().toString();
    Image imageBGround = new Image(imageCodeBackGround,700,650,false,true);
    ImageView imageViewBackGround = new ImageView(imageBGround);
    imageViewBackGround.setLayoutY(0);

    File file = new File("src\\resources\\bag.png");
    String imageCode = file.toURI().toString();
    Image image = new Image(imageCode,700,260, false,true);
    ImageView imageView = new ImageView(image);
    imageView.setLayoutY(290);
    root.getChildren().addAll(imageViewBackGround,imageView);
  }

  /**
   * Initializes enemy values (name, image, hp , def, weight, damage).
   */
  public void initializeEnemyValues() {
    int i = 0;
    int j = 300;
    File fileImg = new File("src\\resources\\characters\\enemy.png");
    Group enemies = new Group();
    for (int index = 0; index < controller.getEnemiesQuantity(); index++) {
      Group actualEnemy = new Group();
      Label name = new Label(controller.getEnemyName(index));
      Label hp = new Label("HP:" + controller.getEnemyHp(index) + "/" +
              controller.getEnemyMaxHp(index));
      enemyHpVisible.add(hp);
      Label defense = new Label("Def:" + controller.getEnemyDefense(index));
      Label damage = new Label("Dmg:" + controller.getEnemyDamage(index));
      Label weight = new Label("Wgt:" + controller.getEnemyWeight(index));

      String imageAsString = fileImg.toURI().toString();

      Image image = new Image(imageAsString,160,60,
              false,true);
      ImageView imageView = new ImageView(image);
      imageView.setLayoutX(20);
      imageView.setLayoutY(10);
      labelSetUp(actualEnemy, name, hp, defense, damage, weight, imageView);

      actualEnemy.setLayoutY(10 + (i%4) * 70);
      i += 1;
      actualEnemy.setLayoutX(j + (i / 5) * 180);
      actualEnemy.getChildren().add(defense);
      enemies.getChildren().add(actualEnemy);
    }
    actualEnemies = enemies;
  }

  /**
   * Returns the actualEnemies node.
   * @return the actualEnemies node.
   */
  public Group getActualEnemies () {
    return actualEnemies;
  }

  /**
   * Updates the HP values for all characters.
   */
  public void updateHp () {
    for (int i = 0; i < controller.getPlayerCharacters().size(); i++) {
      playerHpVisible.get(i).setText("HP:" + controller.getPlayerCharacterHp(i) + "/" +
                      controller.getPlayerCharacterMaxHp(i));
    }
    for (int i = 0; i < controller.getEnemyCharacters().size(); i++) {
      enemyHpVisible.get(i).setText("HP:" + controller.getEnemyHp(i) + "/" +
                      controller.getEnemyMaxHp(i));
    }
  }

  /**
   * Updates the damage and weight for player characters.
   */
  public void updatePlayerDamageWeight () {
    for (int i = 0; i < controller.getPlayerCharacters().size(); i++) {
      playerDamageVisible.get(i).setText("Atk:"+controller.getPlayerCharacterDamage(i));
      playerWeightVisible.get(i).setText("Wgt:"+controller.getPlayerCharacterDamage(i));
    }
  }

  /**
   * Returns the player characters node.
   * @return the player characters node.
   */
  public Group getActualPlayers () {
    return actualPlayers;
  }

  /**
   * Returns the weapons node.
   * @return the weapons node.
   */
  public Group getActualWeapons () {
    return actualWeapons;
  }

  /**
   * Initializes de equipment values (name, image, damage, weight).
   */
  public void initializeEquipment() {
    int i = 10;
    int j = 320;

    Group weapons = new Group();
    for (int index = 0; index < controller.getInventoryLength(); index++) {
      Group actualWeapon = new Group();
      Label name = new Label(controller.getWeaponName(index));
      Label damage = new Label("Damage:" + controller.getWeaponDamage(index));
      damage.setLayoutY(10);
      Label weight = new Label("Weight:" + controller.getWeaponWeight(index));
      weight.setLayoutY(20);

      String imageString = controller.getWeaponImage(index);
      File file = new File(imageString);
      String imageFile = file.toURI().toString();

      Image newImage = new Image(imageFile,60,60,false,true);
      ImageView newImageView = new ImageView(newImage);

      newImageView.setLayoutX(65);
      newImageView.setLayoutY(12);

      actualWeapon.getChildren().add(newImageView);
      actualWeapon.getChildren().add(name);
      actualWeapon.getChildren().add(damage);
      actualWeapon.getChildren().add(weight);
      actualWeapon.setLayoutX(30 + i);
      actualWeapon.setLayoutY(j);
      i += 165;
      if (i % (165 * 4 + 10) == 0) {
        j += 70;
        i = 10;
      }
      weapons.getChildren().add(actualWeapon);
    }
    actualWeapons = weapons;
  }

  /**
   * Updates the target pointer.
   */
  public void updateTargetPointer() {
    targetPointer.setLayoutY(50 + (controller.getActualTargetPointer()%4) * 70);
    targetPointer.setLayoutX(300 + (controller.getActualTargetPointer()/4) * 160);
  }

  /**
   * Updates the equipment pointer.
   */
  public void updateEquipmentPointer() {
    int value = controller.getEquipmentPointer();
    equipmentPointer.setLayoutY(320 + (value / 4) * 70);
    equipmentPointer.setLayoutX(5 + (value % 4) * 165);
  }

  /**
   * Updates the attacker pointer.
   */
  public void updateAttacker() {
    int value = controller.getPlayerAttackingPointer();
    attackerPointer.setLayoutY(20 + (value) * 70);
    attackerPointer.setLayoutX(20);
  }

  @Override
  public void initialize() {
    setBackgrounds();
    initializePlayerValues();
    initializeTargetPointer();
    initializeAttackerPointer();
    initializeEnemyValues();
    initializeEquipment();

    root.getChildren().addAll(targetPointer, equipmentPointer, attackerPointer);
    root.getChildren().addAll(getActualPlayers(), getActualWeapons(), getActualEnemies(),endGame);
    setBattleButtons();
    root.getChildren().add(battleButtons);
    controller.startGame();
  }

  /**
   * Sets the buttons to play the game.
   */
  public void setBattleButtons () {
    battleButtons = new Group();

    Button leftEnemyButton = new Button("Previous Enemy");
    leftEnemyButton.setOnAction(event -> controller.moveTargetLeft());
    leftEnemyButton.setLayoutY(580);
    leftEnemyButton.setLayoutX(10);

    Button rightEnemyButton = new Button("Next Enemy");
    rightEnemyButton.setOnAction(event -> controller.moveTargetRight());
    rightEnemyButton.setLayoutY(580);
    rightEnemyButton.setLayoutX(115);

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



    battleButtons.getChildren().addAll(leftEnemyButton, rightEnemyButton, attackButton, downWeapon, upWeapon,
            leftWeapon, rightWeapon, equipWeapon);
  }

  @Override
  public void update() {
    updateHp();
    updateTargetPointer();
    updateEquipmentPointer();
    updatePlayerDamageWeight();
    updateAttacker();
    endGame.setText(controller.getGameEnd());
    controller.executePhase();
  }
}

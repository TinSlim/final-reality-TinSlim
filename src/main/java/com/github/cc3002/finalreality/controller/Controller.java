package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.listeners.EnemyDeathListener;
import com.github.cc3002.finalreality.controller.listeners.FinishTurnListener;
import com.github.cc3002.finalreality.controller.listeners.PlayerCharacterDeathListener;
import com.github.cc3002.finalreality.controller.listeners.StartTurnListener;
import com.github.cc3002.finalreality.controller.phases.*;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;
import com.github.cc3002.finalreality.model.inventory.Inventory;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Controller class has the methods to access to the model, get values for the GUI and play the game.
 */
public class Controller {

  private final ArrayList<IPlayerCharacter> playerCharacters;
  private int playersAlive;
  private final ArrayList<Enemy> enemyCharacters;
  private int enemiesAlive;
  private final Inventory inventory;

  private String gameEnd;

  private final BlockingQueue<ICharacter> turnsQueue;

  private final StartTurnListener startTurnListener;
  private final FinishTurnListener finishTurnListener;
  private final PlayerCharacterDeathListener faintPlayerCharactersListener;
  private final EnemyDeathListener faintEnemyListener;
  private ICharacter actualCharacter;
  private IPhase phase;
  private final Random random;
  private int position;
  private int targetIndex;

  /**
   * Makes a Controller initializing characters lists, the turns queue, and counters.
   * @param random a random to repeat the same controller using a seed.
   */
  public Controller (Random random) {
    this.random = random;
    playerCharacters = new ArrayList<>();
    enemyCharacters = new ArrayList<>();
    turnsQueue = new LinkedBlockingQueue<>();
    position = 10;
    targetIndex = 0;
    playersAlive = 0;
    enemiesAlive = 0;

    faintPlayerCharactersListener = new PlayerCharacterDeathListener(this);
    faintEnemyListener = new EnemyDeathListener(this);
    finishTurnListener = new FinishTurnListener(this);
    startTurnListener = new StartTurnListener(this);

    inventory = new Inventory();
    gameEnd = "";
  }

  /**
   * Returns the turnsQueue
   * @return turnsQueue
   */
  public BlockingQueue<ICharacter> getQueue () {
    return turnsQueue;
  }

  /**
   * Adds all listeners to a player character and adds it to the list of players.
   * @param character the character who will be added.
   */
  private void addPlayer (IPlayerCharacter character) {
    if (getPlayersAlive() < 4) {
      character.addDeathListener(faintPlayerCharactersListener);
      character.addStartTurnListener(startTurnListener);
      character.addFinishTurnListener(finishTurnListener);
      playerCharacters.add(character);
      changeAlivePlayersQuantity(1);
    }
  }

  /**
   * Makes a KnightCharacter, adds to it the listeners, adds 1 to the players quantity and adds the new
   * character to the alivePlayerCharacters list.
   * @param name Knight's name.
   * @param maxHp Knight's maxHp.
   * @param defense Knight's defense.
   */
  public void makeKnight (String name, int maxHp, int defense) {
    KnightCharacter character = new KnightCharacter(turnsQueue,name,maxHp,defense);
    character.setPosition(playersAlive);
    character.equipWeapon(new Sword("ToySword",0,20));
    addPlayer(character);
  }

  /**
   * Makes a ThiefCharacter, adds to it the listeners, adds 1 to the players quantity and adds the new
   * character to the alivePlayerCharacters list.
   * @param name Thief's name.
   * @param maxHp Thief's maxHp.
   * @param defense Thief's defense.
   */
  public void makeThief (String name, int maxHp, int defense) {
    ThiefCharacter character = new ThiefCharacter(turnsQueue,name,maxHp,defense);
    character.setPosition(playersAlive);
    character.equipWeapon(new Bow("ToyBow",0,20));
    addPlayer(character);
  }

  /**
   * Makes a EngineerCharacter, adds to it the listeners, adds 1 to the players quantity and adds the new
   * character to the alivePlayerCharacters list.
   * @param name Engineer's name.
   * @param maxHp Enigneer's maxHp.
   * @param defense Engineer's defense.
   */
  public void makeEngineer (String name, int maxHp, int defense) {
    EngineerCharacter character = new EngineerCharacter(turnsQueue, name, maxHp, defense);
    character.setPosition(playersAlive);
    character.equipWeapon(new Axe("ToyAxe",0,20));
    addPlayer(character);
  }

  /**
   * Makes a WhiteMageCharacter, adds to it the listeners, adds 1 to the players quantity and adds the new
   * character to the alivePlayerCharacters list.
   * @param name WhiteMage's name.
   * @param maxHp WhiteMage's maxHp.
   * @param defense WhiteMage's defense.
   * @param maxMana WhiteMage's maxMana.
   */
  public void makeWhiteMage (String name, int maxHp, int defense, int maxMana) {
    WhiteMageCharacter character = new WhiteMageCharacter(turnsQueue,name,maxHp,defense,maxMana);
    character.setPosition(playersAlive);
    character.equipWeapon(new Staff("ToyStaff",0,0,20));
    addPlayer(character);
  }

  /**
   * Makes a BlackMageCharacter, adds to it the listeners, adds 1 to the players quantity and adds the new
   * character to the alivePlayerCharacters list.
   * @param name BlackMage's name.
   * @param maxHp BlackMage's maxHp.
   * @param defense BlackMage's defense.
   * @param maxMana BlackMage's maxMana.
   */
  public void makeBlackMage (String name, int maxHp, int defense, int maxMana) {
    BlackMageCharacter character = new BlackMageCharacter(turnsQueue,name,maxHp,defense,maxMana);
    character.setPosition(playersAlive);
    character.equipWeapon(new Staff("ToyStaff",0,0,20));
    addPlayer(character);
  }

  /**
   * Makes a Enemy, adds to it the listeners, adds 1 to the enemy quantity and adds the new character to
   * enemyCharacters list.
   * @param name Enemy's name.
   * @param maxHp Enemy's maxHp.
   * @param defense Enemy's defense.
   * @param weight Enemy's weight.
   * @param damage Enemy's damage.
   */
  public void makeEnemy (String name, int maxHp, int defense, int weight, int damage) {
    if (getEnemiesAlive() < 8) {
      Enemy character = new Enemy(turnsQueue,name,maxHp,weight,defense,damage);
      character.addDeathListener(faintEnemyListener);
      character.addStartTurnListener(startTurnListener);
      character.addFinishTurnListener(finishTurnListener);
      character.setPosition(10);
      enemyCharacters.add(character);
      changeEnemyQuantity (1);
    }
  }

  /**
   * Makes a Sword and adds it to the inventory.
   * @param name Sword's name.
   * @param damage Sword's damage.
   * @param weight Swords's weight.
   */
  public void makeSword (String name, int damage, int weight) {
    inventory.addToInventory(new Sword(name,damage,weight));
  }

  /**
   * Makes an Axe and adds it to the inventory.
   * @param name Axe's name.
   * @param damage Axe's damage.
   * @param weight Axe's weight.
   */
  public void makeAxe (String name, int damage, int weight) {
    inventory.addToInventory(new Axe(name,damage,weight));
  }

  /**
   * Makes a Knife and adds it to the inventory.
   * @param name Knife's name.
   * @param damage Knife's damage.
   * @param weight Knife's weight.
   */
  public void makeKnife (String name, int damage, int weight) {
    inventory.addToInventory(new Knife(name,damage,weight));
  }

  /**
   * Makes a Bow and adds it to the inventory.
   * @param name Bow's name.
   * @param damage Bow's damage.
   * @param weight Bow's weight.
   */
  public void makeBow (String name, int damage, int weight) {
    inventory.addToInventory(new Bow(name,damage,weight));
  }

  /**
   * Makes a Staff and adds it to the inventory.
   * @param name Staff's name.
   * @param damage Staff's damage.
   * @param weight Staff's weight.
   * @param magicDamage Staff's magicDamage.
   */
  public void makeStaff (String name, int damage, int weight, int magicDamage) {
    inventory.addToInventory(new Staff(name,damage,magicDamage,weight));
  }

  /**
   * Returns a player character from the list of playerCharacters, using an index.
   * @param index index of the character wanted.
   * @return player character wanted.
   */
  public IPlayerCharacter getPlayerCharacter (int index) {
    return getPlayerCharacters().get(index);
  }

  /**
   * Returns an enemy from the list of enemies, using an index.
   * @param index index of the character wanted.
   * @return enemy wanted.
   */
  public Enemy getEnemy (int index) {
    return getEnemyCharacters().get(index);
  }

  /**
   * Returns the list of player characters.
   * @return list of player characters.
   */
  public ArrayList<IPlayerCharacter> getPlayerCharacters() {
    return playerCharacters;
  }

  /**
   * Adds i to playerAlive.
   * @param i how many will be added to playersAlive.
   */
  public void changeAlivePlayersQuantity(int i) {
    playersAlive += i;
  }

  /**
   * Returns the name of the player character with the index.
   * @param index of the character.
   * @return name of the character.
   */
  public String getPlayerCharacterName(int index) {
    return getPlayerCharacter(index).getName();
  }

  /**
   * Returns the name of the enemy with the index.
   * @param index of the enemy.
   * @return name of the enemy.
   */
  public String getEnemyName (int index) {
    return getEnemy(index).getName();
  }

  /**
   * Returns the maxHp of the player character with the index.
   * @param index of the player character.
   * @return max hp of the player character.
   */
  public int getPlayerCharacterMaxHp (int index) {
    return getPlayerCharacter(index).getMaxHp();
  }

  /**
   * Returns the maxHp of the enemy with the index.
   * @param index of the enemy.
   * @return max hp of the enemy.
   */
  public int getEnemyMaxHp (int index) {
    return getEnemy(index).getMaxHp();
  }

  /**
   * Returns the hp of the player character with the index.
   * @param index of the player character.
   * @return hp of the player character.
   */
  public int getPlayerCharacterHp (int index) {
    return getPlayerCharacter(index).getHp();
  }

  /**
   * Returns the hp of the enemy with the index.
   * @param index of the enemy.
   * @return hp of the enemy.
   */
  public int getEnemyHp (int index) {
    return getEnemy(index).getHp();
  }

  /**
   * Returns the defense of the player character with the index.
   * @param index of the player character.
   * @return defense of the player character.
   */
  public int getPlayerCharacterDefense (int index) {
    return getPlayerCharacter(index).getDefense();
  }

  /**
   * Returns the defense of the enemy with the index.
   * @param index of the enemy.
   * @return defense of the enemy.
   */
  public int getEnemyDefense (int index) {
    return getEnemy(index).getDefense();
  }

  /**
   * Returns the weight of the player character with the index.
   * @param index of the player character.
   * @return weight of the player character.
   */
  public int getPlayerCharacterWeight (int index) {
    return getPlayerCharacter(index).getEquippedWeapon().getWeight();
  }

  /**
   * Returns the damage of the player character with the index.
   * @param index of the player character.
   * @return damage of the player character.
   */
  public int getPlayerCharacterDamage (int index) {
    return getPlayerCharacter(index).getEquippedWeapon().getDamage();
  }

  /**
   * Returns the max mana of the player character with the index.
   * @param index of the player character.
   * @return max mana of the player character.
   */
  public int getMaxMana (int index) {
    return getPlayerCharacter(index).getMaxMana();
  }

  /**
   * Returns the mana of the player character with the index.
   * @param index of the player character.
   * @return mana of the player character.
   */
  public int getMana (int index) {
    return getPlayerCharacter(index).getMana();
  }

  /**
   * Returns the damage of the enemy with the index.
   * @param index of the enemy.
   * @return damage of the enemy.
   */
  public int getEnemyDamage (int index) {
    return getEnemy(index).getDamage();
  }

  /**
   * Returns the weight of the enemy with the index.
   * @param index of the enemy.
   * @return weight of the enemy.
   */
  public int getEnemyWeight (int index) {
    return getEnemy(index).getWeight();
  }

  /**
   * Returns the weapon with the index.
   * @param index of the weapon.
   * @return weapon.
   */
  public IWeapon getWeapon (int index) {
    return inventory.getWeaponsInventory().get(index);
  }

  /**
   * Returns the name of the weapon with the index.
   * @param index of the weapon.
   * @return the name of the weapon with the index.
   */
  public String getWeaponName (int index) {
    return getWeapon(index).getName();
  }

  /**
   * Returns the damage of the weapon with the index.
   * @param index of the weapon.
   * @return the damage of the weapon with the index.
   */
  public int getWeaponDamage (int index) {
    return getWeapon(index).getDamage();
  }

  /**
   * Returns the weight of the weapon with the index.
   * @param index of the weapon.
   * @return the weight of the weapon with the index.
   */
  public int getWeaponWeight (int index) {
    return getWeapon(index).getWeight();
  }

  /**
   * Returns the list of enemies.
   * @return enemyCharacters array list.
   */
  public ArrayList<Enemy> getEnemyCharacters() {
    return enemyCharacters;
  }

  /**
   * Method called when the user wins.
   */
  public void win() {
    setPhase(new EndPhase());
    gameEnd = "Congratulations, you won!!!";
  }

  /**
   * Method called when the user loses.
   */
  public void lose() {
    setPhase(new EndPhase());
    gameEnd = "GameOver, you lose";
  }

  /**
   * Returns the result of the game, this value changes when the game ends.
   * @return the result of the game.
   */
  public String getGameEnd () {
    return gameEnd;
  }

  /**
   * Returns the quantity of alive enemies.
   * @return enemiesAlive.
   */
  public int getEnemiesAlive() {
    return enemiesAlive;
  }

  /**
   * Adds i to the alive enemies.
   * @param i number added to enemiesAlive.
   */
  public void changeEnemyQuantity (int i) {
    enemiesAlive += i;
  }

  /**
   * Returns the number of alive PlayerCharacters.
   * @return number of alive PlayerCharacters.
   */
  public int getPlayersAlive () {
    return playersAlive;
  }

  /**
   * Returns the inventory with the weapons.
   * @return inventory.
   */
  public Inventory getInventory () {
    return inventory;
  }

  /**
   * Moves the inventory pointer right.
   */
  public void rightMoveInventory () {
    phase.moveRightInventory();
  }

  /**
   * Moves the inventory pointer left.
   */
  public void leftMoveInventory () {
    phase.moveLeftInventory();
  }

  /**
   * Moves the inventory pointer up.
   */
  public void upMoveInventory () {
    phase.moveUpInventory();
  }

  /**
   * Moves the inventory pointer down.
   */
  public void downMoveInventory () {
    phase.moveDownInventory();
  }

  /**
   * The character equips the weapon pointed in the inventory.
   * @param character who equips the weapon.
   */
  public void equipWeaponTo (IPlayerCharacter character) {
    getInventory().equipWeaponToCharacter(character);
  }

  /**
   * The enemy Enemy do a commonAttack to the target.
   * @param enemy who attacks.
   * @param target who receives the attack.
   */
  public void enemyAttacks (Enemy enemy, IPlayerCharacter target) {
    enemy.commonAttack(target);
  }

  /**
   * The player IPlayerCharacter do a commonAttack to the target.
   * @param player who attacks.
   * @param target who receives the attack.
   */
  public void playerCharacterCommonAttack (IPlayerCharacter player, Enemy target) {
    player.commonAttack(target);
  }

  /**
   * Returns the random.
   * @return a random element.
   */
  public Random getRandom() {
    return random;
  }

  /**
   * Sets a phase to this controller.
   * @param newPhase phase that will be setted.
   */
  public void setPhase (IPhase newPhase) {
    newPhase.setController(this);
    this.phase = newPhase;
  }

  /**
   * Returns the phase.
   * @return the phase of this controller.
   */
  protected IPhase getPhase () {
    return this.phase;
  }

  /**
   * Starts a new turn depending on the actual phase.
   */
  public void startNewTurn () {
    phase.newTurn();
  }

  /**
   * Executes the actual phase.
   */
  public void executePhase() {
    phase.doPhase();
  }

  /**
   * Returns the actual character.
   * @return the actual character.
   */
  public ICharacter getCharacter() {
    return actualCharacter;
  }

  /**
   * Saves a character for the actual phase.
   * @param newCharacter the saved character.
   */
  public void setCharacter (ICharacter newCharacter) {
    actualCharacter = newCharacter;
  }

  /**
   * Saves the player character in the phase to use it by the user.
   */
  public void doPlayerPhase() {
    setPhase(new PlayerPhase());
    phase.setPlayerCharacter((IPlayerCharacter) actualCharacter);
  }

  /**
   * Calls the enemy automated attack.
   */
  public void doEnemyPhase() {
    setPhase(new EnemyPhase());
  }

  /**
   * Called when a turn ends, the actual character starts waiting and sets a waiting phase.
   */
  public void endTurn() {
    actualCharacter.waitTurn();
    setPosition(10);
    setPhase(new WaitingPhase());
    if (getQueue().size() > 0) {
      startNewTurn();
    }
  }

  /**
   * Starts a new game, initializing a waiting phase and doing waitTurn() for aLl characters.
   */
  public void startGame() {
    setPhase(new WaitingPhase());
    for (IPlayerCharacter character : playerCharacters) {
      character.waitTurn();
    }
    for (Enemy character : enemyCharacters) {
      character.waitTurn();
    }
  }

  /**
   * Returns the number of player characters.
   * @return number of player characters.
   */
  public int getPlayersQuantity() {
    return playerCharacters.size();
  }

  /**
   * Returns the number of enemies.
   * @return number of enemies.
   */
  public int getEnemiesQuantity() {
    return enemyCharacters.size();
  }

  /**
   * Called when the user wants to move the target pointer to the right.
   */
  public void moveTargetRight() {
    phase.moveTargetRight();
  }

  /**
   * Called when the user wants to move the target pointer to the left.
   */
  public void moveTargetLeft() {
    phase.moveTargetLeft();
  }

  /**
   * Returns the quantity of weapons.
   * @return quantity of weapons.
   */
  public int getInventoryLength() {
    return inventory.getWeaponsInventory().size();
  }

  /**
   * Do an attack depending on the actual phase.
   */
  public void doAttack() {
    phase.doAttack();
  }

  /**
   * Returns the index of the player's target.
   * @return index of the player's target.
   */
  public int getActualTargetPointer() {
    return phase.getTargetPointer();
  }

  /**
   * Returns the index of the equipment's pointer.
   * @return index of the equipment's pointer.
   */
  public int getEquipmentPointer() {
    return inventory.getPointer();
  }

  /**
   * Equips the actual pointed weapon to the actual character, depending on the actual phase.
   */
  public void equipWeapon() {
    phase.equipWeapon();
  }

  /**
   * Returns the actual attacking character pointer.
   * @return the actual attacking character pointer.
   */
  public int getPlayerAttackingPointer() {
    return position;
  }

  /**
   * Sets the actual attacking character pointer.
   * @param i new position.
   */
  public void setPosition (int i) {
    position = i;
  }

  /**
   * Takes a look to the players quantity, enemies quantity and weapons quantity, if in all values there are at least 1,
   * the game can start.
   * @return true  if the game can start.
   */
  public boolean gameCanStart() {
    return (getPlayersAlive() > 0 && getEnemiesAlive() > 0 && inventory.getLen() > 0);
  }

  /**
   * Returns the image of the index player character.
   * @param index of player character.
   * @return image of the index player character.
   */
  public String getPlayerImage(int index) {
    return getPlayerCharacter(index).getImage();
  }

  /**
   * Returns the index of the actual target.
   * @return the index of the actual target.
   */
  public int getTargetIndex() {
    return targetIndex;
  }

  /**
   * Adds i to the index of actual target.
   * @param i how many adds to the index of actual target.
   */
  public void addTargetIndex(int i) {
    targetIndex += i;
  }

  /**
   * Return the image path of the index weapon.
   * @param index of the weapon.
   * @return the image path of the index weapon.
   */
  public String getWeaponImage(int index) {
    return getWeapon(index).getImage();
  }
}


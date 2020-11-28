package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.IMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;
import com.github.cc3002.finalreality.model.inventory.Inventory;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Controller {
  int inventoryLenght = 5;

  ArrayList<IPlayerCharacter> alivePlayerCharacters;

  ArrayList<Enemy> enemyCharacters;

  protected BlockingQueue<ICharacter> turnsQueue;
  int playersAlive;
  int enemiesAlive;

  TurnsListener turnsListener;
  PlayerCharacterDeathListener faintPlayerCharactersListener;
  EnemyDeathListener faintEnemyListener;
  Inventory inventory;

  public Controller () {
    alivePlayerCharacters = new ArrayList<IPlayerCharacter>();
    enemyCharacters = new ArrayList<Enemy>();

    playersAlive = 0;
    enemiesAlive = 0;

    faintPlayerCharactersListener = new PlayerCharacterDeathListener(this);
    faintEnemyListener = new EnemyDeathListener(this);
    turnsListener = new TurnsListener(this);

    inventory = new Inventory();
  }

  /**
   * Returns the turnsQueue
   * @return turnsQueue
   */
  public BlockingQueue<ICharacter> getQueue () {
    return turnsQueue;
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
    character.addDeathListener(faintPlayerCharactersListener);
    character.addTurnsListener(turnsListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
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
    character.addDeathListener(faintPlayerCharactersListener);
    character.addTurnsListener(turnsListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
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
    character.addDeathListener(faintPlayerCharactersListener);
    character.addTurnsListener(turnsListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
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
    character.addDeathListener(faintPlayerCharactersListener);
    character.addTurnsListener(turnsListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
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
    character.addDeathListener(faintPlayerCharactersListener);
    character.addTurnsListener(turnsListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
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
    Enemy character = new Enemy(turnsQueue,name,maxHp,weight,defense,damage);
    character.addDeathListener(faintEnemyListener);
    character.addTurnsListener(turnsListener);
    enemyCharacters.add(character);
    changeEnemyQuantity (1);
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
    return getAlivePlayerCharacters().get(index);
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
  public ArrayList<IPlayerCharacter> getAlivePlayerCharacters() {
    return alivePlayerCharacters;
  }

  /**
   * Adds i to playerAlive.
   * @param i how many will be added to playersAlive.
   */
  public void changePlayersQuantity (int i) {
    playersAlive += i;
  }

  /**
   * Returns IPlayerCharacter character's name.
   * @param character who will be asked for his name.
   * @return character's name.
   */
  public String getPlayerCharacterName(IPlayerCharacter character) {
    return character.getName();
  }

  /**
   * Returns Enemy character's name.
   * @param character who will be asked for his name.
   * @return character's name.
   */
  public String getEnemyName (Enemy character) {
    return character.getName();
  }

  /**
   * Returns player character's name.
   * @param character who will be asked for his name.
   * @return character's name.
   */
  public int getPlayerCharacterMaxHp (IPlayerCharacter character) {
    return character.getMaxHp();
  }

  /**
   * Returns enemy character's maxHp.
   * @param character who will be asked for his maxHp.
   * @return maxHp value.
   */
  public int getEnemyMaxHp (Enemy character) {
    return character.getMaxHp();
  }

  /**
   * Returns player character's hp.
   * @param character who will be asked for his hp.
   * @return hp value.
   */
  public int getPlayerCharacterHp (IPlayerCharacter character) {
    return character.getHp();
  }

  /**
   * Returns enemy character's hp.
   * @param character who will be asked for his hp.
   * @return hp value.
   */
  public int getEnemyHp (Enemy character) {
    return character.getHp();
  }

  /**
   * Returns character's defense.
   * @param character character who will be asked for his defense.
   * @return defense value.
   */
  public int getPlayerCharacterDefense (IPlayerCharacter character) {
    return character.getDefense();
  }

  /**
   * Returns character's defense.
   * @param character character who will be asked for his defense.
   * @return defense value.
   */
  public int getEnemyDefense (Enemy character) {
    return character.getDefense();
  }

  /**
   * Returns this player character's weight, by asking his weapon's weight.
   * @param character who will be asked for his weight.
   * @return  weight of the character's weapon.
   */
  public int getPlayerCharacterWeight (IPlayerCharacter character) {
    return character.getEquippedWeapon().getWeight();
  }

  /**
   * Returns this player character's damage, by asking his weapon's damage.
   * @param character who will be asked for his damage.
   * @return damage of the character's weapon.
   */
  public int getPlayerCharacterDamage (IPlayerCharacter character) {
    return character.getEquippedWeapon().getDamage();
  }

  /**
   * Returns this player character's maxMana value.
   * @param character who will be asked for maxMana value.
   * @return maxMana.
   */
  public int getMaxMana (IPlayerCharacter character) {
    return character.getMaxMana();
  }

  /**
   * Returns this player character's mana value.
   * @param character who will be asked for mana value.
   * @return mana.
   */
  public int getMana (IPlayerCharacter character) {
    return character.getMana();
  }

  /**
   * Returns the Enemy character's damage.
   * @param character who will be asked for damage.
   * @return the character's damage.
   */
  public int getEnemyDamage (Enemy character) {
    return character.getDamage();
  }

  /**
   * Returns the Enemy character's weight.
   * @param character who will be asked for weight.
   * @return the character's weight.
   */
  public int getEnemyWeight (Enemy character) {
    return character.getWeight();
  }

  /**
   * Returns the weapon's name of the character.
   * @param character who will be asked for weapon's name.
   * @return weapon's name.
   */
  public String getWeaponName (IPlayerCharacter character) {
    return character.getEquippedWeapon().getName();
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
  }

  /**
   * Method called when the user loses.
   */
  public void lose() {
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
    getInventory().movePoint(1);
  }

  /**
   * Moves the inventory pointer left.
   */
  public void leftMoveInventory () {
    getInventory().movePoint(-1);
  }

  /**
   * Moves the inventory pointer up.
   */
  public void upMoveInventory () {
    getInventory().movePoint(inventoryLenght);
  }

  /**
   * Moves the inventory pointer down.
   */
  public void downMoveInventory () {
    getInventory().movePoint(-inventoryLenght);
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
   * Method called when a turn finished and then another turn starts.
   */
  public void nextTurn() {
  }
}


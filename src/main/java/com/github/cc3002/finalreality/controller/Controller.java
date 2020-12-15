package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.listeners.EnemyDeathListener;
import com.github.cc3002.finalreality.controller.listeners.FinishTurnListener;
import com.github.cc3002.finalreality.controller.listeners.PlayerCharacterDeathListener;
import com.github.cc3002.finalreality.controller.listeners.StartTurnListener;
import com.github.cc3002.finalreality.controller.turns.EnemyPhase;
import com.github.cc3002.finalreality.controller.turns.Phase;
import com.github.cc3002.finalreality.controller.turns.PlayerPhase;
import com.github.cc3002.finalreality.controller.turns.WaitingPhase;
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
 * Controller class has the methods to access to the model.
 */
public class Controller {
  private CharactersFactory cFactory;
  private WeaponsFactory wFactory;

  private Random random;
  private Phase phase;
  private final int inventoryLength = 5;
  private int maxPlayers = 4;

  private final ArrayList<IPlayerCharacter> allPlayerCharacters;
  private final ArrayList<IPlayerCharacter> alivePlayerCharacters;

  private int playersAlive;
  private final ArrayList<Enemy> enemyCharacters;
  private int enemiesAlive;
  private final Inventory inventory;

  private final BlockingQueue<ICharacter> turnsQueue;

  private final StartTurnListener startTurnListener;
  private final FinishTurnListener finishTurnListener;
  private final PlayerCharacterDeathListener faintPlayerCharactersListener;
  private final EnemyDeathListener faintEnemyListener;

  private ICharacter actualCharacter;

  /**
   * Initialize a Controller, making listeners, a queue, lists of characters.
   */
  public Controller (int seed) {
    random = new Random(seed);
    wFactory = new WeaponsFactory(this);
    cFactory = new CharactersFactory(this);

    allPlayerCharacters = new ArrayList<>();
    alivePlayerCharacters = new ArrayList<>();
    enemyCharacters = new ArrayList<>();

    turnsQueue = new LinkedBlockingQueue<>();

    playersAlive = 0;
    enemiesAlive = 0;

    faintPlayerCharactersListener = new PlayerCharacterDeathListener(this);
    faintEnemyListener = new EnemyDeathListener(this);
    finishTurnListener = new FinishTurnListener(this);
    startTurnListener = new StartTurnListener(this);

    inventory = new Inventory();
  }

  public ArrayList<IPlayerCharacter> getAlivePlayerCharacters () {
    return alivePlayerCharacters;
  }

  /**
   * Returns the turnsQueue
   * @return turnsQueue
   */
  public BlockingQueue<ICharacter> getQueue () {
    return turnsQueue;
  }

  /**
   * Adds the player listeners to the character.
   * @param character
   */
  public void addPlayerToListsAndListeners(IPlayerCharacter character) {
    character.addDeathListener(faintPlayerCharactersListener);
    character.addFinishTurnListener(finishTurnListener);
    character.addStartTurnListener(startTurnListener);
    allPlayerCharacters.add(character);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
  }

  /**
   * Adds the enemy listeners to the character.
   * @param character
   */
  public void addEnemyToListsAndListeners(Enemy character) {
    character.addDeathListener(faintEnemyListener);
    character.addFinishTurnListener(finishTurnListener);
    character.addStartTurnListener(startTurnListener);
    enemyCharacters.add(character);
    changeEnemyQuantity(1);
  }

  /**
   * Makes a knight using the cFactory.
   */
  public void makeKnight () {
    if (getPlayersAlive() < maxPlayers) {
      cFactory.makeKnight();
    }
  }

  /**
   * Makes a thief using the cFactory.
   */
  public void makeThief () {
    if (getPlayersAlive() < maxPlayers) {
      cFactory.makeThief();
    }
  }

  /**
   * Makes a engineer using the cFactory.
   */
  public void makeEngineer () {
    if (getPlayersAlive() < maxPlayers) {
      cFactory.makeEngineer();
    }
  }

  /**
   * Makes a white mage using the cFactory.
   */
  public void makeWhiteMage () {
    if (getPlayersAlive() < maxPlayers) {
      cFactory.makeWhiteMage();
    }
  }

  /**
   * Makes a black mage using the cFactory.
   */
  public void makeBlackMage () {
    if (getPlayersAlive() < maxPlayers) {
      cFactory.makeBlackMage();
    }
  }

  /**
   * Makes a enemy using the cFactory.
   */
  public void makeEnemy () {
    cFactory.makeEnemy();
  }

  /**
   * Makes a sword using the wFactory.
   */
  public void makeSword () {
    wFactory.makeSword();
  }

  /**
   * Makes a knife using the wFactory.
   */
  public void makeKnife () {
    wFactory.makeKnife();
  }

  /**
   * Makes a bow using the wFactory.
   */
  public void makeBow () {
    wFactory.makeBow();
  }

  /**
   * Makes an axe using the wFactory.
   */
  public void makeAxe () {
    wFactory.makeAxe();
  }

  /**
   * Makes a staff using the wFactory.
   */
  public void makeStaff () {
    wFactory.makeStaff();
  }

  public void setWeaponDamage (int i) {
    wFactory.setDamage(i);
  }

  public void setWeaponMagicDamage (int i) {
    wFactory.setMagicDamage(i);
  }

  public void setWeaponName (String name) {
    wFactory.setName(name);
  }

  public void setWeaponWeight (int i) {
    wFactory.setWeight(i);
  }

  public void setCharacterName (String name) {
    cFactory.setName(name);
  }

  public void setCharacterDefense (int i) {
    cFactory.setDefense(i);
  }

  public void setCharacterMaxHp (int i) {
    cFactory.setMaxHp(i);
  }

  public void setCharacterMaxMana (int i) {
    cFactory.setMaxMana(i);
  }

  public void setEnemyWeight (int i) {
    cFactory.setWeight(i);
  }

  public void setEnemyDamage (int i) {
    cFactory.setDamage(i);
  }

  /**
   * Returns a player character from the list of playerCharacters, using an index.
   * @param index index of the character wanted.
   * @return player character wanted.
   */
  public IPlayerCharacter getPlayerCharacter (int index) {
    return getAllPlayerCharacters().get(index);
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
  public ArrayList<IPlayerCharacter> getAllPlayerCharacters() {
    return allPlayerCharacters;
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
    getInventory().movePoint(inventoryLength);
  }

  /**
   * Moves the inventory pointer down.
   */
  public void downMoveInventory () {
    getInventory().movePoint(-inventoryLength);
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

  public void setPhase (Phase phase) {
    phase.setController(this);
    this.phase = phase;
  }

  public Phase getPhase () {
    return this.phase;
  }

  public Random getRandom() {
    return random;
  }

  public void startTurn() {
    phase.newTurn();
  }

  public void endTurn() {
    actualCharacter.waitTurn();
    setPhase(new WaitingPhase());
    if (turnsQueue.size() > 0) {
      phase.newTurn();
    }
  }

  public void doPlayerPhase() {
    setPhase(new PlayerPhase());
  }

  public void doEnemyPhase() {
    setPhase(new EnemyPhase());
    phase.doAttack();
  }

  public void setCharacter(ICharacter character) {
    actualCharacter = character;
  }

  public ICharacter getCharacter() {
    return actualCharacter;
  }

  public void addWeaponToInventory(IWeapon weapon) {
    inventory.addToInventory(weapon);
  }
}


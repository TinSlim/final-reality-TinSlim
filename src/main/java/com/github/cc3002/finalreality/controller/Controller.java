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

    inventory = new Inventory();
  }


  public BlockingQueue<ICharacter> getQueue () {
    return turnsQueue;
  }


  public void makeKnight (String name, int maxHp, int defense) {
    KnightCharacter character = new KnightCharacter(turnsQueue,name,maxHp,defense);
    character.addListener(faintPlayerCharactersListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
  }

  public void makeThief (String name, int maxHp, int defense) {
    ThiefCharacter character = new ThiefCharacter(turnsQueue,name,maxHp,defense);
    character.addListener(faintPlayerCharactersListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
  }

  public void makeEngineer (String name, int maxHp, int defense) {
    EngineerCharacter character = new EngineerCharacter(turnsQueue, name, maxHp, defense);
    character.addListener(faintPlayerCharactersListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
  }

  public void makeWhiteMage (String name, int maxHp, int defense, int maxMana) {
    WhiteMageCharacter character = new WhiteMageCharacter(turnsQueue,name,maxHp,defense,maxMana);
    character.addListener(faintPlayerCharactersListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
  }

  public void makeBlackMage (String name, int maxHp, int defense, int maxMana) {
    BlackMageCharacter character = new BlackMageCharacter(turnsQueue,name,maxHp,defense,maxMana);
    character.addListener(faintPlayerCharactersListener);
    alivePlayerCharacters.add(character);
    changePlayersQuantity(1);
  }

  public void makeEnemy (String name, int maxHp, int defense, int weight, int damage) {
    Enemy character = new Enemy(turnsQueue,name,maxHp,weight,defense,damage);
    character.addListener(faintEnemyListener);
    enemyCharacters.add(character);
    changeEnemyQuantity (1);
  }



  public void makeSword (String name, int damage, int weight) {
    inventory.addToInventory(new Sword(name,damage,weight));
  }

  public void makeAxe (String name, int damage, int weight) {
    inventory.addToInventory(new Axe(name,damage,weight));
  }

  public void makeKnife (String name, int damage, int weight) {
    inventory.addToInventory(new Knife(name,damage,weight));
  }

  public void makeBow (String name, int damage, int weight) {
    inventory.addToInventory(new Bow(name,damage,weight));
  }

  public void makeStaff (String name, int damage, int weight, int magicDamage) {
    inventory.addToInventory(new Staff(name,damage,magicDamage,weight));
  }


  public IPlayerCharacter getPlayerCharacter (int index) {
    return getAlivePlayerCharacters().get(index);
  }

  public Enemy getEnemy (int index) {
    return getEnemyCharacters().get(index);
  }

  /*
    2 Personajes del Jugador
   */

  public ArrayList<IPlayerCharacter> getAlivePlayerCharacters() {
    return alivePlayerCharacters;
  }

  public void changePlayersQuantity (int i) {
    playersAlive += i;
  }

  public String getCharacterName (ICharacter character) {
    return character.getName();
  }

  public int getCharacterMaxHp (ICharacter character) {
    return character.getMaxHp();
  }

  public int getCharacterHp (ICharacter character) {
    return character.getHp();
  }

  public int getCharacterDefense (ICharacter character) {
    return character.getDefense();
  }


  public int getPlayerCharacterWeight (IPlayerCharacter character) {
    return character.getEquippedWeapon().getWeight();
  }

  public int getPlayerCharacterDamage (IPlayerCharacter character) {
    return character.getEquippedWeapon().getDamage();
  }

  public int getMageMaxMana (IMageCharacter character) {
    return character.getMaxMana();
  }

  public int getMageMana (IMageCharacter character) {
    return character.getMana();
  }

  public int getEnemyDamage (Enemy character) {
    return character.getDamage();
  }

  public int getEnemyWeight (Enemy character) {
    return character.getWeight();
  }


  public String getWeaponName (IPlayerCharacter character) {
    return character.getEquippedWeapon().getName();
  }



  public ArrayList<Enemy> getEnemyCharacters() {
    return enemyCharacters;
  }

  public int getEnemiesAlive() {
    return enemiesAlive;
  }

  public void changeEnemyQuantity (int i) {
    enemiesAlive += i;
  }

  public void makeAxe (String name) {
    Axe weapon = new Axe(name,50,60);
    getInventory().addToInventory(weapon);
  }

  public void makeSword (String name) {
    Sword weapon = new Sword(name,50,60);
    getInventory().addToInventory(weapon);
  }

  public void makeStaff (String name) {
    Staff weapon = new Staff(name,50,60,20);
    getInventory().addToInventory(weapon);
  }

  public void makeBow (String name) {
    Bow weapon = new Bow(name,50,60);
    getInventory().addToInventory(weapon);
  }

  public void makeKnife (String name) {
    Knife weapon = new Knife(name,50,60);
    getInventory().addToInventory(weapon);
  }

  public void win() {
  }


  public void loss() {
  }


  public int getPlayersAlive () {
    return playersAlive;
  }

  public Inventory getInventory () {
    return inventory;
  }

  public void rightMoveInventory () {
    inventory.movePoint(1);
  }

  public void leftMoveInventory () {
    inventory.movePoint(-1);
  }

  public void upMoveInventory () {
    inventory.movePoint(inventoryLenght);
  }

  public void downMoveInventory () {
    inventory.movePoint(-inventoryLenght);
  }

  public void equipWeaponTo (IPlayerCharacter character) {
    inventory.equipWeaponToCharacter(character);
  }

  public void enemyAttacks (Enemy enemy, IPlayerCharacter target) {
    enemy.commonAttack(target);
  }

  public void playerCharacterCommonAttack (IPlayerCharacter player, Enemy target) {
    player.commonAttack(target);
  }

}


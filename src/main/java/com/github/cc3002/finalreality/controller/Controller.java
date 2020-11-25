package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.characterfactory.CharacterMaker;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.IMageCharacter;
import com.github.cc3002.finalreality.model.inventory.Inventory;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class Controller {
  int inventoryLenght = 5;
  CharacterMaker characterFactory;

  ArrayList<IPlayerCharacter> alivePlayerCharacters;

  HashMap<String, IPlayerCharacter> faintedPlayerCharacters;
  ArrayList<Enemy> enemyCharacters;

  protected BlockingQueue<ICharacter> turnsQueue;
  int playersAlive;
  int enemiesAlive;
  PlayerCharacterListener faintPlayerCharactersListener;
  EnemyListener faintEnemyListener;
  Inventory inventory;

  public Controller () {
    alivePlayerCharacters = new ArrayList<IPlayerCharacter>();
    enemyCharacters = new ArrayList<Enemy>();
    faintedPlayerCharacters = new HashMap<>();

    playersAlive = 0;
    enemiesAlive = 0;

    faintPlayerCharactersListener = new PlayerCharacterListener(this);
    faintEnemyListener = new EnemyListener(this);

    inventory = new Inventory();
  }


  public BlockingQueue<ICharacter> getQueue () {
    return turnsQueue;
  }

  public void setCharacterMaker(CharacterMaker maker) {
    characterFactory = maker;
    maker.setController(this);
  }


  public void rightCharacterMaker() {
    characterFactory.changeRight();
  }

  public void leftCharacterMaker() {
    characterFactory.changeLeft();
  }

  public void enemyMaker () {
    characterFactory.changeToEnemy();
  }

  public void makeCharacter (String name) {
    characterFactory.makeCharacter(name);
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

  public int getMageMaxMana (IMageCharacter character) {
    return character.getMaxMana();
  }

  public int getMageMana (IMageCharacter character) {
    return character.getMana();
  }

  public int getCharacterWeight (ICharacter character) {
    return character.getWeight();
  }

  public int getCharacterDamage (ICharacter character) {
    return character.getDamage();
  }

  public int getMageMagicDamage (IMageCharacter character) {
    return character.getMagicDamage();
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

  public HashMap<String, IPlayerCharacter> getFaintedPlayerCharacters() {
    return faintedPlayerCharacters;
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

  public CharacterMaker getCharacterMaker() {
    return characterFactory;
  }
}


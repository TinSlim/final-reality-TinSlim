package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.characterfactory.CharacterMaker;
import com.github.cc3002.finalreality.controller.weaponfactory.WeaponMaker;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class Controller {
  int inventoryLenght = 7;

  CharacterMaker characterFactory;
  WeaponMaker weaponFactory;

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

  /*
    1 Crear y asignar objetos
   */


  public void setCharacterMaker(CharacterMaker maker) {
    characterFactory = maker;
    maker.setController(this);
  }

  public void setWeaponMaker(WeaponMaker maker) {
    weaponFactory = maker;
    maker.setController(this);
  }

  void rightCharacterMaker() {
    characterFactory.changeRight();
  }

  void leftCharacterMaker() {
    characterFactory.changeLeft();
  }

  void enemyMaker () {
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

  /*
    3 Tener Conocimiento de enemigos y datos
   */


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

  public void win() {
  }


  public void loss() {
  }



  public void getPlayersCharactersData () {
    for (IPlayerCharacter character : alivePlayerCharacters) {
      character.getData();
    }
  }




  public int getPlayersAlive () {
    return playersAlive;
  }

  /*
    4 Manejar el inventario
    5 Equipar un arma a un personaje
   */

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

  /*
    6 Personaje ataque a otro
   */

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


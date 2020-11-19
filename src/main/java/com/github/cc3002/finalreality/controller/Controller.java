package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;
import com.github.cc3002.finalreality.model.inventory.Inventory;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Controller {
  private List<IPlayerCharacter> playerCharacters;
  private List<Enemy> enemyCharacters;
  private List<ICharacter> allCharacters;
  BlockingQueue<ICharacter> turnsQueue;

  private int quantityPlayerCharacters;
  private int quantityEnemyCharacters;

  private Inventory weaponsInventory;


  public Controller () {
    BlockingQueue<ICharacter> turnsQueue = new LinkedBlockingQueue<>();
    quantityPlayerCharacters = 0;
    quantityEnemyCharacters = 0;
    weaponsInventory = new Inventory();
  }


  public void makeBlackMage (String name, int maxHp, int defense, int maxMana) {
    BlackMageCharacter newBlackMage = new BlackMageCharacter(turnsQueue,name,maxHp,defense,maxMana);
    playerCharacters.add(newBlackMage);
    allCharacters.add(newBlackMage);
  }

  public void makeWhiteMage (String name, int maxHp, int defense, int maxMana) {
    WhiteMageCharacter newWhiteMage = new WhiteMageCharacter(turnsQueue,name,maxHp,defense,maxMana);
    playerCharacters.add(newWhiteMage);
    allCharacters.add(newWhiteMage);
  }

  public void makeEngineer (String name, int maxHp, int defense) {
    EngineerCharacter newEngineer = new EngineerCharacter(turnsQueue,name,maxHp,defense);
    playerCharacters.add(newEngineer);
    allCharacters.add(newEngineer);
  }

  public void makeThief (String name, int maxHp, int defense) {
    ThiefCharacter newThief = new ThiefCharacter(turnsQueue,name,maxHp,defense);
    playerCharacters.add(newThief);
    allCharacters.add(newThief);
  }

  public void makeKnight (String name, int maxHp, int defense) {
    KnightCharacter newKnight = new KnightCharacter(turnsQueue,name,maxHp,defense);
    playerCharacters.add(newKnight);
    allCharacters.add(newKnight);
  }

  public void makeEnemy (String name, int maxHp, int weight, int defense, int damage) {
    Enemy newEnemy = new Enemy(turnsQueue,name,maxHp,weight,defense,damage);
    enemyCharacters.add(newEnemy);
    allCharacters.add(newEnemy);
  }

}

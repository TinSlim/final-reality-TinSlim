package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.controller.turns.Phase;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;

public class CharactersFactory {
  Controller controller;

  int maxSize = 4;
  int actualSize = 0;

  String actualName;
  int actualMaxHp;
  int actualDefense;
  int actualMaxMana;
  int enemyDamage;
  int enemyWeight;

  public CharactersFactory (Controller controller) {
    this.controller = controller;
  }

  public void makeKnight () {
    KnightCharacter character = new KnightCharacter(controller.getQueue(),actualName,actualMaxHp,actualDefense);
    controller.addPlayerToListsAndListeners(character);
  }

  public void makeThief () {
    ThiefCharacter character = new ThiefCharacter(controller.getQueue(),actualName,actualMaxHp,actualDefense);
    controller.addPlayerToListsAndListeners(character);
  }

  public void makeEngineer () {
    EngineerCharacter character = new EngineerCharacter(controller.getQueue(),actualName,actualMaxHp,actualDefense);
    controller.addPlayerToListsAndListeners(character);
  }

  public void makeWhiteMage () {
    WhiteMageCharacter character = new WhiteMageCharacter(controller.getQueue(),actualName,actualMaxHp,
            actualDefense, actualMaxMana);
    controller.addPlayerToListsAndListeners(character);
  }

  public void makeBlackMage () {
    BlackMageCharacter character = new BlackMageCharacter(controller.getQueue(),actualName,actualMaxHp,
            actualDefense, actualMaxMana);
    controller.addPlayerToListsAndListeners(character);
  }

  public void makeEnemy () {
    Enemy character = new Enemy(controller.getQueue(),actualName,actualMaxHp,enemyWeight,actualDefense,enemyDamage);
    controller.addEnemyToListsAndListeners(character);
  }

  public void setName(String name) {
    actualName = name;
  }

  public void setDefense(int i) {
    actualDefense = i;
  }

  public void setMaxHp(int i) {
    actualMaxHp = i;
  }

  public void setWeight(int i) {
    enemyWeight = i;
  }

  public void setDamage(int i) {
    enemyDamage = i;
  }
}

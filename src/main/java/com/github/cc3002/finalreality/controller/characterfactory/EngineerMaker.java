package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;

public class EngineerMaker extends CharacterMaker {

  public EngineerMaker () {
    defense = 100;
    maxHp = 200;
  }

  public void changeRight () {
    this.changeState(new WhiteMageMaker());
  }

  public void changeLeft () {
    this.changeState(new ThiefMaker());
  }

  public void makeCharacter(String name) {
    EngineerCharacter newCharacter = new EngineerCharacter(getController().getQueue(),name,maxHp,defense);
    this.getController().getAlivePlayerCharacters().add(newCharacter);
    this.getController().changePlayersQuantity(1);
  }
}

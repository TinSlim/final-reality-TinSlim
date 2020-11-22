package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;

public class ThiefMaker extends CharacterMaker {

  public ThiefMaker () {
    defense = 100;
    maxHp = 200;
  }

  public void changeRight () {
    this.changeState(new EngineerMaker());
  }

  public void changeLeft () {
    this.changeState(new KnightMaker());
  }

  public void makeCharacter(String name) {
    ThiefCharacter newCharacter = new ThiefCharacter(getController().getQueue(),name,maxHp,defense);
    this.getController().getAlivePlayerCharacters().add(newCharacter);
    this.getController().changePlayersQuantity(1);
  }
}

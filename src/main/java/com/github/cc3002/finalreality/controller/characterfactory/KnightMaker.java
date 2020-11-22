package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;

public class KnightMaker extends CharacterMaker {

  public KnightMaker () {
    defense = 100;
    maxHp = 200;
  }

  public void changeRight () {
    this.changeState(new ThiefMaker());
  }

  public void changeLeft () {
    this.changeState(new BlackMageMaker());
  }

  public void makeCharacter(String name) {
    KnightCharacter newCharacter = new KnightCharacter(getController().getQueue(),name,maxHp,defense);
    this.getController().getAlivePlayerCharacters().add(newCharacter);
    this.getController().changePlayersQuantity(1);
  }
}

package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;

public class WhiteMageMaker extends CharacterMaker {
  int maxMana = 100;

  public WhiteMageMaker () {
    defense = 100;
    maxHp = 200;
    maxMana = 100;
  }

  public void changeRight () {
    this.changeState(new BlackMageMaker());
  }

  public void changeLeft () {
    this.changeState(new EngineerMaker());
  }

  public void makeCharacter(String name) {
    WhiteMageCharacter newCharacter = new WhiteMageCharacter(getController().getQueue(),name,
            maxHp,defense,maxMana);
    this.getController().getAlivePlayerCharacters().add(newCharacter);
    this.getController().changePlayersQuantity(1);
  }
}

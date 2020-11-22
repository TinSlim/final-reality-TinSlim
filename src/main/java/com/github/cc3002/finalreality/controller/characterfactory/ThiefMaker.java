package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;

public class ThiefMaker extends CharacterMaker {

  public ThiefMaker () {
    defense = 100;
    maxHp = 200;
  }

  public void changeRight () {
    this.changeMaker(new EngineerMaker());
  }

  public void changeLeft () {
    this.changeMaker(new KnightMaker());
  }

  public void makeCharacter(String name) {
    ThiefCharacter newCharacter = new ThiefCharacter(getController().getQueue(),name,maxHp,defense);
    this.getController().getAlivePlayerCharacters().add(newCharacter);
    this.getController().changePlayersQuantity(1);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ThiefMaker)) {
      return false;
    }
    final ThiefMaker maker = (ThiefMaker) o;
    return getController().equals(maker.getController());
  }
}

package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;

public class KnightMaker extends CharacterMaker {

  public KnightMaker () {
    defense = 100;
    maxHp = 200;
  }

  public void changeRight () {
    this.changeMaker(new ThiefMaker());
  }

  public void changeLeft () {
    this.changeMaker(new BlackMageMaker());
  }

  public void makeCharacter(String name) {
    KnightCharacter newCharacter = new KnightCharacter(getController().getQueue(),name,maxHp,defense);
    this.getController().getAlivePlayerCharacters().add(newCharacter);
    this.getController().changePlayersQuantity(1);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof KnightMaker)) {
      return false;
    }
    final KnightMaker maker = (KnightMaker) o;
    return getController().equals(maker.getController());
  }
}

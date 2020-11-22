package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;

public class BlackMageMaker extends CharacterMaker {
  int maxMana;

  public BlackMageMaker () {
    defense = 100;
    maxHp = 200;
    maxMana = 100;
  }

  public void changeRight () {
    this.changeMaker(new KnightMaker());
  }

  public void changeLeft () {
    this.changeMaker(new WhiteMageMaker());
  }

  public void makeCharacter(String name) {
    WhiteMageCharacter newCharacter = new WhiteMageCharacter(getController().getQueue(),name,
            maxHp,defense,maxMana);
    this.getController().getAlivePlayerCharacters().add(newCharacter);
    this.getController().changePlayersQuantity(1);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BlackMageMaker)) {
      return false;
    }
    final BlackMageMaker maker = (BlackMageMaker) o;
    return getController().equals(maker.getController());
  }
}

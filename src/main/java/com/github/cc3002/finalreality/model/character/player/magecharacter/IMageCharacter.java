package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IMageCharacter {

  int getMaxMana();

  int getMana();

  void equip(IWeapon weapon);

}

package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IMageCharacter {

  /**
   * Gets this MageCharacter's max mana value.
   * @return this MageCharacter's max mana value.
   */
  int getMaxMana();

  /**
   * Gets this MageCharacter's actual mana.
   * @return this MageCharacter's actual mana.
   */
  int getMana();

  /**
   * Sets weapon to this character's equipped weapon, only if the character's class can use it.
   * @param weapon weapon to equip.
   */
  void equip(IWeapon weapon);

  int getMagicDamage();
}

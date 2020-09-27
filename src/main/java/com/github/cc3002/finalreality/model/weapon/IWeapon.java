package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public interface IWeapon {

  /**
   * Returns this weapon's damage.
   */
  int getDamage();

  /**
   * Equips or not this weapon to a Knight Character.
   * @param character
   */
  void equipToKnight(IPlayerCharacter character);

  /**
   * Equips or not this weapon to a Thief Character.
   * @param character
   */
  void equipToThief(IPlayerCharacter character);

  /**
   * Equips or not this weapon to a Engineer Character.
   * @param character
   */
  void equipToEngineer(IPlayerCharacter character);

  /**
   * Equips or not this weapon to a Knight Character .
   * @param character
   */
  void equipToBlackMage(IPlayerCharacter character);

  /**
   * Equips or not this weapon to a White Mage Character.
   * @param character
   */
  void equipToWhiteMage(IPlayerCharacter character);
}

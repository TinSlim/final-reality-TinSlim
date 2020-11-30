package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public interface IWeapon {

  /**
   * Returns this weapon's damage.
   */
  int getDamage();

  /**
   * Equips or not this weapon to a Knight Character.
   * @param character who is trying to equip this weapon.
   */
  void equipToKnight(IPlayerCharacter character);

  /**
   * Equips or not this weapon to a Thief Character.
   * @param character who is trying to equip this weapon.
   */
  void equipToThief(IPlayerCharacter character);

  /**
   * Equips or not this weapon to a Engineer Character.
   * @param character who is trying to equip this weapon.
   */
  void equipToEngineer(IPlayerCharacter character);

  /**
   * Equips or not this weapon to a Knight Character .
   * @param character who is trying to equip this weapon.
   */
  void equipToBlackMage(IPlayerCharacter character);

  /**
   * Equips or not this weapon to a White Mage Character.
   * @param character who is trying to equip this weapon.
   */
  void equipToWhiteMage(IPlayerCharacter character);

  /**
   * Returns the weight of this weapon.
   * @return weight of this weapon.
   */
  int getWeight();

  /**
   * Returns name of this weapon.
   * @return name of this weapon.
   */
  String getName();

  /**
   * Thows error if this weapon is not a Staff, else returns the magicDamage.
   * @return magicDamage.
   */
  int getMagicDamage();

  /**
   * Returns true if this weapon can cast magic (only Staff can cast magic).
   * @return true or false if the weapon can cast magic.
   */
  boolean castMagic();
}

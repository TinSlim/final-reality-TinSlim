package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;

public interface IWeapon {

  /**
   * Returns this weapon's damage.
   */
  int getDamage();

  /**
   * Equips or not this weapon to a Knight Character.
   * @param character
   */
  void equipToKnight(KnightCharacter character);

  /**
   * Equips or not this weapon to a Thief Character.
   * @param character
   */
  void equipToThief(ThiefCharacter character);

  /**
   * Equips or not this weapon to a Engineer Character.
   * @param character
   */
  void equipToEngineer(EngineerCharacter character);

  /**
   * Equips or not this weapon to a Knight Character .
   * @param character
   */
  void equipToBlackMage(BlackMageCharacter character);

  /**
   * Equips or not this weapon to a White Mage Character.
   * @param character
   */
  void equipToWhiteMage(WhiteMageCharacter character);
}

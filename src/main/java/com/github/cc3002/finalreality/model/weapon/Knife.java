package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;

public class Knife extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @param name
   * @param damage
   * @param weight
   * @param type
   * @see WeaponType
   */
  public Knife(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }

  public void equipToKnight(KnightCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToThief(ThiefCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToEngineer(EngineerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToBlackMage(BlackMageCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToWhiteMage(WhiteMageCharacter character){
    character.setEquippedWeapon(this);
  }
}

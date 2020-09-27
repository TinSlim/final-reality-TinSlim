package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class Axe extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @param name
   * @param damage
   * @param weight
   * @param type
   * @see WeaponType
   */
  public Axe(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }

  public void equipToKnight(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToThief(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToEngineer(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToBlackMage(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToWhiteMage(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }


}

package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class Staff extends AbstractWeapon {

  private int magicDamage = 0;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @param name
   * @param damage
   * @param weight
   * @param type
   * @see WeaponType
   */
  public Staff(String name, int damage, int magicDamage, int weight, WeaponType type) {
    super(name, damage, weight, type);
    this.magicDamage = magicDamage;
  }

  public int getMagicDamage() {
    return this.magicDamage;
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

package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class Sword extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @param name
   * @param damage
   * @param weight
   * @param type
   * @see WeaponType
   */
  public Sword(String name, int damage, int weight) {
    super(name, damage, weight, WeaponType.SWORD);
  }


  public void equipToKnight(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToThief(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToEngineer(IPlayerCharacter character){
  }

  public void equipToBlackMage(IPlayerCharacter character){

  }

  public void equipToWhiteMage(IPlayerCharacter character){
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Sword)) {
      return false;
    }
    final Sword weapon = (Sword) o;
    return getDamage() == weapon.getDamage() &&
            getWeight() == weapon.getWeight() &&
            getName() == weapon.getName();
  }
}

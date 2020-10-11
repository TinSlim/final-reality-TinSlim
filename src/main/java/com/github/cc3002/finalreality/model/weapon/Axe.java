package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class Axe extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @param name
   * @param damage
   * @param weight
   * @see WeaponType
   */
  public Axe(String name, int damage, int weight) {
    super(name, damage, weight, WeaponType.AXE);
  }


  public void equipToKnight(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToThief(IPlayerCharacter character){
  }

  public void equipToEngineer(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToBlackMage(IPlayerCharacter character){
  }

  public void equipToWhiteMage(IPlayerCharacter character){
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Axe)) {
      return false;
    }
    final Axe weapon = (Axe) o;
    return getDamage() == weapon.getDamage() &&
            getWeight() == weapon.getWeight() &&
            getName() == weapon.getName();
  }
}

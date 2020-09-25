package com.github.cc3002.finalreality.model.weapon;

public class Sword extends Weapon implements IKnightWeapon, IThiefWeapon {
  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @param name
   * @param damage
   * @param weight
   * @param type
   * @see WeaponType
   */
  public Sword(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }
}

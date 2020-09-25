package com.github.cc3002.finalreality.model.weapon;

public class Staff extends Weapon implements IThiefWeapon, IBlackMageWeapon, IWhiteMageWeapon {

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
}

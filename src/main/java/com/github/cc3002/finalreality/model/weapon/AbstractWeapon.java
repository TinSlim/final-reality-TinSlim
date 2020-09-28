package com.github.cc3002.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractWeapon implements IWeapon {

  private final String name;
  private final int damage;
  private final int weight;
  private final WeaponType type;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @see WeaponType
   */
  public AbstractWeapon(final String name, final int damage, final int weight,
                        final WeaponType type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }


  public String getName() {
    return name;
  }

  public int getDamage() {
    return damage;
  }

  public int getWeight() {
    return weight;
  }

  public WeaponType getType() {
    return type;
  }



  /** Todo This need to be deleted or something
   *       This was changed to receive an interface
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractWeapon)) {
      return false;
    }
    final AbstractWeapon abstractWeapon = (AbstractWeapon) o;
    return getDamage() == abstractWeapon.getDamage() &&
        getWeight() == abstractWeapon.getWeight() &&
        getName().equals(abstractWeapon.getName()) &&
        getType() == abstractWeapon.getType();
  }**/

   public boolean equals(final Object o) {
     if (this == o) {
       return true;
     }
     if (!(o instanceof IWeapon)) {
       return false;
     }
     final IWeapon abstractWeapon = (IWeapon) o;
     return getDamage() == abstractWeapon.getDamage() &&
     getWeight() == abstractWeapon.getWeight() &&
     getName().equals(abstractWeapon.getName()) &&
     getType() == abstractWeapon.getType();
   }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType());
  }
}

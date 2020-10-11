package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.util.Objects;

public class Staff extends AbstractWeapon implements IMageWeapons {

  private int magicDamage = 0;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @param name
   * @param damage
   * @param weight
   * @see WeaponType
   */
  public Staff(String name, int damage, int magicDamage, int weight) {
    super(name, damage, weight, WeaponType.STAFF);
    this.magicDamage = magicDamage;
  }

  public boolean castMagic(){
    return true;
  }

  public int getMagicDamage() {
    return this.magicDamage;
  }

  public void equipToKnight(IPlayerCharacter character){

  }

  public void equipToThief(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToEngineer(IPlayerCharacter character){

  }

  public void equipToBlackMage(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToWhiteMage(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Staff)) {
      return false;
    }
    final Staff weapon = (Staff) o;
    return getDamage() == weapon.getDamage() &&
            getWeight() == weapon.getWeight() &&
            getName() == weapon.getName() &&
            getMagicDamage() == weapon.getMagicDamage();
  }

  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType(),getMagicDamage());
  }

}

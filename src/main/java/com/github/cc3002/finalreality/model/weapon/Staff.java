package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.util.Objects;

public class Staff extends AbstractWeapon implements IMageWeapons {

  private int magicDamage = 0;

  /**
   * Creates a staff with a name, a base damage, magic damage and weight.
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

  @Override
  public boolean castMagic(){
    return true;
  }

  /**
   * Returns magic damage
   * @return magicDamage
   */
  public int getMagicDamage() {
    return this.magicDamage;
  }

  @Override
  public void equipToKnight(IPlayerCharacter character){

  }

  @Override
  public void equipToThief(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  @Override
  public void equipToEngineer(IPlayerCharacter character){

  }

  @Override
  public void equipToBlackMage(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  @Override
  public void equipToWhiteMage(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  @Override
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

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType(),getMagicDamage());
  }

}

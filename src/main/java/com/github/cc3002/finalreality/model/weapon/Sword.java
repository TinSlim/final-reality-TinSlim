package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class Sword extends AbstractWeapon {

  /**
   * Creates a sword with a name, a base damage and weight.
   *
   * @param name    the sword's name
   * @param damage  the sword's damage
   * @param weight  the sword's weight
   */
  public Sword(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  @Override
  public void equipToKnight(IPlayerCharacter character){
    character.setEquippedWeapon(this);
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
  }

  @Override
  public void equipToWhiteMage(IPlayerCharacter character){
  }

  @Override
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
            getName().equals(weapon.getName());
  }
}

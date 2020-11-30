package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class Knife extends AbstractWeapon {

  /**
   * Creates a knife with a name, a base damage and weight.
   *
   * @param name    the knife's name
   * @param damage  the knife's damage
   * @param weight  the knife's weight
   */
  public Knife(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  @Override
  public void equipToKnight(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  @Override
  public void equipToThief(IPlayerCharacter character){
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
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Knife)) {
      return false;
    }
    final Knife weapon = (Knife) o;
    return getDamage() == weapon.getDamage() &&
            getWeight() == weapon.getWeight() &&
            getName().equals(weapon.getName());
  }
}

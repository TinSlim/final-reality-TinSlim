package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class Bow extends AbstractWeapon {

  /**
   * Creates a bow with a name, a base damage and weight.
   *
   * @param name    the bows's name
   * @param damage  the bow's damage
   * @param weight  the bow's weight
   */
  public Bow(String name, int damage, int weight) {
    super(name, damage, weight);
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
    character.setEquippedWeapon(this);
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
    if (!(o instanceof Bow)) {
      return false;
    }
    final Bow weapon = (Bow) o;
    return getDamage() == weapon.getDamage() &&
            getWeight() == weapon.getWeight() &&
            getName().equals(weapon.getName());
  }
}

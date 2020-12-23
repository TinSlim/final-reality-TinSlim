package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;


/**
 * Class for Axe weapon.
 */
public class Axe extends AbstractWeapon {

  /**
   * Creates an axe with a name, a base damage and weight.
   *
   * @param name    the axe's name
   * @param damage  the axe's damage
   * @param weight  the axe's weight
   */
  public Axe(String name, int damage, int weight) {
    super(name, damage, weight);
    image = "src\\resources\\weapons\\axe.png";
  }

  @Override
  public void equipToKnight(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  @Override
  public void equipToEngineer(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  @Override
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
            getName().equals(weapon.getName());
  }
}

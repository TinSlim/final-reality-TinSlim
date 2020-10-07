package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class Bow extends AbstractWeapon {
  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @param name
   * @param damage
   * @param weight
   * @param type
   * @see WeaponType
   */
  public Bow(String name, int damage, int weight) {
    super(name, damage, weight, WeaponType.BOW);
  }

  public boolean castMagic(){
    return false;
  }

  public void equipToKnight(IPlayerCharacter character){

  }

  public void equipToThief(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToEngineer(IPlayerCharacter character){
    character.setEquippedWeapon(this);
  }

  public void equipToBlackMage(IPlayerCharacter character){
  }

  public void equipToWhiteMage(IPlayerCharacter character){
  }

}

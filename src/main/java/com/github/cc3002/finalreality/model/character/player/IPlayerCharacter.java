package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

public interface IPlayerCharacter {

  /**
   * Sets weapon to this character's equipped weapon, only if the character's class can use it.
   * @param weapon weapon to equip.
   */
  void equip(IWeapon weapon);

  /**
   * Returns this PlayerCharacter's equipped weapon.
   * @return  this PlayerCharacter's equipped weapon
   */
  IWeapon getEquippedWeapon();

  /**
   * Sets weapon to this character's equipped weapon.
   */
  void setEquippedWeapon(AbstractWeapon abstractWeapon);

  /**
   * Returns this PlayerCharacter's maxHp (max health points).
   * @return  this PlayerCharacter's maxHp
   */
  int getMaxHp();

  /**
   * This character receives addedHp Hp without without exceeding the maxHp
   * @param addedHp health points to receive.
   */
  void receiveLife(int addedHp);

  /**
   * Returns this PlayerCharacters's hp
   * @return  this PlayerCharacters's hp
   */
  int getHp();

  /**
   * Sets this PlayerCharacter's hp.
   * @param newHp new hp value to his character's hp.
   */
  void setHp(int newHp);

  /**
   * This PlayerCharacter receive damage, reducing their Hp, without passing the zero.
   * @param damage damage that this character receives.
   */
  void receiveDamage(int damage);

  /**
   * This PlayerCharacter deals damage to the testEnemyA using damage from the EquippedWeapon
   * @param testEnemyA target enemy that receives damage from this PlayerCharacter.
   */
  void commonAttack(Enemy testEnemyA);

  boolean isAlive();

  String getName();

}

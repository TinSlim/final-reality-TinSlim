package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractWeapon implements IWeapon {
  protected String image;

  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   */
  public AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public String getImage () {
    return image;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(),getClass());
  }

  @Override
  public void equipToKnight(IPlayerCharacter character){
  }

  @Override
  public void equipToThief(IPlayerCharacter character){
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
  public int getMagicDamage () {
    throw new AssertionError("No Magic Damage");
  }

  @Override
  public boolean castMagic () {
    return false;
  }
}

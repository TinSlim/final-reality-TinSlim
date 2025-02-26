package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Cristóbal Torres Gutiérrez
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter{

  private IWeapon equippedWeapon = null;

  /**
   * Creates a new character.
   *  @param turnsQueue     the queue with the characters waiting for their turn
   *  @param name           the character's name
   */
  public AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,@NotNull String name,
                                 final int maxHp,final int defense, String imageFile){
    super(turnsQueue, name, maxHp,defense, imageFile);
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public void receiveLife(int addedHp) {
    this.setHp(this.getHp() + addedHp);
    if (this.getHp() > this.getMaxHp()) {
      this.setHp(this.getMaxHp());
    }
  }

  @Override
  public void setEquippedWeapon(IWeapon weapon) {
    this.equippedWeapon = weapon;
  }

  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public void equip(IWeapon weapon) {
    if (this.isAlive()) {
      this.equipWeapon(weapon);
    }
  }

  /**
   * Calls with double dispatch the method of the weapon to equip to this player character.
   * @param weapon weapon that will be tried to equip.
   */
  protected abstract void equipWeapon(IWeapon weapon);

  @Override
  public void commonAttack(Enemy target) {
    if (target.isAlive()) {
      IWeapon weapon = this.getEquippedWeapon();
      int damage = weapon.getDamage();
      target.receiveDamage(damage);
      finishTurnListened.firePropertyChange("NextTurn",null,this);
    }

  }

  @Override
  public int getMana () {
    throw new AssertionError("No Mana");
  }

  @Override
  public int getMaxMana () {
    throw new AssertionError("No Mana");
  }

  @Override
  public void doPhase (Controller controller) {
    if (isAlive()) {
      controller.doPlayerPhase();
    } else {
      controller.endTurn();
    }
  }
}
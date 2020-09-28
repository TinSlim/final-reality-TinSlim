package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class PlayerCharacter extends AbstractCharacter implements IPlayerCharacter{
  //Todo rename the class to Abstract....
  private AbstractWeapon equippedAbstractWeapon = null;

  /**
   * Creates a new character.
   *
   * @param name           the character's name
   * @param turnsQueue     the queue with the characters waiting for their turn
   * @param characterClass the class of this character
   */
  public PlayerCharacter(@NotNull String name,
                         @NotNull BlockingQueue<ICharacter> turnsQueue,
                         final CharacterClass characterClass) {
    super(turnsQueue, name, characterClass);
  }

  @Override
  public void waitTurn() {
    //Todo delete print
    System.out.println(this.getName() + " esperando su turno \n");

    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor
            .schedule(this::addToQueue, equippedAbstractWeapon.getWeight() / 10, TimeUnit.SECONDS);

  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerCharacter)) {
      return false;
    }
    final PlayerCharacter that = (PlayerCharacter) o;
    return getCharacterClass() == that.getCharacterClass()
            && getName().equals(that.getName());
  }

  /**
   * Adds life to this Character without exceed the max Health Points.
   */
  public void receiveLife(int life) {
    this.setHp(this.getHp() + life);
    if (this.getHp() > this.getMaxHp()) {
      this.setHp(this.getMaxHp());
    }
  }

  @Override
  public void setEquippedWeapon(AbstractWeapon abstractWeapon) {
    this.equippedAbstractWeapon = abstractWeapon;
  }

  @Override
  public AbstractWeapon getEquippedWeapon() {
    return equippedAbstractWeapon;
  }

  @Override
  abstract public void equip(IWeapon weapon);

  @Override
  public void commonAttack(ICharacter target) {
    AbstractWeapon abstractWeapon = this.getEquippedWeapon();
    int damage = abstractWeapon.getDamage();
    target.receiveDamage(damage);
  }
}
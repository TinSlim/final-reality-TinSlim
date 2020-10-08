package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacter;
import com.github.cc3002.finalreality.model.character.Enemy;
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
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements IPlayerCharacter{
  //Todo rename the class to Abstract.... and to IWeapon
  private AbstractWeapon equippedAbstractWeapon = null;

  /**
   * Creates a new character.
   *  @param turnsQueue     the queue with the characters waiting for their turn
   * @param name           the character's name
   * @param characterClass the class of this character
   */
  public AbstractPlayerCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,@NotNull String name,
  CharacterClass characterClass, final int maxHp,final int defense){
    super(turnsQueue, name, characterClass,maxHp,defense);
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
    if (!(o instanceof AbstractPlayerCharacter)) {
      return false;
    }
    final AbstractPlayerCharacter that = (AbstractPlayerCharacter) o;
    return getCharacterClass() == that.getCharacterClass()
            && getName().equals(that.getName());
  }

  @Override
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
  public IWeapon getEquippedWeapon() {
    return equippedAbstractWeapon;
  }

  @Override
  abstract public void equip(IWeapon weapon);


  public void commonAttack(Enemy target) {
    IWeapon weapon = this.getEquippedWeapon();
    int damage = weapon.getDamage();
    target.receiveDamage(damage);
  }
}
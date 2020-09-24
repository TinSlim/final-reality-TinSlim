package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import com.github.cc3002.finalreality.model.character.player.PlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Cristóbal Torres Gutiérrez.
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  private final CharacterClass characterClass;
  private Weapon equippedWeapon = null;
  private ScheduledExecutorService scheduledExecutor;

  /**   Added
            **/
  private int maxHp;
  private int hp;


  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, CharacterClass characterClass) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;

    /*    Added     */
    this.maxHp = 100;
    this.hp = this.maxHp;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof PlayerCharacter) {
      scheduledExecutor
          .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    } else {
      var enemy = (Enemy) this;
      scheduledExecutor
          .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void equip(Weapon weapon) {
    if (this instanceof PlayerCharacter) {
      this.equippedWeapon = weapon;
    }
  }

  @Override
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public CharacterClass getCharacterClass() {
    return characterClass;
  }

  /*added*/

  public int getHp() {
      return this.hp;
  }

  public void setHp(int number) {
      this.hp = number;
  }

  public int getMaxHp() {
      return this.maxHp;
  }
  public void receiveDamage(int damage) {
      int actualHp = this.getHp();
      if (actualHp - damage <= 0) {
          this.setHp(0);
      } else {
          this.setHp(actualHp - damage);

      }
  }


  public void commonAttack(AbstractCharacter target) {
      Weapon weapon = this.getEquippedWeapon();
      int damage = weapon.getDamage();
      target.receiveDamage(damage);
  }
}

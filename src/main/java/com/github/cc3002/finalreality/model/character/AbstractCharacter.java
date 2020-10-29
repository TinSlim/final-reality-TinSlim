package com.github.cc3002.finalreality.model.character;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

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

  protected ScheduledExecutorService scheduledExecutor;
  private final int maxHp;
  private int hp;
  private final int defense;

  private boolean outOfCombat;

  /**
   * Creates a new Character
   * @param turnsQueue      the queue with the characters waiting for their turn
   * @param name            the character's name
   * @param maxHp           the character's max health points value
   * @param defense         the character's defense
   */
  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, final int maxHp, final int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.maxHp = maxHp;
    this.hp = maxHp;
    this.defense = defense;
    this.outOfCombat = false;
  }


  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }


  @Override
  public String getName() {
    return name;
  }


  @Override
  public int getHp() {
    return this.hp;
  }

  @Override
  public int getMaxHp() {
    return this.maxHp;
  }

  @Override
  public int getDefense(){
    return this.defense;
  }

  /**
   * Sets this character's Hp (health points).
   * @param newHp health points added to this character's hp.
   */
  public void setHp(int newHp) {
    this.hp = newHp;
  }

  @Override
  public void receiveDamage(int damage) {
    int realDamage = damage - this.getDefense();
    if (realDamage < 0) {
      realDamage = 0;
    }
    if ((this.getHp() - (realDamage)) <= 0) {
      this.setHp(0);
      this.faint();
    } else {
      this.setHp(this.getHp() - realDamage);
    }
  }

  public boolean isAlive() {
    return !outOfCombat;
  }

  public void faint() {
    this.outOfCombat = true;
  }
}

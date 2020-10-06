package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;

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
  private final CharacterClass characterClass;
  protected ScheduledExecutorService scheduledExecutor;
  private int maxHp;
  private int hp;
  private int defense;


  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name, CharacterClass characterClass, final int maxHp, final int defense) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.maxHp = maxHp;
    this.hp = maxHp;
    this.defense = defense;
  }



  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  public void setMaxHp(int i){
    this.maxHp = i;
  }
  @Override
  public String getName() {
    return name;
  }

  @Override
  public CharacterClass getCharacterClass() {
    return characterClass;
  }

  @Override
  public int getHp() {
    return this.hp;
  }

  @Override
  public int getMaxHp() {
    return this.maxHp;
  }

  /**
   * Sets this character's Hp (health points).
   */
  public void setHp(int number) {
    this.hp = number;
  }

  @Override
  public void receiveDamage(int damage) {
    if ((this.getHp() - damage) <= 0) {
      this.setHp(0);
    } else {
      this.setHp(this.getHp() - damage);
    }
  }
}

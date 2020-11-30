package com.github.cc3002.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author Cristóbal Torres Gutiérrez
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  private final int damage;

  private int burnDamage = 0;
  private int poisonDamage = 0;
  boolean paralyze = false;


  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   * @param turnsQueue        the queue with the characters waiting for their turn
   * @param name              the character's name
   * @param maxHp             the character's max health points value
   * @param weight            the character's weight
   * @param defense           the character's defense
   * @param damage            the character's damage
   */
  public Enemy(@NotNull BlockingQueue<ICharacter> turnsQueue,
               @NotNull String name, final int maxHp,
               final int weight,final int defense, final int damage){
    super(turnsQueue,name, maxHp,defense);
    this.weight = weight;
    this.damage = damage;
  }

  /**
   * Returns the weight of this enemy.
   * @return the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor
            .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getName().equals(enemy.getName()) && getWeight() == enemy.getWeight() &&
            getMaxHp() == enemy.getMaxHp() && getDamage() == enemy.getDamage() &&
            getDefense() == enemy.getDefense();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getClass(),getName(),getMaxHp(),getDefense(),getWeight(),getDamage());
  }

  /**
   * Gets this enemy's damage.
   * @return this enemy's damage.
   */
  public int getDamage() {
    return this.damage;
  }

  /**
   * Sets this enemy's burn damage (acquired when a mage uses fire attack).
   * @param newDamage burn damage from mage fire attack.
   */
  public void setBurnDamage(int newDamage) {
    this.burnDamage = newDamage;
  }

  /**
   * Returns this enemy's burn damage.
   * @return this enemy's burn damage.
   */
  public int getBurnDamage(){
    return this.burnDamage;
  }

  /**
   * Sets if this enemy is or not paralyzed.
   * @param value is or not paralyzed.
   */
  public void setParalyze(boolean value){
    this.paralyze = value;
  }

  /**
   * Returns if this enemy is or not paralyzed.
   * @return is or not paralyzed.
   */
  public boolean getParalyze(){
    return this.paralyze;
  }

  /**
   * This enemy do damage to target PlayerCharacter.
   * @param target PlayerCharacter that will receive damage.
   */
  public void commonAttack(IPlayerCharacter target) {
    if (target.isAlive()) {
      target.receiveDamage(this.getDamage());
    }
  }
  
  /**
   * Sets this enemy's poison damage (acquired when a mage uses venom attack).
   * @param damage Poison damage from mage venom attack.
   */
  public void setPoisonDamage(int damage) {
    this.poisonDamage = damage;
  }

  /**
   * Returns this enemy's poisonDamage.
   * @return this enemy's poisonDamage.
   */
  public int getPoisonDamage() {
    return this.poisonDamage;
  }

  /**
   * Applies venom and burn damage effect.
   */
  public void applyEffect() {
    this.receiveDamage(burnDamage);
    this.receiveDamage(poisonDamage);
  }

  /**
   * Applies paralyze state to this Enemy, making it not paralyzed for the next turn.
   */
  public void applyParalyze() {
    if (getParalyze()) {
      setParalyze(false);
    }
  }
}

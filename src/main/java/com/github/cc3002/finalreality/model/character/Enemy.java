package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <Your name>
 */
public class Enemy extends AbstractCharacter {

  private final int weight;


  private int burnDamage = 0;
  private int poisonDamage = 0;
  boolean paralyze = false;
  private int damage = 0;


  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull BlockingQueue<ICharacter> turnsQueue,
               @NotNull String name, final int maxHp,
               final int weight,final int defense){
    super(turnsQueue,name,CharacterClass.ENEMY,maxHp,defense);
    this.weight = weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public void waitTurn() {
    //Todo borrar print
    System.out.println(this.getName() + " esperando su turno \n");

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
    return getWeight() == enemy.getWeight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight());
  }

  /**
   * Gets this enemy's damage.
   */
  public int getDamage() {
    return this.damage;
  }

  /**
   * Sets this enemy's burn damage (acquired when a mage uses fire attack).
   */
  public void setBurnDamage(int newDamage) {
    this.burnDamage = newDamage;
  }

  public int getBurnDamage(){
    return this.burnDamage;
  }
  @Override
  public void commonAttack(ICharacter target) {
    target.receiveDamage(this.damage);
  }


  /**
   * Sets this enemy's poison damage (acquired when a mage uses venom attack).
   */
  public void setPoisonDamage(int damage) {
    this.poisonDamage = damage;
  }
}

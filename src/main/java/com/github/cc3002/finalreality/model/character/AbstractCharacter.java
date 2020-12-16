package com.github.cc3002.finalreality.model.character;

import java.beans.PropertyChangeSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import com.github.cc3002.finalreality.controller.listeners.FinishTurnListener;
import com.github.cc3002.finalreality.controller.listeners.IDeathHandler;
import com.github.cc3002.finalreality.controller.listeners.StartTurnListener;
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

  private final PropertyChangeSupport deathListened;
  private final PropertyChangeSupport startTurnListened;
  protected final PropertyChangeSupport finishTurnListened;

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

    this.deathListened = new PropertyChangeSupport(this);
    this.startTurnListened = new PropertyChangeSupport(this);
    this.finishTurnListened = new PropertyChangeSupport(this);
  }

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
    startTurnListened.firePropertyChange("TurnAllowed",null,this);
  }

  /**
   * Adds a death listener, used when this characters faint.
   * @param listener A death listener
   */
  public void addDeathListener(IDeathHandler listener) {
    deathListened.addPropertyChangeListener(listener);
  }

  /**
   * Adds a finish turn listener to this character, used when his turn finishes.
   * @param listener start turn listener.
   */
  public void addFinishTurnListener(FinishTurnListener listener) {
    finishTurnListened.addPropertyChangeListener(listener);
  }

  /**
   * Adds a start turn listener to this character, used when his turn can start.
   * @param listener start turn listener.
   */
  public void addStartTurnListener(StartTurnListener listener) {
    startTurnListened.addPropertyChangeListener(listener);
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
    if (realDamage <= 0) {
      return;
    }
    if ((this.getHp() - realDamage) <= 0) {
      this.setHp(0);
      this.faint();
    } else {
      this.setHp(this.getHp() - realDamage);
    }
  }

  /**
   * Returns the boolean value of is alive.
   * @return boolean value of is alive.
   */
  public boolean isAlive() {
    return !outOfCombat;
  }

  /**
   * This character becomes out of combat, reports it to the listener.
   */
  public void faint() {
    this.outOfCombat = true;
    deathListened.firePropertyChange("Fainted",null,this);
  }
}

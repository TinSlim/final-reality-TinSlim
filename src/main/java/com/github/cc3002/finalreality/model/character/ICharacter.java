package com.github.cc3002.finalreality.model.character;


import com.github.cc3002.finalreality.controller.Controller;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Cristóbal Torres Gutiérrez.
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   * @return this character's name.
   */
  String getName();

  /**
   * This character receives damage reducing the hp by damage.
   * @param damage damage received.
   */
  void receiveDamage(int damage);

  /**
   * Returns this character's hp (health points).
   * @return this character's hp (health points).
   */
  int getHp();

  /**
   * Returns this character's maxHp (max health points).
   * @return this character's maxHp (max health points).
   */
  int getMaxHp();

  /**
   * Returns this character's defense.
   * @return this character's defense.
   */
  int getDefense();

  /**
   * Calls a method of the controller to do this character movement, if this is an Enemy does
   * an automatized attack, else waits for user decision.
   * @param controller controller who wants the answer.
   */
  void doPhase(Controller controller);
}

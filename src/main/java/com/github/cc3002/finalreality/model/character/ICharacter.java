package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.CharacterClass;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's class.
   */
  CharacterClass getCharacterClass();

  /**
   * This character makes an attack to a target, dealing damage.
   * @param target
   */
  void commonAttack(ICharacter target);

  /**
   * This character receive damage reducing the hp b
   */
  void receiveDamage(int damage);

  /**
   * Returns this character's hp (health points).
   */
  int getHp();

  /**
   * Returns this character's maxHp (max health points).
   */
  int getMaxHp();

  void setMaxHp(int i);
}

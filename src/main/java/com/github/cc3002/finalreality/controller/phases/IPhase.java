package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * Interface for the phases.
 */
public interface IPhase {
  void setController(Controller controller);

  /**
   * Method called when a new character comes to the queue.
   */
  void newTurn();

  /**
   * Executes this phase.
   */
  void doPhase();

  /**
   * Sets a player character to this phase.
   *
   * @param actualCharacter player who is using the phase.
   */
  void setPlayerCharacter(IPlayerCharacter actualCharacter);

  /**
   * The enemy using this phase attacks.
   */
  void enemyAttack();

  /**
   * When the user wants to choose the right target.
   */
  void moveTargetRight();

  /**
   * When the user wants to choose the left target.
   */
  void moveTargetLeft();

  /**
   * The player character using this phase make a common attack to the pointed enemy.
   */
  void doAttack();


  /**
   * Equips the pointed weapon to the player character who is using this phase.
   */
  void equipWeapon();

  /**
   * Moves right the inventory pointer.
   */
  void moveRightInventory();

  /**
   * Moves up the inventory pointer.
   */
  void moveUpInventory();

  /**
   * Moves down the inventory pointer.
   */
  void moveDownInventory();


  /**
   * Moves left the inventory pointer.
   */
  void moveLeftInventory();

  int getAttackPointer();


  int getPlayerAttackingPointer();
}

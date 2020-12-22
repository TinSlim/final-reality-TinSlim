package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * Interface for the phases.
 */
public interface IPhase {

  /**
   * Sets the controller for this phase.
   * @param controller controller using this phase.
   */
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
   * @param actualCharacter player who is using the phase.
   */
  void setPlayerCharacter(IPlayerCharacter actualCharacter);

  /**
   * When the user wants to choose the right target, only does something in PlayerPhase.
   */
  void moveTargetRight();

  /**
   * When the user wants to choose the left target, only does something in PlayerPhase.
   */
  void moveTargetLeft();

  /**
   * The player character using this phase make a common attack to the pointed enemy, only does something
   * in PlayerPhase.
   */
  void doAttack();

  /**
   * Equips the pointed weapon to the player character who is using this phase, only does something in PlayerPhase.
   */
  void equipWeapon();

  /**
   * Moves right the inventory pointer, only does something in PlayerPhase.
   */
  void moveRightInventory();

  /**
   * Moves up the inventory pointer, only does something in PlayerPhase.
   */
  void moveUpInventory();

  /**
   * Moves down the inventory pointer, only does something in PlayerPhase.
   */
  void moveDownInventory();

  /**
   * Moves left the inventory pointer, only does something in PlayerPhase.
   */
  void moveLeftInventory();

  /**
   * Returns the user target index.
   * @return the user target index.
   */
  int getTargetPointer();
}

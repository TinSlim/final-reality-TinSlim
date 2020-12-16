package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * Interface for the phases.
 */
public interface IPhase {
  void setController(Controller controller);

  void newTurn();

  void doPhase();

  void setPlayerCharacter(IPlayerCharacter actualCharacter);

  void enemyAttack();

  void moveTargetRight();

  void moveTargetLeft();

  void doAttack();

  void moveRightInventory();

  void equipWeapon();

  void moveUpInventory();

  void moveDownInventory();

  void moveLeftInventory();
}

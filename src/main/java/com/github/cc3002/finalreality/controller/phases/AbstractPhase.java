package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * Class with common things and methods for all phases.
 */
public abstract class AbstractPhase implements IPhase {

  protected Controller controller;

  @Override
  public void setController (Controller controller) {
    this.controller = controller;
  }

  /**
   * Change the actual phase to newPhase
   * @param newPhase new phase.
   */
  public void changePhase (IPhase newPhase) {
    controller.setPhase(newPhase);
  }

  @Override
  public void newTurn () {
  }

  @Override
  public void doPhase() {
  }


  @Override
  public void doAttack() {
  }

  @Override
  public void moveTargetRight () {
  }

  @Override
  public void moveTargetLeft () {
  }

  @Override
  public void enemyAttack() {
  }

  @Override
  public void setPlayerCharacter(IPlayerCharacter actualCharacter) {
  }

  @Override
  public void moveRightInventory() {
  }

  @Override
  public void equipWeapon() {
  }

  @Override
  public void moveDownInventory () {
  }

  @Override
  public void moveUpInventory () {
  }

  @Override
  public void moveLeftInventory () {
  }

  @Override
  public int getAttackPointer () {
    return -10;
  }

  public int getPlayerAttackingPointer () {
    return 0;
  }
}

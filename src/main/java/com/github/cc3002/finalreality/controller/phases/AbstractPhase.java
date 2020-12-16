package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public abstract class Phase implements IPhase {


  protected Controller controller;

  public Phase () {

  }

  public void setController (Controller controller) {
    this.controller = controller;
  }
  
  public void changePhase (Phase phase) {
    controller.setPhase(phase);
  }


  public void newTurn () {
  }

  public void doPhase() {
  }

  /**
   * Called when a turn ends.
   */
  public void endTurn () {

  }

  public void doAttack() {
  }

  /**
   * When the user wants to choose the right target.
   */
  public void moveTargetRight () {
  }

  /**
   * When the user wants to choose the left target.
   */
  public void moveTargetLeft () {
  }

  public void doTurn() {
  }


  public void enemyAttack() {
  }

  public void setPlayerCharacter(IPlayerCharacter actualCharacter) {
  }

  public void moveRightInventory() {
  }

  public void equipWeapon() {

  }

  public void moveDownInventory () {

  }

  public void moveUpInventory() {
  }

  public void moveLeftInventory() {
  }
}

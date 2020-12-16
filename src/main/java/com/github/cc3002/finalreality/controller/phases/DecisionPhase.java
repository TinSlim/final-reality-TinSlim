package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * Phase to decide what to do, the turn is used by a character.
 */
public class DecisionPhase extends AbstractPhase {

  private int targetIndex;
  private IPlayerCharacter playerCharacter;

  /**
   * Stars a decision phase and sets 0 to the index o pointed enemy.
   */
  public DecisionPhase () {
    targetIndex = 0;
  }

  /**
   * Takes a character from the queue and looks what type is it to continue
   * the phase.
   */
  @Override
  public void doPhase () {
    controller.setCharacter(controller.getQueue().poll());
    controller.getCharacter().doPhase(controller);
  }

  /**
   * Sets a player character when is his phase.
   * @param character
   */
  @Override
  public void setPlayerCharacter (IPlayerCharacter character) {
    playerCharacter = character;
  }

  /**
   * The enemy do an automatic attack to a random player character.
   */
  @Override
  public void enemyAttack () {
    Enemy actualCharacter = (Enemy) controller.getCharacter();
    int targetIndex = controller.getRandom().nextInt(controller.getPlayersQuantity());
    IPlayerCharacter target = (IPlayerCharacter) controller.getPlayerCharacters().get(targetIndex);
    controller.enemyAttacks(actualCharacter,target);
  }

  /**
   * Moves the target pointer one to the right.
   */
  @Override
  public void moveTargetRight () {
    if (targetIndex + 1 < controller.getEnemiesQuantity()) {
      targetIndex += 1;
    }
  }

  /**
   * Moves the target pointer one to the left.
   */
  @Override
  public void moveTargetLeft () {
    if (targetIndex - 1 >= 0) {
      targetIndex -= 1;
    }
  }

  /**
   * The actual playerCharacter do an attack to the pointed target.
   */
  @Override
  public void doAttack ( ) {
    controller.playerCharacterCommonAttack(playerCharacter,controller.getEnemyCharacters().get(targetIndex));
  }

  /**
   * Moves down the inventory pointer.
   */
  @Override
  public void moveDownInventory () {
    controller.downMoveInventory();
  }

  /**
   * Moves up the target pointer one to the left.
   */
  @Override
  public void moveUpInventory () {
    controller.upMoveInventory();
  }

  /**
   * Moves right the target pointer one to the left.
   */
  @Override
  public void moveRightInventory () {
    controller.rightMoveInventory();
  }

  /**
   * Moves left the target pointer one to the left.
   */
  @Override
  public void moveLeftInventory () {
    controller.leftMoveInventory();
  }

  /**
   * Equips the pointed weapon to the actual player character.
   */
  @Override
  public void equipWeapon () {
    controller.equipWeaponTo(playerCharacter);
  }
}

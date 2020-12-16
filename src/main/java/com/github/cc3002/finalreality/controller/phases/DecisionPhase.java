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

  @Override
  public void doPhase () {
    controller.setCharacter(controller.getQueue().poll());
    controller.getCharacter().doPhase(controller);
  }

  @Override
  public void setPlayerCharacter (IPlayerCharacter character) {
    playerCharacter = character;
  }

  @Override
  public void enemyAttack () {
    Enemy actualCharacter = (Enemy) controller.getCharacter();
    int targetIndex = controller.getRandom().nextInt(controller.getPlayersQuantity());
    IPlayerCharacter target = controller.getPlayerCharacters().get(targetIndex);
    controller.enemyAttacks(actualCharacter,target);
  }

  @Override
  public void moveTargetRight () {
    if (targetIndex + 1 < controller.getEnemiesQuantity()) {
      targetIndex += 1;
    }
  }

  @Override
  public void moveTargetLeft () {
    if (targetIndex - 1 >= 0) {
      targetIndex -= 1;
    }
  }

  @Override
  public void doAttack ( ) {
    controller.playerCharacterCommonAttack(playerCharacter,controller.getEnemyCharacters().get(targetIndex));
  }

  @Override
  public void moveDownInventory () {
    controller.downMoveInventory();
  }

  @Override
  public void moveUpInventory () {
    controller.upMoveInventory();
  }

  @Override
  public void moveRightInventory () {
    controller.rightMoveInventory();
  }

  @Override
  public void moveLeftInventory () {
    controller.leftMoveInventory();
  }

  @Override
  public void equipWeapon () {
    controller.equipWeaponTo(playerCharacter);
  }
}

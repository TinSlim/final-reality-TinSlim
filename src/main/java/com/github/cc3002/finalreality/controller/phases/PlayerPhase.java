package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * The PlayerPhase, this phase is used to control the player character who is using the turn.
 */
public class PlayerPhase extends AbstractPhase {

  @Override
  public void moveTargetRight () {
    if (controller.getTargetIndex() + 1 < controller.getEnemiesQuantity()) {
      controller.addTargetIndex(1);
    }
  }

  @Override
  public void moveTargetLeft () {
    if (controller.getTargetIndex() - 1 >= 0) {
      controller.addTargetIndex(-1);
    }
  }

  @Override
  public void doAttack ( ) {
    controller.playerCharacterCommonAttack((IPlayerCharacter) controller.getCharacter(),
            controller.getEnemyCharacters().get(controller.getTargetIndex()));
  }

  @Override
  public void moveUpInventory () {
    controller.getInventory().movePoint(-controller.getInventoryLength());
  }

  @Override
  public void moveDownInventory () {
    controller.getInventory().movePoint(controller.getInventoryLength());
  }

  @Override
  public void moveRightInventory () {
    controller.getInventory().movePoint(1);
  }

  @Override
  public void moveLeftInventory () {
    controller.getInventory().movePoint(-1);
  }

  @Override
  public void equipWeapon () {
    controller.equipWeaponTo((IPlayerCharacter) controller.getCharacter());
  }

  @Override
  public int getTargetPointer() {
    return controller.getTargetIndex();
  }

}

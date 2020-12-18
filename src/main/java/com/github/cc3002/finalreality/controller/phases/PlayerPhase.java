package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class PlayerPhase extends AbstractPhase {
  int targetIndex;

  public PlayerPhase () {
    targetIndex = 0;
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
    controller.playerCharacterCommonAttack((IPlayerCharacter) controller.getCharacter(),controller.getEnemyCharacters().get(targetIndex));
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
  public int getAttackPointer () {
    return targetIndex;
  }
}

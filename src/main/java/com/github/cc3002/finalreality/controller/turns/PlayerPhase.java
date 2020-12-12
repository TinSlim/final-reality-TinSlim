package com.github.cc3002.finalreality.controller.turns;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class PlayerPhase extends Phase {
  int targetIndex;
  IPlayerCharacter playerCharacter;

  public PlayerPhase () {
    playerCharacter = (IPlayerCharacter) actualCharacter;
    targetIndex = 0;
  }

  public void moveTargetRight () {
    if (targetIndex + 1 < controller.getEnemiesAlive()) {
      targetIndex += 1;
    }
  }

  public void moveTargetLeft () {
    if (targetIndex - 1 < 0) {
      targetIndex -= 1;
    }
  }

  public void commonAttack ( ) {
    controller.playerCharacterCommonAttack(playerCharacter,controller.getEnemyCharacters().get(targetIndex));
  }

  public void moveDownInventory () {
    controller.downMoveInventory();
  }

  public void moveUpInventory () {
    controller.upMoveInventory();
  }

  public void moveRightInventory () {
    controller.rightMoveInventory();
  }

  public void moveLeftInventory () {
    controller.leftMoveInventory();
  }

  public void equipWeapon () {
    controller.equipWeaponTo(playerCharacter);
  }
}

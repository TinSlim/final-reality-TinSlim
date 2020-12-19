package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.phases.IPhase;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

public class EnemyPhase extends AbstractPhase {

  public void doPhase( ) {
    Enemy actualCharacter = (Enemy) controller.getCharacter();
    int targetIndex = controller.getRandom().nextInt(controller.getPlayersQuantity());
    IPlayerCharacter target = controller.getPlayerCharacters().get(targetIndex);
    controller.enemyAttacks(actualCharacter,target);
  }
}

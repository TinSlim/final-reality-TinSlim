package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

/**
 * The enemy phase, this phase is used to do the enemy automatic attack.
 */
public class EnemyPhase extends AbstractPhase {

  /**
   * Executes this phase, the character attacks a random player character.
   */
  public void doPhase( ) {
    Enemy actualCharacter = (Enemy) controller.getCharacter();
    int targetIndex = controller.getRandom().nextInt(controller.getPlayersQuantity());
    IPlayerCharacter target = controller.getPlayerCharacters().get(targetIndex);
    controller.enemyAttacks(actualCharacter,target);
  }
}

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
  public void enemyAttack () {
    Enemy actualCharacter = (Enemy) controller.getCharacter();
    int targetIndex = controller.getRandom().nextInt(controller.getPlayersQuantity());
    IPlayerCharacter target = controller.getPlayerCharacters().get(targetIndex);
    controller.enemyAttacks(actualCharacter,target);
  }


}

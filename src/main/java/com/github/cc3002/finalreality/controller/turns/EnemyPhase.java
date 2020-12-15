package com.github.cc3002.finalreality.controller.turns;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.util.Random;

public class EnemyPhase extends Phase {
  private Random r;

  public EnemyPhase() {
    r = new Random();
    doAttack();
  }

  public void doAttack () {
    Enemy actualCharacter = (Enemy) controller.getCharacter();
    if (actualCharacter.isAlive()) {
      int targetIndex = r.nextInt(controller.getPlayersAlive());
      IPlayerCharacter target = (IPlayerCharacter) controller.getAlivePlayerCharacters().get(targetIndex);
      controller.enemyAttacks(actualCharacter,target);
    }
    changePhase(new WaitingPhase());
  }
}

package com.github.cc3002.finalreality.controller.turns;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.util.Random;

public class EnemyPhase extends Phase {
  private Random r;

  public EnemyPhase () {
    r = new Random();
    randomAttack();
    changePhase(new WaitingPhase());
  }

  public void randomAttack () {
    if (actualCharacter.isAlive()) {
      int targetIndex = r.nextInt(controller.getPlayersAlive());
      IPlayerCharacter target = (IPlayerCharacter) controller.getAlivePlayerCharacters().get(targetIndex);
      controller.enemyAttacks((Enemy) actualCharacter,target);
      actualCharacter.waitTurn();
    }
  }
}

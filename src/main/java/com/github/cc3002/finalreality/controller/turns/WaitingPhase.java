package com.github.cc3002.finalreality.controller.turns;


public class WaitingPhase extends Phase {

  public WaitingPhase() {
    useTurnIfAvaible();
  }

  public void useTurnIfAvaible () {
    if (controller.getWaitingCharacters() > 0) {
      newTurn();
    }
  }

  public void newTurn() {
    actualCharacter = controller.getQueue().poll();
    controller.changeWaitingCharacters(-1);
    actualCharacter.doPhase(this);
  }

  public void goToPlayerPhase() {
    changePhase(new PlayerPhase());
  }

  public void goToEnemyPhase() {
    changePhase(new EnemyPhase());
  }
}

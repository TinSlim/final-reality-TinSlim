package com.github.cc3002.finalreality.controller.turns;

public class WaitingPhase extends Phase {

  public void newTurn() {
    changePhase(new DecisionPhase());
  }
}

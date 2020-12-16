package com.github.cc3002.finalreality.controller.phases;

public class WaitingPhase extends AbstractPhase {

  /**
   * Start a new turn, changing to decision phase.
   */
  @Override
  public void newTurn() {
    changePhase(new DecisionPhase());
  }
}

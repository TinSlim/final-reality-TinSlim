package com.github.cc3002.finalreality.controller.phases;

/**
 * Phase that waits for a new character to start a turn.
 */
public class WaitingPhase extends AbstractPhase {

  /**
   * Starts a new turn, changing to decision phase.
   */
  @Override
  public void newTurn() {
    changePhase(new DecisionPhase());
  }
}

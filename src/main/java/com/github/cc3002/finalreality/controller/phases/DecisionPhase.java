package com.github.cc3002.finalreality.controller.phases;

/**
 * Phase to decide what to do, the turn is used by a character.
 */
public class DecisionPhase extends AbstractPhase {

  /**
   * Executes this phase, taking a character to continue his phase.
   */
  @Override
  public void doPhase () {
    controller.setCharacter(controller.getQueue().poll());
    controller.setPosition(controller.getCharacter().getPosition());
    controller.getCharacter().doPhase(controller);
  }
}

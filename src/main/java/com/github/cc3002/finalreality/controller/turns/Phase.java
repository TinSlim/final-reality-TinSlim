package com.github.cc3002.finalreality.controller.turns;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.ICharacter;

public abstract class Phase {


  protected Controller controller;

  public Phase () {

  }

  public void setController (Controller controller) {
    this.controller = controller;
  }
  
  public void changePhase (Phase phase) {
    controller.setPhase(phase);
  }

  public void newTurn () {
  }

  public void endTurn () {
    if (controller.getQueue().size() > 0) {
      changePhase(new WaitingPhase());
    }
  }

  public void doAttack() {
  }
}

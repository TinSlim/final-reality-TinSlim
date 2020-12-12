package com.github.cc3002.finalreality.controller.turns;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.ICharacter;

public class Phase {

  protected ICharacter actualCharacter;
  protected Controller controller;

  public Phase () {
  }

  public void setController (Controller controller) {
    this.controller = controller;
  }
  
  public void changePhase (Phase phase) {
    controller.setPhase(phase);
  }

  public void setActualCharacter(ICharacter actualCharacter) {
    this.actualCharacter = actualCharacter;
  }

  public void newTurn () {
    controller.changeWaitingCharacters(1);
  }

  public void endTurn () {
    changePhase(new WaitingPhase());
  }
}

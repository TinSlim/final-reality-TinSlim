package com.github.cc3002.finalreality.controller.listeners;

import com.github.cc3002.finalreality.controller.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Observes if a character is added to the turnsQueue, if this happens execute the method propertyChange.
 */
public class StartTurnListener implements PropertyChangeListener {
  Controller controller;

  /**
   * Takes de controller input and make it his controller.
   * @param controller controller that has this observer.
   */
  public StartTurnListener(Controller controller) {
    this.controller = controller;
  }

  /**
   * Calls the method newCharacterAddedToQueue from the controller.
   * @param evt the event with the character who entered to the queue.
   */
  public void propertyChange(PropertyChangeEvent evt) {
    controller.startNewTurn();
  }
}

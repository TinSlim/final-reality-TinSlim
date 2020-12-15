package com.github.cc3002.finalreality.controller.listeners;

import com.github.cc3002.finalreality.controller.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Observes if a character receives damage, if this happens execute the method propertyChange.
 */
public class FinishTurnListener implements PropertyChangeListener {
  Controller controller;

  /**
   * Takes de controller input and make it his controller.
   * @param controller controller that has this observer.
   */
  public FinishTurnListener(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.endTurn();
  }
}

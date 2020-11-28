package com.github.cc3002.finalreality.controller.listeners;

import com.github.cc3002.finalreality.controller.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StartTurnListener implements PropertyChangeListener {
  Controller controller;

  public StartTurnListener(Controller controller) {
    this.controller = controller;
  }

  public void propertyChange(PropertyChangeEvent evt) {
    controller.waitingTurn();
  }
}

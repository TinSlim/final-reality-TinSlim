package com.github.cc3002.finalreality.controller.listeners;

import com.github.cc3002.finalreality.controller.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FinishTurnListener implements PropertyChangeListener {
  Controller controller;

  public FinishTurnListener(Controller controller) {
    this.controller = controller;
  }


  public void propertyChange(PropertyChangeEvent evt) {
    controller.turnToAvailable();
  }
}

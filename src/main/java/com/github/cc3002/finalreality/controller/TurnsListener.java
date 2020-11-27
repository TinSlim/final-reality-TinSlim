package com.github.cc3002.finalreality.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TurnsListener implements PropertyChangeListener {
  Controller controller;

  public TurnsListener (Controller controller) {
    this.controller = controller;
  }
  public void propertyChange(PropertyChangeEvent evt) {
    controller.nextTurn ();
  }
}

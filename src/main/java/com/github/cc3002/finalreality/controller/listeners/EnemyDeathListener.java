package com.github.cc3002.finalreality.controller.listeners;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Observes if an Enemy dies, if this happens execute the method propertyChange.
 */
public class EnemyDeathListener implements PropertyChangeListener {
  Controller controller;

  /**
   * Takes de controller input and make it his controller.
   * @param controller controller that has this observer.
   */
  public EnemyDeathListener(Controller controller) {
    this.controller = controller;
  }

  /**
   * Reduce by 1 the quantity of enemies and looks if the user wins.
   * @param evt the event with the character who died.
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.changeEnemyQuantity(-1);
    if (controller.getEnemiesAlive() <= 0) {
      controller.win();
    }
  }
}

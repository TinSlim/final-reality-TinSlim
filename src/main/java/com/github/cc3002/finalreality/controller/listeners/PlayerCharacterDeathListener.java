package com.github.cc3002.finalreality.controller.listeners;

import com.github.cc3002.finalreality.controller.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Observes if a PlayerCharacter dies, if this happens execute the method propertyChange.
 */
public class PlayerCharacterDeathListener implements IDeathHandler {
  Controller controller;

  /**
   * Takes de controller input and make it his controller.
   * @param controller controller that has this observer.
   */
  public PlayerCharacterDeathListener(Controller controller) {
    this.controller = controller;
  }

  /**
   * Reduce by 1 the quantity of player characters and looks if the user user.
   * @param evt the event with the character who died.
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.changePlayersQuantity(-1);
    if (controller.getPlayersAlive() <= 0) {
      controller.lose();
    }
  }
}

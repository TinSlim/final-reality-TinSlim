package com.github.cc3002.finalreality.controller.listeners;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerCharacterDeathListener implements PropertyChangeListener {
  Controller controller;

  public PlayerCharacterDeathListener(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.changePlayersQuantity(-1);
    if (controller.getPlayersAlive() <= 0) {
      controller.lose();
    }
  }
}

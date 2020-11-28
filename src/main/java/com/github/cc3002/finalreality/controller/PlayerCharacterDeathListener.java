package com.github.cc3002.finalreality.controller;

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
    IPlayerCharacter faintedCharacter = (IPlayerCharacter) evt.getNewValue();
    controller.changePlayersQuantity(-1);
    if (controller.getPlayersAlive() <= 0) {
      controller.lose();
    }
  }
}

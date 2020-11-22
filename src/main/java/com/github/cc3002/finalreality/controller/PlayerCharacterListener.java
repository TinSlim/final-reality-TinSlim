package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerCharacterListener implements PropertyChangeListener {
  Controller controller;

  public PlayerCharacterListener (Controller controller) {
    this.controller = controller;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    IPlayerCharacter faintedCharacter = (IPlayerCharacter) evt.getNewValue();
    controller.changePlayersQuantity(-1);
    controller.getFaintedPlayerCharacters().put(faintedCharacter.getName(),faintedCharacter);
    controller.getAlivePlayerCharacters().remove(faintedCharacter);
    if (controller.getPlayersAlive() <= 0) {
      controller.loss();
    }
  }
}

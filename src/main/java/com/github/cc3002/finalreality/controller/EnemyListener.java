package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EnemyListener implements PropertyChangeListener {
  Controller controller;

  public EnemyListener(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    Enemy faintedCharacter = (Enemy) evt.getNewValue();
    controller.changeEnemyQuantity(-1);
    controller.getEnemyCharacters().remove(faintedCharacter);
    if (controller.getEnemiesAlive() <= 0) {
      controller.win();
    }
  }
}
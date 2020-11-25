package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.controller.Controller;

public abstract class CharacterMaker {
  Controller controller;
  int maxHp;
  int defense;

  public void setController (Controller controller) {
    this.controller = controller;
  }

  protected void changeMaker(CharacterMaker maker) {
    controller.setCharacterMaker(maker);
  }

  public void error() {
    throw new AssertionError("Invalid Character Maker");
  }

  public abstract void makeCharacter(String name);

  public void changeRight () {
    error();
  }

  public void changeLeft () {
    error();
  }

  protected Controller getController() {
    return controller;
  }

  public void changeToEnemy() {
    this.changeMaker(new EnemyMaker());
  }
}

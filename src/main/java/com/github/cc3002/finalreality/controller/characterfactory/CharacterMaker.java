package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.controller.Controller;

public class CharacterMaker {
  Controller controller;
  int maxHp;
  int defense;

  public void setController (Controller controller) {
    this.controller = controller;
  }

  protected void changeState(CharacterMaker maker) {
    controller.setCharacterMaker(maker);
  }

  public void error() {

  }

  public void makeCharacter(String name) {
    error();
  }

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
    this.changeState(new EnemyMaker());
  }
}

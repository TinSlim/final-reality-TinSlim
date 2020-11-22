package com.github.cc3002.finalreality.controller;

public class CharacterMaker {
  Controller controller;
  int maxHp;
  int defense;

  public void setController (Controller controller) {
    this.controller = controller;
  }

  protected void changeState(CharacterMaker maker) {
    controller.setMaker(maker);
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

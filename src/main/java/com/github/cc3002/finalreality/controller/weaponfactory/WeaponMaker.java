package com.github.cc3002.finalreality.controller.weaponfactory;


import com.github.cc3002.finalreality.controller.Controller;

public class WeaponMaker {
  Controller controller;
  int weight;
  int damage;

  public void setController (Controller controller) {
    this.controller = controller;
  }

  protected void changeState(WeaponMaker maker) {
    controller.setWeaponMaker(maker);
  }

  public void error() {
  }

  public void makeWeapon(String name) {
    error();
  }

  public void changeToSword () {
    this.changeState(new SwordMaker());
  }

  public void changeToKnife () {
    this.changeState(new KnifeMaker());
  }

  public void changeToBow () {
    this.changeState(new BowMaker());
  }

  public void changeToAxe () {
    this.changeState(new AxeMaker());
  }

  public void changeToStaff () {
    this.changeState(new StaffMaker());
  }

  protected Controller getController() {
    return controller;
  }


}

package com.github.cc3002.finalreality.controller.weaponfactory;

import com.github.cc3002.finalreality.model.weapon.Axe;

public class AxeMaker extends WeaponMaker {

  public void makeWeapon (String name) {
    Axe weapon = new Axe(name,damage,weight);
    controller.getInventory().addToInventory(weapon);
  }
}

package com.github.cc3002.finalreality.controller.weaponfactory;

import com.github.cc3002.finalreality.model.weapon.Bow;

public class BowMaker extends WeaponMaker {

  public void makeWeapon (String name) {
    Bow weapon = new Bow(name,damage,weight);
    controller.getInventory().addToInventory(weapon);
  }
}

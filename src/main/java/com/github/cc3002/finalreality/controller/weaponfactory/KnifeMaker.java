package com.github.cc3002.finalreality.controller.weaponfactory;

import com.github.cc3002.finalreality.model.weapon.Knife;

public class KnifeMaker extends WeaponMaker {

  public void makeWeapon (String name) {
    Knife weapon = new Knife(name,damage,weight);
    controller.getInventory().addToInventory(weapon);
  }
}

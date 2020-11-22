package com.github.cc3002.finalreality.controller.weaponfactory;

import com.github.cc3002.finalreality.model.weapon.Sword;

public class SwordMaker extends WeaponMaker {

  public void makeWeapon (String name) {
    Sword weapon = new Sword(name,damage,weight);
    controller.getInventory().addToInventory(weapon);
  }

}

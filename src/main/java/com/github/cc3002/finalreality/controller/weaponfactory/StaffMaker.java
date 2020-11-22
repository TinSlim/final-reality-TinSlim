package com.github.cc3002.finalreality.controller.weaponfactory;

import com.github.cc3002.finalreality.model.weapon.Staff;

public class StaffMaker extends WeaponMaker {

  int magicDamage = 100;

  public StaffMaker () {
    magicDamage = 100;
  }
  public void makeWeapon (String name) {
    Staff weapon = new Staff(name, damage, magicDamage,weight);
    controller.getInventory().addToInventory(weapon);
  }
}

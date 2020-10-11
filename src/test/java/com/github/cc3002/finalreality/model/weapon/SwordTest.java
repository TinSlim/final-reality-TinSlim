package com.github.cc3002.finalreality.model.weapon;

public class SwordTest extends AbstractWeaponTest{

  public void setWeapons() {
    testWeaponA = new Sword("TestSwordA",50,42);
    testWeaponB = new Sword("TestSwordB",3,414);
    testWeaponC = new Knife("TestSwordA",50,42);
    testWeaponD = new Sword("TestSwordA",50,42);

    testWeaponFName = new Sword("TestSwordName",50,42);
    testWeaponFDamageA = new Sword("TestSwordA",1,42);
    testWeaponFDamageB = new Sword("TestSwordA",200,42);
    testWeaponFWeight = new Sword("TestSwordA",50,1);
  }
}

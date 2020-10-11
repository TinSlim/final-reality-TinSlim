package com.github.cc3002.finalreality.model.weapon;

public class BowTest extends AbstractWeaponTest{

  public void setWeapons() {
    testWeaponA = new Bow("TestBowA",50,42);
    testWeaponB = new Bow("TestBowB",50,42);
    testWeaponC = new Sword("TestBowA",50,42);
    testWeaponD = new Bow("TestBowA",50,42);

    testWeaponFName = new Bow("TestBowName",50,42);
    testWeaponFDamageA = new Bow("TestBowA",1,42);
    testWeaponFDamageB = new Bow("TestBowA",200,42);
    testWeaponFWeight = new Bow("TestBowA",50,1);
  }
}

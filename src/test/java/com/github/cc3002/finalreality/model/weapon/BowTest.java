package com.github.cc3002.finalreality.model.weapon;

public class BowTest extends AbstractWeaponTest {

  public void setWeapons() {
    testWeaponA = new Bow("TestBowA",50,42);
    testWeaponB = new Bow("TestBowB",50,42);
    testWeaponC = new Sword("TestBowA",50,42);
    testWeaponD = new Bow("TestBowA",50,42);

    testWeaponF1 = new Bow("TestBowName",50,42);
    testWeaponF2 = new Bow("TestBowA",1,42);
    testWeaponF3 = new Bow("TestBowA",200,42);
    testWeaponF4 = new Bow("TestBowA",50,1);
  }
}

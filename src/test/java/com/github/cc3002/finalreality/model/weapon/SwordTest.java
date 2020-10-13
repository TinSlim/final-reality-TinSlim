package com.github.cc3002.finalreality.model.weapon;

/**
 * Contains set up to test methods with Sword.
 */
public class SwordTest extends AbstractWeaponTest {

  public void setWeapons() {
    testWeaponA = new Sword("TestSwordA",50,42);
    testWeaponB = new Sword("TestSwordB",3,414);
    testWeaponC = new Knife("TestSwordA",50,42);
    testWeaponD = new Sword("TestSwordA",50,42);

    testWeaponF1 = new Sword("TestSwordName",50,42);
    testWeaponF2 = new Sword("TestSwordA",1,42);
    testWeaponF3 = new Sword("TestSwordA",200,42);
    testWeaponF4 = new Sword("TestSwordA",50,1);
  }
}

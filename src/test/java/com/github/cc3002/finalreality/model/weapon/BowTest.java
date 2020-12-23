package com.github.cc3002.finalreality.model.weapon;

/**
 * Contains set up to test methods with Bow.
 */
public class BowTest extends AbstractWeaponTest {

  @Override
  public void setWeapons() {
    testWeaponA = new Bow("TestBowA",50,42);
    testWeaponB = new Bow("TestBowB",50,42);
    testWeaponC = new Sword("TestBowA",50,42);
    testWeaponD = new Bow("TestBowA",50,42);

    testWeaponF1 = new Bow("TestBowName",50,42);
    testWeaponF2 = new Bow("TestBowA",1,42);
    testWeaponF3 = new Bow("TestBowA",200,42);
    testWeaponF4 = new Bow("TestBowA",50,1);

    imgFileName = "src\\resources\\weapons\\bow.png";
  }
}

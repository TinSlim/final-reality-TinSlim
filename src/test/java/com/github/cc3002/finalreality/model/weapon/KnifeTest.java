package com.github.cc3002.finalreality.model.weapon;

public class KnifeTest extends AbstractWeaponTest {

  public void setWeapons() {
    testWeaponA = new Knife("TestKnifeA",50,42);
    testWeaponB = new Knife("TestKnifeB",50,42);
    testWeaponC = new Bow("TestKnifeA",50,42);
    testWeaponD = new Knife("TestKnifeA",50,42);

    testWeaponF1 = new Knife("TestKnifeName",50,42);
    testWeaponF2 = new Knife("TestKnifeA",1,42);
    testWeaponF3 = new Knife("TestKnifeA",200,42);
    testWeaponF4 = new Knife("TestKnifeA",50,1);
  }
}

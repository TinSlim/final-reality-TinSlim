package com.github.cc3002.finalreality.model.weapon;

public class KnifeTest extends AbstractWeaponTest{

  public void setWeapons() {
    testWeaponA = new Knife("TestKnifeA",50,42);
    testWeaponB = new Knife("TestKnifeB",50,42);
    testWeaponC = new Bow("TestKnifeA",50,42);
    testWeaponD = new Knife("TestKnifeA",50,42);

    testWeaponFName = new Knife("TestKnifeName",50,42);
    testWeaponFDamageA = new Knife("TestKnifeA",1,42);
    testWeaponFDamageB = new Knife("TestKnifeA",200,42);
    testWeaponFWeight = new Knife("TestKnifeA",50,1);
  }
}

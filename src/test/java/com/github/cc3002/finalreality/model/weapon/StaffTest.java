package com.github.cc3002.finalreality.model.weapon;

public class StaffTest extends AbstractWeaponTest{

  public void setWeapons() {
    testWeaponA = new Staff("TestStaffA",50,42,20);
    testWeaponB = new Staff("TestStaffB",50,42,20);
    testWeaponC = new Sword("TestStaffA",50,42);
    testWeaponD = new Staff("TestStaffA",50,42,20);

    testWeaponF1 = new Staff("TestStaffName",50,42,20);
    testWeaponF2 = new Staff("TestStaffA",1,42,20);
    testWeaponF3 = new Staff("TestStaffA",50,1,20);
    testWeaponF4 = new Staff("TestStaffA",50,42,1);
  }
}

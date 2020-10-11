package com.github.cc3002.finalreality.model.weapon;

public class AxeTest extends AbstractWeaponTest{

  public void setWeapons() {
    testWeaponA = new Axe("TestAxeA",50,42);
    testWeaponB = new Axe("TestAxeB",50,42);
    testWeaponC = new Staff("TestAxeA",50,42,42);
    testWeaponD = new Axe("TestAxeA",50,42);

    testWeaponFName = new Axe("TestAxeName",50,42);
    testWeaponFDamageA = new Axe("TestAxeA",1,42);
    testWeaponFDamageB = new Axe("TestAxeA",200,1);
    testWeaponFWeight = new Axe("TestAxeA",50,1);
  }
}

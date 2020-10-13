package com.github.cc3002.finalreality.model.weapon;

/**
 * Contains set up to test methods with Axe.
 */
public class AxeTest extends AbstractWeaponTest {

  public void setWeapons() {
    testWeaponA = new Axe("TestAxeA",50,42);
    testWeaponB = new Axe("TestAxeB",50,42);
    testWeaponC = new Staff("TestAxeA",50,42,42);
    testWeaponD = new Axe("TestAxeA",50,42);

    testWeaponF1 = new Axe("TestAxeName",50,42);
    testWeaponF2 = new Axe("TestAxeA",1,42);
    testWeaponF3 = new Axe("TestAxeA",200,1);
    testWeaponF4 = new Axe("TestAxeA",50,1);
  }
}

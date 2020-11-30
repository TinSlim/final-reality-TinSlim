package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains set up to test methods with Staff.
 */
public class StaffTest extends AbstractWeaponTest {

  @Override
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

  @Override
  @Test
  public void testGetMagicDamage () {
    assertEquals(42,testWeaponA.getMagicDamage());
  }

  @Override
  @Test
  public void testCastMagic () {
    assertTrue(testWeaponA.castMagic());
  }
}

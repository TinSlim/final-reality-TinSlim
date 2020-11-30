package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public abstract class AbstractMageCharacterTest extends AbstractPlayerCharacterTest {

  public IPlayerCharacter testMageA;
  public IPlayerCharacter testMageB;
  public IPlayerCharacter testMageC;


  protected IWeapon testWeaponStaffA = new Staff("TestStaffA",0,30,90);
  protected IWeapon testWeaponStaffB = new Staff("TestStaffB",0,10,90);
  protected IWeapon testWeaponStaffC = new Staff("TestStaffC",0,0,90);

  protected IPlayerCharacter testMaxManaMageA;
  protected IPlayerCharacter testMaxManaMageB;
  protected IPlayerCharacter testMaxManaMageC;

  /**
   * Tests the getMaxmana method.
   */
  @Test
  public void testGetMaxMana(){
    assertEquals(100,testMaxManaMageA.getMaxMana());
    assertEquals(15,testMaxManaMageB.getMaxMana());
    assertEquals(0,testMaxManaMageC.getMaxMana());
  }
}

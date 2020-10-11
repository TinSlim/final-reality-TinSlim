package com.github.cc3002.finalreality.model.weapon;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public abstract class AbstractWeaponTest {
  IWeapon testWeaponA;
  IWeapon testWeaponB;
  IWeapon testWeaponC;
  IWeapon testWeaponD;

  IWeapon testWeaponFName;
  IWeapon testWeaponFDamageA;
  IWeapon testWeaponFDamageB;
  IWeapon testWeaponFWeight;

  @BeforeEach
  public void setUp(){
    this.setWeapons();

  }

  @Test
  public void testEquals(){
    assertEquals(testWeaponA,testWeaponA);
    assertNotEquals(testWeaponA,testWeaponB);
    assertNotEquals(testWeaponA,testWeaponC);
    assertEquals(testWeaponA,testWeaponD);

    assertNotEquals(testWeaponA,testWeaponFName);
    assertNotEquals(testWeaponA,testWeaponFDamageA);
    assertNotEquals(testWeaponA,testWeaponFDamageB);
    assertNotEquals(testWeaponA,testWeaponFWeight);
  }

  @Test
  public void testHash(){
    assertEquals(testWeaponA.hashCode(),testWeaponA.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponB.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponC.hashCode());
    assertEquals(testWeaponA.hashCode(),testWeaponD.hashCode());

    assertNotEquals(testWeaponA.hashCode(),testWeaponFName.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponFDamageA.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponFDamageB.hashCode());
    assertNotEquals(testWeaponA.hashCode(),testWeaponFWeight.hashCode());
  }

  protected abstract void setWeapons();
}

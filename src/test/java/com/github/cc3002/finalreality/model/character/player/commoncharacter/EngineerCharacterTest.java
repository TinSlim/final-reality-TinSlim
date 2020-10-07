package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacterTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EngineerCharacterTest extends AbstractCommonCharacterTest {

  public void setTestCharacter(){
    testCharacterA = new EngineerCharacter(turnsQueue,"EngineerA",100,100);
    testCharacterB = new EngineerCharacter(turnsQueue,"EngineerB",50,50);
    testCharacterC = new EngineerCharacter(turnsQueue,"EngineerC",0,0);
    testCharacterD = new EngineerCharacter(turnsQueue,"EngineerD",-10,-10);
    testPlayerCharacter = new EngineerCharacter(turnsQueue,"EngineerE",100,100);
  }



  public void testEquipWeapons() {
    testPlayerCharacter.equip(testWeaponKnife);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponStaff);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponSword);
    assertNull(testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponAxe);
    assertEquals(testWeaponAxe, testPlayerCharacter.getEquippedWeapon());

    testPlayerCharacter.equip(testWeaponBow);
    assertEquals(testWeaponBow, testPlayerCharacter.getEquippedWeapon());
  }
}

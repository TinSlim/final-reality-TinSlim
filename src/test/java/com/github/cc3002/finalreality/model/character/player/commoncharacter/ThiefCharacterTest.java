package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacterTest;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ThiefCharacterTest extends AbstractCommonCharacterTest {

  public void setTestCharacter(){
    testCharacterA = new ThiefCharacter(turnsQueue,"ThiefA",100,100);
    testCharacterB = new ThiefCharacter(turnsQueue,"ThiefB",50,50);
    testCharacterC = new ThiefCharacter(turnsQueue,"ThiefC",0,0);
    testCharacterD = new ThiefCharacter(turnsQueue,"ThiefD",-10,-10);
  }


  @Test
  public void testEquipWeapons() {
    testCharacterA.equip(testWeaponKnife);
    assertNull(testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponAxe);
    assertNull(testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponSword);
    assertEquals(testWeaponSword,testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponBow);
    assertEquals(testWeaponBow,testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponStaff);
    assertEquals(testWeaponStaff,testCharacterA.getEquippedWeapon());

  }
}
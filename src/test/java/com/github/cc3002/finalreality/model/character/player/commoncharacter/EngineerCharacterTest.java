package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacterTest;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EngineerCharacterTest extends AbstractCommonCharacterTest {

  public void setTestCharacter(){
    testCharacterA = new EngineerCharacter(turnsQueue,"EngineerA",100,100);
    testCharacterB = new EngineerCharacter(turnsQueue,"EngineerB",50,50);
    testCharacterC = new EngineerCharacter(turnsQueue,"EngineerC",0,0);
    testCharacterD = new EngineerCharacter(turnsQueue,"EngineerD",-10,-10);
  }


  @Test
  public void testEquipWeapons() {
    testCharacterA.equip(testWeaponSword);
    assertNull(testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponKnife);
    assertNull(testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponStaff);
    assertNull(testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponAxe);
    assertEquals(testWeaponAxe,testCharacterA.getEquippedWeapon());

    testCharacterA.equip(testWeaponBow);
    assertEquals(testWeaponBow,testCharacterA.getEquippedWeapon());
  }

}

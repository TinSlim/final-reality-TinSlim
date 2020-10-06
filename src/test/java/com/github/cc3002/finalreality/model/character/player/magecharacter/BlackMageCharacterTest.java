package com.github.cc3002.finalreality.model.character.player.magecharacter;

import com.github.cc3002.finalreality.model.character.player.AbstractMageCharacterTest;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackMageCharacterTest extends AbstractMageCharacterTest {

  public void setTestCharacter(){
    testCharacterA = new BlackMageCharacter(turnsQueue,"BlackMageA",100,100,100);
    testCharacterB = new BlackMageCharacter(turnsQueue,"BlackMageB",50,50,50);
    testCharacterC = new BlackMageCharacter(turnsQueue,"BlackMageC",0,0,0);
    testCharacterD = new BlackMageCharacter(turnsQueue,"BlackMageD",-10,-10,-10);
    testCharacterE = new BlackMageCharacter(turnsQueue,"BlackMageE",100,100,100);
  }

  public void testEquipWeapons() {
    testCharacterE.equip(testWeaponSword);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponAxe);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponBow);
    assertNull(testCharacterE.getEquippedWeapon());


    testCharacterE.equip(testWeaponKnife);
    assertEquals(testWeaponKnife,testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponStaff);
    assertEquals(testWeaponStaff,testCharacterE.getEquippedWeapon());
  }
}

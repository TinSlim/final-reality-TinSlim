package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractCommonCharacterTest;
import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EngineerCharacterTest extends AbstractCommonCharacterTest {

  public void setTestCharacter(){
    testCharacterA = new EngineerCharacter(turnsQueue,"EngineerA",100,100);
    testCharacterB = new EngineerCharacter(turnsQueue,"EngineerB",50,50);
    testCharacterC = new EngineerCharacter(turnsQueue,"EngineerC",0,0);
    testCharacterD = new EngineerCharacter(turnsQueue,"EngineerD",-10,-10);
    testCharacterE = new EngineerCharacter(turnsQueue,"EngineerE",100,100);
  }



  public void testEquipWeapons() {
    testCharacterE.equip(testWeaponKnife);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponStaff);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponSword);
    assertNull(testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponAxe);
    assertEquals(testWeaponAxe,testCharacterE.getEquippedWeapon());

    testCharacterE.equip(testWeaponBow);
    assertEquals(testWeaponBow,testCharacterE.getEquippedWeapon());
  }
}

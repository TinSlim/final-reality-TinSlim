package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Bow;

/**
 * Class with set ups to test engineer class and method to test equipWeapons
 */
public class EngineerCharacterTest extends AbstractPlayerCharacterTest {

  @Override
  public void setTestCharacter(){
    setEnemies();

    testCharacterA = new EngineerCharacter(turnsQueue,"EngineerA",100,0);
    testCharacterB = new EngineerCharacter(turnsQueue,"EngineerB",50,50);
    testCharacterC = new EngineerCharacter(turnsQueue,"EngineerC",0,0);
    testCharacterD = new EngineerCharacter(turnsQueue,"EngineerD",-10,-10);
    testPlayerCharacter = new EngineerCharacter(turnsQueue,"EngineerE",100,100);

    testAttackWeaponA = new Bow("TestBowAttack",100,100);
    testAttackWeaponB = new Axe("TestAxeAttackA",50,20);
    testAttackWeaponC = new Axe("TestAxeAttackB",0,42);

    testEquipableWeaponA = testWeaponAxe;
    testEquipableWeaponB = testWeaponBow;
    testEquipableWeaponC = testWeaponBow;

    testNoEquipableWeaponA = testWeaponStaff;
    testNoEquipableWeaponB = testWeaponKnife;
    testNoEquipableWeaponC = testWeaponSword;
    testNoEquipableWeaponD = testWeaponStaff;

    testTurnsCharacterA = new EngineerCharacter(turnsQueue,"TestTurnsEngineerA",100,100);
    ((EngineerCharacter) testTurnsCharacterA).equip(testAttackWeaponA);
    testTurnsCharacterB = new EngineerCharacter(turnsQueue,"TestTurnsEngineerB",100,100);
    ((EngineerCharacter) testTurnsCharacterB).equip(testAttackWeaponB);
  }

  @Override
  public void setEqCharacter() {
    testConstructionCharacter = new EngineerCharacter(turnsQueue,"testEngineerA",100,100);
    testDiffCharacterSameClass = new EngineerCharacter(turnsQueue,"testEngineerB",100,1);
    testDiffCharacterDiffClass = new ThiefCharacter(turnsQueue, "BlackMageA", 100, 100);
    testSameCharacterSameClass = new EngineerCharacter(turnsQueue, "testEngineerA", 100, 100);

    testOnlyDiffName = new EngineerCharacter(turnsQueue, "DiffName", 100, 100);
    testOnlyDiffMaxHp = new EngineerCharacter(turnsQueue, "testEngineerA", 1, 100);
    testOnlyDiffDefense = new EngineerCharacter(turnsQueue, "testEngineerA", 100, 1);
    testOnlyDiffManaOrWeightOrOther = new EngineerCharacter(turnsQueue, "test", 5, 1);
    testOnlyDiffDamageOrOther = new EngineerCharacter(turnsQueue, "test", 5, 1);
  }
}

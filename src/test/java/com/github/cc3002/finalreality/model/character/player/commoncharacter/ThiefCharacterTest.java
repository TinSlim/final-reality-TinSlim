package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.cc3002.finalreality.model.weapon.Bow;
import com.github.cc3002.finalreality.model.weapon.Sword;


/**
 * Class with set ups to test thief class and method to test equipWeapons
 */
public class ThiefCharacterTest extends AbstractPlayerCharacterTest {

  @Override
  public void setTestCharacter(){
    setEnemies();

    testCharacterA = new ThiefCharacter(turnsQueue,"ThiefA",100,0);
    testCharacterB = new ThiefCharacter(turnsQueue,"ThiefB",50,50);
    testCharacterC = new ThiefCharacter(turnsQueue,"ThiefC",0,0);
    testCharacterD = new ThiefCharacter(turnsQueue,"ThiefD",-10,-10);

    testPlayerCharacter = new ThiefCharacter(turnsQueue,"ThiefE",100,100);

    testAttackWeaponA = new Sword("TestSwordAttack",100,100);
    testAttackWeaponB = new Bow("TestBowAttack",50,20);
    testAttackWeaponC = new Bow("TestBowAttack",0,42);

    testEquipableWeaponA = testWeaponSword;
    testEquipableWeaponB = testWeaponBow;
    testEquipableWeaponC = testWeaponStaff;

    testNoEquipableWeaponA = testWeaponKnife;
    testNoEquipableWeaponB = testWeaponKnife;
    testNoEquipableWeaponC = testWeaponKnife;
    testNoEquipableWeaponD = testWeaponAxe;

    testTurnsCharacterA = new ThiefCharacter(turnsQueue,"TestTurnsThiefA",100,100);
    ((ThiefCharacter) testTurnsCharacterA).equip(testAttackWeaponA);
    testTurnsCharacterB = new ThiefCharacter(turnsQueue,"TestTurnsThiefB",100,100);
    ((ThiefCharacter) testTurnsCharacterB).equip(testAttackWeaponB);
  }

  @Override
  public void setEqCharacter() {
    testConstructionCharacter = new ThiefCharacter(turnsQueue,"testThiefA",100,100);
    testDiffCharacterSameClass = new ThiefCharacter(turnsQueue,"testThiefB",1,1);
    testDiffCharacterDiffClass = new EngineerCharacter(turnsQueue, "EngineerA", 100, 100);
    testSameCharacterSameClass = new ThiefCharacter(turnsQueue,"testThiefA",100,100);

    testOnlyDiffName = new ThiefCharacter(turnsQueue, "DiffName", 100, 100);
    testOnlyDiffMaxHp = new ThiefCharacter(turnsQueue, "testThiefA", 1, 100);
    testOnlyDiffDefense = new ThiefCharacter(turnsQueue, "testThiefA", 100, 1);
    testOnlyDiffManaOrWeightOrOther = new ThiefCharacter(turnsQueue, "testThiefA", 5000, 100);
    testOnlyDiffDamageOrOther = new ThiefCharacter(turnsQueue, "testThiefA", 5000, 100);
  }
}
package com.github.cc3002.finalreality.model.character.player.commoncharacter;
import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import com.github.cc3002.finalreality.model.weapon.Axe;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;

/**
 * Class with set ups to test knight class and method to test equipWeapons
 */
public class KnightCharacterTest extends AbstractCommonCharacterTest {

  @Override
  public void setTestCharacter(){
    setEnemies();

    testCharacterA = new KnightCharacter(turnsQueue,"KnightA",100,0);
    testCharacterB = new KnightCharacter(turnsQueue,"KnightB",50,50);
    testCharacterC = new KnightCharacter(turnsQueue,"KnightC",0,0);
    testCharacterD = new KnightCharacter(turnsQueue,"KnightD",-10,-10);
    testPlayerCharacter = new KnightCharacter(turnsQueue,"KnightE",100,100);

    testAttackWeaponA = new Sword("TestSwordAttack",100,100);
    testAttackWeaponB = new Axe("TestAxeAttack",50,20);
    testAttackWeaponC = new Knife("TestKnifeAttack",0,42);

    testEquipableWeaponA = testWeaponSword;
    testEquipableWeaponB = testWeaponAxe;
    testEquipableWeaponC = testWeaponKnife;

    testNoEquipableWeaponA = testWeaponStaff;
    testNoEquipableWeaponB = testWeaponStaff;
    testNoEquipableWeaponC = testWeaponBow;
    testNoEquipableWeaponD = testWeaponBow;

    testTurnsCharacterA = new KnightCharacter(turnsQueue,"TestTurnsKnightA",100,100);
    ((KnightCharacter) testTurnsCharacterA).equip(testAttackWeaponA);
    testTurnsCharacterB = new KnightCharacter(turnsQueue,"TestTurnsKnightB",100,100);
    ((KnightCharacter) testTurnsCharacterB).equip(testAttackWeaponB);
  }


  @Override
  public void setEqCharacter() {
    testConstructionCharacter = new KnightCharacter(turnsQueue,"testKnightA",100,100);
    testDiffCharacterSameClass = new KnightCharacter(turnsQueue,"testKnightB",100,1);
    testDiffCharacterDiffClass = new ThiefCharacter(turnsQueue, "testThiefA", 100, 100);
    testSameCharacterSameClass = new KnightCharacter(turnsQueue, "testKnightA", 100, 100);

    testOnlyDiffName = new KnightCharacter(turnsQueue, "DiffName", 100, 100);
    testOnlyDiffMaxHp = new KnightCharacter(turnsQueue, "testKnightA", 1, 100);
    testOnlyDiffDefense = new KnightCharacter(turnsQueue, "testKnightA", 100, 1);
    testOnlyDiffManaOrWeightOrOther = new KnightCharacter(turnsQueue, "test", 5, 1);
    testOnlyDiffDamageOrOther = new KnightCharacter(turnsQueue, "test", 5, 1);
  }
}

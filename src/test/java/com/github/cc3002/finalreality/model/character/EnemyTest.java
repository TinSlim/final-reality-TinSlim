package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class with set ups for Enemy class tests and the test method for common
 * attack and adverse effects.
 */
class EnemyTest extends AbstractCharacterTest {
  protected IPlayerCharacter testPlayerCharacterA;
  protected IPlayerCharacter testPlayerCharacterB;
  protected IPlayerCharacter testPlayerCharacterC;
  protected IPlayerCharacter testPlayerCharacterD;

  protected Enemy testEffectsA;
  protected Enemy testEffectsB;
  protected Enemy testEffectsC;

  /**
   * Sets testsCharacters.
   */
  public void setTestCharacter() {
    testCharacterA = new Enemy(turnsQueue,"EnemyA",100,100,0,100);
    testCharacterB = new Enemy(turnsQueue,"EnemyB",50,50,50,50);
    testCharacterC = new Enemy(turnsQueue,"EnemyC",0,0,0,0);
    testCharacterD = new Enemy(turnsQueue,"EnemyD",-10,-10,-10,0);

    testEffectsA = new Enemy(turnsQueue,"EnemyA",100,100,10,100);
    testEffectsB = new Enemy(turnsQueue,"EnemyB",50,50,50,50);
    testEffectsC = new Enemy(turnsQueue,"EnemyC",10,1,1,20);

    testPlayerCharacterA = new KnightCharacter(turnsQueue, "testPCharacterA",80,80);
    testPlayerCharacterB = new ThiefCharacter(turnsQueue, "testPCharacterB",70,80);
    testPlayerCharacterC = new EngineerCharacter(turnsQueue, "testPCharacterC",10,80);
    testPlayerCharacterD = new EngineerCharacter(turnsQueue, "testPCharacterD",10,0);

    testTurnsCharacterA = new Enemy(turnsQueue,"EnemyA",100,100,100,100);
    testTurnsCharacterB = new Enemy(turnsQueue,"EnemyB",50,20,50,50);
  }

  /**
   * Sets EqCharacters for construction test.
   */
  public void setEqCharacter() {
    testConstructionCharacter = new Enemy(turnsQueue,"EnemyA",100,100,100,100);
    testDiffCharacterSameClass = new Enemy(turnsQueue,"EnemyB",50,50,50,50);
    testDiffCharacterDiffClass = new ThiefCharacter(turnsQueue, "ThiefMageA", 100, 100);
    testSameCharacterSameClass = new Enemy(turnsQueue,"EnemyA",100,100,100,100);

    testOnlyDiffName = new Enemy(turnsQueue,"DiffName",100,100,100,100);
    testOnlyDiffMaxHp = new Enemy(turnsQueue,"EnemyA",2,100,100,100);
    testOnlyDiffDefense = new Enemy(turnsQueue,"EnemyA",100,100,2,100);
    testOnlyDiffManaOrWeightOrOther = new Enemy(turnsQueue,"EnemyA",100,2,100,100);
    testOnlyDiffDamageOrOther = new Enemy(turnsQueue,"EnemyA",100,100,100,2);
  }

  /**
   * Tests attack to PlayerCharacters.
   */
  @Test
  public void testCommonAttack() {
    testEffectsA.commonAttack(testPlayerCharacterA);
    assertEquals(60,testPlayerCharacterA.getHp());
    assertTrue(testPlayerCharacterA.isAlive());

    testEffectsB.commonAttack(testPlayerCharacterB);
    assertEquals(70,testPlayerCharacterB.getHp());
    assertTrue(testPlayerCharacterB.isAlive());

    testEffectsC.commonAttack(testPlayerCharacterC);
    assertEquals(10,testPlayerCharacterC.getHp());
    assertTrue(testPlayerCharacterC.isAlive());

    testEffectsC.commonAttack(testPlayerCharacterD);
    assertEquals(0,testPlayerCharacterD.getHp());
    assertFalse(testPlayerCharacterD.isAlive());

    testEffectsC.commonAttack(testPlayerCharacterD);
    assertFalse(testPlayerCharacterD.isAlive());
  }

  /**
   * Tests applying adverseEffects damage to enemy.
   */
  @Test
  public void testApplyAdverseEffect() {
    testPlayerCharacterA = new BlackMageCharacter(turnsQueue,"BlackMageA",100,100,500);
    ((BlackMageCharacter) testPlayerCharacterA).setSeed(8);
    testPlayerCharacterA.equip(new Staff("TestStaffAttackA",50,42,20));

    testPlayerCharacterB = new WhiteMageCharacter(turnsQueue,"WhiteMageA",100,100,500);
    ((BlackMageCharacter) testPlayerCharacterA).setSeed(8);
    testPlayerCharacterB.equip(new Staff("TestStaffAttackA",50,42,20));

    ((BlackMageCharacter) testPlayerCharacterA).fire(testEffectsA);
    assertEquals(21, testEffectsA.getBurnDamage());
    assertEquals(68, testEffectsA.getHp());
    testEffectsA.applyEffect();
    assertEquals(57, testEffectsA.getHp());

    ((WhiteMageCharacter) testPlayerCharacterB).venom(testEffectsB);
    assertEquals(14, testEffectsB.getPoisonDamage());
    assertEquals(50, testEffectsB.getHp());
    testEffectsB.applyEffect();
    assertEquals(50, testEffectsB.getHp());
  }

  /**
   * Tests applying paralyze to enemy.
   */
  @Test
  public void TestApplyParalyze() {
    testPlayerCharacterA = new BlackMageCharacter(turnsQueue,"BlackMageA",100,100,500);
    ((BlackMageCharacter) testPlayerCharacterA).setSeed(8);
    testPlayerCharacterA.equip(new Staff("TestStaffAttackA",50,42,20));

    testPlayerCharacterB = new WhiteMageCharacter(turnsQueue,"WhiteMageA",100,100,500);
    ((BlackMageCharacter) testPlayerCharacterA).setSeed(8);
    testPlayerCharacterB.equip(new Staff("TestStaffAttackA",50,42,20));

    ((BlackMageCharacter) testPlayerCharacterA).thunder(testEffectsA);
    assertTrue(testEffectsA.getParalyze());
    assertEquals(68, testEffectsA.getHp());
    testEffectsA.applyParalyze();
    assertFalse(testEffectsA.getParalyze());

    ((WhiteMageCharacter) testPlayerCharacterB).paralyze(testEffectsB);
    assertTrue(testEffectsB.getParalyze());
    testEffectsB.applyParalyze();
    assertFalse(testEffectsB.getParalyze());

    testEffectsB.applyParalyze();
    assertFalse(testEffectsB.getParalyze());
  }
}
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

  protected Enemy testEnemyA;
  protected Enemy testEnemyB;
  protected Enemy testEnemyC;

  /**
   * Sets testsCharacters.
   */
  public void setTestCharacter() {
    testCharacterA = new Enemy(turnsQueue,"EnemyA",100,100,100,100);
    testCharacterB = new Enemy(turnsQueue,"EnemyB",50,50,50,50);
    testCharacterC = new Enemy(turnsQueue,"EnemyC",0,0,0,0);
    testCharacterD = new Enemy(turnsQueue,"EnemyD",-10,-10,-10,0);

    testEnemyA = new Enemy(turnsQueue,"EnemyA",100,100,100,100);
    testEnemyB = new Enemy(turnsQueue,"EnemyB",50,50,50,50);
    testEnemyC = new Enemy(turnsQueue,"EnemyC",10,1,1,0);

    testPlayerCharacterA = new KnightCharacter(turnsQueue, "testPCharacterB",80,80);
    testPlayerCharacterB = new ThiefCharacter(turnsQueue, "testPCharacterA",70,80);
    testPlayerCharacterC = new EngineerCharacter(turnsQueue, "testPCharacterC",10,80);

    testTurnsCharacterA = new Enemy(turnsQueue,"EnemyA",100,100,100,100);
    testTurnsCharacterB = new Enemy(turnsQueue,"EnemyB",50,20,50,50);
  }

  /**
   * Sets EqCharacters for construction test.
   */
  public void setEqCharacter() {
    testEqCharacterA = new Enemy(turnsQueue,"EnemyA",100,100,100,100);
    testEqCharacterB = new Enemy(turnsQueue,"EnemyB",50,50,50,50);
    testEqCharacterC = new ThiefCharacter(turnsQueue, "ThiefMageA", 100, 100);
    testEqCharacterD = new Enemy(turnsQueue,"EnemyA",100,100,100,100);

    testEqCharacterF1 = new Enemy(turnsQueue,"DiffName",100,100,100,100);
    testEqCharacterF2 = new Enemy(turnsQueue,"EnemyA",2,100,100,100);
    testEqCharacterF3 = new Enemy(turnsQueue,"EnemyA",100,2,100,100);
    testEqCharacterF4 = new Enemy(turnsQueue,"EnemyA",100,100,2,100);
    testEqCharacterF5 = new Enemy(turnsQueue,"EnemyA",100,100,100,2);
  }

  /**
   * Tests attack to PlayerCharacters.
   */
  @Test
  public void testCommonAttack() {
    testEnemyA.commonAttack(testPlayerCharacterA);
    assertEquals(0,testPlayerCharacterA.getHp());

    testEnemyB.commonAttack(testPlayerCharacterB);
    assertEquals(20,testPlayerCharacterB.getHp());

    testEnemyC.commonAttack(testPlayerCharacterC);
    assertEquals(10,testPlayerCharacterC.getHp());
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

    ((BlackMageCharacter) testPlayerCharacterA).fire(testEnemyA);
    assertEquals(21,testEnemyA.getBurnDamage());
    assertEquals(58,testEnemyA.getHp());
    testEnemyA.applyEffect();
    assertEquals(37,testEnemyA.getHp());

    ((WhiteMageCharacter) testPlayerCharacterB).venom(testEnemyB);
    assertEquals(14,testEnemyB.getPoisonDamage());
    assertEquals(50,testEnemyB.getHp());
    testEnemyB.applyEffect();
    assertEquals(36,testEnemyB.getHp());
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

    ((BlackMageCharacter) testPlayerCharacterA).thunder(testEnemyA);
    assertTrue(testEnemyA.getParalyze());
    assertEquals(58,testEnemyA.getHp());
    testEnemyA.applyParalyze();
    assertFalse(testEnemyA.getParalyze());

    ((WhiteMageCharacter) testPlayerCharacterB).paralyze(testEnemyB);
    assertTrue(testEnemyB.getParalyze());
    testEnemyB.applyParalyze();
    assertFalse(testEnemyB.getParalyze());;

    testEnemyB.applyParalyze();
    assertFalse(testEnemyB.getParalyze());
  }
}
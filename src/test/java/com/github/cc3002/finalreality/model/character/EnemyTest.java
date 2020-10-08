package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.EngineerCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.ThiefCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnemyTest extends AbstractCharacterTest {
  protected IPlayerCharacter testPlayerCharacterA;
  protected IPlayerCharacter testPlayerCharacterB;
  protected IPlayerCharacter testPlayerCharacterC;

  protected Enemy testEnemyA;
  protected Enemy testEnemyB;
  protected Enemy testEnemyC;

  public void setTestCharacter(){
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
  }

  @Test
  public void testCommonAttack(){
    testEnemyA.commonAttack(testPlayerCharacterA);
    assertEquals(0,testPlayerCharacterA.getHp());

    testEnemyB.commonAttack(testPlayerCharacterB);
    assertEquals(20,testPlayerCharacterB.getHp());

    testEnemyC.commonAttack(testPlayerCharacterC);
    assertEquals(10,testPlayerCharacterC.getHp());
  }
}
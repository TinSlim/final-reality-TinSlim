package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IPlayerCharacterTest;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest implements IPlayerCharacterTest {
  protected IPlayerCharacter testPlayerCharacter;

  protected IWeapon testWeaponSword = new Sword("TestSword",80,42);
  protected IWeapon testWeaponKnife = new Knife("TestKnife",20,5);
  protected IWeapon testWeaponStaff = new Staff("TestStaff",10,100,90);
  protected IWeapon testWeaponBow = new Bow("TestBow",50,30);
  protected IWeapon testWeaponAxe = new Axe("TestAxe",100,50);

  protected IWeapon testClassWeaponA;//100
  protected IWeapon testClassWeaponB;//50
  protected IWeapon testClassWeaponC;//0

  protected Enemy testEnemyA;
  protected Enemy testEnemyB;
  protected Enemy testEnemyC;

  @Test
  public void testEquipWeaponsToPlayer(){
    testEquipWeapons();
  }

  protected abstract void testEquipWeapons();

  public void setEnemies(){
    testEnemyA = new Enemy(turnsQueue,"testEnemyA",80,100,100);
    testEnemyB = new Enemy(turnsQueue,"testEnemyB",70,100,100);
    testEnemyC = new Enemy(turnsQueue,"testEnemyC",10,100,100);
  }

  @Test
  public void testCommonAttack(){
    testPlayerCharacter.equip(testClassWeaponA);
    testPlayerCharacter.commonAttack(testEnemyA);
    assertEquals(0,testEnemyA.getHp());

    testPlayerCharacter.equip(testClassWeaponB);
    testPlayerCharacter.commonAttack(testEnemyB);
    assertEquals(20,testEnemyB.getHp());

    testPlayerCharacter.equip(testClassWeaponC);
    testPlayerCharacter.commonAttack(testEnemyC);
    assertEquals(10,testEnemyC.getHp());
  }
}

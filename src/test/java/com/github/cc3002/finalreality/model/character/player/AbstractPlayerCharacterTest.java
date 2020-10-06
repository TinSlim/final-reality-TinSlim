package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.IPlayerCharacterTest;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest implements IPlayerCharacterTest {
  protected IPlayerCharacter testCharacterE;

  protected IWeapon testWeaponSword = new Sword("TestSword",80,42);
  protected IWeapon testWeaponKnife = new Knife("TestKnife",20,5);
  protected IWeapon testWeaponStaff = new Staff("TestStaff",10,100,90);
  protected IWeapon testWeaponBow = new Bow("TestBow",50,30);
  protected IWeapon testWeaponAxe = new Axe("TestAxe",100,50);


  @BeforeEach
  public void setUp(){
    setTestCharacter();
  }

  @Test
  public void testEquipWeaponsToPlayer(){
    testEquipWeapons();
  }

  protected abstract void testEquipWeapons();
}

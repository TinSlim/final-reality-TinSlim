package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.AbstractCharacterTest;
import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IPlayerCharacterTest;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest implements IPlayerCharacterTest {
  protected IPlayerCharacter testCharacterA;
  protected IPlayerCharacter testCharacterB;
  protected IPlayerCharacter testCharacterC;
  protected IPlayerCharacter testCharacterD;

  protected IWeapon testWeaponSword = new Sword("TestSword",80,42);
  protected IWeapon testWeaponKnife = new Knife("TestKnife",20,5);
  protected IWeapon testWeaponStaff = new Sword("TestSword",10,15);
  protected IWeapon testWeaponBow = new Bow("TestBow",50,30);
  protected IWeapon testWeaponAxe = new Axe("TestAxe",100,50);
  protected IWeapon testWeaponA;
  protected IWeapon testWeaponB;
  protected IWeapon testWeaponC;


  @Test
  public abstract void testEquipWeapons();

}

package com.github.cc3002.finalreality.model.character.player;

import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.WhiteMageCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;
import com.github.cc3002.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public abstract class AbstractMageCharacterTest extends AbstractPlayerCharacterTest{

  public IMageCharacter testMageA;
  public IMageCharacter testMageB;
  public IMageCharacter testMageC;


  protected IWeapon testWeaponStaffA = new Staff("TestStaffA",0,80,90);
  protected IWeapon testWeaponStaffB = new Staff("TestStaffB",0,10,90);
  protected IWeapon testWeaponStaffC = new Staff("TestStaffC",0,0,90);

  @Test
  public abstract void testCast();

}

package com.github.cc3002.finalreality.model.inventory;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.character.player.magecharacter.BlackMageCharacter;
import com.github.cc3002.finalreality.model.weapon.Knife;
import com.github.cc3002.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTest {
  protected Inventory testBag;
  protected BlockingQueue<ICharacter> turnsQueue = new LinkedBlockingQueue<>();
  IPlayerCharacter testPlayerCharacter = new BlackMageCharacter(turnsQueue,"TestPlayer",12,31,12);

  @BeforeEach
  public void setUp(){
    testBag = new Inventory();
  }

  @Test
  public void testAddTo(){
    assertEquals(testBag.getWeaponsInventory().size(), testBag.getLen());

    testBag.addToInventory(new Knife("TestKnifeA",16,12));
    assertEquals(testBag.getWeaponsInventory().size(), testBag.getLen());

    testBag.addToInventory(new Sword("TestKnife",32,22));
    testBag.addToInventory(new Knife("TestKnifeB",11,5));
    assertEquals(testBag.getWeaponsInventory().size(), testBag.getLen());
  }

  @Test
  public void testPointer(){
    addWeaponsToBag(20);
    assertEquals(0,testBag.getPointer());

    testBag.movePoint(12);
    assertEquals(12,testBag.getPointer());

    testBag.movePoint(20);
    assertEquals(19,testBag.getPointer());

    testBag.movePoint(-40);
    assertEquals(0,testBag.getPointer());
  }

  @Test
  public void testEquipToPlayerCharacter(){

    Knife testKnifeA = new Knife("TestKnifeA",22,21);
    Knife testKnifeB = new Knife("TestKnifeB",11,5);
    Sword testSword = new Sword("TestSword",32,22);

    testBag.addToInventory(testKnifeA);
    testBag.addToInventory(testKnifeB);
    testBag.addToInventory(testSword);

    testBag.equipWeaponToCharacter(testPlayerCharacter);
    assertEquals(null,testPlayerCharacter.getEquippedWeapon());

    testBag.movePoint(1);
    testBag.equipWeaponToCharacter(testPlayerCharacter);
    assertEquals(testKnifeA,testPlayerCharacter.getEquippedWeapon());

    testBag.movePoint(1);
    testBag.equipWeaponToCharacter(testPlayerCharacter);
    assertEquals(testKnifeB,testPlayerCharacter.getEquippedWeapon());

    testBag.movePoint(1);
    testBag.equipWeaponToCharacter(testPlayerCharacter);
    assertEquals(testKnifeB,testPlayerCharacter.getEquippedWeapon());
  }

  public void addWeaponsToBag(int i){
    for (int j = 1; j<i; j++){
      String name = "TestSword" + j;
      testBag.addToInventory(new Sword(name,j+10,j+12));
    }
  }
}

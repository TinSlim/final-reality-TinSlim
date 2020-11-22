package com.github.cc3002.finalreality.controller.characterfactory;

import com.github.cc3002.finalreality.controller.Controller;
import com.github.cc3002.finalreality.model.character.player.commoncharacter.KnightCharacter;

public class KnightMakerTest extends CharacterMakerTest {

  public void setTestMaker() {
    testCharacterMaker = new KnightMaker();
    testController = new Controller();
    testCharacterMaker.setController(testController);
    expectedRightMaker = new ThiefMaker();
    expectedLeftMaker = new BlackMageMaker();
    expectedNewCharacter = new KnightCharacter(testController.getQueue(),"TestCharacter",
            200,100);
  }
}

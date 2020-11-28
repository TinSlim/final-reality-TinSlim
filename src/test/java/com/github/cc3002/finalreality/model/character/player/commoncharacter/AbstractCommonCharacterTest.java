package com.github.cc3002.finalreality.model.character.player.commoncharacter;

import com.github.cc3002.finalreality.model.character.player.AbstractPlayerCharacterTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractCommonCharacterTest extends AbstractPlayerCharacterTest {

  @Test
  public void testGetMaxMana(){
    boolean shouldPassMaxMana = false;
    try {
      testPlayerCharacter.getMaxMana();
    } catch (AssertionError e) {
      shouldPassMaxMana = true;
    }
    assertTrue(shouldPassMaxMana);

    boolean shouldPassMana = false;
    try {
      testPlayerCharacter.getMana();
    } catch (AssertionError e) {
      shouldPassMana = true;
    }
    assertTrue(shouldPassMana);
  }
}

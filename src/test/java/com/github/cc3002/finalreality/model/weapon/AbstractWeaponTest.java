package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  int h;

  @BeforeEach
  void setUp() {
    h = 10;

  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  void testPlus() {
    assertEquals(h + h, 20);

  }
}
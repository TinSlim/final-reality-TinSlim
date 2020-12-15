package com.github.cc3002.finalreality.controller;

import com.github.cc3002.finalreality.model.weapon.*;

public class WeaponsFactory {
  String actualName;
  int actualDamage;
  int actualMagicDamage;
  int actualWeight;

  private Controller controller;

  public WeaponsFactory (Controller controller) {
    this.controller = controller;
  }
  public void makeSword () {
    controller.addWeaponToInventory(new Sword(actualName,actualDamage,actualWeight));
  }

  public void makeKnife () {
    controller.addWeaponToInventory(new Knife(actualName,actualDamage,actualWeight));
  }

  public void makeBow () {
    controller.addWeaponToInventory(new Bow(actualName,actualDamage,actualWeight));
  }

  public void makeAxe () {
    controller.addWeaponToInventory(new Axe(actualName,actualDamage,actualWeight));
  }

  public void makeStaff () {
    controller.addWeaponToInventory(new Staff(actualName,actualDamage,actualMagicDamage,actualWeight));
  }

  public void setDamage(int i) {
    actualDamage = i;
  }

  public void setMagicDamage(int i) {
    actualMagicDamage = i;
  }

  public void setName(String name) {
    actualName = name;
  }

  public void setWeight(int i) {
    actualWeight = i;
  }
}

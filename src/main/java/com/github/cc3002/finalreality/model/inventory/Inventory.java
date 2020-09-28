package com.github.cc3002.finalreality.model.inventory;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<IWeapon> weaponsInventory = new ArrayList<IWeapon>();
    int pointInventory = 0;
    int lenInventory = 0;

    public Inventory() {  // Todo Ver el constructor
         }

    public void addToInventory(AbstractWeapon weapon){
        this.weaponsInventory.add(weapon);
        this.lenInventory += 1;
    }

    public void movePoint(int slots) {
        if (this.lenInventory - 1 <= this.pointInventory + slots) {
            this.pointInventory = this.pointInventory + slots;
        } else {
            this.pointInventory = this.lenInventory - 1;
        }
    }

    public void equipWeaponToCharacter (IPlayerCharacter character) {
        character.equip(this.weaponsInventory.get(this.pointInventory));
    }


}

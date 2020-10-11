package com.github.cc3002.finalreality.model.inventory;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.AbstractWeapon;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<IWeapon> weaponsInventory;
    private int pointInventory;
    private int lenInventory;

    public Inventory() {
        weaponsInventory = new ArrayList<IWeapon>();
        addToInventory(null);
        pointInventory = 0;
        lenInventory = 1;
    }

    public List<IWeapon> getWeaponsInventory(){
        return this.weaponsInventory;
    }

    public int getLen(){
        return this.lenInventory;
    }

    public void addToInventory(IWeapon weapon){
        this.weaponsInventory.add(weapon);
        this.lenInventory += 1;
    }

    public int getPointer(){
        return this.pointInventory;
    }

    public void movePoint(int slots) {
        if (0 >= this.pointInventory + slots) {
            this.pointInventory = 0;
        }
        else if (this.lenInventory - 1 <= this.pointInventory + slots) {
            this.pointInventory = this.lenInventory-1;
        } else {
            this.pointInventory = this.pointInventory + slots;
        }
    }

    public void equipWeaponToCharacter (IPlayerCharacter character) {
        if (pointInventory != 0){
        character.equip(this.weaponsInventory.get(this.pointInventory));
        }
    }
}

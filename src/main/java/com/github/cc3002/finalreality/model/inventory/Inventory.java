package com.github.cc3002.finalreality.model.inventory;

import com.github.cc3002.finalreality.model.character.player.IPlayerCharacter;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<IWeapon> weaponsInventory;
    private int pointInventory;
    private int lenInventory;

    /**
     * Creates an empty inventory.
     */
    public Inventory () {
        weaponsInventory = new ArrayList<IWeapon>();
        addToInventory(null);
        pointInventory = 0;
        lenInventory = 1;
    }

    /**
     * Returns the weapons inventory list.
     * @return weapons inventory list.
     */
    public List<IWeapon> getWeaponsInventory(){
        return this.weaponsInventory;
    }

    /**
     * Returns len of the weapons inventory list.
     * @return len of the weapons inventory list.
     */
    public int getLen(){
        return this.lenInventory;
    }

    /**
     * Adds "weapon" to inventory list and adds 1 to the inventory len.
     * @param weapon weapon wanted to be added to inventory.
     */
    public void addToInventory(IWeapon weapon){
        this.weaponsInventory.add(weapon);
        this.lenInventory += 1;
    }

    /**
     * Returns the index of the weapon pointed in the inventory.
     * @return index of the weapon pointed in the inventory.
     */
    public int getPointer(){
        return this.pointInventory;
    }

    /**
     * Move the pointer adding slot to index without over passing the list.
     * @param slots how many slots to move the pointer.
     */
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

    /**
     * Tries to equip the pointed weapon to "character".
     * @param character character who will be equipped with the current pointed weapon.
     */
    public void equipWeaponToCharacter (IPlayerCharacter character) {
        if (pointInventory != 0){
        character.equip(this.weaponsInventory.get(this.pointInventory));
        }
    }

}

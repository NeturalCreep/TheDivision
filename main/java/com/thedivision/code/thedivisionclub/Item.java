package com.thedivision.code.thedivisionclub;

/**
 * Created by Administrator on 2018/2/19 0019.
 */

public class Item {
private static boolean GearOrWeapon;
private  Gear gear;
private  Weapon weapon;
public static Item  Gear(){
    Item item = new Item();
    item.GearOrWeapon=true;
    item.gear = new Gear();
    return  item;
}
public static Item  Weapon(){
    Item item = new Item();
    item.GearOrWeapon = false;
    item.weapon = new Weapon();
    return  item;
}
    public  Gear getGear(){
    return  gear;
}
    public  Weapon getWeapon(){
    return  weapon;
}
public boolean GetGearOrWeapon(){
    return GearOrWeapon;
}
}

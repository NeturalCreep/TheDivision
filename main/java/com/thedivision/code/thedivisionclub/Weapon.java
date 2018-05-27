package com.thedivision.code.thedivisionclub;

/**
 * Created by Administrator on 2018/2/19 0019.
 */

public class Weapon {
    private int Sec1;
    private int Sec2;
    private int Sec3;
    private int Itemtype;
    private int Grand;
    public  void SetItemType(int ItemNum){
        this.Itemtype = ItemNum;
    }
    public void SetSec1(int data){
        this.Sec1 = data;
    }
    public void SetSec2(int data){
        this.Sec2 = data;
    }
    public void SetSec3(int data){
        this.Sec3 = data;
    }
    public void SetGrand(int Grand){this.Grand = Grand;}
    public int GetSec1(){
        return  Sec1;
    }
    public int GetSec2(){
        return  Sec2;
    }
    public int GetSec3(){
        return  Sec3;
    }
    public int GetItemType(){
        return  Itemtype;
    }
    public int GetGrand(){return  Grand;}
}

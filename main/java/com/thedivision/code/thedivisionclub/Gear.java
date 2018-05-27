package com.thedivision.code.thedivisionclub;

/**
 * Created by Administrator on 2018/2/19 0019.
 */

public class Gear {
    private String Main1="";
    private String Main2="";
    private String Sec1="";
    private String Sec2="";
    private String Sec3="";
    private int Itemtype;
    private int Fire;
    private int Health;
    private int Electric;
    private int Grand;
    private int arm;
    public  void SetItemType(int ItemNum){
        this.Itemtype = ItemNum;
    }
    public  void SetItemFire(int Fire){
        this.Fire = Fire;
    }
    public  void SetItemHealth(int Health){
        this.Health = Health;
    }
    public  void SetItemElectric(int Electric){
        this.Electric = Electric;
    }
    public  void SetItemGrand(int Grand){
        this.Grand = Grand;
    }
    public void SetItemArm(int Arm){
        this.arm = Arm;
    }
    public void SetMain1(String data){
        if(!data.equals("0")) {
            this.Main1 = data;
        }
    }
    public void SetMain2(String data){
        if(!data.equals("0")) {
            this.Main2 = data;
        }
    }
    public void SetSec1(String data){
        if(!data.equals("0")) {
            this.Sec1 = data;
        }
    }
    public void SetSec2(String data){
        if(!data.equals("0")) {
            this.Sec2 = data;
        }
    }
    public void SetSec3(String data){
        if(!data.equals("0")) {
            this.Sec3 = data;
        }
    }
    public String GetMain1(){
        return  Main1;
    }
    public String GetMain2(){
        return  Main2;
    }
    public String GetSec1(){
        return  Sec1;
    }
    public String GetSec2(){
        return  Sec2;
    }
    public String GetSec3(){
        return  Sec3;
    }
    public int GetItemType(){
        return  Itemtype;
    }
    public int GetFire(){
        return  Fire;
    }
    public int GetHealth(){
        return  Health;
    }
    public int GetElectric(){
        return  Electric;
    }
    public int GetGrand(){
        return  Grand;
    }
    public int GetItemArm(){return  arm;}
}

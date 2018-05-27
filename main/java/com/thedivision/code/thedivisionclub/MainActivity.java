package com.thedivision.code.thedivisionclub;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import ShowView.Item;
import ShowView.Login;
import ShowView.Sellitem;
import ShowView.Tool;

public class MainActivity extends AppCompatActivity implements Callback{
    private ViewPager SCROOL_VIEW_PAGER = null;
    private ViewPagerAdpater Adpater = null;
    private ArrayList<Fragment> List2show;
    private ImageView Btn_Tool;
    private ImageView Btn_Item;
    private ImageView Btn_Sell;
    private ImageView Btn_Login;
    private VolleyManger Manger;
    private Tool tool;
    private Login login;
    private Item item;
    private Sellitem sellitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }
    private void Init(){
        Btn_Tool = (ImageView)findViewById(R.id.tool);
        Btn_Item = (ImageView)findViewById(R.id.item);
        Btn_Login = (ImageView)findViewById(R.id.login);
        Btn_Sell = (ImageView)findViewById(R.id.sell);
        tool = new Tool();
        item = new Item(this.getApplicationContext());
        sellitem = new Sellitem();
        login = new Login();
        Manger = VolleyManger.InitVolleyManger(this.getApplicationContext(),this);
        SCROOL_VIEW_PAGER = (ViewPager)findViewById(R.id.ViewPager);
        SCROOL_VIEW_PAGER.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Light_Item(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        List2show = new ArrayList<Fragment>();
        List2show.add(tool);
        List2show.add(item);
        List2show.add(login);
        List2show.add(sellitem);
        Light_Item(0);
        Adpater = new ViewPagerAdpater(getSupportFragmentManager(),List2show);
        SCROOL_VIEW_PAGER.setAdapter(Adpater);
        Btn_Tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SCROOL_VIEW_PAGER.setCurrentItem(2);
                Light_Item(2);
            }
        });
        Btn_Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SCROOL_VIEW_PAGER.setCurrentItem(1);
                Light_Item(1);
            }
        });
        Btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SCROOL_VIEW_PAGER.setCurrentItem(3);
                Light_Item(3);
            }
        });
        Btn_Sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SCROOL_VIEW_PAGER.setCurrentItem(0);
                Light_Item(0);
            }
        });

    }
    private void Light_Item(int Item){
        switch (Item){
            case 2:
                Btn_Tool.setBackgroundColor(Color.argb(255,255,64,129));
                Btn_Item.setBackgroundColor(Color.WHITE);
                Btn_Login.setBackgroundColor(Color.WHITE);
                Btn_Sell.setBackgroundColor(Color.WHITE);
                break;
            case 1 :
                Btn_Item.setBackgroundColor(Color.argb(255,255,64,129));
                Btn_Tool.setBackgroundColor(Color.WHITE);
                Btn_Login.setBackgroundColor(Color.WHITE);
                Btn_Sell.setBackgroundColor(Color.WHITE);
                break;
            case 3:
                Btn_Login.setBackgroundColor(Color.argb(255,255,64,129));
                Btn_Item.setBackgroundColor(Color.WHITE);
                Btn_Tool.setBackgroundColor(Color.WHITE);
                Btn_Sell.setBackgroundColor(Color.WHITE);
                break;
            case 0:
                Btn_Sell.setBackgroundColor(Color.argb(255,255,64,129));
                Btn_Item.setBackgroundColor(Color.WHITE);
                Btn_Tool.setBackgroundColor(Color.WHITE);
                Btn_Login.setBackgroundColor(Color.WHITE);
                break;
        }
    }

    @Override
    public void Gearcallback(ArrayList<com.thedivision.code.thedivisionclub.Item> object) {
        item.RefreshTheData(object);
    }
}

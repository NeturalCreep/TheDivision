package com.thedivision.code.thedivisionclub;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/2/27 0027.
 */

public class VolleyManger {
    private static VolleyManger Manger;
    private Callback callback;
    private RequestQueue Queue;
    public VolleyManger(Context context,Callback callback){
         Queue = Volley.newRequestQueue(context);
        this.callback = callback;
    }
    public static VolleyManger  InitVolleyManger(Context context,Callback callback){
        if(Manger==null) {
            Manger = new VolleyManger(context,callback);
        }
        return Manger;
    }
    public static VolleyManger InitVolleyManger(){
        return  Manger;
    }
    public static VolleyManger GetVolleyManger(){
        return  Manger;
    }
    public void doJsonHttpPost(String url){
        StringRequest json = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    ArrayList<Item> gears = new ArrayList<Item>();
                    JSONArray array = jsonObject.getJSONArray("Gear");
                    for (int i = 0; i < array.length(); i++) {
                        JSONArray array1 = array.getJSONArray(i);
                        Item item = Item.Gear();
                        Gear gear = item.getGear();
                        gear.SetItemGrand(array1.getInt(1));
                        gear.SetItemType(array1.getInt(2));
                        gear.SetItemFire(array1.getInt(3));
                        gear.SetItemHealth(array1.getInt(4));
                        gear.SetItemElectric(array1.getInt(5));
                        gear.SetItemArm(array1.getInt(6));
                        gear.SetMain1(array1.getString(8));
                        gear.SetMain2(array1.getString(9));
                        gear.SetSec1(array1.getString(10));
                        gear.SetSec2((array1.getString(11)));
                        gear.SetSec3(array1.getString(12));
                        gears.add(item);
                    }
                    JSONArray array2 = jsonObject.getJSONArray("Weapon");
                    for (int i = 0; i < array2.length(); i++) {
                        JSONArray array1 = array.getJSONArray(i);
                        Item item = Item.Weapon();
                        Weapon gear = item.getWeapon();
                        gear.SetGrand(array1.getInt(1));
                        gear.SetItemType(array1.getInt(2));
                        gear.SetSec1(array1.getInt(3));
                        gear.SetSec2((array1.getInt(4)));
                        gear.SetSec3(array1.getInt(5));
                        gears.add(item);
                    }
                    callback.Gearcallback(gears);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        });
        Queue.add(json);

    }
}

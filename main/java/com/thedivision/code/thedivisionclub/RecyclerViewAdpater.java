package com.thedivision.code.thedivisionclub;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2018/2/19 0019.
 */

public class RecyclerViewAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mcontext;
    private LayoutInflater inflater;
    private ArrayList<Item> Items;
    public RecyclerViewAdpater(Context mContext, ArrayList<Item> ItemList){
        this.mcontext = mContext;
        //装备数组
        this.Items = ItemList;
        inflater = LayoutInflater.from(mContext);
    }
    //通过装备属性分辨视图类型
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View weapon = inflater.inflate(R.layout.activity_recycler_view_item,parent,false);
        View Gear = inflater.inflate(R.layout.activity_recycler_view_gear,parent,false);
        if(viewType==0x01){
            GearViewHolder GHolder = new GearViewHolder(Gear);
            return GHolder;
        }else if(viewType == 0x02){
            WeaponViewHolder Wholder = new WeaponViewHolder(weapon);
            return Wholder;
        }
        return null;
    }
    //绑定Viewholder
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(Items.get(position).GetGearOrWeapon()){
            GearViewHolder GHolder = (GearViewHolder)holder;
            GHolder.TypeData(Items.get(position));
            Log.e("Arm",Items.get(position).getGear().GetItemArm()+"");
        }else{
            WeaponViewHolder Wholder = (WeaponViewHolder)holder;
            Wholder.TypeData(Items.get(position));
        }
    }
    //返回Item类型
    @Override
    public int getItemViewType(int position) {
        if(Items.get(position).GetGearOrWeapon()){
        return 0x01;
        }else{
            return  0x02;
        }
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }
    public void refreshdata(ArrayList<Item> items){
        this.Items = items;
        notifyDataSetChanged();
    }
    class GearViewHolder extends RecyclerView.ViewHolder{
        private TextView Grand;
        private ImageView Img ;
        private TextView Name;
        private TextView Arm;
        private TextView Main1;
        private TextView Main2;
        private TextView Sec1;
        private TextView Sec2;
        private TextView Sec3;
        private TextView Fire;
        private TextView Health;
        private TextView Electric;
        public GearViewHolder(View itemView) {
            super(itemView);
            Grand = (TextView)itemView.findViewById(R.id.GearGrand);
            Img = (ImageView)itemView.findViewById(R.id.GearImg);
            Name = (TextView)itemView.findViewById(R.id.GearName);
            Arm = (TextView)itemView.findViewById(R.id.Arm);
            Main1 = (TextView)itemView.findViewById(R.id.Main1);
            Main2 = (TextView)itemView.findViewById(R.id.Main2);
            Sec1 = (TextView)itemView.findViewById(R.id.Sec1);
            Sec2 = (TextView)itemView.findViewById(R.id.Sec2);
            Sec3 = (TextView)itemView.findViewById(R.id.Sec3);
            Fire = (TextView)itemView.findViewById(R.id.Fire);
            Health = (TextView)itemView.findViewById(R.id.Satinment);
            Electric = (TextView)itemView.findViewById(R.id.Electric);
        }
        public void TypeData(Item data){
            Log.e("Tag",data.getGear().hashCode()+"");
            Gear gear = data.getGear();
            Grand.setText("装等:"+gear.GetGrand()+"");
            Name.setText(GearName.GetName(gear.GetItemType()));
            Img.setImageBitmap(BitmapFactory.decodeResource(mcontext.getResources(),GearName.GetImg(gear.GetItemType())));
            Arm.setText("装甲："+gear.GetItemArm()+"");
            Main1.setText(gear.GetMain1());
            Main2.setText(gear.GetMain2());
            Sec1.setText(gear.GetSec1());
            Sec2.setText(gear.GetSec2());
            Sec3.setText(gear.GetSec3());
            Fire.setText(gear.GetFire()+"");
            Health.setText(gear.GetHealth()+"");
            Electric.setText(gear.GetElectric()+"");
        }
    }

    class WeaponViewHolder extends RecyclerView.ViewHolder{
        private TextView Grand;
        private ImageView Img;
        private  TextView Name;
        private ImageView Talent1;
        private ImageView Talent2;
        private ImageView Talent3;
        public WeaponViewHolder(View itemView) {
            super(itemView);
            Grand = (TextView)itemView.findViewById(R.id.WeaponGrand);
            Name = (TextView)itemView.findViewById(R.id.WeaponName);
            Img = (ImageView)itemView.findViewById(R.id.WeaponImg);
            Talent1 = (ImageView)itemView.findViewById(R.id.Talent1);
            Talent2 = (ImageView)itemView.findViewById(R.id.Talent2);
            Talent3 = (ImageView)itemView.findViewById(R.id.Talent3);
        }
        public void TypeData(Item data){
            Weapon weapon = data.getWeapon();
            Grand.setText(weapon.GetGrand()+"");
            Name.setText(weapon.GetItemType()+"");
        }
    }
}

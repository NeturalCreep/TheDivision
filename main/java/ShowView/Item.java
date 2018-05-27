package ShowView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.thedivision.code.thedivisionclub.Gear;
import com.thedivision.code.thedivisionclub.R;
import com.thedivision.code.thedivisionclub.RecyclerViewAdpater;
import com.thedivision.code.thedivisionclub.VolleyManger;
import com.thedivision.code.thedivisionclub.Weapon;

import java.util.ArrayList;


public class Item extends Fragment {
    private RecyclerView recyclerView;
    private  View RootView;
    private RecyclerViewAdpater Adpater;
    private ArrayList<com.thedivision.code.thedivisionclub.Item> Items;
    private Context context;
    public Item(){

    }
    @SuppressLint("ValidFragment")
    public Item(Context context) {
        // Required empty public constructor
    this.context = context;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Items==null) {
            Items = new ArrayList<com.thedivision.code.thedivisionclub.Item>();
        }
    }
    public void RefreshTheData(ArrayList<com.thedivision.code.thedivisionclub.Item> items){
        Adpater.refreshdata(items);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RootView = inflater.inflate(R.layout.fragment_item, container, false);
        recyclerView = (RecyclerView)RootView.findViewById(R.id.ReCyclerView2show);
        Adpater = new RecyclerViewAdpater(RootView.getContext(),Items);
        recyclerView.setAdapter(Adpater);
        LinearLayoutManager Manger = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(Manger);
        recyclerView.addItemDecoration(new SpacesItemDecoration(8));
        VolleyManger.InitVolleyManger().doJsonHttpPost("http://192.168.1.71:19017/wanteditem");
        return RootView;
    }
}
 class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildPosition(view) == 0)
            outRect.top = space;
    }
}

package com.thedivision.code.thedivisionclub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/30.
 */

public class GearName {
    private static String[] Name = {"机密突袭甲胄","机密突袭护膝","机密突袭枪套","机密突袭手套","机密突袭背包","机密突袭面具"};
    private static int[] IMG = {R.drawable.striker_vest,R.drawable.striker_kneepad,R.drawable.striker_holster,R.drawable.striker_gloves,
            R.drawable.striker_backpack,R.drawable.striker_mask};
    public static String GetName(int index){
        return Name[index];
    }
    public static int GetImg(int index){
        return IMG[index];
    }
}

package com.LWT.DataController;

import com.LWT.Dao.BilingableDao;
import com.LWT.Entity.VW_N4_Bilingable;

import java.util.List;

/**
 * Created by Du on 2017/3/31.
 */
public class test {
    public void ceshi(){
        BilingableDao bd=new BilingableDao();
        List<VW_N4_Bilingable> vw=bd.getAllData();
        for(int i=0;i<vw.size();i++) {
            VW_N4_Bilingable vnb=vw.get(i);
            System.out.println(vnb.toString());
        }
    }
    public static void main(String[] args){
        test t=new test();
        t.ceshi();
    }
}

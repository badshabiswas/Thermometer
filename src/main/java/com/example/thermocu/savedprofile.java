package com.example.thermocu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.thermocu.R.string.hredoy;

public class savedprofile extends AppCompatActivity {

    ExpandableListView expandablelistview;
    List<String>listgroup;
    HashMap<String,List<String>> listitem;

    Mainadapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedprofile);

        expandablelistview=findViewById(R.id.expandview);
        listgroup=new ArrayList<>();
        listitem=new HashMap<>();
        adapter=new Mainadapter(this,listgroup,listitem);
        expandablelistview.setAdapter(adapter);
        initListData();

    }


    private void initListData() {
        listgroup.add(getString(R.string.hredoy));
        listgroup.add(getString(R.string.ahad));
        listgroup.add(getString(R.string.shovon));
        listgroup.add(getString(R.string.mahedi));
        listgroup.add(getString(R.string.digu));

        String[] array;
         List<String> list1= new ArrayList<>();
         array=getResources().getStringArray(R.array.hredoy);
         for (String item:array){
             list1.add(item);
         }

        List<String> list2= new ArrayList<>();
        array=getResources().getStringArray(R.array.ahad);
        for (String item:array){
            list2.add(item);
        }
        List<String> list3= new ArrayList<>();
        array=getResources().getStringArray(R.array.shovon);
        for (String item:array){
            list3.add(item);
        }
        List<String> list4= new ArrayList<>();
        array=getResources().getStringArray(R.array.mahedi);
        for (String item:array){
            list4.add(item);
        }
        List<String> list5= new ArrayList<>();
        array=getResources().getStringArray(R.array.digu);
        for (String item:array){
            list5.add(item);
        }
        listitem.put(listgroup.get(0),list1);
        listitem.put(listgroup.get(1),list2);
        listitem.put(listgroup.get(2),list3);
        listitem.put(listgroup.get(3),list4);
        listitem.put(listgroup.get(4),list5);
        adapter.notifyDataSetChanged();

    }
}
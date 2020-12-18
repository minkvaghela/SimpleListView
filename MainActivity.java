package com.example.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;

    String[] Repository = new String[]{"R1","R2","R3","R4","R5","R6"};
    String[] Owner = new String[]{"O1","O2","O3","O4","O5","O6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int x=0; x<6; x++){
           HashMap<String, String> hm = new HashMap<String, String>();
           hm.put("listRepo", Repository[x]);
           hm.put("listOwn", Owner[x]);
           aList.add(hm);
        }

        String[] from = {
          "listRepo", "listOwn"
        };
        int[] to = {
          R.id.textView1, R.id.textView2
        };
        SimpleAdapter sa = new SimpleAdapter(getBaseContext(), aList, R.layout.custom_list, from, to);
        list = (ListView)findViewById(R.id.list_view);
        list.setAdapter(sa);
    }
}

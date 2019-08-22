package com.example.khang.hkhang97;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.khang.hkhang97.ListAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private String json;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_list);
        json="[\n" +
                "\"xiaomi\",\n" +
                "\"bitis hunter\",\n" +
                "\"bts\",\n" +
                "\"balo\",\n" +
                "\"bitis hunter x\",\n" +
                "\"tai nghe\",\n" +
                "\"harry potter\",\n" +
                "\"anker\",\n" +
                "\"iphone\",\n" +
                "\"balo nữ\",\n" +
                "\"nguyễn nhật ánh\",\n" +
                "\"đắc nhân tâm\",\n" +
                "\"ipad\",\n" +
                "\"senka\",\n" +
                "\"tai nghe bluetooth\",\n" +
                "\"son\",\n" +
                "\"maybelline\",\n" +
                "\"laneige\",\n" +
                "\"kem chống nắng\",\n" +
                "\"anh chính là thanh xuân của em\"\n" +
                "]";
        setUpRv();
    }
    private void setUpRv(){
        Gson gson = new Gson();
        try {

            Tikis tiki1 = gson.fromJson(json, Tikis.class);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            listAdapter = new ListAdapter(MainActivity.this, tiki1.getTikisList());
            recyclerView.setAdapter(listAdapter);
        }catch (Exception ex){
            ex.printStackTrace();{}
        }
    }
}

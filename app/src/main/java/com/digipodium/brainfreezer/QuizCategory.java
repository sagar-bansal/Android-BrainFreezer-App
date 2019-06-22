package com.digipodium.brainfreezer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class QuizCategory extends AppCompatActivity {

    private ArrayList<category> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_category);
        RecyclerView recycler=findViewById(R.id.recycler);
        arr = new ArrayList<>();
        arr.add(new category("Physics"));
        arr.add(new category("Chemistry"));
        arr.add(new category("History"));
        arr.add(new category("Biology"));
        arr.add(new category("Grammar"));
        arr.add(new category("Geography"));
        arr.add(new category("Computers"));
        arr.add(new category("General Knowledge"));
        arr.add(new category("Maths"));
        arr.add(new category("Civics"));

        adapter adapt=new adapter(this,arr);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapt);



    }
}

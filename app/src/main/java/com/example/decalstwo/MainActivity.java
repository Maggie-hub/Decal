package com.example.decalstwo;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recycle);

        List<User> list = new ArrayList<>(40);
        for (int i = 0; i < 20; i++) {
            User user = new User();
            if (i % 2 == 0) {
                user.setImage(R.mipmap.lm);
            } else if (i % 3 == 0)
                user.setImage(R.mipmap.lm1);
            else if (i % 5 == 0)
                user.setImage(R.mipmap.lm2);
            else {
                user.setImage(R.mipmap.lm4);
            }

            if (i % 2 == 0)
                user.setStatue(1);
            else
                user.setStatue(0);

            list.add(user);
        }


        MyAdapter myAdapter = new MyAdapter(list, this);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rv.setLayoutManager(new GridLayoutManager(this, 3));
//        rv.addItemDecoration(new GridSpacingItemDecoration(
//                3,30,false));

        rv.setAdapter(myAdapter);


    }
}

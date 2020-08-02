package com.example.databindingdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        GridView GV = findViewById(R.id.gridView);

        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setAge(R.mipmap.ic_launcher);
            list.add(user);
        }

        GV.setAdapter(new MyAdapter());
        int a= 0;

        try {
            int b = a/0;

        }catch (Exception e){
            Log.i("hello", "onCreate: 除数不能为零");
        }




    }


    class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return list.size();
        }


        @Override
        public Object getItem(int position) {
            return list.get(position);
        }


        @Override
        public long getItemId(int position) {
            return position;
        }


        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view1;

            if (convertView == null)

                view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_image, null);
            else
                view1 = convertView;

            ImageView viewById = view1.findViewById(R.id.image);
            viewById.setImageResource(list.get(position).getAge());

            return view1;
        }
    }
}

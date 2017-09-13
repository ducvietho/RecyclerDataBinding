package com.example.hoducviet.demodatabinding.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.example.hoducviet.demodatabinding.R;
import com.example.hoducviet.demodatabinding.databinding.ActivityMainBinding;
import com.example.hoducviet.demodatabinding.manager.RecyclerUserAdapter;
import com.example.hoducviet.demodatabinding.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerUserAdapter adapter;
    private ActivityMainBinding binding;
    private ArrayList<User> list;
    private GridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        list = new ArrayList<>();
        list.add(new User("Viet","Ha Noi"));
        list.add(new User("Khanh","Hà Nam"));
        manager = new GridLayoutManager(MainActivity.this,1);
        adapter = new RecyclerUserAdapter(MainActivity.this,list);
        binding.recUser.setHasFixedSize(true);
        binding.recUser.setLayoutManager(manager);
        binding.recUser.setAdapter(adapter);

    }
}

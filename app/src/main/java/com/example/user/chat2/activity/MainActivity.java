package com.example.user.chat2.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.user.chat2.R;
import com.example.user.chat2.adapter.UserAdapter;
import com.example.user.chat2.model.User;

import java.util.ArrayList;

import github.chenupt.springindicator.viewpager.ScrollerViewPager;

public class MainActivity extends AppCompatActivity {
    ScrollerViewPager viewPager;
    Button button;
    private RecyclerView recyclerView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registr_activity);
        button = findViewById(R.id.button);
        final Intent intent = new Intent(MainActivity.this, StartActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
     /*   ArrayList<User> itemList = new ArrayList<User>();

        UserAdapter itemArrayAdapter = new UserAdapter(itemList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);

        // Populating list items
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                itemList.add(new User("Right " + i, "", "", "", User.ItemType.ONE_ITEM));
            } else {
                itemList.add(new User("Left " + i, "", "", "", User.ItemType.TWO_ITEM));
            }
        }
    }*/
//        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
//        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
//        PagerModelManager manager = new PagerModelManager();
//        manager.addCommonFragment(GuideFragment.class, getBgRes(), getTitles());
//        ModelPagerAdapter adapter = new (getSupportFragmentManager(), manager);
//        viewPager.setAdapter(adapter);
//        viewPager.fixScrollSpeed();

        // just set viewPager
        //   springIndicator.setViewPager(viewPager);


//    private ArrayList<String> getTitles(){
//        ArrayList<String> list =new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        return list;
//    }
//
//    private ArrayList<Integer> getBgRes(){
//    ArrayList<Integer> integers =new ArrayList<>();
//    integers.add(R.drawable.flag_afghanistan);
//    integers.add(R.drawable.flag_aland);
//    integers.add(R.drawable.flag_uzbekistan);
//    integers.add(R.drawable.flag_andorra);
//
//        return integers;
//    }
    }
}

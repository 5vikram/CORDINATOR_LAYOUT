package com.example.root.viewpager;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by root on 26/8/16.
 */
public class SecondActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    Handler viewpagerScrollerHandler;
    Runnable viewpagerScrollerrunnable;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private Toolbar toolbar;
    private ArrayList<Item> items = new ArrayList<>();
    Timer swipeTimer;
    final int NUM_PAGES = 6;
    int currentPage = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mViewPager = (ViewPager) findViewById(R.id.activityhomeviewpager_id);
       /* toolbar=(Toolbar)findViewById(R.id.my_awesome_toolbar) ;
        toolbar.setTitle("Slide pager");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);*/

        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(SecondActivity.this);
        mViewPager.setAdapter(pagerAdapter);


// Create your adapter for recyclerview-----

        items.add(new Item(R.drawable.one,"Allium roseum"));
        items.add(new Item(R.drawable.two,"Alchemilla"));
        items.add(new Item(R.drawable.three,"Amaranthus"));
        items.add(new Item(R.drawable.four,"Antirrhinum majus"));
        items.add(new Item(R.drawable.five,"Aubreita deltoidea"));
        items.add(new Item(R.drawable.six,"Balloon Flower"));

        items.add(new Item(R.drawable.one,"Bachelor's Button"));
        items.add(new Item(R.drawable.two,"Baby's Breath"));
        items.add(new Item(R.drawable.three,"Bellflowers"));
        items.add(new Item(R.drawable.four,"Bleeding Heart"));
        items.add(new Item(R.drawable.five,"Blue Star Flower"));
        items.add(new Item(R.drawable.six,"Bouvardia"));


        recyclerView = (RecyclerView) findViewById(R.id.design_bottom_sheet);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setHasFixedSize(true);


            itemAdapter = new ItemAdapter(SecondActivity.this,items);
            recyclerView.setAdapter(itemAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewpagerScrollerHandler = new Handler();
        viewpagerScrollerrunnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage == NUM_PAGES - 1) {
                    currentPage = 0;
                }
                mViewPager.setCurrentItem(currentPage++, true);
            }
        };
        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                viewpagerScrollerHandler.post(viewpagerScrollerrunnable);
            }
        }, 2000, 5000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewpagerScrollerHandler.removeCallbacks(viewpagerScrollerrunnable);
        swipeTimer.cancel();
        viewpagerScrollerHandler = null;
        viewpagerScrollerrunnable = null;
        swipeTimer = null;
    }
}

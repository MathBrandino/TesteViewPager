package br.com.caelum.testeviewpager;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.testeviewpager.adapter.Adapter;
import br.com.caelum.testeviewpager.application.MinhaApplication;
import br.com.caelum.testeviewpager.fragments.Fragment1;
import br.com.caelum.testeviewpager.fragments.Fragment2;
import br.com.caelum.testeviewpager.fragments.Fragment3;

public class MainActivity extends AppCompatActivity {

    private MinhaApplication application;
    private ViewPager viewPager;
    private Fragment2 fragment2;
    private Fragment1 fragment1;
    private Fragment3 fragment3;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        application = new MinhaApplication();
        TabLayout layout = (TabLayout) findViewById(R.id.tab_layout);
        layout.addTab(layout.newTab().setText("Recycler View"));
        layout.addTab(layout.newTab().setText("Image View"));

        layout.addTab(layout.newTab().setText("List View"));

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(layout));

        for (int i = 0; i <= 20; i++)
            application.getIntegers().add(i);

        fragment2 = new Fragment2();
        fragment1 = new Fragment1();
        fragment3 = new Fragment3();
        application.getIntegers();
        fragments = new ArrayList<>();


        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment1);

        Adapter adapter = new Adapter(getSupportFragmentManager(), fragments);


        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(1);
        layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
                invalidateOptionsMenu();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public MinhaApplication getMinhaApplication() {
        return application;
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem rotacionar = menu.add("Rotacionar");
        rotacionar.setTitle("Rotacionar");
        rotacionar.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        rotacionar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

               fragment2.rotaciona();

                return true;
            }
        });

        if (viewPager.getCurrentItem() == 1 || viewPager.getCurrentItem() == 2) {
            rotacionar.setVisible(false);
        } else {
            rotacionar.setVisible(true);
        }

        return super.onCreateOptionsMenu(menu);
    }


}

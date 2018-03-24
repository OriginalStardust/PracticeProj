package com.sunchang.tabtest;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private List<Fragment> mFragmentList = new ArrayList<>();

    private LinearLayout mTabMain;
    private LinearLayout mTabMedia;
    private LinearLayout mTabApp;
    private LinearLayout mTabShare;

    private ImageView mImageMain;
    private ImageView mImageMedia;
    private ImageView mImageApp;
    private ImageView mImageShare;

    private TextView mTextMain;
    private TextView mTextMedia;
    private TextView mTextApp;
    private TextView mTextShare;

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().hide();
        }

        this.initViews();
        this.initEvents();
    }

    private void initViews() {
        mViewPager = (ViewPager) this.findViewById(R.id.view_pager);

        mTabMain = (LinearLayout) this.findViewById(R.id.tab_main);
        mTabMedia = (LinearLayout) this.findViewById(R.id.tab_media);
        mTabApp = (LinearLayout) this.findViewById(R.id.tab_app);
        mTabShare = (LinearLayout) this.findViewById(R.id.tab_share);

        mImageMain = (ImageView) this.findViewById(R.id.tab_main_image);
        mImageMedia = (ImageView) this.findViewById(R.id.tab_media_image);
        mImageApp = (ImageView) this.findViewById(R.id.tab_app_image);
        mImageShare = (ImageView) this.findViewById(R.id.tab_share_image);

        mTextMain = (TextView) this.findViewById(R.id.tab_main_text);
        mTextMedia = (TextView) this.findViewById(R.id.tab_media_text);
        mTextApp = (TextView) this.findViewById(R.id.tab_app_text);
        mTextShare = (TextView) this.findViewById(R.id.tab_share_text);

        MainFragment mainFragment = new MainFragment();
        MediaFragment mediaFragment = new MediaFragment();
        AppFragment appFragment = new AppFragment();
        ShareFragment shareFragment = new ShareFragment();
        mFragmentList.add(mainFragment);
        mFragmentList.add(mediaFragment);
        mFragmentList.add(appFragment);
        mFragmentList.add(shareFragment);

        FragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(this.getSupportFragmentManager(),
                mFragmentList);
        mViewPager.setAdapter(pagerAdapter);
    }

    private void initEvents() {
        mTabMain.setOnClickListener(this);
        mTabMedia.setOnClickListener(this);
        mTabApp.setOnClickListener(this);
        mTabShare.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                MainActivity.this.resetImages();
                switch (position) {
                    case 0:
                        mImageMain.setImageResource(R.drawable.tab01_pressed);
                        mTextMain.setTextColor(Color.rgb(230, 87, 87));
                        break;
                    case 1:
                        mImageMedia.setImageResource(R.drawable.tab02_pressed);
                        mTextMedia.setTextColor(Color.rgb(230, 87, 87));
                        break;
                    case 2:
                        mImageApp.setImageResource(R.drawable.tab03_pressed);
                        mTextApp.setTextColor(Color.rgb(230, 87, 87));
                        break;
                    case 3:
                        mImageShare.setImageResource(R.drawable.tab06_pressed);
                        mTextShare.setTextColor(Color.rgb(230, 87, 87));
                        break;
                    default:
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_main:
                mImageMain.setImageResource(R.drawable.tab01_pressed);
                mTextMain.setTextColor(Color.rgb(230, 87, 87));
                mViewPager.setCurrentItem(0);
                break;
            case R.id.tab_media:
                mImageMedia.setImageResource(R.drawable.tab02_pressed);
                mTextMedia.setTextColor(Color.rgb(230, 87, 87));
                mViewPager.setCurrentItem(1);
                break;
            case R.id.tab_app:
                mImageApp.setImageResource(R.drawable.tab03_pressed);
                mTextApp.setTextColor(Color.rgb(230, 87, 87));
                mViewPager.setCurrentItem(2);
                break;
            case R.id.tab_share:
                mImageShare.setImageResource(R.drawable.tab06_pressed);
                mTextShare.setTextColor(Color.rgb(230, 87, 87));
                mViewPager.setCurrentItem(3);
                break;
            default:
        }
    }

    private void resetImages() {
        mImageMain.setImageResource(R.drawable.tab01_normal);
        mImageMedia.setImageResource(R.drawable.tab02_normal);
        mImageApp.setImageResource(R.drawable.tab03_normal);
        mImageShare.setImageResource(R.drawable.tab06_normal);

        mTextMain.setTextColor(Color.parseColor("#555555"));
        mTextMedia.setTextColor(Color.parseColor("#555555"));
        mTextApp.setTextColor(Color.parseColor("#555555"));
        mTextShare.setTextColor(Color.parseColor("#555555"));
    }

    @Override
    public void onBackPressed() {
        final QuitAppDialog dialog = new QuitAppDialog(this);
        dialog.setCancelable(true);
        dialog.show();
        dialog.setOnPositiveListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
        dialog.setOnNegativeListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}

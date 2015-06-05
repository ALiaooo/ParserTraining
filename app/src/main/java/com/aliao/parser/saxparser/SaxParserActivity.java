package com.aliao.parser.saxparser;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.aliao.parser.R;

/**
 * Created by 丽双 on 2015/6/3.
 */
public class SaxParserActivity extends FragmentActivity {


    private String lastFragmentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax);
        replaceFragment("parser",  SaxParserFragment.TAG);
    }


    public void replaceLitePal() {
        replaceFragment("解析litepal", LitePalParserFragment.TAG);
    }
    public void replaceBeauty() {
        replaceFragment("解析beauty", BeautyParserFragment.TAG);
    }

    private void replaceFragment(CharSequence title, String currentFragmentTag) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment lastFragment = fm.findFragmentByTag(lastFragmentTag);
        Fragment currentFragment = fm.findFragmentByTag(currentFragmentTag);
        if (lastFragment != null) {
            ft.remove(lastFragment);
        }
        if (currentFragment == null) {
            currentFragment = getFragment(currentFragmentTag);
            ft.replace(R.id.container, currentFragment, currentFragmentTag);
        } else {
            ft.attach(currentFragment);
        }
        ft.commit();
        lastFragmentTag = currentFragmentTag;
        setTitle(title);
    }

    private Fragment getFragment(String tag) {

        if (tag.equals(SaxParserFragment.TAG)) {
            return SaxParserFragment.newInstance();
        }if (tag.equals(LitePalParserFragment.TAG)) {
            return new LitePalParserFragment();
        } else if (tag.equals(BeautyParserFragment.TAG)) {
            return new BeautyParserFragment();
        } else {
            throw new IllegalArgumentException("Wrong tag");
        }
    }

}

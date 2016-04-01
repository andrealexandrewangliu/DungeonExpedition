package com.game.andreliu.dungeondivers.layout.init;


import android.support.v7.app.ActionBarActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.game.andreliu.dungeondivers.R;

public class NewGameActivity extends ActionBarActivity{
    private static NewGameActivity currentInstance;
    private NewGameDifficultyFragment newGameDifficultyFragment = new NewGameDifficultyFragment();
    private NewGameBackgroundFragment newGameBackgroundFragment = new NewGameBackgroundFragment();

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public static NewGameActivity getCurrentInstance() {
        return currentInstance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentInstance = this;
        setContentView(R.layout.activity_new_game);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    public void onClick(int R_id) {
        switch (R_id) {
            case R.id.buttonNext:
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
                break;
            case R.id.buttonPrev:
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /*switch (position){
                case 1:
                    return newGameDifficultyFragment;
                case 2:
                    return newGameBackgroundFragment;
            }
            return newGameDifficultyFragment;*/
            switch (position){
                case 0:
                    return NewGameDifficultyFragment.createInstance();
                case 1:
                    return NewGameIdentityFragment.createInstance();
                case 2:
                    return NewGameBackgroundFragment.createInstance();
            }
            return NewGameDifficultyFragment.createInstance();
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Difficulty";
                case 1:
                    return "Identity";
                case 2:
                    return "Background";
                case 3:
                    return "SECTION 3";
            }
            return null;
        }
    }

}

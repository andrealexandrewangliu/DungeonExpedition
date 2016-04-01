package com.game.andreliu.dungeondivers.layout.init;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.game.andreliu.dungeondivers.R;

/**
 * Created by xmyx on 14/03/16.
 */
public class NewGameIdentityFragment extends Fragment implements OnClickListener{
    public static NewGameIdentityFragment createInstance(){
        NewGameIdentityFragment instance = new NewGameIdentityFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_new_game_indentity, container, false);
        v.findViewById(R.id.buttonNext).setOnClickListener(this);
        v.findViewById(R.id.buttonPrev).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonNext:
            case R.id.buttonPrev:
                NewGameActivity.getCurrentInstance().onClick(v.getId());
        }
    }
}

package com.game.andreliu.dungeondivers.init;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.game.andreliu.dungeondivers.R;

/**
 * Created by xmyx on 14/03/16.
 */
public class NewGameBackgroundFragment extends Fragment implements OnClickListener{
    private  NewGameActivity parent;
    public static NewGameBackgroundFragment createInstance(NewGameActivity parent){
        NewGameBackgroundFragment instance = new NewGameBackgroundFragment();
        instance.setParent(parent);
        return instance;
    }

    protected  void setParent(NewGameActivity parent){
        this.parent = parent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_new_game_background, container, false);
        return v;
    }

    @Override
    public void onClick(View v) {
    }
}

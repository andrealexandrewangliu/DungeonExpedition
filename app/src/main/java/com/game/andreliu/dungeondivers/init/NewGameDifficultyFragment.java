package com.game.andreliu.dungeondivers.init;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.game.andreliu.dungeondivers.R;

/**
 * Created by xmyx on 14/03/16.
 */
public class NewGameDifficultyFragment extends Fragment implements OnClickListener{
    private  NewGameActivity parent;
    private RadioButton easyRadio;
    private RadioButton normalRadio;
    private RadioButton hardRadio;

    public static NewGameDifficultyFragment createInstance(NewGameActivity parent){
        NewGameDifficultyFragment instance = new NewGameDifficultyFragment();
        instance.setParent(parent);
        return instance;
    }
    protected  void setParent(NewGameActivity parent){
        this.parent = parent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_new_game_difficulty, container, false);

        easyRadio = (RadioButton) v.findViewById(R.id.radioEasy);
        normalRadio = (RadioButton) v.findViewById(R.id.radioNormal);
        hardRadio = (RadioButton) v.findViewById(R.id.radioHard);

        v.findViewById(R.id.Easy).setOnClickListener(this);
        v.findViewById(R.id.Normal).setOnClickListener(this);
        v.findViewById(R.id.Hard).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Easy:
                easyRadio.setChecked(true);
                normalRadio.setChecked(false);
                hardRadio.setChecked(false);
                break;
            case R.id.Normal:
                easyRadio.setChecked(false);
                normalRadio.setChecked(true);
                hardRadio.setChecked(false);
                break;
            case R.id.Hard:
                easyRadio.setChecked(false);
                normalRadio.setChecked(false);
                hardRadio.setChecked(true);
                break;
        }
    }
}

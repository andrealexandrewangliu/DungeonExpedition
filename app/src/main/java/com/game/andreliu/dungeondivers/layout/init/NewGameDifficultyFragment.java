package com.game.andreliu.dungeondivers.layout.init;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.game.andreliu.dungeondivers.R;
import com.game.andreliu.dungeondivers.data.CurrentGameData;

/**
 * Created by xmyx on 14/03/16.
 */
public class NewGameDifficultyFragment extends Fragment implements OnClickListener{
    private RadioButton easyRadio;
    private RadioButton normalRadio;
    private RadioButton hardRadio;
    private TextView dificultyDetails;

    public static NewGameDifficultyFragment createInstance(){
        NewGameDifficultyFragment instance = new NewGameDifficultyFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_new_game_difficulty, container, false);

        easyRadio = (RadioButton) v.findViewById(R.id.radioEasy);
        normalRadio = (RadioButton) v.findViewById(R.id.radioNormal);
        hardRadio = (RadioButton) v.findViewById(R.id.radioHard);
        dificultyDetails = (TextView) v.findViewById(R.id.dificultyDetails);

        v.findViewById(R.id.buttonNext).setOnClickListener(this);

        v.findViewById(R.id.Easy).setOnClickListener(this);
        v.findViewById(R.id.Normal).setOnClickListener(this);
        v.findViewById(R.id.Hard).setOnClickListener(this);
        easyRadio.setOnClickListener(this);
        normalRadio.setOnClickListener(this);
        hardRadio.setOnClickListener(this);
        setDificultyDetails();
        return v;
    }

    private void setDificultyDetails(){
        switch (CurrentGameData.getCurrentGame().getDifficulty()){
            case EASY:
                dificultyDetails.setText("For those playing rpg the first time;\nFull heal in town;\nNo game over.");
                break;
            case NORMAL:
                dificultyDetails.setText("For common players;\nNeed to heal in town;\nIf leader is down, then retreat automatically;\nMorale modifiers.");
                break;
            case HARD:
                dificultyDetails.setText("For those who wish a challenge;\nNeed to heal and supply in town;\nIf leader is down, then game over, party members can die permanently;\nMorale modifiers, disheartened members may quit;\nMore bad events.");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioEasy:
            case R.id.Easy:
                easyRadio.setChecked(true);
                normalRadio.setChecked(false);
                hardRadio.setChecked(false);
                CurrentGameData.getCurrentGame().setDifficulty(CurrentGameData.difficultyType.EASY);
                setDificultyDetails();
                break;
            case R.id.radioNormal:
            case R.id.Normal:
                easyRadio.setChecked(false);
                normalRadio.setChecked(true);
                hardRadio.setChecked(false);
                CurrentGameData.getCurrentGame().setDifficulty(CurrentGameData.difficultyType.NORMAL);
                setDificultyDetails();
                break;
            case R.id.radioHard:
            case R.id.Hard:
                easyRadio.setChecked(false);
                normalRadio.setChecked(false);
                hardRadio.setChecked(true);
                CurrentGameData.getCurrentGame().setDifficulty(CurrentGameData.difficultyType.HARD);
                setDificultyDetails();
                break;
            case R.id.buttonNext:
                NewGameActivity.getCurrentInstance().onClick(v.getId());
        }
    }
}

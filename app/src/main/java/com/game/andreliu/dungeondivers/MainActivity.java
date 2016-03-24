package com.game.andreliu.dungeondivers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.game.andreliu.dungeondivers.data.CurrentGameData;
import com.game.andreliu.dungeondivers.data.gamedata.CharacterStats.GameCharacterClass;
import com.game.andreliu.dungeondivers.init.LoadSaveActivity;
import com.game.andreliu.dungeondivers.init.NewGameActivity;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//Remove title bar
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.newButton).setOnClickListener(onNewGame);
        this.findViewById(R.id.loadButton).setOnClickListener(onLoadGame);
        GameCharacterClass.initClasses();
    }


    private OnClickListener onNewGame = new OnClickListener() {
        @Override
        public void onClick(final View v) {
            Intent i = new Intent(MainActivity.this, NewGameActivity.class);
            startActivity(i);
        }
    };


    private OnClickListener onLoadGame = new OnClickListener() {
        @Override
        public void onClick(final View v) {
            Intent i = new Intent(MainActivity.this, LoadSaveActivity.class);
            startActivity(i);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

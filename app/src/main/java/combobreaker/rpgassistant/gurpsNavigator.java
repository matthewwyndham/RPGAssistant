package combobreaker.rpgassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class gurpsNavigator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gurps_navigator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void navigateChar(View v) {
        startActivity(new Intent(gurpsNavigator.this, GURPS.class));
    }

    public void navigateMonster(View v) {
        startActivity(new Intent(gurpsNavigator.this, Monsters.class));
    }
}

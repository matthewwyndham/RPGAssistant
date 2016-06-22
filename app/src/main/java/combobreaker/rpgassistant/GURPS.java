package combobreaker.rpgassistant;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class GURPS extends AppCompatActivity {
    int hpcounter;
    SharedPreferences saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gurps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hp counter
        saved = getSharedPreferences("hpcounter", 0);
        hpcounter = saved.getInt("hpcounter", 0);

        // todo: add the other updaters

        update();
    }

    public void update() {
        // hp counter
        TextView t = (TextView) findViewById(R.id.hpview);
        t.setText(hpcounter + "");

        // todo: add all the other counters
    }

    public void plushp(View v) {
        hpcounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("hpcounter", hpcounter);
        editor.apply();
        update();
    }

    public void minushp(View v) {
        hpcounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("hpcounter", hpcounter);
        editor.apply();
        update();
    }

    // todo: add the other buttons' functions
}

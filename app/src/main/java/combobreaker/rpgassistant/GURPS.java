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
    int stcounter;
    int hpcounter;
    int dxcounter;
    int wicounter;
    int iqcounter;
    int pecounter;
    int htcounter;
    int fpcounter;
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

        // st counter
        saved = getSharedPreferences("stcounter", 0);
        stcounter = saved.getInt("stcounter", 0);

        // dxcounter
        saved = getSharedPreferences("dxcounter", 0);
        dxcounter = saved.getInt("dxcounter", 0);

        // wicounter
        saved = getSharedPreferences("wicounter", 0);
        wicounter = saved.getInt("wicounter", 0);

        // iqcounter
        saved = getSharedPreferences("iqcounter", 0);
        iqcounter = saved.getInt("iqcounter", 0);

        // pecounter
        saved = getSharedPreferences("percounter", 0);
        pecounter = saved.getInt("percounter", 0);

        // htcounter
        saved = getSharedPreferences("htcounter", 0);
        htcounter = saved.getInt("htcounter", 0);

        // fpcounter
        saved = getSharedPreferences("fpcounter", 0);
        fpcounter = saved.getInt("fpcounter", 0);

        update();
    }

    public void update() {
        // hp counter
        TextView a = (TextView) findViewById(R.id.hpview);
        a.setText(hpcounter + "");

        // st counter
        TextView b = (TextView) findViewById(R.id.stview);
        b.setText(stcounter + "");

        // dxcounter
        TextView c = (TextView) findViewById(R.id.dxview);
        b.setText(dxcounter + "");

        // wicounter
        TextView d = (TextView) findViewById(R.id.willview);
        b.setText(wicounter + "");

        // iqcounter
        TextView e = (TextView) findViewById(R.id.iqview);
        b.setText(iqcounter + "");

        // pecounter
        TextView f = (TextView) findViewById(R.id.perview);
        b.setText(pecounter + "");

        // htcounter
        TextView g = (TextView) findViewById(R.id.htview);
        b.setText(htcounter + "");

        // fpcounter
        TextView h = (TextView) findViewById(R.id.fpview);
        b.setText(fpcounter + "");
    }

    // st controls

    // hp controls
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

    // dx controls

    // wi controls

    // iq controls

    // pe controls

    // ht controls

    // fp controls

}

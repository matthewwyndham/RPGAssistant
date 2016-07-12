package combobreaker.rpgassistant;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GURPS extends AppCompatActivity {
    // this is actually the character sheet... my bad, wrong name...
    int stcounter;
    int hpcounter;
    int dxcounter;
    int wicounter;
    int iqcounter;
    int pecounter;
    int htcounter;
    int fpcounter;
    int chpcounter;
    int cfpcounter;
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

        // chpcounter
        saved = getSharedPreferences("hfpcounter", 0);
        fpcounter = saved.getInt("chpcounter", 0);

        // cfpcounter
        saved = getSharedPreferences("cfpcounter", 0);
        fpcounter = saved.getInt("cfpcounter", 0);

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
        c.setText(dxcounter + "");

        // wicounter
        TextView d = (TextView) findViewById(R.id.willview);
        d.setText(wicounter + "");

        // iqcounter
        TextView e = (TextView) findViewById(R.id.iqview);
        e.setText(iqcounter + "");

        // pecounter
        TextView f = (TextView) findViewById(R.id.perview);
        f.setText(pecounter + "");

        // htcounter
        TextView g = (TextView) findViewById(R.id.htview);
        g.setText(htcounter + "");

        // fpcounter
        TextView h = (TextView) findViewById(R.id.fpview);
        h.setText(fpcounter + "");

        //chpcounter
        TextView i = (TextView) findViewById(R.id.chpview);
        i.setText(chpcounter + "");

        // cfpcounter
        TextView j = (TextView) findViewById(R.id.cfpview);
        j.setText(cfpcounter + "");
    }

    // st controls
    public void plusst(View v) {
        stcounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("stcounter", stcounter);
        editor.apply();
        update();
    }

    public void minusst(View v) {
        stcounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("stcounter", stcounter);
        editor.apply();
        update();
    }

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
    public void plusdx(View v) {
        dxcounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("dxcounter", dxcounter);
        editor.apply();
        update();
    }

    public void minusdx(View v) {
        dxcounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("dxcounter", dxcounter);
        editor.apply();
        update();
    }

    // wi controls
    public void pluswi(View v) {
        wicounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("wicounter", wicounter);
        editor.apply();
        update();
    }

    public void minuswi(View v) {
        wicounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("wicounter", wicounter);
        editor.apply();
        update();
    }

    // iq controls
    public void plusiq(View v) {
        iqcounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("iqcounter", iqcounter);
        editor.apply();
        update();
    }

    public void minusiq(View v) {
        iqcounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("iqcounter", iqcounter);
        editor.apply();
        update();
    }

    // pe controls
    public void pluspe(View v) {
        pecounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("ecounter", pecounter);
        editor.apply();
        update();
    }

    public void minuspe(View v) {
        pecounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("pecounter", pecounter);
        editor.apply();
        update();
    }

    // ht controls
    public void plusht(View v) {
        htcounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("htcounter", htcounter);
        editor.apply();
        update();
    }

    public void minusht(View v) {
        htcounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("htcounter", htcounter);
        editor.apply();
        update();
    }

    // fp controls
    public void plusfp(View v) {
        fpcounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("fpcounter", fpcounter);
        editor.apply();
        update();
    }

    public void minusfp(View v) {
        fpcounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("fpcounter", fpcounter);
        editor.apply();
        update();
    }

    // Current HP controls
    public void pluschp(View v) {
        chpcounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("chpcounter", chpcounter);
        editor.apply();
        update();
    }

    public void minuschp(View v) {
        chpcounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("chpcounter", chpcounter);
        editor.apply();
        update();
    }

    // Current FP controls
    public void pluscfp(View v) {
        cfpcounter++;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("cfpcounter", cfpcounter);
        editor.apply();
        update();
    }

    public void minuscfp(View v) {
        cfpcounter--;
        SharedPreferences.Editor editor = saved.edit();
        editor.putInt("cfpcounter", cfpcounter);
        editor.apply();
        update();
    }

}

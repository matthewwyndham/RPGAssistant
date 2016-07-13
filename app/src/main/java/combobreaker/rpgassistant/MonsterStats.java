package combobreaker.rpgassistant;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MonsterStats extends AppCompatActivity {
    ArrayList<Amonster> list;
    SharedPreferences saved;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_stats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = getIntent().getParcelableArrayListExtra("monsters");
        position = getIntent().getIntExtra("which", 0);

        EditText a = (EditText) findViewById(R.id.monstername);
        a.setText(list.get(position).nameofmonster);
        a = (EditText) findViewById(R.id.monsterlevel);
        a.setText(list.get(position).level);
        a = (EditText) findViewById(R.id.monsterdescription);
        a.setText(list.get(position).description);
        a = (EditText) findViewById(R.id.monstertheClass);
        a.setText(list.get(position).theClass);
        a = (EditText) findViewById(R.id.monsterst);
        a.setText(list.get(position).st);
        a = (EditText) findViewById(R.id.monsterdx);
        a.setText(list.get(position).dx);
        a = (EditText) findViewById(R.id.monsteriq);
        a.setText(list.get(position).iq);
        a = (EditText) findViewById(R.id.monsterht);
        a.setText(list.get(position).ht);
        a = (EditText) findViewById(R.id.monsterdodge);
        a.setText(list.get(position).dodge);
        a = (EditText) findViewById(R.id.monsterhp);
        a.setText(list.get(position).hp);
        a = (EditText) findViewById(R.id.monsterwill);
        a.setText(list.get(position).will);
        a = (EditText) findViewById(R.id.monsterper);
        a.setText(list.get(position).per);
        a = (EditText) findViewById(R.id.monsterfp);
        a.setText(list.get(position).fp);
        a = (EditText) findViewById(R.id.monsterparry);
        a.setText(list.get(position).parry);
        a = (EditText) findViewById(R.id.monsterspeed);
        a.setText(list.get(position).speed);
        a = (EditText) findViewById(R.id.monstermove);
        a.setText(list.get(position).move);
        a = (EditText) findViewById(R.id.monstersm);
        a.setText(list.get(position).sm);
        a = (EditText) findViewById(R.id.monsterdr);
        a.setText(list.get(position).dr);
        a = (EditText) findViewById(R.id.monsterattacks);
        a.setText(list.get(position).attacks);
        a = (EditText) findViewById(R.id.monstertraits);
        a.setText(list.get(position).traits);
        a = (EditText) findViewById(R.id.monsterskills);
        a.setText(list.get(position).skills);
        a = (EditText) findViewById(R.id.monsternotes);
        a.setText(list.get(position).notes);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a = (EditText) findViewById(R.id.monstername);
                list.get(position).nameofmonster = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterlevel);
                list.get(position).level = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterdescription);
                list.get(position).description = a.getText().toString();
                a = (EditText) findViewById(R.id.monstertheClass);
                list.get(position).theClass = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterst);
                list.get(position).st = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterdx);
                list.get(position).dx = a.getText().toString();
                a = (EditText) findViewById(R.id.monsteriq);
                list.get(position).iq = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterht);
                list.get(position).ht = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterdodge);
                list.get(position).dodge = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterhp);
                list.get(position).hp = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterwill);
                list.get(position).will = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterper);
                list.get(position).per = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterfp);
                list.get(position).fp = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterparry);
                list.get(position).parry = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterspeed);
                list.get(position).speed = a.getText().toString();
                a = (EditText) findViewById(R.id.monstermove);
                list.get(position).move = a.getText().toString();
                a = (EditText) findViewById(R.id.monstersm);
                list.get(position).sm = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterdr);
                list.get(position).dr = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterattacks);
                list.get(position).attacks = a.getText().toString();
                a = (EditText) findViewById(R.id.monstertraits);
                list.get(position).traits = a.getText().toString();
                a = (EditText) findViewById(R.id.monsterskills);
                list.get(position).skills = a.getText().toString();
                a = (EditText) findViewById(R.id.monsternotes);
                list.get(position).notes = a.getText().toString();
                saveMonsters();
                Toast.makeText(MonsterStats.this, "Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void saveMonsters() {
        saved = getSharedPreferences("monsterlist", 0);
        String saving = "";
        for (Amonster mon : list) {
            saving += mon.getCode();
            saving += "^^^";
        }
        SharedPreferences.Editor editor = saved.edit();
        editor.putString("monsterlist", saving);
        editor.apply();
    }
}

package combobreaker.rpgassistant;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CharacterStats extends AppCompatActivity {
    ArrayList<Acharacter> list;
    SharedPreferences saved;
    int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = getIntent().getParcelableArrayListExtra("characters");
        position = getIntent().getIntExtra("which", 0);

        EditText a = (EditText) findViewById(R.id.charactername);
        a.setText(list.get(position).nameofcharacter);
        a = (EditText) findViewById(R.id.characterlevel);
        a.setText(list.get(position).level);
        a = (EditText) findViewById(R.id.characterdescription);
        a.setText(list.get(position).description);
        a = (EditText) findViewById(R.id.charactertheClass);
        a.setText(list.get(position).theClass);
        a = (EditText) findViewById(R.id.characterst);
        a.setText(list.get(position).st);
        a = (EditText) findViewById(R.id.characterdx);
        a.setText(list.get(position).dx);
        a = (EditText) findViewById(R.id.characteriq);
        a.setText(list.get(position).iq);
        a = (EditText) findViewById(R.id.characterht);
        a.setText(list.get(position).ht);
        a = (EditText) findViewById(R.id.characterdodge);
        a.setText(list.get(position).dodge);
        a = (EditText) findViewById(R.id.characterhp);
        a.setText(list.get(position).hp);
        a = (EditText) findViewById(R.id.characterwill);
        a.setText(list.get(position).will);
        a = (EditText) findViewById(R.id.characterper);
        a.setText(list.get(position).per);
        a = (EditText) findViewById(R.id.characterfp);
        a.setText(list.get(position).fp);
        a = (EditText) findViewById(R.id.characterparry);
        a.setText(list.get(position).parry);
        a = (EditText) findViewById(R.id.characterspeed);
        a.setText(list.get(position).speed);
        a = (EditText) findViewById(R.id.charactermove);
        a.setText(list.get(position).move);
        a = (EditText) findViewById(R.id.charactersm);
        a.setText(list.get(position).sm);
        a = (EditText) findViewById(R.id.characterdr);
        a.setText(list.get(position).dr);
        a = (EditText) findViewById(R.id.characterattacks);
        a.setText(list.get(position).attacks);
        a = (EditText) findViewById(R.id.charactertraits);
        a.setText(list.get(position).traits);
        a = (EditText) findViewById(R.id.characterskills);
        a.setText(list.get(position).skills);
        a = (EditText) findViewById(R.id.characternotes);
        a.setText(list.get(position).notes);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a = (EditText) findViewById(R.id.charactername);
                list.get(position).nameofcharacter = a.getText().toString();
                a = (EditText) findViewById(R.id.characterlevel);
                list.get(position).level = a.getText().toString();
                a = (EditText) findViewById(R.id.characterdescription);
                list.get(position).description = a.getText().toString();
                a = (EditText) findViewById(R.id.charactertheClass);
                list.get(position).theClass = a.getText().toString();
                a = (EditText) findViewById(R.id.characterst);
                list.get(position).st = a.getText().toString();
                a = (EditText) findViewById(R.id.characterdx);
                list.get(position).dx = a.getText().toString();
                a = (EditText) findViewById(R.id.characteriq);
                list.get(position).iq = a.getText().toString();
                a = (EditText) findViewById(R.id.characterht);
                list.get(position).ht = a.getText().toString();
                a = (EditText) findViewById(R.id.characterdodge);
                list.get(position).dodge = a.getText().toString();
                a = (EditText) findViewById(R.id.characterhp);
                list.get(position).hp = a.getText().toString();
                a = (EditText) findViewById(R.id.characterwill);
                list.get(position).will = a.getText().toString();
                a = (EditText) findViewById(R.id.characterper);
                list.get(position).per = a.getText().toString();
                a = (EditText) findViewById(R.id.characterfp);
                list.get(position).fp = a.getText().toString();
                a = (EditText) findViewById(R.id.characterparry);
                list.get(position).parry = a.getText().toString();
                a = (EditText) findViewById(R.id.characterspeed);
                list.get(position).speed = a.getText().toString();
                a = (EditText) findViewById(R.id.charactermove);
                list.get(position).move = a.getText().toString();
                a = (EditText) findViewById(R.id.charactersm);
                list.get(position).sm = a.getText().toString();
                a = (EditText) findViewById(R.id.characterdr);
                list.get(position).dr = a.getText().toString();
                a = (EditText) findViewById(R.id.characterattacks);
                list.get(position).attacks = a.getText().toString();
                a = (EditText) findViewById(R.id.charactertraits);
                list.get(position).traits = a.getText().toString();
                a = (EditText) findViewById(R.id.characterskills);
                list.get(position).skills = a.getText().toString();
                a = (EditText) findViewById(R.id.characternotes);
                list.get(position).notes = a.getText().toString();
                saveCharacters();
                Toast.makeText(CharacterStats.this, "Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void saveCharacters() {
        saved = getSharedPreferences("characterlist", 0);
        String saving = "";
        for (Acharacter mon : list) {
            saving += mon.getCode();
            saving += "^^^";
        }
        SharedPreferences.Editor editor = saved.edit();
        editor.putString("characterlist", saving);
        editor.apply();
    }
}

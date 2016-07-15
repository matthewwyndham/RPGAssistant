package combobreaker.rpgassistant;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class editWeapon extends AppCompatActivity {
    ArrayList<Weapon> list;
    SharedPreferences saved;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_weapon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = getIntent().getParcelableArrayListExtra("weaponlist");
        position = getIntent().getIntExtra("which", 0);

        EditText a = (EditText) findViewById(R.id.TechLevel);
        a.setText(list.get(position).TechLevel);
        a = (EditText) findViewById(R.id.Class);
        a.setText(list.get(position).Class);
        a = (EditText) findViewById(R.id.Type);
        a.setText(list.get(position).Type);
        a = (EditText) findViewById(R.id.Cost);
        a.setText(list.get(position).Cost);
        a = (EditText) findViewById(R.id.Weight);
        a.setText(list.get(position).Weight);
        a = (EditText) findViewById(R.id.Modifier);
        a.setText(list.get(position).Modifier);
        a = (EditText) findViewById(R.id.ST);
        a.setText(list.get(position).ST);
        a = (EditText) findViewById(R.id.Legality);
        a.setText(list.get(position).Legality);
        a = (EditText) findViewById(R.id.Damage);
        a.setText(list.get(position).Damage);
        a = (EditText) findViewById(R.id.Reach);
        a.setText(list.get(position).Reach);
        a = (EditText) findViewById(R.id.Parry);
        a.setText(list.get(position).Parry);
        a = (EditText) findViewById(R.id.Accuracy);
        a.setText(list.get(position).Accuracy);
        a = (EditText) findViewById(R.id.Range);
        a.setText(list.get(position).Range);
        a = (EditText) findViewById(R.id.RateOfFire);
        a.setText(list.get(position).RateOfFire);
        a = (EditText) findViewById(R.id.Shots);
        a.setText(list.get(position).Shots);
        a = (EditText) findViewById(R.id.Bulk);
        a.setText(list.get(position).Bulk);
        a = (EditText) findViewById(R.id.Recoil);
        a.setText(list.get(position).Recoil);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a = (EditText) findViewById(R.id.TechLevel);
                list.get(position).TechLevel = a.getText().toString();
                a = (EditText) findViewById(R.id.Class);
                list.get(position).Class = a.getText().toString();
                a = (EditText) findViewById(R.id.Type);
                list.get(position).Type = a.getText().toString();
                a = (EditText) findViewById(R.id.Cost);
                list.get(position).Cost = a.getText().toString();
                a = (EditText) findViewById(R.id.Weight);
                list.get(position).Weight = a.getText().toString();
                a = (EditText) findViewById(R.id.Modifier);
                list.get(position).Modifier = a.getText().toString();
                a = (EditText) findViewById(R.id.ST);
                list.get(position).ST = a.getText().toString();
                a = (EditText) findViewById(R.id.Legality);
                list.get(position).Legality = a.getText().toString();
                a = (EditText) findViewById(R.id.Damage);
                list.get(position).Damage = a.getText().toString();
                a = (EditText) findViewById(R.id.Reach);
                list.get(position).Reach = a.getText().toString();
                a = (EditText) findViewById(R.id.Parry);
                list.get(position).Parry = a.getText().toString();
                a = (EditText) findViewById(R.id.Accuracy);
                list.get(position).Accuracy = a.getText().toString();
                a = (EditText) findViewById(R.id.Range);
                list.get(position).Range = a.getText().toString();
                a = (EditText) findViewById(R.id.RateOfFire);
                list.get(position).RateOfFire = a.getText().toString();
                a = (EditText) findViewById(R.id.Shots);
                list.get(position).Shots = a.getText().toString();
                a = (EditText) findViewById(R.id.Bulk);
                list.get(position).Bulk = a.getText().toString();
                a = (EditText) findViewById(R.id.Recoil);
                list.get(position).Recoil = a.getText().toString();

                saveWeapons();
                Toast.makeText(editWeapon.this, "Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void saveWeapons() {
        saved = getSharedPreferences("weaponlist", 0);
        String saving = "";
        for (Weapon item : list) {
            saving += item.getCode();
            saving += "^^^";
        }
        SharedPreferences.Editor editor = saved.edit();
        editor.putString("weaponlist", saving);
        editor.apply();
    }
}

package combobreaker.rpgassistant;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class Monsters extends AppCompatActivity {
    ArrayList<Amonster> list;
    AmonsterAdapter adapter;
    SharedPreferences saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monsters);

        list = new ArrayList<Amonster>();

        //instantiate custom adapter
        adapter = new AmonsterAdapter(list, this);

        //loadMonsters();

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.realListOfMonsters);
        lView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadMonsters();
    }

    // load the monsters from saved preferences
    private void loadMonsters() {
        list.clear();
        saved = getSharedPreferences("monsterlist", 0);
        String loading = saved.getString("monsterlist", "");

        if (loading.equals("")) {
            Amonster mon = new Amonster();
            mon.random();
            mon.nameofmonster = "Dragon";
            mon.traits = "Max Awesomeness(12)";
            loading = mon.getCode();
            loading += "^^^";
        }

        String[] loadingStrings = loading.split("\\^\\^\\^");
        for (String mon : loadingStrings) {
            Amonster current = new Amonster();
            current.loadCode(mon);
            list.add(current);
        }

        adapter.notifyDataSetChanged();
        Toast.makeText(Monsters.this, "Monsters Updated", Toast.LENGTH_SHORT).show();
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

    // randomly generated monster
    public void genrandmon(View v) {
        Amonster mon = new Amonster();
        mon.random();
        list.add(mon);
        adapter.notifyDataSetChanged();
        saveMonsters();
    }

    // save monsters
    public void updateMonsters(View v) {
        loadMonsters();
        adapter.notifyDataSetChanged();
    }


    public void deleteall(View v) {
        list.clear();
        adapter.notifyDataSetChanged();
        saveMonsters();
    }
}
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

import java.util.ArrayList;
import java.util.Set;

public class Monsters extends AppCompatActivity {
    ArrayList<Amonster> list;
    MyCustomAdapter adapter;
    SharedPreferences saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monsters);

        list = new ArrayList<Amonster>();

        loadMonsters();

        //instantiate custom adapter
        adapter = new MyCustomAdapter(list, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.realListOfMonsters);
        lView.setAdapter(adapter);
    }

    // load the monsters from saved preferences
    private void loadMonsters() {
        saved = getSharedPreferences("monsterlist", 0);
        String loading = saved.getString("monsterlist", "");

        // todo: read in the files, split by delimiter for different parts of monster.
        String[] loadingStrings = loading.split("\\^\\^\\^");
        for (String mon : loadingStrings) {
            Amonster current = new Amonster();
            current.loadCode(mon);
            // add data
            list.add(current);
        }
    }

    private void saveMonsters() {
        saved = getSharedPreferences("monsterlist", 0);
        String saving = "";
        for (Amonster mon : list) {
            saving += mon.getCode();
            saving += "^^^";
        }

    }

    // randomly generated monster
    public void genrandmon(View v) {
        Amonster mon = new Amonster();
        list.add(mon);
        adapter.notifyDataSetChanged();
    }

    // todo: blank monster

    // todo: delete all

}
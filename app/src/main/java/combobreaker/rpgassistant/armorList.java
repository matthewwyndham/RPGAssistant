package combobreaker.rpgassistant;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class armorList extends AppCompatActivity {
    ArrayList<Armor> list;
    armorAdapter adapter;
    SharedPreferences saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armor_list);

        list = new ArrayList<Armor>();

        //instantiate custom adapter
        adapter = new armorAdapter(list, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.armorListView);
        lView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadArmors();
    }

    // load the list from saved preferences
    private void loadArmors() {
        list.clear();
        saved = getSharedPreferences("armorlist", 0);
        String loading = saved.getString("armorlist", "");

        if (loading.equals("")) {
            Armor item = new Armor();
            item.randomize();
            loading = item.getCode();
            loading += "^^^";
        }

        String[] loadingStrings = loading.split("\\^\\^\\^");
        for (String item : loadingStrings) {
            Armor current = new Armor();
            current.loadCode(item);
            list.add(current);
        }

        adapter.notifyDataSetChanged();
        Toast.makeText(armorList.this, "Armors Updated", Toast.LENGTH_SHORT).show();
    }

    // store the list in a shared preference string
    private void saveArmors() {
        saved = getSharedPreferences("armorlist", 0);
        String saving = "";
        for (Armor item : list) {
            saving += item.getCode();
            saving += "^^^";
        }
        SharedPreferences.Editor editor = saved.edit();
        editor.putString("armorlist", saving);
        editor.apply();
    }

    // randomly generate one
    public void randomArmor(View v) {
        Armor item = new Armor();
        list.add(item);
        adapter.notifyDataSetChanged();
        saveArmors();
    }

    // refresh the list
    public void updateArmors(View v) {
        loadArmors();
        adapter.notifyDataSetChanged();
    }

    // delete all
    public void clearArmors(View v) {
        list.clear();
        adapter.notifyDataSetChanged();
        saveArmors();
    }
}

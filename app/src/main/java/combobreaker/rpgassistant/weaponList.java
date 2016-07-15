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

public class weaponList extends AppCompatActivity {
    ArrayList<Weapon> list;
    weaponAdapter adapter;
    SharedPreferences saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_list);

        list = new ArrayList<Weapon>();

        //instantiate custom adapter
        adapter = new weaponAdapter(list, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.weaponListView);
        lView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadWeapons();
    }

    // load the list from saved preferences
    private void loadWeapons() {
        list.clear();
        saved = getSharedPreferences("weaponlist", 0);
        String loading = saved.getString("weaponlist", "");

        if (loading.equals("")) {
            Weapon item = new Weapon();
            item.Type = "Wooden";
            item.Class = "Stick";
            item.TechLevel = "0";
            item.Cost = "0";
            item.Weight = "5 lbs";
            item.Modifier = "+1 pointiness";
            item.ST = "0";
            item.Legality = "5";
            loading = item.getCode();
            loading += "^^^";
        }

        String[] loadingStrings = loading.split("\\^\\^\\^");
        for (String item : loadingStrings) {
            Weapon current = new Weapon();
            current.loadCode(item);
            list.add(current);
        }

        adapter.notifyDataSetChanged();
        Toast.makeText(weaponList.this, "Weapons Updated", Toast.LENGTH_SHORT).show();
    }

    // store the list in a shared preference string
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

    // randomly generate one
    public void randomWeapon(View v) {
        Weapon item = new Weapon();
        list.add(item);
        adapter.notifyDataSetChanged();
        saveWeapons();
    }

    // refresh the list
    public void updateWeapons(View v) {
        loadWeapons();
        adapter.notifyDataSetChanged();
    }

    // delete all
    public void clearWeapons(View v) {
        list.clear();
        adapter.notifyDataSetChanged();
        saveWeapons();
    }
}

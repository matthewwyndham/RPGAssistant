package combobreaker.rpgassistant;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Characters extends AppCompatActivity {
    ArrayList<Acharacter> list;
    AcharacterAdapter adapter;
    SharedPreferences saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        list = new ArrayList<Acharacter>();

        //instantiate custom adapter
        adapter = new AcharacterAdapter(list, this);

        //handle listview and assign adapter
      //  ListView lView = (ListView)findViewById(R.id.realListOfcharacters);
       // lView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadCharacters();
    }

    // load the monsters from saved preferences
    private void loadCharacters() {
        list.clear();
        saved = getSharedPreferences("characterlist", 0);
        String loading = saved.getString("characterlist", "");

        if (loading.equals("")) {
            Acharacter mon = new Acharacter();
            mon.random();
            mon.nameofcharacter = "Dragon";
            mon.traits = "Max Awesomeness(12)";
            loading = mon.getCode();
            loading += "^^^";
        }

        String[] loadingStrings = loading.split("\\^\\^\\^");
        for (String mon : loadingStrings) {
            Acharacter current = new Acharacter();
            current.loadCode(mon);
            list.add(current);
        }

        adapter.notifyDataSetChanged();
        Toast.makeText(Characters.this, "Characters Updated", Toast.LENGTH_SHORT).show();
    }

    private void saveCharacter() {
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

    // randomly generated monster
    public void generateCharacter(View v) {
        Acharacter mon = new Acharacter();
        mon.random();
        list.add(mon);
        adapter.notifyDataSetChanged();
        saveCharacter();
    }

    // save monsters
    public void updateCharacters(View v) {
        loadCharacters();
        adapter.notifyDataSetChanged();
    }


    public void clearCharacters(View v) {
        list.clear();
        adapter.notifyDataSetChanged();
        saveCharacter();
    }
}
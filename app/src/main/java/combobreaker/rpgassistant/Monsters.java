package combobreaker.rpgassistant;

import android.content.Context;
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

public class Monsters extends AppCompatActivity {
    ArrayList<String> list;
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monsters);

        list = new ArrayList<String>();
        list.add("Monster");
        list.add("Dragon");

        //instantiate custom adapter
        adapter = new MyCustomAdapter(list, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.realListOfMonsters);
        lView.setAdapter(adapter);
    }

    // randomly generated monster
    public void genrandmon(View v) {
        list.add("Name");
        adapter.notifyDataSetChanged();
    }

    // todo: blank monster

    // todo: delete all

}
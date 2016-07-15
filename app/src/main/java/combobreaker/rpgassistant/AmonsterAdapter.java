package combobreaker.rpgassistant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matt on 7/7/2016.
 */
// This code is to make my list of monsters have buttons in it
// http://stackoverflow.com/questions/17525886/listview-with-add-and-delete-buttons-in-each-row-in-android


public class AmonsterAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<Amonster> list = new ArrayList<Amonster>();
    private Context context;
    SharedPreferences saved;

    public AmonsterAdapter(ArrayList<Amonster> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0; //list.get(pos).getId();
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.monsterlistitem, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position).nameofmonster);

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);
        Button viewBtn = (Button)view.findViewById(R.id.view_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task
                notifyDataSetChanged();
                saveMonsters();
            }
        });
        viewBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MonsterStats.class);
                intent.putParcelableArrayListExtra("monsters", list);
                intent.putExtra("which", position);
                context.startActivity(intent);
            }
        });

        return view;
    }

    private void saveMonsters() {
        saved = context.getSharedPreferences("monsterlist", 0);

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

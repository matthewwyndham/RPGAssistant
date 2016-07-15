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
 * Created by Matt on 7/14/2016.
 */
public class weaponAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<Weapon> list = new ArrayList<Weapon>();
    private Context context;
    SharedPreferences saved;

    public weaponAdapter(ArrayList<Weapon> list, Context context) {
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
            view = inflater.inflate(R.layout.weaponlistitem, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position).getNameOf());

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);
        Button viewBtn = (Button)view.findViewById(R.id.view_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task
                notifyDataSetChanged();
                saveWeapons();
            }
        });
        viewBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), editWeapon.class);
                intent.putParcelableArrayListExtra("weapons", list);
                intent.putExtra("which", position);
                context.startActivity(intent);
            }
        });

        return view;
    }

    private void saveWeapons() {
        saved = context.getSharedPreferences("weaponlist", 0);

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

package combobreaker.rpgassistant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class Adds extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.navigateAdds);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Languages");
        listDataHeader.add("Advantages and Perks");
        listDataHeader.add("Disadvantages and Quirks");
        listDataHeader.add("Skills");
        listDataHeader.add("Hand Weapon");
        listDataHeader.add("Range Weapon");
        listDataHeader.add("Armor and Possessions");
        listDataHeader.add("Other Notes");

        // Languages
        List<String> languages = new ArrayList<String>();
        languages.add("Basic");
        languages.add("Binary");
        languages.add("Elvish");
        languages.add("Spanish");

        // Advantages and Perks
        List<String> Ads = new ArrayList<String>();
        Ads.add("Bash");
        Ads.add("Cleave");
        Ads.add("Great Cleave");
        Ads.add("Rage");
        Ads.add("Dark Vision");
        Ads.add("Magic Sensitive");

        // Disadvantages and Quirks
        List<String> dis = new ArrayList<String>();
        dis.add("Two Left Feet");
        dis.add("Four Eyes");

        // Skills
        List<String> skills = new ArrayList<String>();
        skills.add("Small Weapon Proficient");
        skills.add("Weapon Focus: Bow Staff");
        skills.add("Weapon Focus: Nun Chuck");
        skills.add("Technology Focus: Computer Hacking");

        // Hand Weapons
        List<String> hand = new ArrayList<String>();
        hand.add("Dagger");
        hand.add("Long Sword");
        hand.add("Excalibur");

        // Range Weapons
        List<String> range = new ArrayList<String>();
        range.add("Batarang");
        range.add("Crossbow");

        // Armor and Possessions
        List<String> armor = new ArrayList<String>();
        armor.add("Full Plate");

        // Other Notes
        List<String> other = new ArrayList<String>();
        other.add("Poisoned will looking for an apple");
        other.add("Has voices in their head that tells them to do bad things!");

        listDataChild.put(listDataHeader.get(0), languages); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Ads);
        listDataChild.put(listDataHeader.get(2), dis);
        listDataChild.put(listDataHeader.get(3), skills);
        listDataChild.put(listDataHeader.get(4), hand);
        listDataChild.put(listDataHeader.get(5), range);
        listDataChild.put(listDataHeader.get(6), armor);
        listDataChild.put(listDataHeader.get(7), other);

    }
}
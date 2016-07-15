package combobreaker.rpgassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LootNavigator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loot_navigator);
    }

    public void navigateWeapons(View v) {
        startActivity(new Intent(LootNavigator.this, weaponList.class));
    }

    public void navigateArmor(View v) {
        startActivity(new Intent(LootNavigator.this, armorList.class));
    }
}

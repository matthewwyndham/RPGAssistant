package combobreaker.rpgassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class diceEmulator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_emulator);
        setTitle("Dice Emulator");
    }

    // d2
    public void gen2(View v) {
        TextView buddy = (TextView) findViewById(R.id.d2view);
        Random rand = new Random();
        int n = rand.nextInt(2) + 1;
        buddy.setText(n + "");
    }

    // d3
    public void gen3(View v) {
        TextView buddy = (TextView) findViewById(R.id.d3view);
        Random rand = new Random();
        int n = rand.nextInt(3) + 1;
        buddy.setText(n + "");
    }

    // d4
    public void gen4(View v) {
        TextView buddy = (TextView) findViewById(R.id.d4view);
        Random rand = new Random();
        int n = rand.nextInt(4) + 1;
        buddy.setText(n + "");
    }

    // d6
    public void gen6(View v) {
        TextView buddy = (TextView) findViewById(R.id.d6view);
        Random rand = new Random();
        int n = rand.nextInt(6) + 1;
        buddy.setText(n + "");
    }

    // d8
    public void gen8(View v) {
        TextView buddy = (TextView) findViewById(R.id.d8view);
        Random rand = new Random();
        int n = rand.nextInt(8) + 1;
        buddy.setText(n + "");
    }

    // d10
    public void gen10(View v) {
        TextView buddy = (TextView) findViewById(R.id.d10view);
        Random rand = new Random();
        int n = rand.nextInt(10) + 1;
        buddy.setText(n + "");
    }

    // d20
    public void gen20(View v) {
        TextView buddy = (TextView) findViewById(R.id.d20view);
        Random rand = new Random();
        int n = rand.nextInt(20) + 1;
        buddy.setText(n + "");
    }

    // c100
    public void gen100(View v) {
        TextView buddy = (TextView) findViewById(R.id.d100view);
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        buddy.setText(n + "");
    }

}

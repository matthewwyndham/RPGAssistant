package combobreaker.rpgassistant;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Random;

public class Acharacter implements Parcelable {

    public String nameofcharacter; // a
    public String description; // b
    public String st; // c
    public String dx; // d
    public String iq; // e
    public String ht; // f
    public String dodge; // g
    public String hp; // h
    public String will; // i
    public String per; // j
    public String fp; // k
    public String parry; // l
    public String speed; // m
    public String move; // n
    public String sm; // o
    public String dr; // p
    public String attacks; // q
    public String traits; // r
    public String skills; // s
    public String theClass; // t
    public String notes; // u
    public String level; // v
    //public String languages;
    //public String rNotes;

    public Acharacter() {
        nameofcharacter = "Smoking Man";
        description = "Description";
        st = "0";
        dx = "0";
        iq = "0";
        ht = "0";
        dodge = "0";
        hp = "0";
        will = "0";
        per = "0";
        fp = "0";
        parry = "0";
        speed = "0";
        move = "0";
        sm = "0";
        dr = "0";
        attacks = "30";
        traits = "Knowledge";
        skills = "Lung Cancer";
        theClass = "G-Man";
        notes = "Deception";
        level = "0";
    //    languages = "Basic";
    //    rNotes = "X-Files";
    }

    protected Acharacter(Parcel in) {
        nameofcharacter = in.readString();
        description = in.readString();
        st = in.readString();
        dx = in.readString();
        iq = in.readString();
        ht = in.readString();
        dodge = in.readString();
        hp = in.readString();
        will = in.readString();
        per = in.readString();
        fp = in.readString();
        parry = in.readString();
        speed = in.readString();
        move = in.readString();
        sm = in.readString();
        dr = in.readString();
        attacks = in.readString();
        traits = in.readString();
        skills = in.readString();
        theClass = in.readString();
        notes = in.readString();
        level = in.readString();
    //    languages = in.readString();
      //  rNotes = in.readString();
    }

    public static final Parcelable.Creator<Acharacter> CREATOR = new Parcelable.Creator<Acharacter>() {
        @Override
        public Acharacter createFromParcel(Parcel in) {
            return new Acharacter(in);
        }

        @Override
        public Acharacter[] newArray(int size) {
            return new Acharacter[size];
        }
    };

    public void random() {
        Random rand = new Random();
        int level = rand.nextInt(4) + 1;
        randomize(level);
    }

    public void randomize(int newlevel) {
        int max = newlevel * 10;
        level = (newlevel + "");
        Random rand = new Random();
        st = rand.nextInt(max) + "";
        dx = rand.nextInt(max) + "";
        iq = rand.nextInt(max) + "";
        ht = rand.nextInt(max) + "";
        dodge = rand.nextInt(max) + "";
        hp = rand.nextInt(max) + "";
        will = rand.nextInt(max) + "";
        per = rand.nextInt(max) + "";
        fp = rand.nextInt(max) + "";
        parry = rand.nextInt(max) + "";
        speed = rand.nextInt(max) + "";
        move = rand.nextInt(max) + "";
        sm = rand.nextInt(max) + "";
        dr = rand.nextInt(max) + "";
    }

    public String getCode() {
        StringBuilder sb = new StringBuilder(200);
        sb.append(nameofcharacter);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(st);
        sb.append("|");
        sb.append(dx);
        sb.append("|");
        sb.append(iq);
        sb.append("|");
        sb.append(ht);
        sb.append("|");
        sb.append(dodge);
        sb.append("|");
        sb.append(hp);
        sb.append("|");
        sb.append(will);
        sb.append("|");
        sb.append(per);
        sb.append("|");
        sb.append(fp);
        sb.append("|");
        sb.append(parry);
        sb.append("|");
        sb.append(speed);
        sb.append("|");
        sb.append(move);
        sb.append("|");
        sb.append(sm);
        sb.append("|");
        sb.append(dr);
        sb.append("|");
        sb.append(attacks);
        sb.append("|");
        sb.append(traits);
        sb.append("|");
        sb.append(skills);
        sb.append("|");
        sb.append(theClass);
        sb.append("|");
        sb.append(notes);
        sb.append("|");
      /*  sb.append(languages);
        sb.append("|");
        sb.append(rNotes);
        sb.append("|");*/

        return sb.toString();
    }

    public void loadCode(String code) {
        String[] data = code.split("\\|");
        nameofcharacter = data[0];
        description = data[1];
        st = data[2];
        dx = data[3];
        iq = data[4];
        ht = data[5];
        dodge = data[6];
        hp = data[7];
        will = data[8];
        per = data[9];
        fp = data[10];
        parry = data[11];
        speed = data[12];
        move = data[13];
        sm = data[14];
        dr = data[15];
        attacks = data[16];
        traits = data[17];
        skills = data[18];
        theClass = data[19];
        notes = data[20];
 //       languages = data[21];
   //     rNotes = data[22];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameofcharacter);
        dest.writeString(description);
        dest.writeString(st);
        dest.writeString(dx);
        dest.writeString(iq);
        dest.writeString(ht);
        dest.writeString(dodge);
        dest.writeString(hp);
        dest.writeString(will);
        dest.writeString(per);
        dest.writeString(fp);
        dest.writeString(parry);
        dest.writeString(speed);
        dest.writeString(move);
        dest.writeString(sm);
        dest.writeString(dr);
        dest.writeString(attacks);
        dest.writeString(traits);
        dest.writeString(skills);
        dest.writeString(theClass);
        dest.writeString(notes);
        dest.writeString(level);
     //   dest.writeString(languages);
      //  dest.writeString(rNotes);
    }
}
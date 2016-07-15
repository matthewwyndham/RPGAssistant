package combobreaker.rpgassistant;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Matt on 7/13/2016.
 */
public class Weapon implements Parcelable {
    public String TechLevel;
    public String Class; // name of weapon (bow / sword / gun / etc)
    public String Type; // What the weapon is made of / who it was made by (fur / bone / iron / Euclidean / etc)
    public String Cost;
    public String Weight;
    public String Modifier; // special effects
    public String ST; // strength required to use
    public String Legality;
    public String Damage;

    public String Reach; // melee
    public String Parry; // melee

    public String Accuracy; // ranged
    public String Range; // ranged
    public String RateOfFire; // ranged
    public String Shots; // ranged
    public String Bulk; // ranged
    public String Recoil; // Firearms only

    public String getNameOf() {
        return Type + " " + Class;
    }

    public Weapon() {
        randomize();
    }

    protected Weapon(Parcel in) {
        TechLevel = in.readString();
        Class = in.readString();
        Type = in.readString();
        Cost = in.readString();
        Weight = in.readString();
        Modifier = in.readString();
        ST = in.readString();
        Legality = in.readString();
        Damage = in.readString();
        Reach = in.readString();
        Parry = in.readString();
        Accuracy = in.readString();
        Range = in.readString();
        RateOfFire = in.readString();
        Shots = in.readString();
        Bulk = in.readString();
        Recoil = in.readString();
    }

    public static final Creator<Weapon> CREATOR = new Creator<Weapon>() {
        @Override
        public Weapon createFromParcel(Parcel in) {
            return new Weapon(in);
        }

        @Override
        public Weapon[] newArray(int size) {
            return new Weapon[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TechLevel);
        dest.writeString(Class);
        dest.writeString(Type);
        dest.writeString(Cost);
        dest.writeString(Weight);
        dest.writeString(Modifier);
        dest.writeString(ST);
        dest.writeString(Legality);
        dest.writeString(Damage);
        dest.writeString(Reach);
        dest.writeString(Parry);
        dest.writeString(Accuracy);
        dest.writeString(Range);
        dest.writeString(RateOfFire);
        dest.writeString(Shots);
        dest.writeString(Bulk);
        dest.writeString(Recoil);
    }

    public String getCode() {
        StringBuilder sb = new StringBuilder(400);
        sb.append(TechLevel); sb.append("|");
        sb.append(Class); sb.append("|");
        sb.append(Type); sb.append("|");
        sb.append(Cost); sb.append("|");
        sb.append(Weight); sb.append("|");
        sb.append(Modifier); sb.append("|");
        sb.append(ST); sb.append("|");
        sb.append(Legality); sb.append("|");
        sb.append(Damage); sb.append("|");
        sb.append(Reach); sb.append("|");
        sb.append(Parry); sb.append("|");
        sb.append(Accuracy); sb.append("|");
        sb.append(Range); sb.append("|");
        sb.append(RateOfFire); sb.append("|");
        sb.append(Shots); sb.append("|");
        sb.append(Bulk); sb.append("|");
        sb.append(Recoil); sb.append("|");
        return sb.toString();
    }

    public void loadCode(String code) {
        String[] data = code.split("\\|");
        TechLevel = data[0];
        Class = data[1];
        Type = data[2];
        Cost = data[3];
        Weight = data[4];
        Modifier = data[5];
        ST = data[6];
        Legality = data[7];
        Damage = data[8];
        Reach = data[9];
        Parry = data[10];
        Accuracy = data[11];
        Range = data[12];
        RateOfFire = data[13];
        Shots = data[14];
        Bulk = data[15];
        Recoil = data[16];
    }

    public void randomize() {

    }
}

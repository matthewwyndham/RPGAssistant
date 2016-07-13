package combobreaker.rpgassistant;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Matt on 7/13/2016.
 */
public class Weapon implements Parcelable, Loot{
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

    @Override
    public String getNameOf() {
        return Type + " " + Class;
    }

    @Override
    public String getTypeOf() {
        return "Weapon";
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
}

package combobreaker.rpgassistant;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

/**
 * Created by Matt on 7/13/2016.
 */
public class Armor implements Parcelable, Loot{
    public String TechLevel;
    public String Class; // (Loincloth / Chestplate / Greaves / Gloves / Shoes)
    public String Type; // material / maker (Gallifrayan / Adamantite / Metallic / etc)
    public String Modifier; // special affects
    public String Location; // Skull, Eyes, Face, Neck, Torso, Arms, Hands, Groin, Legs, Feet
    public String DR; // Damage Resistance

    public String Cost;
    public String Weight;
    public String LC; // Legality Class (4: Open / 3: Licensed / 2: Restricted / 1: Military / 0: Banned)
    public String Notes;

    public Armor() {
        randomLocation();
        Class = randomClass();
    }

    protected Armor(Parcel in) {
        TechLevel = in.readString();
        Class = in.readString();
        Type = in.readString();
        Modifier = in.readString();
        Location = in.readString();
        DR = in.readString();
        Cost = in.readString();
        Weight = in.readString();
        LC = in.readString();
        Notes = in.readString();
    }

    public static final Creator<Armor> CREATOR = new Creator<Armor>() {
        @Override
        public Armor createFromParcel(Parcel in) {
            return new Armor(in);
        }

        @Override
        public Armor[] newArray(int size) {
            return new Armor[size];
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
        dest.writeString(Modifier);
        dest.writeString(Location);
        dest.writeString(DR);
        dest.writeString(Cost);
        dest.writeString(Weight);
        dest.writeString(LC);
        dest.writeString(Notes);
    }

    private String randomClass() {
        Random randy = new Random();
        if (getLocation() == 0) { // skull
            int num = randy.nextInt(3);
            if (num == 0)
                return "Helmet";
            else if (num == 1)
                return "Cap";
            else if (num == 2)
                return "Pot";
        } else if (getLocation() == 1) { // eyes
            return "Glasses";
        } else if (getLocation() == 2) { // face
            return "Visor";
        } else if (getLocation() == 3) { // neck
            return "Scarf";
        } else if (getLocation() == 4) { // torso
            return "Chestplate";
        } else if (getLocation() == 5) { // arms
            return "Arms";
        } else if (getLocation() == 6) { // hands
            return "Gloves";
        } else if (getLocation() == 7) { // groin
            return "Belt";
        } else if (getLocation() == 8) { // legs
            return "Grieves";
        } else if (getLocation() == 9) { // feet
            return "Boots";
        }
        return "Flower";
    }

    private int getLocation() {
        if (Location.equals("Skull"))
            return 0;
        else if (Location.equals("Eyes"))
            return 1;
        else if (Location.equals("Face"))
            return 2;
        else if (Location.equals("Neck"))
            return 3;
        else if (Location.equals("Torso"))
            return 4;
        else if (Location.equals("Arms"))
            return 5;
        else if (Location.equals("Hands"))
            return 6;
        else if (Location.equals("Groin"))
            return 7;
        else if (Location.equals("Legs"))
            return 8;
        else if (Location.equals("Feet"))
            return 9;
        // shouldn't happen
        return 4;
    }

    private void randomLocation() {
        Random rand = new Random();
        int l = rand.nextInt(10);
        if (l == 0)
            Location = "Skull";
        else if (l == 1)
            Location = "Eyes";
        else if (l == 2)
            Location = "Face";
        else if (l == 3)
            Location = "Neck";
        else if (l == 4)
            Location = "Torso";
        else if (l == 5)
            Location = "Arms";
        else if (l == 6)
            Location = "Hands";
        else if (l == 7)
            Location = "Groin";
        else if (l == 8)
            Location = "Legs";
        else if (l == 9)
            Location = "Feet";
    }

    @Override
    public String getNameOf() {
        return Type + " " + Class;
    }

    @Override
    public String getTypeOf() {
        return "Armor";
    }
}

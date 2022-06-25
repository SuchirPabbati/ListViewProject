package com.example.listviewproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Valorant implements Parcelable{
    String name;
    String place;
    String health;
    String date;
    String info;
    int image;
    public Valorant(String name, String place, int image, String health, String date, String info){
        this.name = name;
        this.image = image;
        this.place = place;
        this.health = health;
        this.date = date;
        this.info = info;

    }

    protected Valorant(Parcel in) {
        name = in.readString();
        place = in.readString();
        health = in.readString();
        date = in.readString();
        info = in.readString();
        image = in.readInt();
    }

    public static final Creator<Valorant> CREATOR = new Creator<Valorant>() {
        @Override
        public Valorant createFromParcel(Parcel in) {
            return new Valorant(in);
        }

        @Override
        public Valorant[] newArray(int size) {
            return new Valorant[size];
        }
    };

    public String getName(){
        return name;
    }
    public String getHealth(){
        return health;
    }
    public String getDate(){
        return date;
    }
    public String getPlace(){
        return place;
    }
    public String getInfo(){
        return info;
    }
    public int getImage(){
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(place);
        parcel.writeString(health);
        parcel.writeString(date);
        parcel.writeString(info);
        parcel.writeInt(image);
    }
}

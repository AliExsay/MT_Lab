package com.example.lab3.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {

    private int id;
    private String name;
    private boolean check;

    public Car(int id, String name, boolean check) {
        this.id = id;
        this.name = name;
        this.check = check;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
    }

    public static final Parcelable.Creator<Car> CREATOR = new
            Parcelable.Creator<Car>() {
                // распаковываем объект из Parcel
                public Car createFromParcel(Parcel in) {
                    return new Car(in);
                }
                public Car[] newArray(int size) {
                    return new Car[size];
                }
            };
    // конструктор, считывающий данные из Parcel
    private Car(Parcel parcel) {
        id = parcel.readInt();
        name = parcel.readString();
        check = false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCheck() {
        return check;
    }
}

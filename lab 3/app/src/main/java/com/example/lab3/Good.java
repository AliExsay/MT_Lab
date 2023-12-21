package com.example.lab3;
import android.os.Parcel;
import android.os.Parcelable;

public class Good implements Parcelable {
    private int id;
    private String name;
    private boolean check;
    double price;
    int imageResource;

    public Good(int id, String name, double price, int imageResource, boolean check) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
        this.check = check;
    }

    protected Good(Parcel in) {
        id = in.readInt();
        name = in.readString();
        check = in.readByte() != 0;
        price = in.readDouble();
        imageResource = in.readInt();
    }

    public static final Creator<Good> CREATOR = new Creator<Good>() {
        @Override
        public Good createFromParcel(Parcel in) {
            return new Good(in);
        }

        @Override
        public Good[] newArray(int size) {
            return new Good[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCheck() {
        return check;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeByte((byte) (check ? 1 : 0));
        dest.writeDouble(price);
        dest.writeInt(imageResource);
    }
}


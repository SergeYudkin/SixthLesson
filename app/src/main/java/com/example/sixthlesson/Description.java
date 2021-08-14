package com.example.sixthlesson;

import android.os.Parcel;
import android.os.Parcelable;


public class Description implements Parcelable {


    public Description(int finalI, String cont) {
        this.cont = cont;
    }

    private String cont;

    protected Description(Parcel in) {
        cont = in.readString();
    }

    public Description(String test) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cont);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Description> CREATOR = new Creator<Description>() {
        @Override
        public Description createFromParcel(Parcel in) {
            return new Description(in);
        }

        @Override
        public Description[] newArray(int size) {
            return new Description[size];
        }
    };

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
}

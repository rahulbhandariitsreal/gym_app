package com.example.gym_app.modal;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class GymExercise implements Parcelable {
    private String name;
    private String bodyPart;
    private int sets;
    private int reps;
    private int rest;



    public int getType_of_holder() {
        return type_of_holder;
    }

    public void setType_of_holder(int type_of_holder) {
        this.type_of_holder = type_of_holder;
    }

    private int type_of_holder;

    public GymExercise(String name, String bodyPart, int sets, int reps, int rest) {
        this.name = name;
        this.bodyPart = bodyPart;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        type_of_holder=0;
    }

    protected GymExercise(Parcel in) {
        name = in.readString();
        bodyPart = in.readString();
        sets = in.readInt();
        reps = in.readInt();
        rest = in.readInt();
    }

    public static final Creator<GymExercise> CREATOR = new Creator<GymExercise>() {
        @Override
        public GymExercise createFromParcel(Parcel in) {
            return new GymExercise(in);
        }

        @Override
        public GymExercise[] newArray(int size) {
            return new GymExercise[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public int getRest() {
        return rest;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(bodyPart);
        dest.writeInt(sets);
        dest.writeInt(reps);
        dest.writeInt(rest);
    }
}


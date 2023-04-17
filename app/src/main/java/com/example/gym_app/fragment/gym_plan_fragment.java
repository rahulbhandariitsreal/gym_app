package com.example.gym_app.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gym_app.modal.GymExercise;
import com.example.gym_app.adapter.Multi_Adapter_Gym;
import com.example.gym_app.R;

import java.util.ArrayList;


public class gym_plan_fragment extends Fragment implements Multi_Adapter_Gym.ItemClickListener {

   private ArrayList<GymExercise> gymExercises = new ArrayList<>();
   private RecyclerView recyclerView;

   private Multi_Adapter_Gym adapter;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_gym_plan_fragment, container, false);
      recyclerView=view.findViewById(R.id.my_recycler_view);
        addexer();
        setRecycler();
        return view;
    }

    private void setRecycler() {
        adapter=new Multi_Adapter_Gym(gymExercises,getContext());
        adapter.setItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    public void addexer(){
        gymExercises.add(new GymExercise("Chest", "Barbell Bench Press", 3, 10, 60));
        gymExercises.add(new GymExercise("Chest", "Incline Dumbbell Press", 3, 12, 60));
        gymExercises.add(new GymExercise("Chest", "Cable Flyes", 3, 12, 60));
        gymExercises.add(new GymExercise("Chest", "Dumbbell Pullover", 3, 12, 60));

        gymExercises.add(new GymExercise("Back", "Lat Pulldowns", 3, 12, 60));
        gymExercises.add(new GymExercise("Back", "Seated Cable Rows", 3, 12, 60));
        gymExercises.add(new GymExercise("Back", "Deadlifts", 3, 10, 60));
        gymExercises.add(new GymExercise("Back", "Pull-Ups", 3, 12, 60));

        gymExercises.add(new GymExercise("Legs", "Squats", 3, 10, 60));
        gymExercises.add(new GymExercise("Legs", "Leg Press", 3, 12, 60));
        gymExercises.add(new GymExercise("Legs", "Romanian Deadlifts", 3, 12, 60));
        gymExercises.add(new GymExercise("Legs", "Calf Raises", 3, 15, 60));
        gymExercises.add(new GymExercise("Legs", "Leg Extensions", 3, 12, 60));

        gymExercises.add(new GymExercise("Shoulders", "Barbell Shoulder Press", 3, 10, 60));
        gymExercises.add(new GymExercise("Shoulders", "Lateral Raises", 3, 12, 60));
        gymExercises.add(new GymExercise("Shoulders", "Face Pulls", 3, 12, 60));
        gymExercises.add(new GymExercise("Shoulders", "Reverse Flyes", 3, 12, 60));

        gymExercises.add(new GymExercise("Biceps", "Barbell Curls", 3, 12, 60));
        gymExercises.add(new GymExercise("Biceps", "Dumbbell Curls", 3, 12, 60));
        gymExercises.add(new GymExercise("Biceps", "Hammer Curls", 3, 12, 60));
        gymExercises.add(new GymExercise("Biceps", "Preacher Curls", 3, 12, 60));

        gymExercises.add(new GymExercise("Triceps", "Close-Grip Bench Press", 3, 10, 60));
        gymExercises.add(new GymExercise("Triceps", "Triceps Pushdowns", 3, 12, 60));
        gymExercises.add(new GymExercise("Triceps", "Dips", 3, 12, 60));
        gymExercises.add(new GymExercise("Triceps", "Skull Crushers", 3, 12, 60));

        gymExercises.add(new GymExercise("Abs", "Crunches", 3, 15, 60));
        gymExercises.add(new GymExercise("Abs", "Leg Raises", 3, 15, 60));
        gymExercises.add(new GymExercise("Abs", "Plank", 3, 60, 60));
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(getContext(), ""+gymExercises.get(pos).getBodyPart(), Toast.LENGTH_SHORT).show();

        GymExercise gymExercise=gymExercises.get(pos);
        // create a builder for the alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

// set the title and message for the dialog
        builder.setTitle("Title");
        builder.setMessage("Message");
         TextView mBodyPartTextView;
         TextView mExerciseNameTextView;
         TextView mSetsTextView;
         TextView mRepsTextView;
         TextView mRestTextView;
         ImageView imageView;

// create a custom view for the dialog
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.exercise_list_item, null);

        mBodyPartTextView = itemView.findViewById(R.id.body_part_textview);
        mExerciseNameTextView = itemView.findViewById(R.id.exercise_name_textview);
        mSetsTextView = itemView.findViewById(R.id.sets_textview);
        mRepsTextView = itemView.findViewById(R.id.reps_textview);
        mRestTextView = itemView.findViewById(R.id.rest_textview);
        imageView = itemView.findViewById(R.id.exercise_image_view);

        mBodyPartTextView.setText(gymExercise.getBodyPart());
        mExerciseNameTextView.setText(gymExercise.getName());
        mSetsTextView.setText("Sets: " + gymExercise.getSets());
        mRepsTextView.setText("Reps: " + gymExercise.getReps());
        mRestTextView.setText("Rest: " + gymExercise.getRest() + "s");
        imageView.setImageResource(R.drawable.ic_launcher_background);

        builder.setView(itemView);

// add buttons to the dialog
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // handle the OK button click
                dialog.dismiss();
            }
        });


// create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
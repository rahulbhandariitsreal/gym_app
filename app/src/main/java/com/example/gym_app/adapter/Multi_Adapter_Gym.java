package com.example.gym_app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gym_app.R;
import com.example.gym_app.modal.GymExercise;

import java.util.ArrayList;

public class Multi_Adapter_Gym extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<GymExercise> mGymExercises;

    public static final int GYM_PLAN = 1;

    public static final int EXERXISE_ITEM = 2;
    private Context context;

    private ItemClickListener clickListener;




    public Multi_Adapter_Gym(ArrayList<GymExercise> mGymExercises, Context context) {
        this.mGymExercises = mGymExercises;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (viewType == GYM_PLAN) {
            v = LayoutInflater.from(context).inflate(R.layout.gym_plan_list_item, parent, false);
            return new Gymplan(v);
        }else{
            v = LayoutInflater.from(context).inflate(R.layout.exercise_list_item, parent, false);
            return new ExerciseDetials(v);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(mGymExercises.get(position).getType_of_holder() == 0){
            return GYM_PLAN;
        }
        return EXERXISE_ITEM;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
if(getItemViewType(position) == GYM_PLAN){
    ((Gymplan) holder).setExerxise(mGymExercises.get(position));
}else{

    ( (ExerciseDetials)holder).setdetailsofexercise(mGymExercises.get(position));
}
    }

    @Override
    public int getItemCount() {
        return mGymExercises.size();
    }


    public  class ExerciseDetials extends RecyclerView.ViewHolder {
        public TextView mBodyPartTextView;
        public TextView mExerciseNameTextView;
        public TextView mSetsTextView;
        public TextView mRepsTextView;
        public TextView mRestTextView;
        public ImageView imageView;

        public ExerciseDetials(View itemView) {
            super(itemView);
            mBodyPartTextView = itemView.findViewById(R.id.body_part_textview);
            mExerciseNameTextView = itemView.findViewById(R.id.exercise_name_textview);
            mSetsTextView = itemView.findViewById(R.id.sets_textview);
            mRepsTextView = itemView.findViewById(R.id.reps_textview);
            mRestTextView = itemView.findViewById(R.id.rest_textview);
            imageView = itemView.findViewById(R.id.exercise_image_view);
        }

       @SuppressLint("SetTextI18n")
       public void setdetailsofexercise(GymExercise gymExercise) {
            mBodyPartTextView.setText(gymExercise.getBodyPart());
            mExerciseNameTextView.setText(gymExercise.getName());
            mSetsTextView.setText("Sets: " + gymExercise.getSets());
            mRepsTextView.setText("Reps: " + gymExercise.getReps());
            mRestTextView.setText("Rest: " + gymExercise.getRest() + "s");
            imageView.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    public void setItemClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public  class Gymplan extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView level;
        public ImageView imageView;


        public Gymplan(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title_text_view);
            level = itemView.findViewById(R.id.subtitle_text_view);
            imageView = itemView.findViewById(R.id.plan_image_view);
            itemView.setOnClickListener(this);
        }

        void setExerxise(GymExercise exercise) {

            name.setText(exercise.getBodyPart());
            level.setText("Begginner");
            imageView.setImageResource(R.drawable.ic_launcher_background);

        }



        @Override
        public void onClick(View v) {
if(clickListener != null){
    clickListener.onClick(v,getAdapterPosition());

}
        }
    }
    public interface ItemClickListener{
        void onClick(View view,int pos);
    }
}


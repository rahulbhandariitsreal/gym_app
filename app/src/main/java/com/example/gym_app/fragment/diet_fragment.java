package com.example.gym_app.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gym_app.R;
import com.example.gym_app.modal.Diet;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class diet_fragment extends Fragment {


    // Create an ArrayList of Diet objects for bulking with real eating food
    ArrayList<Diet> bulkingDietList = new ArrayList<>();

    // Create an ArrayList of Diet objects for cutting with real eating food
    ArrayList<Diet> cuttingDietList = new ArrayList<>();

    // Create an ArrayList of Diet objects for maintaining with real eating food
    ArrayList<Diet> maintainingDietList = new ArrayList<>();

    private ImageView bulk,cut,maintain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_diet_fragment, container, false);

        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                creatBulkingdiet();
                cuttingdiet();
                maintaningdiet();
            }
        });
        bulk=view.findViewById(R.id.Bulking);
        cut=view.findViewById(R.id.Cutting);
        maintain=view.findViewById(R.id.Maintaning);


        bulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Bulking", Toast.LENGTH_SHORT).show();
showalterdialogue(bulkingDietList);
            }
        });

        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Cutting", Toast.LENGTH_SHORT).show();
                showalterdialogue(cuttingDietList);
            }
        });

        maintain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Maintaing", Toast.LENGTH_SHORT).show();
                showalterdialogue(maintainingDietList);
            }
        });
        return view;
    }

    private void showalterdialogue(ArrayList<Diet> maintainingDietList) {
        // create a builder for the alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

// set the title and message for the dialog
        builder.setTitle("Title");
        builder.setMessage("Message");

// create a custom view for the dialog
        View customView = LayoutInflater.from(getContext()).inflate(R.layout.custome_diet_item, null);
        // Assuming this code is inside an Activity class

// Get references to the layout elements
        ImageView imageView = customView.findViewById(R.id.image_view);
        TextView titleTextView = customView.findViewById(R.id.title_textview);
        TextView descriptionTextView = customView.findViewById(R.id.description_textview);
        TextView dateTextView = customView.findViewById(R.id.date_textview);

// Set the image
        imageView.setImageResource(R.drawable.ic_launcher_background);

// Set the text for the TextView elements
        titleTextView.setText("My Title");
        descriptionTextView.setText("My Description");
        dateTextView.setText("My Date");

        builder.setView(customView);

// add buttons to the dialog
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // handle the OK button click
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // handle the Cancel button click
                dialog.dismiss();
            }
        });

// create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();




    }

    public void creatBulkingdiet(){
// Create an ArrayList of real eating food for the High Protein diet
        ArrayList<String> highProteinFoods = new ArrayList<>();
        highProteinFoods.add("Chicken breast");
        highProteinFoods.add("Salmon");
        highProteinFoods.add("Greek yogurt");
        highProteinFoods.add("Eggs");
        highProteinFoods.add("Quinoa");

// Add the High Protein diet to the bulking diet list
        bulkingDietList.add(new Diet("High Protein", "A diet that emphasizes high protein intake.", highProteinFoods));

// Create an ArrayList of real eating food for the High Calorie diet
        ArrayList<String> highCalorieFoods = new ArrayList<>();
        highCalorieFoods.add("Sweet potato");
        highCalorieFoods.add("Avocado");
        highCalorieFoods.add("Brown rice");
        highCalorieFoods.add("Peanut butter");
        highCalorieFoods.add("Whole milk");

// Add the High Calorie diet to the bulking diet list
        bulkingDietList.add(new Diet("High Calorie", "A diet that emphasizes high calorie intake.", highCalorieFoods));

// Create an ArrayList of real eating food for the Carbohydrate Cycling diet
        ArrayList<String> carbCyclingFoods = new ArrayList<>();
        carbCyclingFoods.add("Bananas");
        carbCyclingFoods.add("Whole grain bread");
        carbCyclingFoods.add("Oats");
        carbCyclingFoods.add("Sweet potato");
        carbCyclingFoods.add("Brown rice");

// Add the Carbohydrate Cycling diet to the bulking diet list
        bulkingDietList.add(new Diet("Carbohydrate Cycling", "A diet that involves alternating between high and low carbohydrate intake.", carbCyclingFoods));

// Create an ArrayList of real eating food for the Clean Eating diet
        ArrayList<String> cleanEatingFoods = new ArrayList<>();
        cleanEatingFoods.add("Broccoli");
        cleanEatingFoods.add("Spinach");
        cleanEatingFoods.add("Chicken breast");
        cleanEatingFoods.add("Salmon");
        cleanEatingFoods.add("Sweet potato");

// Add the Clean Eating diet to the bulking diet list
        bulkingDietList.add(new Diet("Clean Eating", "A diet that emphasizes unprocessed, whole foods.", cleanEatingFoods));
    }

    public void cuttingdiet(){


// Create an ArrayList of real eating food for the Low Carb diet
        ArrayList<String> lowCarbFoods = new ArrayList<>();
        lowCarbFoods.add("Chicken breast");
        lowCarbFoods.add("Salmon");
        lowCarbFoods.add("Broccoli");
        lowCarbFoods.add("Spinach");
        lowCarbFoods.add("Cauliflower");

// Add the Low Carb diet to the cutting diet list
        cuttingDietList.add(new Diet("Low Carb", "A diet that emphasizes low carbohydrate intake.", lowCarbFoods));

// Create an ArrayList of real eating food for the Intermittent Fasting diet
        ArrayList<String> intermittentFastingFoods = new ArrayList<>();
        intermittentFastingFoods.add("Lean protein sources");
        intermittentFastingFoods.add("Fruits and vegetables");
        intermittentFastingFoods.add("Nuts and seeds");
        intermittentFastingFoods.add("Whole grains");
        intermittentFastingFoods.add("Legumes");

// Add the Intermittent Fasting diet to the cutting diet list
        cuttingDietList.add(new Diet("Intermittent Fasting", "A diet that involves fasting and feasting periods.", intermittentFastingFoods));

// Create an ArrayList of real eating food for the Mediterranean diet
        ArrayList<String> mediterraneanFoods = new ArrayList<>();
        mediterraneanFoods.add("Fish");
        mediterraneanFoods.add("Olive oil");
        mediterraneanFoods.add("Fruits and vegetables");
        mediterraneanFoods.add("Nuts and seeds");
        mediterraneanFoods.add("Whole grains");

// Add the Mediterranean diet to the cutting diet list
        cuttingDietList.add(new Diet("Mediterranean", "A diet that emphasizes whole, plant-based foods and healthy fats.", mediterraneanFoods));

// Create an ArrayList of real eating food for the Whole30 diet
        ArrayList<String> whole30Foods = new ArrayList<>();
        whole30Foods.add("Lean protein sources");
        whole30Foods.add("Vegetables");
        whole30Foods.add("Fruits");
        whole30Foods.add("Healthy fats");
        whole30Foods.add("Spices and herbs");

// Add the Whole30 diet to the cutting diet list
        cuttingDietList.add(new Diet("Whole30", "A diet that involves avoiding grains, dairy, sugar, and processed foods.", whole30Foods));
    }

    public void maintaningdiet(){


// Create an ArrayList of real eating food for the Balanced diet
        ArrayList<String> balancedFoods = new ArrayList<>();
        balancedFoods.add("Lean protein sources");
        balancedFoods.add("Fruits and vegetables");
        balancedFoods.add("Whole grains");
        balancedFoods.add("Low-fat dairy products");
        balancedFoods.add("Nuts and seeds");

// Add the Balanced diet to the maintaining diet list
        maintainingDietList.add(new Diet("Balanced", "A diet that includes all food groups in appropriate amounts.", balancedFoods));

// Create an ArrayList of real eating food for the DASH diet
        ArrayList<String> dashFoods = new ArrayList<>();
        dashFoods.add("Fruits and vegetables");
        dashFoods.add("Whole grains");
        dashFoods.add("Lean protein sources");
        dashFoods.add("Low-fat dairy products");
        dashFoods.add("Nuts and seeds");

// Add the DASH diet to the maintaining diet list
        maintainingDietList.add(new Diet("DASH", "A diet that emphasizes fruits, vegetables, and low-fat dairy products.", dashFoods));

// Create an ArrayList of real eating food for the Flexitarian diet
        ArrayList<String> flexitarianFoods = new ArrayList<>();
        flexitarianFoods.add("Plant-based protein sources");
        flexitarianFoods.add("Fruits and vegetables");
        flexitarianFoods.add("Whole grains");
        flexitarianFoods.add("Low-fat dairy products");
        flexitarianFoods.add("Nuts and seeds");

// Add the Flexitarian diet to the maintaining diet list
        maintainingDietList.add(new Diet("Flexitarian", "A diet that includes plant-based protein sources and limited amounts of meat.", flexitarianFoods));

// Create an ArrayList of real eating food for the Mediterranean diet
        ArrayList<String> mediterraneanFoods = new ArrayList<>();
        mediterraneanFoods.add("Fish");
        mediterraneanFoods.add("Olive oil");
        mediterraneanFoods.add("Fruits and vegetables");
        mediterraneanFoods.add("Nuts and seeds");
        mediterraneanFoods.add("Whole grains");

// Add the Mediterranean diet to the maintaining diet list
        maintainingDietList.add(new Diet("Mediterranean", "A diet that emphasizes whole, plant-based foods and healthy fats.", mediterraneanFoods));
    }
}
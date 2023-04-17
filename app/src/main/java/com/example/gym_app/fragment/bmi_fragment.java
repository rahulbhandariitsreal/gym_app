package com.example.gym_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gym_app.R;

public class bmi_fragment extends Fragment {


    EditText heightEditText, weightEditText;
    TextView bmiResultTextView;
    Button calculateButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View view=inflater.inflate(R.layout.fragment_bmi_fragment, container, false);





                // initialize views
                heightEditText = view.findViewById(R.id.height);
                weightEditText = view.findViewById(R.id.weight);
                bmiResultTextView = view.findViewById(R.id.bmi_result);
                calculateButton = view.findViewById(R.id.calculate_button);

                // set click listener for calculate button
                calculateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        calculateBMI();
                    }
                });

        return view;
    }
    private void calculateBMI() {
        // get user input for height and weight
        String heightString = heightEditText.getText().toString();
        String weightString = weightEditText.getText().toString();

        if (!heightString.isEmpty() && !weightString.isEmpty()) {
            // convert height and weight to floating point numbers
            float height = Float.parseFloat(heightString);
            float weight = Float.parseFloat(weightString);

            // calculate BMI
            float bmi = weight / ((height / 100) * (height / 100));

            // display result
            bmiResultTextView.setText("Your BMI is " + String.format("%.2f", bmi));
        } else {
            // handle case where height or weight is not provided
            bmiResultTextView.setText("Please enter your height and weight.");
        }
    }
}
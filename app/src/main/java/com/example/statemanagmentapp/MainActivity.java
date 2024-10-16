package com.example.statemanagmentapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private TextView TextViewCount;
    private Button ButtonIncrement;
    private EditText EditText;
    private CheckBox CheckBox;
    private TextView TextCheckBox;
    private Switch Switch;
    private StateViewModel stateViewModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextViewCount = findViewById(R.id.TextViewCount);
        ButtonIncrement = findViewById(R.id.ButtonIncrement);
        EditText = findViewById(R.id.EditText);
        CheckBox = findViewById(R.id.CheckBox);
        TextCheckBox = findViewById(R.id.TextCheckBox);
        Switch = findViewById(R.id.Switch);

        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);

        updateCountText();
        updateEditText();
        updateCheckBox();
        updateToggleSwitch();

        ButtonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stateViewModel.incrementCount();
                updateCountText();
            }
        });
        CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(CheckBox.isChecked()) {
                    stateViewModel.setChecked(true);
                } else {
                    stateViewModel.setChecked(false);
                }
                updateCheckBox();
            }
        });
        Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(Switch.isChecked()) {
                    stateViewModel.setSwitched(true);
                } else {
                    stateViewModel.setSwitched(false);
                }
                updateToggleSwitch();
            }
        });
    }
    private void updateCountText() {
        TextViewCount.setText("Licznik: " + stateViewModel.getCount());
    }
    private void updateEditText() {
        EditText.setText("" + stateViewModel.getTextEditText());
    }
    private void updateCheckBox() {
        if(stateViewModel.getChecked()) {
            TextCheckBox.setText("Opcja zaznaczona");
        } else {
            TextCheckBox.setText("");
        }
    }
    private void updateToggleSwitch() {
        if(stateViewModel.getSwitched()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
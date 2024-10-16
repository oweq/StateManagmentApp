package com.example.statemanagmentapp;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel {
    private int count = 0;
    private String TextEditText = "";
    private Boolean checked = false;
    private Boolean switched = false;

    public int getCount() {
        return count;
    }
    public void incrementCount() {
        count++;
    }
    public String getTextEditText() {
        return TextEditText;
    }

    public Boolean getChecked() {
        return checked;
    }

    public Boolean getSwitched() {
        return switched;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public void setSwitched(Boolean switched) {
        this.switched = switched;
    }
}
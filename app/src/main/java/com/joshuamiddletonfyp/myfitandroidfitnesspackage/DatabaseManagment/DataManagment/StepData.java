package com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.DataManagment;

import java.util.Date;

/**
 * Created by joshu on 05/04/2016.
 */
public class StepData {
    int steps;
    String username;
    int day;
    int month;
    int year;
    int hour;

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}

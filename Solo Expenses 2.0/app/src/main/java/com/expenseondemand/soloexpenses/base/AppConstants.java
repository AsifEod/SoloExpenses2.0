package com.expenseondemand.soloexpenses.base;

public class AppConstants {

    public enum Theme {Default, RED} // This lists all the supported themes
    public enum ScreenName{DASHBOARD, SELECT_CATEGORY, CREATE_NORMAL_EXPENSE}

    public static Theme APP_THEME = Theme.Default; // current theme of the application

    //    Category IDs
    public static final int KEY_MILEAGE_EXPENSE_CATEGORY_ID = 1;
    public static final int KEY_MILEAGE_GPS_EXPENSE_CATEGORY_ID = 2;
    public static final int KEY_MILEAGE_DISTANCE_EXPENSE_CATEGORY_ID = 3;
    public static final int KEY_HOTEL_AND_LODGING_EXPENSE_CATEGORY_ID = 4;
    public static final int KEY_ENTERTAINMENT_EXPENSE_CATEGORY_ID = 5;
    public static final int KEY_NORMAL_EXPENSE_CATEGORY_ID = 6;


    public static final String KEY_CATEGORY_MODEL = "KEY_CATEGORY_MODEL";


}

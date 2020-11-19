package com.project.employees.constants;

public interface Err {

        /*  ================== 1 ERRORS ABOUT EMPLOYEESS =========================*/
        final public static String ERR_1_1 = "name is required (1.1)";
        final public static String ERR_1_2 = "email is required (1.2)";
        final public static String ERR_1_3 = "email is not valid (1.3)";
        final public static String ERR_1_4 = "department is required (1.4)";
        final public static String ERR_1_5 = "department is required (1.5)";
        final public static String ERR_1_6 = "salary is required or is not a valid number (1.6)";
        final public static String ERR_1_7 = "birth_date is required on format dd-MM-yyyyy (1.7)";

        final public static String ERR_1_8 = "name must be less than 255 characters (1.8)";
        final public static String ERR_1_9 = "email must be less than 255 characters (1.9)";
        final public static String ERR_1_10 = "department must be less than 255 characters (1.10)";

        final public static String ERR_1_11 = "employee is not found (1.11)";


        /*  ================== 2 ERRORS ABOUT AUTH =========================*/
        final public static String ERR_2_1 = "There was a error on create your token. (2.1)";
        final public static String ERR_2_2 = "Authorization header is not valid. Use /auth/key-access to get your key to use in Authorization header (2.2)";
}

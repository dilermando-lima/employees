package com.project.employees.utils;

import com.google.gson.Gson;

public class UtilsMethods {


    public static <T> T cloneObject(Object obj, Class<T> c) {
		Gson g = new Gson();
		return c.cast(g.fromJson(g.toJson(obj), c));
	}

}

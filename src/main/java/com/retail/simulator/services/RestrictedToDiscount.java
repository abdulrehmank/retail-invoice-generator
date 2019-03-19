package com.retail.simulator.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestrictedToDiscount {

    private static RestrictedToDiscount restrictedToDiscount = new RestrictedToDiscount();

    private List<Integer> restrictedCategories;

    private RestrictedToDiscount() {
        restrictedCategories = new ArrayList<Integer>(Arrays.asList(2));
    }

    public static RestrictedToDiscount getInstance() {
        return restrictedToDiscount;
    }

    public List<Integer> getRestrictedCategories() {
        return restrictedCategories;
    }



}

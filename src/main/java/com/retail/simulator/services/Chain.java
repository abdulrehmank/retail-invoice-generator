package com.retail.simulator.services;

import com.retail.simulator.models.User;

public interface Chain {
    public void setNext(Chain nextInChain);
    public double process(User.UserType userType, Object... conditionalParams);
}

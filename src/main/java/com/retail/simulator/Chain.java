package com.retail.simulator;

public interface Chain {
    public void setNext(Chain nextInChain);
    public double process(User.UserType userType, Object... conditionalParams);
}

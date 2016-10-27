package com.practice;

public class GuestEmployee extends Employee {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    transient String tempIdCard = "Given";

    public GuestEmployee(String tempId) {
        this.tempIdCard = tempId;

    }

    @Override
    public String toString() {
        return "GuestEmployee [tempIdCard=" + tempIdCard + ", name=" + name + ", age=" + age + ", rollNo=" + rollNo
                + "]";
    }

}

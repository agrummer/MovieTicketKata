package de.saxsys.dojo.ticketkata;

public class Person {

    private int age;
    private boolean student;

    public Person(int age, boolean student) {
        this.age = age;
        this.student = student;
    }

    public float calcBaseRate(boolean isGroup) {
        if (isChild()) {
            return CashRegisterConfig.CHILD_BASE_RATE;
        }

        if (isGroup) {
            return CashRegisterConfig.GROUP_BASE_RATE;
        }

        if (isSenior()) {
            return CashRegisterConfig.SENIOR_BASE_RATE;
        }

        if (student) {
            return CashRegisterConfig.STUDENT_BASE_RATE;
        }

        return CashRegisterConfig.DEFAULT_BASE_RATE;
    }

    private boolean isChild() {
        return age <= CashRegisterConfig.CHILD_MAX_AGE;
    }

    private boolean isSenior() {
        return age >= CashRegisterConfig.SENIOR_MIN_AGE;
    }

}

package de.saxsys.dojo.ticketkata;

public class Person {

    private final int age;
    private final boolean student;

    public Person(int age, boolean student) {
        this.age = age;
        this.student = student;
    }

    public int getAge() {
        return age;
    }

    public boolean isStudent() {
        return student;
    }

    public float calcBaseRate(boolean isGroup) {
        if (isChild()) {
            return Config.CHILD_BASE_RATE;
        }

        if (isGroup) {
            return Config.GROUP_BASE_RATE;
        }

        if (isSenior()) {
            return Config.SENIOR_BASE_RATE;
        }

        if (student) {
            return Config.STUDENT_BASE_RATE;
        }

        return Config.DEFAULT_BASE_RATE;
    }

    private boolean isChild() {
        return age <= Config.CHILD_MAX_AGE;
    }

    private boolean isSenior() {
        return age >= Config.SENIOR_MIN_AGE;
    }

}

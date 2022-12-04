package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student vasya = new Student();
        vasya.setName("Vasilyj Ivanovich Ivanov");
        vasya.setGroupNumber("121A");
        vasya.setDateEnroll("22/06/2022");
        System.out.println("This student is " + vasya.getName() + System.lineSeparator() + "Group number is " +  vasya.getGroupNumber()
                + System.lineSeparator() + "Student was enrolled at " + vasya.getDateEnroll());
    }
}

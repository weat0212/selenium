package main.java.tutorials;

import java.util.StringJoiner;

public class Test {

    public static void main(String[] args) {
        String birth = "19960212";
        String year = birth.substring(0, 4);
        String month = birth.substring(4, 6);
        String days = birth.substring(6, 8);

        StringJoiner sj = new StringJoiner("/", "[", "]");
        sj.add(year);
        sj.add(month);
        sj.add(days);
        System.out.println(sj);
    }
}

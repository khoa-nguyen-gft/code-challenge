//package demo;

import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args) {
        List<String> valueList = new ArrayList<>();
        valueList.add("Joe");
        valueList.add("John");
        valueList.add("Sean");

        firstLast(valueList);// ➞ [5, 25]


    }

    public static List firstLast(List<String> valueList) {
        String v2 = valueList.stream().reduce((first, second) -> second).get();
        System.out.println(v2);
        return null;
    }
}
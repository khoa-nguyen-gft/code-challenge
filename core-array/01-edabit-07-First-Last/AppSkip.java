//package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AppSkip{
    public static void main(String[] args) {
        List<String> valueList = new ArrayList<>();
        valueList.add("Joe");
        valueList.add("John");
        valueList.add("Sean");

        firstLast(valueList);// ➞ [5, 25]


    }

    public static List firstLast(List<String> valueList) {
        //we’re only allowed to perform a single operation that consumes a Stream,
        //where the Supplier functional interface becomes really handy:
        Supplier<Stream<String>> supplierStream =  ()-> valueList.stream();
        long count = supplierStream.get().count();
        String v2 = supplierStream.get().skip(count -1).findFirst().get();
        System.out.println(v2);
        return null;
    }
}
package pers.hai.simple.tuple;

public class MyObject {

    public static void main(String[] args) {
        ThreeTuple<Integer, String, OneTuple<String>> tuple = new MyObject().method(100, "Out", "Inner");
        System.out.println(tuple.a);
        System.out.println(tuple.b);
        System.out.println(tuple.c.a);
    }
    
    public ThreeTuple<Integer, String, OneTuple<String>> method(Integer index, String label, String innerLabel) {
        OneTuple<String> oneTuple = new OneTuple<String>(innerLabel);
        ThreeTuple<Integer, String, OneTuple<String>> tuple = new ThreeTuple<Integer, String, OneTuple<String>>(index, label, oneTuple);
        return tuple;
    }
}

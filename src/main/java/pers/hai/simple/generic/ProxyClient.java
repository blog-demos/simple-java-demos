package pers.hai.simple.generic;

public class ProxyClient {

    public static void main(String[] args) {
        StudentProxy proxy = new StudentProxy(new Student());
        proxy.setName("Tr");
        System.out.println(proxy.getName());
    }
}

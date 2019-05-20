package pers.hai.simple.excep;

import java.util.ArrayList;
import java.util.List;

import pers.hai.util.commons.logs.LogUtils;

public class ExceptionClient {

    public static void main(String[] args) {
        
        ExceptionClient client = new ExceptionClient();
        
//        client.showInfo();
//        
//        try {
//            client.testException();
//        } catch (AException e) {
//            e.printStackTrace();
//        }
//        
//        client.testRuntimeException();
//        
//        client.testError();
        
        client.exceptionCall();
    }
    
    public void showInfo() {
        try {
            System.out.println("first info");
            testException();
            System.out.println("second info");
        } catch (Exception e) {
            System.err.println(e);
        }
        
        System.out.println("outside info");
    }
    
    private void testException() throws AException {
        boolean f = true;
        if (f) {
            throw new AException("AException");
        }
        
        System.out.println("f is false.");
    }
    
    public void testRuntimeException() {
        throw new BException("BException");
    }
    
    public void testError() {
        throw new CError("CError");
    }
    
    private void exceptionCall() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i + 1);
        }
        
        call_1(list);
        
        call_2(list);
        
        call_3(list);
    }
    
    // 第一种对每一种情况进行异常检查
    private void call_1(List<Integer> list) {
        long t = System.currentTimeMillis();
        try {
            int index = 0;
            while(true) {
                list.get(index++);
            } 
        } catch (IndexOutOfBoundsException e) {
            LogUtils.printTimeUsed("不针对检查异常", t);
        }
    }
    
    // 第二种只对错误的情况进行异常检查
    private void call_2(List<Integer> list) {
        long t = System.currentTimeMillis();
        t = System.currentTimeMillis();
        int size = list.size();
        int index = 0;
        while(true) {
            if (index >= size) {
                try {
                    list.get(index++);
                } catch (IndexOutOfBoundsException e) {
                    LogUtils.printTimeUsed("针对性检查异常", t);
                    break;
                }
            }
            list.get(index++);
        }
    }
    
    // 第三种 普通的循环遍历
    private void call_3(List<Integer> list) {
        long t = System.currentTimeMillis();
        t = System.currentTimeMillis();
        int size = list.size();
        int index = 0;
        for (index = 0; index < size; index++) {
            list.get(index++);
        }
        
        LogUtils.printTimeUsed("循环遍历", t);
    }
}

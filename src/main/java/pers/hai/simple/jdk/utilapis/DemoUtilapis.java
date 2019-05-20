package pers.hai.simple.jdk.utilapis;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.EventObject;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Vector;

import pers.hai.util.commons.obj.SerializationUtils;

public class DemoUtilapis {

    public static void main(String[] args) {
        testFormatter();
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testFormatter() {
        @SuppressWarnings("resource")
        Formatter formatter = new Formatter();
        Date date = new Date();
        System.out.println(formatter.format("当前日期: %1$tY-%1$tm-%1$te", date));
        
        String msg = "欢迎光临，当前( {0} )等待的业务受理的顾客有 {1} 位，请排号办理业务！"; 
        MessageFormat mf = new MessageFormat(msg);
        String fmsg = mf.format(new Object[]{ new Date(), 35 });
        System.out.println(fmsg);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd H:m:s");
        System.out.println(format.format(date));
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testEventObject() {
        Flyable flyable = new Bird();
        EventObject object = new EventObject(flyable);
        
        System.out.println(object);
        
        SerializationUtils.writeObject(object, "F:/Temp/bird.txt");
        Object object2 = SerializationUtils.readObject("F:/Temp/bird.txt");
        System.out.println(object2);
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testSimpleTimeZone() {
        SimpleTimeZone zone = new SimpleTimeZone(-28800000, "America/Los_Angeles");
        System.out.println(zone);
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testServiceLoader() {
        ServiceLoader<Flyable> loader = ServiceLoader.load(Flyable.class);
        for (Flyable flyable : loader) {
            flyable.fly();
        }
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testTreeMap() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "a");
        treeMap.put(2, "b");
        System.out.println(treeMap);
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testVector() {
        Vector<String> strings = new Vector<String>();
        strings.addElement("ABC");
        strings.addElement("BCD");
        strings.add("12345");

        System.out.println(strings);
        System.out.println(strings.capacity());
        System.out.println(strings.firstElement());
        System.out.println(strings.lastElement());
        
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("9");
        strings.addAll(list);
        System.out.println(strings);
        
        strings.add("8");
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testBitSet() {
        BitSet bitSet = new BitSet();
        bitSet.set(3);
        System.out.println(bitSet);
        System.out.println(bitSet.cardinality());
        bitSet.set(4, true);
        System.out.println(bitSet.cardinality());
        bitSet.flip(5); // 取此位的反
        System.out.println(bitSet);
        
        BitSet bitSet2 = new BitSet();
        bitSet2.set(4);
        System.out.println(bitSet.intersects(bitSet2)); // 判断两个 bitset 里是否有相同值的位
//        bitSet.and(bitSet2);
        bitSet.or(bitSet2);
        System.out.println("------------------------>");
        System.out.println(bitSet);
        
        byte[] bytes = bitSet.toByteArray();
        System.out.println(Arrays.toString(bytes));
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testTimeZone() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
        
        String label = "America/Anchorage";
        TimeZone tempTimeZone = TimeZone.getTimeZone(label);
        format.setTimeZone(tempTimeZone);
        System.out.println(label + ":\t\t" + format.format(new Date()));
        
        label = "Pacific/Gambier";
        tempTimeZone = TimeZone.getTimeZone(label);
        format.setTimeZone(tempTimeZone);
        System.out.println(label + ":\t\t" + format.format(new Date()));
        
        label = "Asia/Shanghai";
        tempTimeZone = TimeZone.getTimeZone(label);
        format.setTimeZone(tempTimeZone);
        System.out.println(label + ":\t\t\t" + format.format(new Date()));
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testEnumSet() {
        EnumSet<Season> seasons = EnumSet.noneOf(Season.class);
        seasons.add(Season.Autumn);
        seasons.add(Season.Winter);
        System.out.println(seasons);
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testEnumMap() {
        EnumMap<Season,String> errMsgMap = new EnumMap<Season,String>(Season.class);
        errMsgMap.put(Season.Spring, "杨柳依依");
        errMsgMap.put(Season.Summer, "烈日炎炎");
        errMsgMap.put(Season.Autumn, "秋风瑟瑟");
        errMsgMap.put(Season.Winter, "白雪皑皑");
       
        for(Map.Entry<Season,String> entry : errMsgMap.entrySet() ){  
            System.out.println(entry.getValue()+ "\t" + entry.getKey().getValue());  
        }
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testClassValue() {
    }
    
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testStringTokenizer() {
        String label = "Both  of you are very clever and have optimal strategies for the game.";
        StringTokenizer tokenizer = new StringTokenizer(label);
        System.out.println(tokenizer.countTokens());
        while(tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
        
//        String[] splits = label.split(" +");
//        for (String string : splits) {
//            System.out.println(string);
//        }
    }
    
    // TODO ---------------------------------------- Separated -------------------------------------------------
    public static void testUUID() {
        UUID uuid = new UUID(1024L, 998628218376238L);
        System.out.println(uuid);
        
        uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.getLeastSignificantBits());
        System.out.println(uuid.getMostSignificantBits());
        System.out.println(uuid.version());
        System.out.println(uuid.variant());
        
        uuid = UUID.fromString("0ad982a8-3f0d-4b54-89d6-3946cc7f0e28");
        System.out.println(uuid);
    }
}

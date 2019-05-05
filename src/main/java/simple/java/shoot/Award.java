package simple.java.shoot;

// 奖励
public interface Award {
    public static final int DOUBLE_FIRE = 0; // int DOUBLE_FIRE = 0;
    public static final int LIFE = 1; // int LIFE = 1;

    // 获取奖励
    public int getType();
}

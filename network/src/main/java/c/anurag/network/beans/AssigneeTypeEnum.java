package c.anurag.network.beans;

/**
 * Created by anuragpurwar on 2/4/18.
 */

public enum AssigneeTypeEnum {
    user(1), department(2);

    private final int value;

    AssigneeTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

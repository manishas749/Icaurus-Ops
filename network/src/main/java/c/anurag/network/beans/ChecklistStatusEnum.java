package c.anurag.network.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anuragpurwar on 2/4/18.
 */

public enum ChecklistStatusEnum {
    PENDING(0), CANCELLED(1), COMPLETED(2), DELETED(3), PAUSED(5);

    private final int value;

    ChecklistStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    //Lookup table
    private static final Map<Integer, ChecklistStatusEnum> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(ChecklistStatusEnum env : ChecklistStatusEnum.values())
        {
            lookup.put(env.getValue(), env);
        }
    }

    //This method can be used for reverse lookup purpose
    public static ChecklistStatusEnum get(int value)
    {
        return lookup.get(value);
    }
}

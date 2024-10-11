package c.anurag.network.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anuragpurwar on 2/4/18.
 */

public enum AssigneeNCWResultEnum {
    pending(0), acknowledged(1);

    private final int value;

    AssigneeNCWResultEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    //Lookup table
    private static final Map<Integer, AssigneeNCWResultEnum> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(AssigneeNCWResultEnum env : AssigneeNCWResultEnum.values())
        {
            lookup.put(env.getValue(), env);
        }
    }

    //This method can be used for reverse lookup purpose
    public static AssigneeNCWResultEnum get(int value)
    {
        return lookup.get(value);
    }
}

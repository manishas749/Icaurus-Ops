package c.anurag.network.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anuragpurwar on 2/4/18.
 */

public enum AssigneeDecsisionResultEnum {
    no(0), yes(1);

    private final int value;

    AssigneeDecsisionResultEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    //Lookup table
    private static final Map<Integer, AssigneeDecsisionResultEnum> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(AssigneeDecsisionResultEnum env : AssigneeDecsisionResultEnum.values())
        {
            lookup.put(env.getValue(), env);
        }
    }

    //This method can be used for reverse lookup purpose
    public static AssigneeDecsisionResultEnum get(int value)
    {
        return lookup.get(value);
    }
}

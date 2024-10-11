package c.anurag.network.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anuragpurwar on 2/4/18.
 */

public enum AssigneeStepResultEnum {
    pending(0), completed(1), skipped(2), deferred(3);

    private final int value;

    AssigneeStepResultEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    //Lookup table
    private static final Map<Integer, AssigneeStepResultEnum> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(AssigneeStepResultEnum env : AssigneeStepResultEnum.values())
        {
            lookup.put(env.getValue(), env);
        }
    }

    //This method can be used for reverse lookup purpose
    public static AssigneeStepResultEnum get(int value)
    {
        return lookup.get(value);
    }
}

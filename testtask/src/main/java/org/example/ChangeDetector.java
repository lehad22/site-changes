package org.example;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChangeDetector {

    public Changes detectChanges(Map<String, String> yesterday, Map<String, String> today) {
        Set<String> disappeared = new HashSet<>(yesterday.keySet());
        disappeared.removeAll(today.keySet());

        Set<String> appeared = new HashSet<>(today.keySet());
        appeared.removeAll(yesterday.keySet());

        Set<String> changed = new HashSet<>();
        for (String url : yesterday.keySet()) {
            if (today.containsKey(url) && !yesterday.get(url).equals(today.get(url))) {
                changed.add(url);
            }
        }

        return new Changes(disappeared, appeared, changed);
    }
}

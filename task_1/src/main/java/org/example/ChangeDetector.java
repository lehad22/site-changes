package org.example;

import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChangeDetector {
// В данном случае ? extends URL не нужен, так как URl final, но по хорошему сделать так
    public static Changes detectChanges(Map<? extends URL, String> yesterday, Map<? extends URL, String> today) {
        Set<URL> disappeared = new HashSet<>(yesterday.keySet());
        disappeared.removeAll(today.keySet());

        Set<URL> appeared = new HashSet<>(today.keySet());
        appeared.removeAll(yesterday.keySet());

        Set<URL> changed = new HashSet<>();
        for (URL url : yesterday.keySet()) {
            if (today.containsKey(url) && !yesterday.get(url).equals(today.get(url))) {
                changed.add(url);
            }
        }

        return new Changes(disappeared, appeared, changed);
    }
}

package org.example;

import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChangeDetector {
    // В данном случае ? extends URL не нужен, так как URl final, но по хорошему сделать так
    public static Changes detectChanges(Map<? extends URL, String> yesterday, Map<? extends URL, String> today) {

        Set<URL> disappeared = new HashSet<>();
        Set<URL> appeared = new HashSet<>();
        Set<URL> changed = new HashSet<>();

        for (Map.Entry<? extends URL, String> entry : yesterday.entrySet()) {
            URL url = entry.getKey();
            String oldContent = entry.getValue();
            if (!today.containsKey(url)) {
                disappeared.add(url);
            }
            else {
                String newContent = today.get(url);
                if (!oldContent.equals(newContent)) {
                    changed.add(url);
                }
            }
        }
        for (URL url : today.keySet()) {
            if (!yesterday.containsKey(url)) {
                appeared.add(url);
            }
        }

        return new Changes(disappeared, appeared, changed);
    }
}

package org.example;

import java.util.Set;

public class Changes {
    private final Set<String> disappeared;
    private final Set<String> appeared;
    private final Set<String> changed;

    public Changes(Set<String> disappeared, Set<String> appeared, Set<String> changed) {
        this.disappeared = disappeared;
        this.appeared = appeared;
        this.changed = changed;
    }

    public Set<String> getDisappeared() {
        return disappeared;
    }

    public Set<String> getAppeared() {
        return appeared;
    }

    public Set<String> getChanged() {
        return changed;
    }
}

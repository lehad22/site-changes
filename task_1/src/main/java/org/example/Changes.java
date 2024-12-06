package org.example;

import java.net.URL;
import java.util.Set;

public class Changes {
    private final Set<URL> disappeared;
    private final Set<URL> appeared;
    private final Set<URL> changed;

    Changes(Set<URL> disappeared, Set<URL> appeared, Set<URL> changed) {
        this.disappeared = disappeared;
        this.appeared = appeared;
        this.changed = changed;
    }

    public Set<URL> getDisappeared() {
        return disappeared;
    }

    public Set<URL> getAppeared() {
        return appeared;
    }

    public Set<URL> getChanged() {
        return changed;
    }
}

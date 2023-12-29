package org.example;

import java.util.ArrayList;
import java.util.List;

public class LanguageList {
    private final List<String> languages = new ArrayList<>();

    public boolean isEmpty() {
        return languages.isEmpty();
    }

    public void addLanguage(String language) {
        if (containsLanguage(language)) return;

        languages.add(language);
    }

    public void removeLanguage(String language) {
        if (!containsLanguage(language)) return;

        languages.remove(language);
    }

    public String firstLanguage() {
        if (languages.isEmpty()) return null;

        return languages.get(0);
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        return languages.contains(language);
    }

    public boolean isExciting() {
        return (containsLanguage("Java") || containsLanguage("Kotlin"));
    }
}


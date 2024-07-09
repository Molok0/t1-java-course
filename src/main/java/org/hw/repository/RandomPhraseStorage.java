package org.hw.repository;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class RandomPhraseStorage implements PhraseStorage {

    private static Random rand = new Random();

    private final List<String> phrases;

    public RandomPhraseStorage() {
        this.phrases = new CopyOnWriteArrayList<>();
        phrases.add("Hello World");
    }

    @Override
    public void addPhrase(String phrase) {
        phrases.add(phrase);
    }

    @Override
    public String randomGetPhrase() {
        int index = rand.nextInt(phrases.size());
        return phrases.get(index);
    }
}

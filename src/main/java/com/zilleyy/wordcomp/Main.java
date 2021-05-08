package com.zilleyy.wordcomp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        RandomCollection<Word> words = new RandomCollection<>();

        try {
            String jsonStr = Files.lines(Paths.get("src/main/java/com/zilleyy/wordcomp/words.json")).collect(Collectors.joining(System.lineSeparator()));
            JSONObject json = new JSONObject(jsonStr);
            json.keySet().forEach(key -> {
                JSONArray array = json.getJSONArray(key);

                String spelling = key;
                double weight = array.getDouble(0);
                int rank = array.getInt(1);

                words.add(weight, new Word(spelling, weight, rank));
            });
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String result = "";
        for (int index = 0; index < 100; index++) {
            result += " " + words.next().getSpelling();
        }
        System.out.println(result);
    }

}
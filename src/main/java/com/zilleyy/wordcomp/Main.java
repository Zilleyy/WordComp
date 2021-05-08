package com.zilleyy.wordcomp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        RandomCollection<Word> words = new RandomCollection<>();
        List<String> list  = new ArrayList<>();
        try {
            String jsonStr = Files.lines(Paths.get("src/main/java/com/zilleyy/wordcomp/random.json")).collect(Collectors.joining(System.lineSeparator()));
            JSONArray json = new JSONObject(jsonStr).getJSONArray("data");
            json.forEach(key -> {
                String spelling = (String) key;

                list.add(spelling);
            });
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String a = "";
        for (byte index = 0; index < 100; index++) {
            a += " " + list.get(new Random().nextInt(list.size()));
        }
        System.out.println(a);
    }

}
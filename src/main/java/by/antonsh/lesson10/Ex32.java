package by.antonsh.lesson10;

import java.util.HashMap;
import java.util.Map;

/*
Имеется текст, создать для него частотный словарь
 */
public class Ex32 {
    public static void main(String[] args) {
        String text = " Коси траву, коси траву, пока солнце высоко.".toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : text.trim().replaceAll("[ ,.:!]", "_")
                .split("_")) {
            if (word.isEmpty() || word == null) {
                continue;
            } else if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("слово: " + entry.getKey() + " повторяется: " + entry.getValue() + " раз.");
        }
    }

}

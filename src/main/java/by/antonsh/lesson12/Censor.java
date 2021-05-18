package by.antonsh.lesson12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Censor {
    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("first.txt")));
        String censor = new String(Files.readAllBytes(Paths.get("second.txt")));
        AtomicInteger count = new AtomicInteger();
        List<String> blackList = new ArrayList<>(Arrays.stream(censor.toLowerCase().split("[,]"))
                .collect(Collectors.toList()));
        List<String> listOfSentences = new ArrayList<>(
                Arrays.stream(text.toLowerCase().split("(?<=[.?!])"))
                        .collect(Collectors.toList()));
        listOfSentences.stream().forEach(a -> {
            List<String> listOfWords = new ArrayList<>(Arrays.stream(a.split("[,.!: ]"))
                    .collect(Collectors.toList()));
            if (listOfWords.stream().filter(w -> blackList.contains(w)).findFirst().isPresent()) {
                count.getAndIncrement();
                System.out.println("В предложении: " + a + " содержатся запрещенные слова.");
            }
            return;
        });
        if (count.get() > 0) {
            System.out.println(count.get() + " предложения(й) содержат запрещенные слова");
        } else {
            System.out.println("Все предложения не содержат запрещенных слов.");
        }
    }
}

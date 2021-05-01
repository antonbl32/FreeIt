package by.antonsh.concurrency.ex2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String bookName;
    private boolean onHands;
    private boolean justInLibrary;
    private boolean busy;
}

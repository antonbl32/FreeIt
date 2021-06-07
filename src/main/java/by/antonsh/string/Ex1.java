package by.antonsh.string;
/*
1) Вырезать подстроку из строки начиная с первого вхождения символа(А) до,
последнего вхождения сивола(B).
 */
public class Ex1 {
    public static void main(String[] args) {
        String text="Hello my friend!";
        String subText=text.substring(text.indexOf("m"),text.lastIndexOf("e"));
        System.out.println(subText);

    }
}

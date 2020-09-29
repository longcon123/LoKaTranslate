import java.util.Scanner;
public class DictionaryManagements {
    static Scanner sc = new Scanner(System.in);
    static int stt = 0;
    public static void insertFromCommandline(Dictionary dic) {
        long n = sc.nextLong();
        sc.nextLine();
        for(int i = stt; i < stt+n; i++) {
            String eWord = sc.nextLine();
            String vExpl = sc.nextLine();
            Word word = new Word(eWord, vExpl);
            dic.addWord(word);
            //stt++;
        }
    }
}


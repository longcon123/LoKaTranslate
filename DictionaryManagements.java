import java.io.*;
import java.util.Scanner;
public class DictionaryManagements {
    static Scanner sc = new Scanner(System.in);
    static int stt = 0;
    static Dictionary dic = new Dictionary();
    public DictionaryManagements(Dictionary dic) {
        this.dic = dic;
    }
    public static void insertFromCommandline() {
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
    public static void insertFromFile() throws IOException {
        FileReader fis = new FileReader("D:\\BTL_Dictionary\\src\\main\\resources\\E_V.txt");
        BufferedReader br = new BufferedReader(fis);
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            //read file
        }
    }
}


import java.io.*;
import java.util.Scanner;
public class DictionaryManagements {
    static Scanner sc = new Scanner(System.in);
    static Dictionary dic = new Dictionary();
    /**public DictionaryManagements(Dictionary dic) {
        DictionaryManagements.dic = dic;
    }*/
    public DictionaryManagements() {
    }
    public static void insertFromCommandline() {
        long n = sc.nextLong();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String eWord = sc.nextLine();
            String vExpl = sc.nextLine();
            Word word = new Word(eWord, vExpl);
            dic.addWord(word);
            //stt++;
        }
    }
    public static String getWord(int i) {
        return dic.getWords(i).getWord_target();
    }
    public static String getWordDefi(int i) {
        return dic.getWords(i).getWord_explain();
    }
    public static int getSize() {
        return dic.getSize();
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


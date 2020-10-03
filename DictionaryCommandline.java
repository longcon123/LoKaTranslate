//import java.io.IOException;

public class DictionaryCommandline extends DictionaryManagements{
    public static void showAllWords() {
        System.out.println("No ||English    |Vietnamese");
        for(int i = 0; i < getSize(); i++) {
            String vi = getWord(i);
            System.out.print(i+1 + "  |"+vi);
            for(int j = vi.length(); j < 15; j++) {
                System.out.print(" ");
            }
            System.out.println("|" + getWordDefi(i));
        }
    }
    public static void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }
    public static void main(String[] args)  {
        //dicMan.insertFromFile();
        dictionaryBasic();
    }
}

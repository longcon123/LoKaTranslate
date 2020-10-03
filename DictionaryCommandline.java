import java.io.IOException;

public class DictionaryCommandline {
    static Dictionary newDic = new Dictionary();
    static DictionaryManagements dicMan = new DictionaryManagements(newDic);
    public static void showAllWords() {
        System.out.println("No ||English    |Vietnamese");
        for(int i = 0; i < dicMan.dic.getSize(); i++) {
            String vi = dicMan.dic.getWords(i).getWord_target();
            System.out.print(i+1 + "  |"+vi);
            for(int j = vi.length(); j < 15; j++) {
                System.out.print(" ");
            }
            System.out.println("|"+dicMan.dic.getWords(i).getWord_explain());
        }
    }
    public static void dictionaryBasic() {
        dicMan.insertFromCommandline();
        showAllWords();
    }
    public static void main(String[] args) throws IOException {
        //dicMan.insertFromFile();
        dictionaryBasic();
    }
}

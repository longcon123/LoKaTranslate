public class DictionaryCommandline {
    static Dictionary dic = new Dictionary();
    public static void showAllWords() {
        System.out.println("No ||English    |Vietnamese");
        for(int i = 0; i < dic.getSize(); i++) {
            String vi = dic.getWords(i).word_target;
            System.out.print(i+"  |"+vi);
            for(int j = vi.length(); j < 15; j++) {
                System.out.print(" ");
            }
            System.out.println("|"+dic.getWords(i).word_explain);
        }
    }
    public static void dictionaryBasic() {
        DictionaryManagements.insertFromCommandline(dic);
        showAllWords();
    }
    public static void main(String[] args) {
        dictionaryBasic();
    }
}

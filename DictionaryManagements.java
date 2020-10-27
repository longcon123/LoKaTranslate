import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DictionaryManagements {
    private final Scanner sc = new Scanner(System.in);
    private final Dictionary dic = new Dictionary();
    private int tongsotuFix = 0;
    /**public DictionaryManagements(Dictionary dic) {
        DictionaryManagements.dic = dic;
    }*/
    public DictionaryManagements() {
    }
    public void insertFromCommandline() {
        long n = sc.nextLong();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String eWord = sc.nextLine();
            String vExpl = sc.nextLine();
            Word word = new Word(eWord, vExpl);
            dic.addMap(eWord, word);
            dic.addList(word);
            //stt++;mk
        }
    }
    /**public static String getWord(int i) {
        return dic.getWords(i).getWord_target();
    }*/
    /**public static String getWordDefiMap(String word) {
        return dic.getWords(word).getWord_explain();
    }*/
    public int getSize() {
        return dic.getSizeMap();
    }
    //int i = 0;
    public void insertFromFile(String path) throws IOException {
        FileReader fis = new FileReader(path);
        BufferedReader br = new BufferedReader(fis);
        FileReader fis1 = new FileReader("D:\\BTL_Dictionary\\src\\main\\resources\\fixE-V.txt");
        BufferedReader br1 = new BufferedReader(fis1);
        String line;
        String line1;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("<html>");
            //System.out.println(split[0]);
            Word word = new Word(split[0].toLowerCase(),"<html>" + split[1]);
            dic.addMap(split[0].toLowerCase(), word);
            dic.addList(word);
        }
        while ((line1 = br1.readLine()) != null) {
            tongsotuFix++;
            String[] split = line1.split("<newW>");
            //System.out.println(split[0]);
            String oldWord = split[0];
            String newWord = split[1];
            String newDef = split[2];
            Word word = new Word(newWord, newDef);
            dic.addFixMap(word);
            if(dic.mapIsContain(oldWord) && newWord.equals(oldWord)) {
                dic.getWordsMap(oldWord).setWord_explain(newDef);
                dic.addListDefi(oldWord, newDef);
            }
            else if (dic.mapIsContain(oldWord) && !(newWord.equals(oldWord))) {
                dic.getWordsMap(oldWord).setWord_target(newWord);
                dic.removeListWord(oldWord);
                dic.addList(word);
                //dic.getWordList(oldWord).
            }
            else if (!dic.mapIsContain(oldWord)) {
                dic.addMap(newWord, word);
                dic.addList(word);
            }
        }
    }
    public List<String> searchWordByChar(String str) {
        List<String> lst = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if(!str.isEmpty()) {
            List<Word> words = new ArrayList<>(dic.getWordList(str));
            for (int i = 0; i < words.size(); i++) {
                for (int j = 0; j < str.length(); j++) {
                    if (words.get(i).getWord_target().length() < str.length()) {
                        break;
                    } else if (words.get(i).getWord_target().charAt(j) != str.charAt(j)) {
                        break;
                    }
                    if (j == str.length() - 1) {
                        lst.add(words.get(i).getWord_target());
                    }
                }
            }
        }
        int n = lst.size();
        if(n >= 15) {
            for(int i = 0; i < 15; i++) {
                temp.add(lst.get(i));
            }
        }
        else {
            for(int i = 0; i < n; i++) {
                temp.add(lst.get(i));
            }
        }
        return temp;
    }
    public String searchWordByEnter(String str) {
        if(dic.mapIsContain(str)) {
            return dic.getWordsMap(str).getWord_explain();
        }
        return "-1";
    }
    public int getTongsotuFix() {
        return this.tongsotuFix;
    }
    public String getWordEx(String str) {
        return dic.getWordsMap(str).getWord_explain();
    }
    public String getWordTarget(String str) {
        return dic.getWordsMap(str).getWord_target();
    }
    public void addNewWord(String newWord, String newDefi) {
        String formatFix = newWord + "<newW>" + newWord + "<newW>" + newDefi;
        Word word = new Word(newWord, formatFix);
        if(!(dic.mapIsContain(newWord))) {
            dic.addMap(newWord, word);
            dic.addList(word);
            dic.addFixMap(word);
        }
        tongsotuFix++;
    }
    /**public void fixWord(String oldWord, String newWord) {
        String formatFix = oldWord + "<newW>" + newWord + "<newW>"  + dic.getWordsMap(oldWord).getWord_explain();
        String formatDef = "<html><i>" + newWord + "</i><br/><ul><li><font color='#cc0001'><b> " + dic.getWordsMap(oldWord).getWord_explain() + " </b></font></li></ul></html>";
        Word fixedWord = new Word(newWord, formatFix);
        if(!dic.mapIsContain(newWord)) {
            Word word = new Word(newWord, formatDef);
            dic.addMap(newWord, word);
            dic.removeWordMap(oldWord);
            dic.removeListWord(oldWord);
            dic.addList(word);
            dic.addFixMap(oldWord, fixedWord);
        }
        else{
            System.out.println("Da co tu nay roi");
        }
        tongsotuFix++;
    }*/
    public void fixDefi(String oldWord, String newDefi) {
        String formatFix = oldWord + "<newW>" + oldWord + "<newW>" + newDefi;
        Word fixedWord = new Word(oldWord, formatFix);
        if(dic.mapIsContain(oldWord)) {
            if(!(dic.getWordsMap(oldWord).getWord_explain().equals(newDefi))) {
                dic.getWordsMap(oldWord).setWord_explain(newDefi);
                dic.addListDefi(oldWord, newDefi);
            }
            dic.addFixMap(fixedWord);
        }
        tongsotuFix++;
    }
    /**
    public void fixDefiEng(String word, String newDefi) {
        String formatDefi = "<html><i>-manship</i><br/><ul><li><font color='#cc0001'><b> " + newDefi + " </b></font></li></ul></html>";
        /**"hallo<html><i>hallo /hə'lou/ (halloa) /hə'lou/ (hello) /'he'lou/</i><br/><ul><li>" +
                "<b><i> thán từ</i></b><ul><li><font color='#cc0000'>" +
                "<b> chào anh!, chào chị!</b></font></li></ul><ul><li><font color='#cc0000'>" +
                "<b> này, này</b></font></li></ul><ul><li><font color='#cc0000'>" +
                "<b> ô này! (tỏ ý ngạc nhiên)</b></font><ul></li></ul></ul></li></ul><ul><li>" +

                "<b><i> danh từ</i></b><ul><li><font color='#cc0000'>" +
                "<b> tiếng chào</b></font></li></ul><ul><li><font color='#cc0000'>" +
                "<b> tiếng gọi \"này, này\" !</b></font></li></ul><ul><li><font color='#cc0000'>" +
                "<b> tiếng kêu ô này \"! (tỏ ý ngạc nhiên) </b></font><ul></li></ul></ul></li></ul><ul><li>" +

                "<b><i> nội động từ</i></b><ul><li><font color='#cc0000'>" +
                "<b> chào</b></font></li></ul><ul><li><font color='#cc0000'>" +
                "<b> gọi \"này, này\"</b></font></li></ul><ul><li><font color='#cc0000'>" +
                "<b> kêu \"ô này\" (tỏ ý ngạc nhiên)</b></font></li></ul></li></ul></html>"
         */
        //dic.getWordsMap()Words(word).setWord_explain(newDefi);*/
    public void writeFile() {
        System.out.println("OK nhe!");
        File file = new File("D:\\BTL_Dictionary\\src\\main\\resources\\fixE-V.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(Map.Entry<String, Word> mapElement : dic.fixData.entrySet()){
                String word = mapElement.getKey();
                String dataWithNewLine = mapElement.getValue().getWord_explain() + System.getProperty("line.separator");
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void clearData() {
        dic.clear();
    }
    public boolean wordIsContain(String word) {
        return dic.mapIsContain(word);
    }
}


import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<Word> words = new ArrayList<Word>();
    public Dictionary() {
    }
    public void addWord(Word newWord) {
        this.words.add(newWord);
    }
    public int getSize() {
        return this.words.size();
    }
    public Word getWords(int i) {
        return this.words.get(i);
    }

}

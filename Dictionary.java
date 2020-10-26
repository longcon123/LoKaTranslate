import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Dictionary {
    //List<Word> words = new ArrayList<Word>();
    Map<String, Word> data = new HashMap<>();
    Map<String, Word> fixData = new HashMap<>();
    Map<String, Integer> trendWord = new HashMap<>();
    List<Word> a = new ArrayList<>();
    List<Word> b = new ArrayList<>();
    List<Word> c = new ArrayList<>();
    List<Word> d = new ArrayList<>();
    List<Word> e = new ArrayList<>();
    List<Word> f = new ArrayList<>();
    List<Word> g = new ArrayList<>();
    List<Word> h = new ArrayList<>();
    List<Word> i = new ArrayList<>();
    List<Word> j = new ArrayList<>();
    List<Word> k = new ArrayList<>();
    List<Word> l = new ArrayList<>();
    List<Word> m = new ArrayList<>();
    List<Word> n = new ArrayList<>();
    List<Word> o = new ArrayList<>();
    List<Word> p = new ArrayList<>();
    List<Word> q = new ArrayList<>();
    List<Word> r = new ArrayList<>();
    List<Word> s = new ArrayList<>();
    List<Word> t = new ArrayList<>();
    List<Word> u = new ArrayList<>();
    List<Word> v = new ArrayList<>();
    List<Word> w = new ArrayList<>();
    List<Word> x = new ArrayList<>();
    List<Word> y = new ArrayList<>();
    List<Word> z = new ArrayList<>();
    List<Word> other = new ArrayList<>();
    public Dictionary() {

    }
    public void addMap(String word,Word newWord) {
        this.data.put(word, newWord);
    }
    public int getSizeMap() {
        return this.data.size();
    }
    public boolean mapIsContain(String word) {
        return this.data.containsKey(word);
    }
    public Word getWordsMap(String key) {
        return this.data.get(key);
    }
    public void removeWordMap(String key) {
        this.data.remove(key);
    }
    public void addFixMap(Word newWord) {
        newWord.setWord_explain(newWord.getWord_explain());
        this.fixData.put(newWord.getWord_target(), newWord);
    }
    public int getSizeFixMap() {
        return this.fixData.size();
    }
    public boolean fixIsContain(String word) {
        return this.fixData.containsKey(word);
    }
    public Word getFixWords(String key) {
        return this.fixData.get(key);
    }
    public void addList(Word word) {
        if (word != null) {
            char chr = word.getWord_target().charAt(0);
            if (Character.isLetter(chr)) {
                switch (chr) {
                    case 'a':
                        a.add(word);
                        break;
                    case 'b':
                        b.add(word);
                        break;
                    case 'c':
                        c.add(word);
                        break;
                    case 'd':
                        d.add(word);
                        break;
                    case 'e':
                        e.add(word);
                        break;
                    case 'f':
                        f.add(word);
                        break;
                    case 'g':
                        g.add(word);
                        break;
                    case 'h':
                        h.add(word);
                        break;
                    case 'i':
                        i.add(word);
                        break;
                    case 'j':
                        j.add(word);
                        break;
                    case 'k':
                        k.add(word);
                        break;
                    case 'l':
                        l.add(word);
                        break;
                    case 'm':
                        m.add(word);
                        break;
                    case 'n':
                        n.add(word);
                        break;
                    case 'o':
                        o.add(word);
                        break;
                    case 'p':
                        p.add(word);
                        break;
                    case 'q':
                        q.add(word);
                        break;
                    case 'r':
                        r.add(word);
                        break;
                    case 's':
                        s.add(word);
                        break;
                    case 't':
                        t.add(word);
                        break;
                    case 'u':
                        u.add(word);
                        break;
                    case 'v':
                        v.add(word);
                        break;
                    case 'w':
                        w.add(word);
                        break;
                    case 'x':
                        x.add(word);
                        break;
                    case 'y':
                        y.add(word);
                        break;
                    case 'z':
                        z.add(word);
                        break;
                }
            } else {
                other.add(word);
            }
        }
    }
    public List<Word> getWordList(String word) {
            char chr = word.charAt(0);
            if (Character.isLetter(chr)) {
                switch (chr) {
                    case 'a':
                        return a;
                    case 'b':
                        return b;
                    case 'c':
                        return c;
                    case 'd':
                        return d;
                    case 'e':
                        return e;
                    case 'f':
                        return f;
                    case 'g':
                        return g;
                    case 'h':
                        return h;
                    case 'i':
                        return i;
                    case 'j':
                        return j;
                    case 'k':
                        return k;
                    case 'l':
                        return l;
                    case 'm':
                        return m;
                    case 'n':
                        return n;
                    case 'o':
                        return o;
                    case 'p':
                        return p;
                    case 'q':
                        return q;
                    case 'r':
                        return r;
                    case 's':
                        return s;
                    case 't':
                        return t;
                    case 'u':
                        return u;
                    case 'v':
                        return v;
                    case 'w':
                        return w;
                    case 'x':
                        return x;
                    case 'y':
                        return y;
                    case 'z':
                        return z;
                }
            }
        return other;
    }
    public int getSizeList(String word) {
        if (word != null) {
            char chr = word.charAt(0);
            if (Character.isLetter(chr)) {
                switch (chr) {
                    case 'a':
                        return a.size();
                    case 'b':
                        return b.size();
                    case 'c':
                        return c.size();
                    case 'd':
                        return d.size();
                    case 'e':
                        return e.size();
                    case 'f':
                        return f.size();
                    case 'g':
                        return g.size();
                    case 'h':
                        return h.size();
                    case 'i':
                        return i.size();
                    case 'j':
                        return j.size();
                    case 'k':
                        return k.size();
                    case 'l':
                        return l.size();
                    case 'm':
                        return m.size();
                    case 'n':
                        return n.size();
                    case 'o':
                        return o.size();
                    case 'p':
                        return p.size();
                    case 'q':
                        return q.size();
                    case 'r':
                        return r.size();
                    case 's':
                        return s.size();
                    case 't':
                        return t.size();
                    case 'u':
                        return u.size();
                    case 'v':
                        return v.size();
                    case 'w':
                        return w.size();
                    case 'x':
                        return x.size();
                    case 'y':
                        return y.size();
                    case 'z':
                        return z.size();
                }
            }
            return other.size();
        }
        return 0;
    }
    public void addListDefi(String word, String newDefi) {
        List<Word> temp = getWordList(word);
        for(int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getWord_target().equals(word)) {
                temp.get(i).setWord_explain(newDefi);
            }
        }
    }
    public void removeListWord(String word) {
        List<Word> temp = getWordList(word);
        for(int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getWord_target().equals(word)) {
                temp.remove(i);
                break;
            }
        }
    }
}

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.FileInputStream;

class KeyTypingManager {
    Deque<Character> expectedKeys;
    Deque<Integer> expectedRawLength;
    Deque<Integer> expectedKeyLength;
    Deque<Character> rawData;
    Trie<Character, HashSet<char[]>> trie;

    public KeyTypingManager() {
        Trie<Character, HashSet<char[]>> trie = new Trie(new HashSet());
        File file = new File("data.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while((line = reader.readLine()) != null) {
                String[] t = line.split(":");
                if (t.length < 2) {
                    continue;
                }
                trie.resetCursor();
                for (char i: t[0].toCharArray()) {
                    trie.transitOrAdd(i, new HashSet());
                }
                char[] b = t[1].toCharArray();
                trie.currentNode().add(b);
            }
        } catch (Exception e) {} finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {}
        }
        String str = ",、.。-ー[「]」";
        for (int i = 0; i < 10; i += 2) {
            trie.resetCursor();
            trie.transitOrAdd(str.charAt(i), new HashSet());
            trie.currentNode().add(new char[]{str.charAt(i + 1)});
        }
        trie.resetCursor();
        this.trie = trie;
    }

    public void append(String str) {
        this.genSequence(str, true);
    }

    void genSequence(String str, boolean pushBack) {
        int idx = 0;
        boolean isDiphthong = false;
        Deque<Character> tmpKeys = new ArrayDeque();
        Deque<Integer> tmpLen = new ArrayDeque();
        Deque<Integer> tmpKeyLen = new ArrayDeque();
        while (idx < str.length()) {
            char i = str.charAt(idx);
            char c = '\0';
            switch (i) {
                case '、':
                    c = ',';
                    break;
                case '。':
                c = '.';
                break;
                case 'ー':
                c = '-';
                break;
                case '「':
                c = '[';
                break;
                case '」':
                c = ']';
                break;
                default:
                if (i == 'ッ') {
                    if (isDiphthong) {
                        tmpKeys.push('x');
                        tmpKeys.push('t');
                        tmpKeys.push('u');
                        tmpLen.push(1);
                        tmpKeyLen.push(3);
                    }
                    isDiphthong = true;
                    idx += 1;
                } else if (i == 'ン') {
                    if (str.length() <= idx + 1 || "ンナニヌネノアイウエオヤユヨ".contains(new String(new char[]{str.charAt(idx + 1)}))) {
                        tmpKeys.push('n');
                        tmpKeys.push('n');
                        tmpKeyLen.push(2);
                    } else {
                        tmpKeys.push('n');
                        tmpKeyLen.push(1);
                    }
                    tmpLen.push(1);
                    idx += 1;
                } else if ("ァィゥェォヮャュョ".contains(new String(new char[]{i}))) {
                    tmpKeys.push('x');
                    switch (i) {
                        case 'ァ':
                        tmpKeys.push('a');
                        tmpKeyLen.push(2);
                        break;
                        case 'ィ':
                        tmpKeys.push('i');
                        tmpKeyLen.push(2);
                        break;
                        case 'ゥ':
                        tmpKeys.push('u');
                        tmpKeyLen.push(2);
                        break;
                        case 'ェ':
                        tmpKeys.push('e');
                        tmpKeyLen.push(2);
                        break;
                        case 'ォ':
                        tmpKeys.push('o');
                        tmpKeyLen.push(2);
                        break;
                        case 'ヮ':
                        tmpKeys.push('w');
                        tmpKeys.push('a');
                        tmpKeyLen.push(3);
                        break;
                        case 'ャ':
                        tmpKeys.push('y');
                        tmpKeys.push('a');
                        tmpKeyLen.push(3);
                        break;
                        case 'ュ':
                        tmpKeys.push('y');
                        tmpKeys.push('u');
                        tmpKeyLen.push(3);
                        break;
                        case 'ョ':
                        tmpKeys.push('y');
                        tmpKeys.push('o');
                        tmpKeyLen.push(3);
                        break;
                        default:
                        break;
                    }
                    tmpLen.push(1);
                    idx += 1;
                } else {
                    //
                }
            }
        }
    }

    public boolean onTyped(char c) {
        if (trie.isRoot()) {
            if (expectedKeys.size() >= 2) {
                char a = expectedKeys.getFirst();
                char b = expectedKeys.getFirst();
                if (rawData.getFirst() == 'ッ' && a == b) {
                    int t = (int)expectedKeyLength.pollFirst();
                    t -= 1;
                    expectedKeyLength.addFirst(t);
                    rawData.pollFirst();
                    expectedKeys.addFirst(b);
                    return true;
                }
                expectedKeys.addFirst(b);
                expectedKeys.addFirst(a);
            } else if (expectedKeys.size() == 0) {
                if (c == 'x' || c == 'l') {
                    rawData.pollFirst();
                    expectedKeys.pollFirst();
                    int t = (int)expectedKeyLength.pollFirst();
                    t -= 1;
                    expectedKeyLength.addFirst(t);
                    trie.transit(c);
                    genSequence("ッ", false);
                    expectedKeys.pollFirst();
                    return true;
                }
            }
        }
        if (!trie.transit(c)) return false;
        if (check()) {
            expectedKeys.pollFirst();
            int t = (int)expectedKeyLength.pollFirst();
            t -= 1;
            expectedKeyLength.addFirst(t);
            char a = rawData.pollFirst();
            if (rawData.peekFirst() != null) {
            }
        }
        return false;
    }

    boolean check() {
        if (this.rawData.isEmpty()) {
            return true;
        }
        char a = this.rawData.getFirst();
        ArrayList tmp = new ArrayList();
        tmp.add(a);
        if (this.trie.currentNode().contains(tmp)) {
            return true;
        }
        if (this.rawData.size() > 1) {
            char b = this.rawData.peekFirst();
            tmp.add(b);
            this.rawData.addFirst(a);
            if (this.trie.currentNode().contains(tmp)) {
                return true;
            }
        }
        for (var entry : this.trie.children().entrySet()) {
            this.trie.transit(entry.getKey());
            boolean r = this.check();
            this.trie.back();
            if (r) {
                return true;
            }
        }
        return false;
    }

    public String upcoming() {
        String s = new String();
        for (int i = 0; i < Math.min(16, this.expectedKeys.size()); i += 1) {
            //
        }
        return s;
    }
}

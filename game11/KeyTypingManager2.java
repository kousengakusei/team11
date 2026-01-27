import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.FileInputStream;
import java.lang.Process;
import java.lang.ProcessBuilder;
import java.lang.StringBuilder;

class KeyTypingManager2 {
    Process process;

    public KeyTypingManager2() {
        try {
            process = new ProcessBuilder("key_typing_manager.exe").start();
        } catch (Exception e) {}
    }
    
    void append(String str) {
        try {
            var w = process.getOutputStream();
            w.write(new byte[] {'p'});
            byte[] b = str.getBytes();
            w.write(b);
            w.write(new byte[] {'\n'});
            w.flush();
        } catch (Exception e) {
    }
}

public boolean onTyped(char c) {
    try {
        var w = process.getOutputStream();
        w.write(new byte[] {'t', (byte)c, '\n'});
        w.flush();
        var r = process.getInputStream();
        byte[] data = new byte[2];
        r.read(data);
        return data[0] == 't';
    } catch (Exception e) {
        return false;
    }
}

public String upcoming() {
    try {
        var w = process.getOutputStream();
        w.write(new byte[] {'x', '\n'});
        w.flush();
        var r = process.getInputStream();
        byte[] data = new byte[18];
        r.read(data);
            if (data[0] == 'o') {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < 18; i += 1) {
                    if (data[i] == '\n') {
                        break;
                    }
                    sb.append((char)data[i]);
                }
                return sb.toString();
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }
}

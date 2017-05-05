package P02_FileStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        Music music = new Music(12, 3);
        StreamProgressInfo info = new StreamProgressInfo(music);
        System.out.println(info.calculateCurrentPercent());
    }
}

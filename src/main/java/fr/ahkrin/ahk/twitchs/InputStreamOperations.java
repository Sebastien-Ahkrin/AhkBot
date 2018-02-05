package fr.ahkrin.ahk.twitchs;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamOperations {
    public static String InputStreamToString (InputStream in, int bufSize) {
        final StringBuilder out = new StringBuilder();
        final byte[] buffer = new byte[bufSize];
        try {
            for (int ctr; (ctr = in.read(buffer)) != -1;) {
                out.append(new String(buffer, 0, ctr));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot convert stream to string", e);
        }
        return out.toString();
    }

    public static String InputStreamToString (InputStream in) {
        return InputStreamToString(in, 1024);
    }
}

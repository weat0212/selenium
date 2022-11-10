package main.java.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author created by andy.wang
 * @Date on 2022/6/15
 */
public class IOUtils {

    /**
     * 在console輸入值
     * @param msg
     * @return
     * @throws IOException
     */
    public static String inputValue(String msg) throws IOException {
        System.out.println("Enter ".concat(msg).concat(":"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}

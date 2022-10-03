package main.java.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;

/**
 * @author created by andy.wang
 * @Date on 2022/6/15
 */
public class CommonUtils {

    public static String inputValue(String msg) throws IOException {
        System.out.println("Enter ".concat(msg).concat(":"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}

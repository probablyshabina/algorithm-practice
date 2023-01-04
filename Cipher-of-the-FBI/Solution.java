import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int strLength = 0;
        String message = "";
        int rotateBy = 0;

        InputStreamReader io = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(io);

        try {
            strLength = Integer.parseInt(br.readLine());
            message = br.readLine();
            rotateBy =  Integer.parseInt(br.readLine());
            String alphabets = "abcdefghijklmnopqrstuvwxyz";
            char[] newAlphaUp = new char[alphabets.length()];
            char[] newAlphaLow = new char[alphabets.length()];

            for (int i = 0; i < alphabets.length(); i++) {
                newAlphaUp[i] = alphabets.toUpperCase().toCharArray()[(i + rotateBy) % alphabets.length()];
                newAlphaLow[i] = alphabets.toLowerCase().toCharArray()[(i + rotateBy) % alphabets.length()];
            }

            char[] msg = new char[strLength];
            msg = message.toCharArray();

            char[] newMsg = new char[strLength];

            for (int i = 0; i < msg.length; i++) {
                for (int j = 0; j < alphabets.length(); j++) {
                    if(msg[i] == alphabets.toCharArray()[j]){
                        newMsg[i] = newAlphaLow[j];
                        System.out.print(newAlphaLow[j]);
                        break;
                    }
                    else if(msg[i] == alphabets.toUpperCase().toCharArray()[j]){
                        newMsg[i] = newAlphaUp[j];
                        System.out.print(newAlphaUp[j]);
                        break;
                    }
                    else if(msg[i] == '-' ||  msg[i] == ','){
                        newMsg[i] = msg[i];
                        System.out.print(newMsg[i]);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
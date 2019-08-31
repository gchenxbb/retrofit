package com.retrofit.character;

public class CharacterUtil {


    public static int codePointAt(String str, int index) {
        if ((index < 0) || (index >= str.length())) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return Character.codePointAt(str, index);
    }

}

package com.bikash.springjpa.utility;

public class TokenRandomCharacters {
    public static String generateToken(){
        String alphabetsInUpperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetsInLowerCase="abcdefghijklmnopqrstuvwxyz";
        String numbers ="1234567890";

        String allCharacters = alphabetsInLowerCase+alphabetsInUpperCase+numbers;

        StringBuffer randomStrg = new StringBuffer();
        for(int i=0;i<10;i++){
            //generate random number between 0 and length of all characters
            int randomIndex = (int) (Math.random()*allCharacters.length());
            //retrieve
            randomStrg.append(allCharacters.charAt(randomIndex));
        }
        return randomStrg.toString();
    }

}

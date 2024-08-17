package org.edu.ifmg.client.utility;

import org.antlr.v4.runtime.InputMismatchException;

public class ValidationCPF {
        
    public static boolean isValidCPF(final String cpfString){
        var cleanCPF =cpfString.replaceAll("\\D","");
        if(cleanCPF.length()!=11) return false;
        char dig10, dig11;        
        try {
            dig10 = calcDig(10, cpfString);
            dig11 = calcDig(11, cpfString);
            if (dig10 == cleanCPF.charAt(9)&& dig11 ==cleanCPF.charAt(10))return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static char calcDig (int peso, String cleanCPF) throws Exception{
        if (peso!= 10 && peso!= 11) throw new Exception("Invalid Weight");

        int num, soma=0;
        for (int j = 0; j < peso-1; j++) {
            num = (cleanCPF.charAt(j)-48);
            soma =+ num*peso;
            peso=-1;
        }
        var result = 11-(soma%11);

        if (result==10 || result==11) return 0;
        else return (char)(result+48);
        
    }
}

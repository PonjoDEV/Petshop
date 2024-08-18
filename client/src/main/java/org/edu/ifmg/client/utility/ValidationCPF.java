package org.edu.ifmg.client.utility;

public class ValidationCPF {

    public static boolean isValidCPF(final String cpfString) {
        var cleanCPF = cpfString.replaceAll("\\D", "");
        if (cleanCPF.length() != 11) return false;
        char dig10, dig11;
        try {
            dig10 = calcDig(10, cleanCPF);
            dig11 = calcDig(11, cleanCPF);
            return dig10 == cleanCPF.charAt(9) && dig11 == cleanCPF.charAt(10);
        } catch (Exception e) {
            return false;
        }
    }

    private static char calcDig(int peso, String cleanCPF) throws IllegalArgumentException {
        if (peso != 10 && peso != 11) throw new IllegalArgumentException("Invalid Weight");

        var i = peso - 1;
        int num, soma = 0;
        for (int j = 0; j < i; j++) {
            num = (cleanCPF.charAt(j) - 48);
            soma = soma + (num * peso);
            peso = peso - 1;
        }

        int result = 11 - (soma % 11);
        if (result == 10 || result == 11) return '0';
        else return (char) (result + 48);
    }
}

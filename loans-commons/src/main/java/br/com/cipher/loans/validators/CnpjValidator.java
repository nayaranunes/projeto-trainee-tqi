package br.com.cipher.loans.validators;


import br.com.cipher.loans.error.RequestException;

public class CnpjValidator {

    public static void isCnpj(String cnpj) {

        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
                (cnpj.length() != 14)) {
            throw new RequestException("Invalid CNPJ! Try to check your request.");
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        // first verifying digit
        sm = 0;
        peso = 2;
        for (i = 11; i >= 0; i--) {

            // convert the i-ésimo character in a number:
            num = cnpj.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig13 = '0';
        else dig13 = (char) ((11 - r) + 48);

        // second verifying digit
        sm = 0;
        peso = 2;
        for (i = 12; i >= 0; i--) {
            num = cnpj.charAt(i) - 48;
            sm = sm + num * peso;
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig14 = '0';
        else dig14 = (char) ((11 - r) + 48);

        // Verify if the digits matches with the entered digits
        if (!(dig13 == cnpj.charAt(12) && dig14 == cnpj.charAt(13)))
            throw new RequestException("Invalid CNPJ! Try to check your request.");
    }
}

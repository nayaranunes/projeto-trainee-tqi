package br.com.cipher.loans.validator;

import br.com.cipher.loans.error.RequestException;

public class ContactValidator {

    public static void phone(String phone) {

        if (!(phone.matches("[0-9]{10}")) && !(phone.matches("[0-9]{11}"))) {
            throw new RequestException("Invalid phone number!");
        }
    }

    public static void email(String email) {
        if (!email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9]" +
                "(?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9]" +
                "(?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
            throw new RequestException("Invalid email!");
        }
    }

}

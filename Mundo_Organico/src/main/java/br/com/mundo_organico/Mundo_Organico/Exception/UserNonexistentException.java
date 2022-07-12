package br.com.mundo_organico.Mundo_Organico.Exception;

import java.io.Serial;

public class UserNonexistentException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public UserNonexistentException(String msg) {
        super(msg);
    }
}

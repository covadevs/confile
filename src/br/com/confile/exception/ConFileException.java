package br.com.confile.exception;

import br.com.confile.ConFileErrorCode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConFileException extends Exception {

    private static final Logger LOGGER = Logger.getLogger(ConFileException.class.getName());

    public ConFileException(ConFileErrorCode error) {
        super(error.getMsg());
        LOGGER.log(Level.SEVERE, "ERROR CODE {0} - ".concat(error.getMsg()), error.getCode());
    }

}

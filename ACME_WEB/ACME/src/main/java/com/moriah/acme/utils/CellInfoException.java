package com.moriah.acme.utils;

public class CellInfoException extends Exception {
    /**
     * serialVersionUID format is YYYYMMDD for the date of the last binary change.
     */
    private static final long serialVersionUID = 20101208L;

    public CellInfoException(String cellInfoError, Throwable throwable)
    {
        super(cellInfoError, throwable);
    }
}

package com.moriah.acme.ws.rs;

public class JobException extends Exception {
    /**
     * serialVersionUID format is YYYYMMDD for the date of the last binary change.
     */
    private static final long serialVersionUID = 20101208L;

    public JobException(String cellInfoError, Throwable throwable)
    {
        super(cellInfoError, throwable);
    }
}

package com.company;

public class InvalidCatalogException extends Throwable {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }
    //public NUllCatalogException(Exception ex) { super("Null catalog.", ex); }
}

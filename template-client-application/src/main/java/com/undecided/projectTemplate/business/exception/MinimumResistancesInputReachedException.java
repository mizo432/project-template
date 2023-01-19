package com.undecided.projectTemplate.business.exception;

public class MinimumResistancesInputReachedException extends Exception {

    public MinimumResistancesInputReachedException() {
        super("Let at least 2 resistors to make parallel calculation!");
    }
}

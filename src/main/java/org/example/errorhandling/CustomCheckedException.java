package org.example.errorhandling;

class CustomCheckedException extends Exception {

    CustomCheckedException() {
        super();
    }

    CustomCheckedException(String message) {
        super(message);
    }

}


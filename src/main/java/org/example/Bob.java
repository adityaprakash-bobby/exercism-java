package org.example;

class Bob {

    private static final String QUESTION_RESPONSE = "Sure.";
    private static final String YELL_RESPONSE = "Whoa, chill out!";
    private static final String YELL_QUESTION_RESPONSE = "Calm down, I know what I'm doing!";
    private static final String SILENCE_RESPONSE = "Fine. Be that way!";
    private static final String ANYTHING_ELSE_RESPONSE = "Whatever.";


    private static boolean isQuestion(String input) {
        return input.trim().endsWith("?");
    }

    private static boolean isYell(String input) {
        return input.chars().filter(Character::isLetter).count() > 0
                && input == input.toUpperCase();
    }

    private static boolean isYellQuestion(String input) {
        return isQuestion(input) && isYell(input);
    }

    private static boolean isSilence(String input) {
        return input.strip().isEmpty();
    }

    String hey(String input) {

        if (isSilence(input)) return SILENCE_RESPONSE;
        else if (isYellQuestion(input)) return YELL_QUESTION_RESPONSE;
        else if (isQuestion(input)) return QUESTION_RESPONSE;
        else if (isYell(input)) return YELL_RESPONSE;
        else return ANYTHING_ELSE_RESPONSE;
    }
}

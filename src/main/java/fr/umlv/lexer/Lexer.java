package fr.umlv.lexer;

import java.util.Objects;
import java.util.Optional;

class Lexer<T> {

    private static final Lexer LEXER = new Lexer();

    static Lexer create() {
        return LEXER;
    }

    Optional<T> tryParse(String value) {
        Objects.requireNonNull(value);
        return Optional.empty();
    }

}
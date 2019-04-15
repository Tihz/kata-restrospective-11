package fr.umlv.lexer;

import java.util.Objects;
import java.util.Optional;

public class EmptyLexer<T> implements Lexer<T> {

    private static final EmptyLexer LEXER = new EmptyLexer();

    static EmptyLexer instance() {
        return LEXER;
    }

    public Optional<T> tryParse(String value) {
        Objects.requireNonNull(value);
        return Optional.empty();
    }
}

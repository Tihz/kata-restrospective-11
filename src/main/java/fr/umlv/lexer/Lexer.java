package fr.umlv.lexer;

import java.util.Optional;
import java.util.regex.Pattern;

interface Lexer<T> {

    static Lexer create() {
        return EmptyLexer.instance();
    }

    static Lexer from(String pattern) {
        return new GroupPatternLexer(pattern);
    }

    static Lexer from(Pattern pattern) {
        return new GroupPatternLexer(pattern);
    }

    Optional<T> tryParse(String value);

}
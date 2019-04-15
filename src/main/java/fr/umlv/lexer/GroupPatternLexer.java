package fr.umlv.lexer;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupPatternLexer implements Lexer<String> {

    private Pattern pattern;

    GroupPatternLexer(String pattern) {
        this(Pattern.compile(Objects.requireNonNull(pattern)));
    }

    GroupPatternLexer(Pattern pattern) {
        int groupCount = pattern.matcher("").groupCount();
        if (groupCount != 1) {
            throw new IllegalArgumentException("GroupPatternLexer can only capture one group, count: " + groupCount + "in " + pattern.pattern());
        }
        this.pattern = Objects.requireNonNull(pattern);
    }

    @Override
    public Optional<String> tryParse(String value) {
        return Optional.of(value)
                .map(pattern::matcher)
                .filter(Matcher::matches)
                .map(matcher -> matcher.group(1));
    }
}

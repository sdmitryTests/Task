package hse.projects.taskone.deserializers;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private String jsonArray;
    private int nestingLevel;
    private int currentIndex;

    public Separator(String jsonArray) {
        this.jsonArray = jsonArray;
        this.nestingLevel = 0;
        this.currentIndex = 0;
    }

    public Separator() {
    }

    public static void main(String[] args) {
        String jsonArray = "[{\"name\":\"andrey\",\"age\":\"20\"},{\"name\":\"dora\",\"age\":\"21\"}]";
        Separator separator = new Separator(jsonArray);
        System.out.println(separator.splitJsonArray());
    }

    private boolean verifyJsonArray() {
        return jsonArray.startsWith("[") && jsonArray.endsWith("]");
    }

    private void removeArrayBrackets() {
        jsonArray = jsonArray.substring(1, jsonArray.length() - 1);
    }

    private void rewindObject() {
        int startOfObject = currentIndex;
        for (; currentIndex < jsonArray.length() && nestingLevel > 0; currentIndex++) {
            switch (jsonArray.charAt(currentIndex)) {
                case '{' -> nestingLevel++;
                case '}' -> nestingLevel--;
            }
        }
        if (nestingLevel > 0) {
            throw new IllegalStateException("Bad format: there are no end bracket for begin bracket at " + startOfObject);
        }
    }

    public List<String> splitJsonArray() {
        if (!verifyJsonArray()) {
            throw new IllegalStateException("Bad format: it is not json array!");
        }
        removeArrayBrackets();
        List<String> strLst = new ArrayList<>();
        for (; currentIndex < jsonArray.length(); currentIndex++) {
            if (isBeginBracket()) {
                nestingLevel++;
                int startObjectIndex = currentIndex++;
                rewindObject();
                strLst.add(jsonArray.substring(startObjectIndex, currentIndex));
            } else if (isEndBracket()) {
                throw new IllegalStateException("Unexpected end bracket at " + currentIndex);
            } else if ()
                switch (jsonArray.charAt(currentIndex)) {
                    case '{' -> {

                    }
                    case '}' ->
                    case ',' -> currentIndex++;
                    default -> throw new IllegalStateException("Unexpected character at " + currentIndex);
                }
        }
        return strLst;
    }

    private boolean isBeginBracket() {
        return '{' == jsonArray.charAt(currentIndex);
    }

    private boolean isBeginBracket() {
        return '{' == jsonArray.charAt(currentIndex);
    }

    private boolean isEndBracket() {
        return '}' == jsonArray.charAt(currentIndex);
    }

    List<String> toStringList(String jsonList) {
        int bracketCounter = 0;
        boolean added = true;
        int startIndex = 1;
        StringBuilder sb = new StringBuilder(jsonList);
        List<String> strLst = new ArrayList<>();
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == '}') {
                --bracketCounter;
                added = false;
            }
            if (sb.charAt(i) == '{') {
                ++bracketCounter;
            }
            if (bracketCounter == 0 && !added) {
                added = true;
                strLst.add(sb.substring(startIndex, i + 1));
                startIndex = i + 1;
            }
        }
        return strLst;
    }
}

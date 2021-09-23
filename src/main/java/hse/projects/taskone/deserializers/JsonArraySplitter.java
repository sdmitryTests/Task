package hse.projects.taskone.deserializers;

import java.util.ArrayList;
import java.util.List;

public class JsonArraySplitter {
    private String jsonArray;
    private int nestingLevel;
    private int currentIndex;
    private List<String> strLst;

    public JsonArraySplitter(String jsonArray) {
        this.jsonArray = jsonArray;
        this.nestingLevel = 0;
        this.currentIndex = 0;
        this.strLst = new ArrayList<>();
    }

    public JsonArraySplitter() {
    }


    public List<String> splitJsonArray() {
        if (!verifyJsonArray()) {
            throw new IllegalStateException("Bad format: it is not json array!");
        }
        removeArrayBrackets();
        for (; currentIndex < jsonArray.length(); currentIndex++) {
            if (isBeginBracket()) {
                nestingLevel++;
                addJsonObjectToArray();
            } else if (isEndBracket()) {
                throw new IllegalStateException("Unexpected end bracket at index " + currentIndex);
            } else if (!isComma()){
                throw new IllegalStateException("Unexpected character at index " + currentIndex);
            }
        }
        return strLst;
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

    private void addJsonObjectToArray(){
        int startObjectIndex = currentIndex++;
        rewindObject();
        strLst.add(jsonArray.substring(startObjectIndex, currentIndex));
    }

    private boolean isComma() {
        return ',' == jsonArray.charAt(currentIndex);
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
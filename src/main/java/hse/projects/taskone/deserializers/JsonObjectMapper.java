package hse.projects.taskone.deserializers;

import java.util.HashMap;
import java.util.Map;

public class JsonObjectMapper {
    private String jsonObject;
    private int currentIndex = 0;
    private Map<String, String> jsonObjectFields = new HashMap<>();

    public Map<String, String> jsonObjectToMap(String jsonObject) {
        this.jsonObject = jsonObject;
        if (!isJsonObject() || isEmpty()) {
            throw new IllegalStateException("Wrong format: missing json object structure");
        }
        deleteBrackets();
        while (!isEmpty()){
            addFieldToMap();
        }
        return jsonObjectFields;
    }

    private boolean isEmpty() {
        return jsonObject.length() == 0;
    }

    private boolean isJsonObject() {
        return jsonObject.startsWith("{") && jsonObject.endsWith("}");
    }

    private void deleteBrackets() {
        jsonObject = jsonObject.substring(1, jsonObject.length() - 1);
    }

    private void addFieldToMap(){
        jsonObjectFields.put(extractJsonFieldName(), extractJsonFieldValue());
        deleteJsonObjectField();
    }
    private String extractJsonFieldName(){
        currentIndex = jsonObject.indexOf("\":") + 2;
        return jsonObject.substring(1, currentIndex - 2);
    }

    private boolean isStringField() {
        return jsonObject.charAt(currentIndex) == '\"';
    }

    private boolean isListField() {
        return jsonObject.charAt(currentIndex) == '[';
    }

    private boolean isLastField() {
        return !jsonObject.contains(",\"");
    }

    private String extractJsonFieldValue(){
        String val;
        if (isStringField()) {
            if (isLastField()){
                val = jsonObject.substring(currentIndex + 1, jsonObject.length() - 1);
                currentIndex = jsonObject.length();
            } else {
                val = jsonObject.substring(currentIndex + 1, jsonObject.indexOf("\",\""));
                currentIndex = jsonObject.indexOf("\",\"") + 2;
            }
        } else if (isListField()) {
            val = extractJsonList();
        } else {
            if (isLastField()){
                val = jsonObject.substring(currentIndex);
                currentIndex = jsonObject.length();
            } else {
            val = jsonObject.substring(currentIndex, jsonObject.indexOf(",\""));
            currentIndex = jsonObject.indexOf(",\"") + 1;
            }
        }
        return val;
    }

    private String extractJsonList() {
        int startIndex = currentIndex;
        currentIndex++;
        int nestingLevel = 1;
        for (; currentIndex < jsonObject.length() && nestingLevel > 0; currentIndex++){
            if (jsonObject.charAt(currentIndex) == '[') {
                nestingLevel++;
            } else if (jsonObject.charAt(currentIndex) == ']') {
                nestingLevel--;
            }
        }
        if (nestingLevel > 0) {
            throw new IllegalStateException("Wrong format: missing json List structure");
        }
        return jsonObject.substring(startIndex, currentIndex);
    }

    private void deleteJsonObjectField() {
        jsonObject = jsonObject.substring(currentIndex);
    }
}

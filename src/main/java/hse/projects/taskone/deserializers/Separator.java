package hse.projects.taskone.deserializers;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    List<String> toStringList(String str) {
        int bracketCounter = 0;
        boolean added = true;
        int startIndex = 1;
        StringBuilder sb = new StringBuilder(str);
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

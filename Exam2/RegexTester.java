package TU_Java.Exam2;

import java.util.ArrayList;
import java.util.List;

public class RegexTester {
    public static List<Boolean> test(Regex regex, String[] strings){
        List<Boolean> inList = new ArrayList<>();
        for (String str : strings) {
            boolean matcher = str.matches(regex.getPattern());
            if (matcher){
                inList.add(true);
            }else {
                inList.add(false);
            }
        }
        return inList;
    }
}

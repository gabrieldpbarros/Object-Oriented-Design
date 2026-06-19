package comparators;
import java.util.Comparator;

public class LastCharacter implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int s1Index = s1.length() - 1;
        int s2Index = s2.length() - 1;
        char a = s1.charAt(s1Index);
        char b = s2.charAt(s2Index);

        if (a > b) return 1;
        if (a < b) return -1;
        return 0;
    }
}

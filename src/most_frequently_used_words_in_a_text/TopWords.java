package most_frequently_used_words_in_a_text;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * �������� �������, �������, ������� ������ ������ (��������, � ����������� � ��������� �����),
 * ���������� ������ ���-3 �������� ������������� ���� � ������� �������� ����� ���������.
 *
 * �������������:
 * ����� ������������ ����� ������ ���� (�� A �� Z), ������������� ���������� ���� ��� ��������� ���������� () � ASCII.'
 * ��������� ����� ���������� � ������, �������� ��� ����� ����� (, , , ��� ��� �������������)'abcabc''abc'ab'c
 * ����� ������ ������� (��������, , , , ...) �� �������� ������ ����� � ������ ��������������� ��� �������.#\/.
 * ���������� ������ ���� ��������������� � ��������, � ����� � ���������� ������ ���� � ������ ��������.
 * ����� ����� ���� ��������� �����������.
 * ���� ����� �������� ����� ���� ���������� ����, �� ������ ���� ���������� ���� ���-2,
 * ���� ���-1 �����, ���� ������ ������, ���� ����� �� �������� ����.
 *
 * �������:
 * top_3_words("In a village of La Mancha, the name of which I have no desire to call to
 * mind, there lived not long since one of those gentlemen that keep a lance
 * in the lance-rack, an old buckler, a lean hack, and a greyhound for
 * coursing. An olla of rather more beef than mutton, a salad on most
 * nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
 * on Sundays, made away with three-quarters of his income.")
 * # => ["a", "of", "on"]
 *
 * top_3_words("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e")
 * # => ["e", "ddd", "aa"]
 *
 * top_3_words("  //wont won't won't")
 * # => ["won't", "wont"]
 *
 * ��� ������������� Java ������ �� ����� ���� ����� ����� ���: , ������, ��� �� ������� .TopWords.top3(String s)List<String>
 *
 * �������� ����� (�� ������, � ������ ��� ������������):
 * ��������� �������� �������, ����� ������ �������� �������� ����� ������ ��������� ������.
 * ��������� ���������� ����� ������� ���������� ����.
 */

public class TopWords {

    public static void main(String[] args) {
        System.out.println(top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
    }

    public static final int LIMIT = 3;

    public static List<String> top3(String string) {
        final Map<String, Integer> wordsCount = new HashMap<>();

        Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z']*");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String s = matcher.group().toLowerCase();
            wordsCount.put(s, wordsCount.getOrDefault(s, 1) + 1);
        }

        List<Map.Entry<String, Integer>> topWords = new ArrayList<>(wordsCount.entrySet());
        topWords.sort(Map.Entry.comparingByValue());
        ArrayList<String> result = new ArrayList<>();
        int j = 0;
        for (int i = topWords.size() - 1; i >= 0; i--) {
            String s = topWords.get(i).getKey();
            if (j > 2 || s == null || s.length() == 0) {
                break;
            }
            if (Character.isAlphabetic(s.charAt(0))) {
                result.add(j, topWords.get(i).getKey());
                j++;
            }
        }

        result.trimToSize();
        return result;
    }

    public static List<String> top3_streams(String string) {
        final Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z']*");
        final Matcher matcher = pattern.matcher(string.toLowerCase());
        final Map<String, Integer> wordsCount = new HashMap<>();

        while (matcher.find()) {
            String s = matcher.group();
            wordsCount.put(s, wordsCount.getOrDefault(s, 1) + 1);
        }

        return wordsCount.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

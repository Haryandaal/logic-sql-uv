import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramGroup {
    public static void main(String[] args) {
        String[] input = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        List<List<String>> output = groupAnagrams(input);

        // Cetak hasil
        for (List<String> group : output) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String str : strings) {
            // Mengurutkan karakter dalam string (manual tanpa fungsi bawaan seperti Arrays.sort)
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = 0; j < chars.length - i - 1; j++) {
                    if (chars[j] > chars[j + 1]) {
                        char temp = chars[j];
                        chars[j] = chars[j + 1];
                        chars[j + 1] = temp;
                    }
                }
            }
            String sorted = new String(chars); // String yang sudah diurutkan

            // Tambahkan ke grup berdasarkan string yang diurutkan
            if (!groups.containsKey(sorted)) {
                groups.put(sorted, new ArrayList<>());
            }
            groups.get(sorted).add(str);
        }

        // Konversi HashMap ke List<List<String>>
        return new ArrayList<>(groups.values());
    }
}
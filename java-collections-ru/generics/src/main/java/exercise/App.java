package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books,
                                                      Map<String, String> searchParams) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {

            boolean check = false;

            for (Map.Entry<String, String> param : searchParams.entrySet()) {
                if (book.containsKey(param.getKey()) && book.containsValue(param.getValue())) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }

            if (check) {
                result.add(book);
            }
        }
        return result;
    }
}
//END

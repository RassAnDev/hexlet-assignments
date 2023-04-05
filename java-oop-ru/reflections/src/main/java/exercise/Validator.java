package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address addressForValidation) {
        List<String> result = new ArrayList<>();

        for (Field field : addressForValidation.getClass().getDeclaredFields()) {
            NotNull annotation = field.getAnnotation(NotNull.class);
            boolean isNullFieldValue = false;

            try {
                field.setAccessible(true);
                isNullFieldValue = field.get(addressForValidation) == null;
            } catch (IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace();
            }

            if (annotation != null && isNullFieldValue) {
                result.add(field.getName());
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address addressForValidation) {
        Map<String, List<String>> result = new HashMap<>();

        for (Field field : addressForValidation.getClass().getDeclaredFields()) {
            NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
            MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
            Object fieldValue;
            boolean isNullFieldValue = false;
            boolean isMinLengthValue = false;

            try {
                field.setAccessible(true);
                fieldValue = field.get(addressForValidation);
                isNullFieldValue =  fieldValue == null;
                Integer fieldLength = isNullFieldValue ? 0 : fieldValue.toString().length();
                isMinLengthValue = minLengthAnnotation != null && fieldLength >= minLengthAnnotation.minLength();
            } catch (IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace();
            }

            if (notNullAnnotation != null && isNullFieldValue) {
                result.put(field.getName(), List.of("can not be null"));
            } else if (minLengthAnnotation != null && !isMinLengthValue) {
                result.put(field.getName(), List.of("length less than 4"));
            }
        }
        return result;
    }
}
// END

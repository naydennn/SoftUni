package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

		String input = reader.readLine();

		while (!input.equals("HARVEST")) {

			switch (input) {
				case "private":
					getFields(declaredFields, f -> Modifier.isPrivate(f.getModifiers()));
					break;
				case "protected":
					getFields(declaredFields, f -> Modifier.isProtected(f.getModifiers()));
					break;
				case "public":
					getFields(declaredFields, f -> Modifier.isPublic(f.getModifiers()));
					break;
				case "all":
					Arrays.stream(declaredFields)
							.forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " "+ f.getType().getSimpleName() + " " + f.getName()));
					break;
			}
			input = reader.readLine();
		}
	}

	private static void getFields(Field[] declaredFields, Predicate<Field> predicate) {
		Arrays.stream(declaredFields)
				.filter(predicate)
				.forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName()));
	}
}

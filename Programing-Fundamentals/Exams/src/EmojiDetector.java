import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        long coolThreshold = 1;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (Character.isDigit(symbol)){
                coolThreshold *= Character.getNumericValue(symbol);
            }
        }
        List<String> emojis = new ArrayList<>();

        Pattern pattern = Pattern.compile("(?<emoji>([:]{2}|[*]{2})[A-Z][a-z]{2,}\\2)");
        Matcher matcher = pattern.matcher(input);
        int emojiCount = 0;

        while (matcher.find()) {
            String emoji = matcher.group("emoji");
            long emojiCool =0;

            for (int i =2; i < emoji.length()-2; i++) {
                emojiCool += emoji.charAt(i);
            }
            if (emojiCool > coolThreshold){
                emojis.add(emoji);
            }
            emojiCount++;
        }
        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println(emojiCount + " emojis found in the text. The cool ones are:");

        for (String s : emojis) {
            System.out.println(s);
        }
    }
}

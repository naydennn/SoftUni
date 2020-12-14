import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i <numberOfSongs ; i++) {
            String[] input = scanner.nextLine().split("_");
            Song s = new Song(input[0],input[1], input[2]);
            songs.add(s);
        }
        String nameOfPrintSong = scanner.nextLine();

        if (nameOfPrintSong.equals("all")) {
            for (Song song: songs) {
                System.out.println(song.getName());
            }
        } else {
        for (Song song:songs) {
            if (song.getType().equals(nameOfPrintSong)) {
                System.out.println(song.getName());
            }
        }
        }

    }
    public static class Song {
        String type;
        String name;
        String time;

        Song (String type, String name, String time) {
            this.type = type;
            this.name = name;
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}

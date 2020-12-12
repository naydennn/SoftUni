import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        for(int i = 1; i <= 9;i++){
            if(N%i != 0){
                continue;
            }
            for(int o = 1;o <= 9;o++){
                if(N%o != 0){
                    continue;
                }
                for(int p = 1;p <= 9;p++){
                    if(N%p != 0){
                        continue;
                    }
                    for (int a = 1; a <= 9;a++){
                        if(N%a != 0){
                            continue;
                        }
                        System.out.printf("%d%d%d%d ",i,o,p,a);

                    }
                }
            }
        }
    }
}


import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        return Integer.parseInt(scanner.nextLine());
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        String input = scanner.nextLine().replace(',', '.'); // Substitui vírgula por ponto
        return Double.parseDouble(input);
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}

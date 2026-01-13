import java.util.Scanner;

public class CrxUrlBuilder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Chromium version and Extension ID (or 'exit' to quit)");

        while (true) {
            System.out.print("> ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Bye.");
                break;
            }

            String[] parts = line.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Correct format: <VERSION> <EXTENSION_ID>");
                continue;
            }

            String version = parts[0];
            String extensionId = parts[1];

            String url = buildCrxUrl(version, extensionId);
            System.out.println(url);
        }

        scanner.close();
    }

    private static String buildCrxUrl(String version, String extensionId) {
        return "https://clients2.google.com/service/update2/crx"
                + "?response=redirect"
                + "&acceptformat=crx2,crx3"
                + "&prodversion=" + version
                + "&x=id%3D" + extensionId + "%26installsource%3Dondemand%26uc";
    }
}

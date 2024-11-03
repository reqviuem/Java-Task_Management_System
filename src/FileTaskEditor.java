import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTaskEditor  {

    public void editFile() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the name of the file you want to edit:");
        String name = scan.nextLine();
        String filename = name + ".txt";

        File file = new File("./Tasks/" + filename);
        if (!file.exists()) {
            System.out.println("File does not exist! Please try again!!");
            return;
        }

        System.out.println("Enter the new content (type END on a new line when finished):");
        StringBuilder text = new StringBuilder();
        String inputLine;
        while (!(inputLine = scan.nextLine()).equals("END")) {
            text.append(inputLine);
            text.append(System.lineSeparator());
        }
        ContentIdentification contentIdentification = new ContentIdentification();
        contentIdentification.identifyContent(filename, text);
        contentIdentification.displayContentList(filename);

        String fileLocation = "./Tasks/" + filename;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, false));) {
            writer.write(text.toString());
            System.out.println("Text successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

    }


}

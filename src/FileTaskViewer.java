import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileTaskViewer   {
    public void show() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to show:");
        String name = scan.nextLine();


        try {

            File file = new File("./Tasks/" + name + ".txt");
            try (Scanner fileReader = new Scanner(file)) {
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    System.out.println(line);
                }
            }
            System.out.println("The file is shown.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please try again!!");
        }
    }


}
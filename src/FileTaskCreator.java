import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileTaskCreator  {



    public void createFile()
    {
        try
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the name of the file you want to create:");
            String name = scan.nextLine();
            String fullFileName = name + ".txt";

            File file = new File("./Tasks/" + fullFileName);


            if (file.createNewFile())
            {
                System.out.println("File created: " + file.getName());
            }
            else
            {
                System.out.println("File already exists.");
                return;
            }


            System.out.println("Enter the text you want to write to the file (type END on a new line when finished):");
            StringBuilder text = new StringBuilder();
            String inputLine;
            while (!(inputLine = scan.nextLine()).equals("END"))
            {
                text.append(inputLine);
                text.append(System.lineSeparator());
            }


            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            writer.write(text.toString());
            System.out.println("Text successfully written to the file.");
            writer.close();


            ContentIdentification contentIdentification = new ContentIdentification();
            contentIdentification.identifyContent(fullFileName, text);
            contentIdentification.displayContentList(fullFileName);

            System.out.println("Would you like to link the new task? (yes/no)");
            String linkAnotherTask = scan.nextLine();

            if (linkAnotherTask.equalsIgnoreCase("yes")) {
                new Linking(fullFileName);
            }



        }
        catch (Exception e)
        {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }


}
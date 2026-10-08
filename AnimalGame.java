
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
public class AnimalGame {
    public static void main(String[] args) 
    {
        ArrayCollection<String> animals = new ArrayCollection<String>();
        try{
            File file = new File("Animals.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                animals.add(scanner.nextLine());
            }
            scanner.close();

            int random = (int)(Math.random() * 26 + 65);
            char letter = (char) random;
            /*
            for(int i = 0; i < 100; i++)
            {
                System.out.println(i+": "+(char)(i));
            }
            */
            System.out.println("Your letter is: " + letter);
        } catch (FileNotFoundException e) {
            System.out.println("ok so the coder did something stupid and now the file is gone \noops");
        }
        System.out.println("The End!");
    }
}

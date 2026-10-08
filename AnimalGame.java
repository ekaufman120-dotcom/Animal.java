
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
        } catch (FileNotFoundException e) {
            System.out.println("ok so the coder did something stupid and now the file is gone \noops");
        }

        if(animals.isEmpty())
        {
            System.out.println("The file is empty or not found, so the game cannot proceed.");
            throw new RuntimeException("The file is empty or not found, so the game cannot proceed.");
        }

        int random = (int)(Math.random() * 26 + 65);
        char letter = (char) random;
        /*
        for(int i = 0; i < 100; i++)
        {
            System.out.println(i+": "+(char)(i));
        }
        */
        int correct = 0;
        while(gameRound(animals, letter)) 
        {
            correct++;
        }
        System.out.println("You got " + correct + " correct answer(s).");

    }

    public static boolean gameRound(ArrayCollection<String> animals, char letter)
    {
        System.out.println("Enter an animal that starts with the letter " + letter + ": ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("You entered: " + input);
        if(animals.contains(input) && input.charAt(0) == letter)
        {
            animals.remove(input);
            System.out.println("Correct!");
            return true;
        }
        if(!animals.contains(input))
        {
            System.out.println("That animal is not in the list, you lose!");
        }
        if(input.length()>0&&input.charAt(0) != letter)
        {
            System.out.println("That animal does not start with your letter " + letter + ", you lose!");
        }
        return false;
    }
}

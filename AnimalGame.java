
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
                animals.add(scanner.nextLine().toLowerCase());
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
        ArrayCollection<String> duplicates = new ArrayCollection<String>();
        int random = (int)(Math.random() * 26 + 65);
        String letter =  ""+(char)(random);
        letter = letter.toLowerCase();
        /*
        for(int i = 0; i < 100; i++)
        {
            System.out.println(i+": "+(char)(i));
        }
        */
        //only ONE scanner used, rather than making one every time
        Scanner scanner = new Scanner(System.in);
        int correct = 0;
        while(gameRound(animals, duplicates, letter, scanner)) 
        {
            correct++;
        }
        System.out.println("You got " + correct + " correct answer(s).");
        scanner.close();

    }

    public static boolean gameRound(ArrayCollection<String> animals, ArrayCollection<String> duplicates, String letter, Scanner scanner)
    {
        if(duplicates.isEmpty())
        {
            System.out.println("Enter an animal that starts with the letter " + letter.toUpperCase() + ": ");
        }
        else
        {
            System.out.println("Enter an animal that starts with the following letter (no repeats!): " + letter.toUpperCase());
        }
        String input = scanner.nextLine().toLowerCase();
        System.out.println("You entered: " + input);
        if(animals.contains(input) && input.charAt(0) == letter.charAt(0))
        {
            animals.remove(input);
            duplicates.add(input);
            System.out.println("Correct!");
            return true;
        }
        if(input.length()>0&&input.charAt(0) != letter.charAt(0))
        {
            System.out.println("That animal does not start with your letter " + letter.toUpperCase() + ", you lose!");
        }
        else if(!animals.contains(input)&&!duplicates.contains(input))
        {
            System.out.println("That animal is not in the list, you lose!");
        }
        else if(duplicates.contains(input))
        {
            System.out.println("That animal has already been used, you lose!");
        }
        else
        {
            System.out.println("Error: invalid accuracy case");
        }
        return false;
    }
}

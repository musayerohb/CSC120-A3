import java.util.Scanner;
import java.util.Random;


class Conversation {

  public static void main(String[] arguments) {

    String[] canned_responses = {"That's so cool!", "Wow!", "I never thought about that.", "Oh...", "Interesting..."};
    String[] mirror_words = {"I", "me", "am", "you", "my", "your", "are"};

    // You will start the conversation here.
    Scanner userInput = new Scanner(System.in);
    Random random = new Random();
    System.out.println("How many rounds? ");
    int round_number = userInput.nextInt();

    int rounds_passed = 0;
    System.out.println("Hi there! What do you want to talk about?");

    while (rounds_passed != round_number) {
      String user_response = userInput.next();
      int index = random.nextInt(canned_responses.length);
      System.out.println(canned_responses[index]);
      rounds_passed = rounds_passed + 1;
      
    }
    
    
  }
}

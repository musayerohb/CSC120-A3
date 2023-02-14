import java.util.Scanner;
import java.util.Random;


class Conversation {

  public static void main(String[] arguments) {

    String[] canned_responses = {"That's so cool!", "Wow!", "I never thought about that.", "Oh...", "Interesting..."};

    // You will start the conversation here.
    Scanner userInput = new Scanner(System.in);
    Random random = new Random();

    System.out.println("How many rounds? ");
    int round_number = userInput.nextInt();
    userInput.nextLine();

    int rounds_passed = 0;
    System.out.println("Hi there! What do you want to talk about?");
    boolean should_response_change = false;
    
    while (rounds_passed != round_number) {
      String user_response = userInput.nextLine();
      
      // Look for words to mirror
      String[] user_response_list = user_response.split(" ");
      should_response_change = false;
      
      for (int i = 0; i < user_response_list.length; i++){
        if (user_response_list[i].equals("I")){
          int position = i;
          user_response_list[position] = ("you");
          should_response_change = true;
          continue;
        }
        else if (user_response_list[i].equals("you")){
          int position = i;
          user_response_list[position] = ("I");
          should_response_change = true;
          continue;
        }
        else if (user_response_list[i].equals("your")){
          int position = i;
          user_response_list[position] = ("my");
          should_response_change = true;
          continue;
        }
        else if (user_response_list[i].equals("are")){
          int position = i;
          user_response_list[position] = ("am");
          should_response_change = true;
          continue;
        }
      }
      
      if (should_response_change == true) {
        String mirror_response = String.join(" ", user_response_list);
        System.out.println(mirror_response + "?");
      }
      else {
        int index = random.nextInt(canned_responses.length);
        System.out.println(canned_responses[index]);
      }
      rounds_passed = rounds_passed + 1;
    }
  }
}

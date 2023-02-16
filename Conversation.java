import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Conversation {
  public static void main(String[] arguments) {

    String[] canned_responses = {"That's so cool!", "Wow!", "I never thought about that.", "Oh...", "Interesting..."};

    
    // You will start the conversation here.
    Scanner userInput = new Scanner(System.in);
    Random random = new Random();

    System.out.println("How many rounds? ");

    //amt of rounds * 2 + 1

    int round_number = userInput.nextInt();
    userInput.nextLine();
    ArrayList <String> transcript = new ArrayList<String>();

    int rounds_passed = 0;
    System.out.println("Hi there! What do you want to talk about?");
    transcript.add("Hi there! What do you want to talk about?");

    boolean should_response_change = false;

    while (rounds_passed != round_number) {
      String user_response = userInput.nextLine();
      transcript.add(user_response);

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
        else if (user_response_list[i].equals("You")){
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
        else if (user_response_list[i].equals("Your")){
          int position = i;
          user_response_list[position] = ("My");
          should_response_change = true;
          continue;
        }
        else if (user_response_list[i].equals("my")){
          int position = i;
          user_response_list[position] = ("your");
          should_response_change = true;
          continue;
        }
        else if (user_response_list[i].equals("My")){
          int position = i;
          user_response_list[position] = ("Your");
          should_response_change = true;
          continue;
        }
        else if (user_response_list[i].equals("are")){
          int position = i;
          user_response_list[position] = ("am");
          should_response_change = true;
          continue;
        }
        else if (user_response_list[i].equals("Are")){
          int position = i;
          user_response_list[position] = ("Am");
          should_response_change = true;
          continue;
        }
      }
    if (should_response_change == true) {
      String mirror_response = String.join(" ", user_response_list);
      System.out.println(mirror_response + "?");
      transcript.add(mirror_response + "?");
    }

    else {
      int index = random.nextInt(canned_responses.length);
      //String random_canned_response = canned_responses[index]; 
      System.out.println(canned_responses[index]);
      transcript.add(canned_responses[index]);
    }
    
    rounds_passed = rounds_passed + 1;
  }
    System.out.println("See ya!");
    transcript.add("See ya!");
    System.out.println("");
    System.out.println("Transcript:");
    System.out.println(transcript);
    userInput.close();
    
  }
}
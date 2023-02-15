import java.util.Scanner;
import java.util.Random;


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
    String[] transcript = new String[round_number*2 + 2];

    int rounds_passed = 0;
    System.out.println("Hi there! What do you want to talk about?");
    transcript[0] = "Hi there! What do you want to talk about?";
    int transcript_index = 0;

    boolean should_response_change = false;
    
    while (rounds_passed != round_number) {
      String user_response = userInput.nextLine();
      transcript[(transcript_index+1)] = user_response;
      
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
        transcript[(transcript_index+1)] = mirror_response + "?";
      }
      else {
        int index = random.nextInt(canned_responses.length);
        String random_canned_response = canned_responses[index]; 
        System.out.println(random_canned_response);
        transcript[(transcript_index+1)] = random_canned_response;
      }
      rounds_passed = rounds_passed + 1;
    }
    userInput.close();
  
    System.out.println("Transcript");
    for (int m = 0; m < transcript.length; m++) {
      System.out.println(transcript[m]);
    }

  }
}

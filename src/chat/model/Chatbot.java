package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String[] verbs;
	private String[] topics;
	private String[] followUps;
	private String[] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;

	public Chatbot(String username)
	{
		// this.movieList = new ArrayList<String>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String[10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = null;
		this.topics = new String[7];
		this.verbs = new String[4];
		this.followUps = new String[5];

		buildVerbs();
		buildShoppingList();
		buildCuteAnimals();
		buildTopics();
		buildQuestions();
		// buildFollowups();
	}

	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}

	// private void buildMovieList()
	{
		// movieList.add("Spiderman");
		// movieList.add("Ratatoullie");
		// movieList.add("Hidden Figures");
		// movieList.add("Emoji Movie");
		// movieList.add("Your Name");
		// movieList.add("Back to the Future Box Set");
		// movieList.add("Shrek");
		// movieList.add("Shrek 2");
		// movieList.add("Shrek the Third");
		// movieList.add("Shrek; the Final Chapter");
		// movieList.add("The Calm Before the Storm");
	}

	private void buildTopics()
	{
		topics[0] = "Memes";
		topics[1] = "Sports";
		topics[2] = "dogs";
		topics[3] = "people";
		topics[4] = "Music";
		topics[5] = "Cars";
		topics[6] = "TV shows";
	}

	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("Veggies");
		shoppingList.add("protien");
		shoppingList.add("fruit");
		shoppingList.add("chicken tendies");
		shoppingList.add("noodles");
		shoppingList.add("a girlfriend");
		shoppingList.add("Pizza rolls");
		shoppingList.add("metal spoons");
		shoppingList.add("freshavacado");
	}

	private void buildCuteAnimals()//acceptable animal names that can be used
	{
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("hedgehog");
		cuteAnimalMemes.add("Dog");
		cuteAnimalMemes.add("Dik Dik");
	}

	private void buildQuestions()//lists of a bunch of questions that the chatbot can ask the user.
	{
		questions[0] = "How are you today?";
		questions[1] = "What Is your favorite sport?";
		questions[2] = "What Is your favorite TV show?";
		questions[3] = "Why do I exist?";
		questions[4] = "What is your favorite food?";
		questions[5] = "What is your favorite kind of dog?";
		questions[6] = "What is your favorite animal?";
		questions[7] = "What is your favorite kind of song?";
		questions[8] = "What is your favorite movie?";
		questions[9] = "What is your favorite book?";
	}

	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";

		chatbotResponse += buildChatbotResponse();

		return chatbotResponse;
	}

	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);

		response += verbs[random];

		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";

		random = (int) (Math.random() * topics.length);
		response += questions[random];

		return response;
	}

	public boolean lengthChecker(String input)
	{
		boolean validLength = false;

		if (input != null && input.length() > 2)
		{
			validLength = true;
		}

		return validLength;
	}

	public boolean htmlTagChecker(String input)
	{
		return false;
	}

	public boolean userNameChecker(String input)
	{
		boolean validUsername = false;
		
		if (input != "" && input != null && input.indexOf("@") <= 0 && input.indexOf("@") >= 0 && !input.contains("@"+"@"))
		{
			validUsername = true;
		}
		return validUsername;
	}

	public boolean contentChecker(String contentCheck)
	{
		return false;
	}

	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}

	public boolean shoppingListChecker(String shoppingItem)//clears the response to ensure that the item is valid
	{
		boolean validList = false;
		
		for (int index = 0; index < 11; index ++)
		{
			if(shoppingItem.contains(shoppingList.get(index)))
			{
				validList = true;
			}
		}
		return validList;
	}

	public boolean movieTitleChecker(String title)
	{
		return false;
	}

	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		boolean validQuit = false;

		if (exitString != "" && exitString != null && !exitString.equalsIgnoreCase("exit") && exitString.equalsIgnoreCase("quit"))
		{
			validQuit = true;
		}
		return validQuit;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}

	public List<Movie> getMovieList()
	{
		return movieList;
	}

	public List<String> getShoppingList()
	{
		return shoppingList;
	}

	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String[] getQuestions()
	{
		return questions;
	}

	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}

	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}

	public LocalTime getCurrentTime()
	{
		return null;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}

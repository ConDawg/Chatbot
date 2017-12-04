
package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	/*
	 * makes a neat looking
	 */
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
		this.content = "Words go here";
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

	/**
	 * Creates verbs that the chatbot can use in response to the user
	 * 
	 */
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

	// This includes topics that the chatbot
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

	/**
	 * Adds a bunch of food items that the chatbot can use in a converstation.
	 */
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

	/**
	 * acceptable animal names that can be used
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("hedgehog");
		cuteAnimalMemes.add("Dog");
		cuteAnimalMemes.add("Dik Dik");
	}

	/**
	 * lists of a bunch of questions that the chatbot can ask the user.
	 */
	private void buildQuestions()
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

	/**
	 * Methods operate by taking what is said and arranging that to the method's purpose(Creates a
	 * response). input the users text as a string. Returns the user input and a response built by
	 * buildChatbotResponse.
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";

		chatbotResponse += buildChatbotResponse();

		return chatbotResponse;
	}

	/**
	 * This method takes various items the user previously input (verbs, topics, movies, ect.) and
	 * formulates a sentence.
	 * 
	 * @return Random response is given
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);

		response += verbs[random];

		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";

		random = (int) (Math.random() * topics.length);
		response += questions[random];

		random = (int) (Math.random() * 2);

		if (random % 2 == 0)
		{
	//		random = (int) (Math.random() * movieList.size());
	//		response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}

		int followup = (int) (Math.random() * 5);

		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}

		return response;
	}

	/**
	 * This makes it so that if the user has an input less than 2 characters, it will close.
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;

		if (input != null && input.length() > 2)

		{
			validLength = true;
		}

		return validLength;
	}

	/**
	 * Makes sure the tags have proper documentation.
	 */
	public boolean htmlTagChecker(String input)
	{
		boolean containsHTML = false;
		if (input == null || !input.contains("<"))
		{
			return containsHTML;
		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">", firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";

		// Check bad tags
		if (input.contains("<>") || input.indexOf("< >") > -1)
		{
			containsHTML = false;
		}
		// check singleton
		if (input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
		{
			containsHTML = true;
		}
		// Check others
		else if (firstClose > firstOpen)
		{
			// Others
			tagText = input.substring(firstOpen + 1, firstClose).toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
		}
		return containsHTML;
	}

	/**
	 * checks the username including the '@'
	 */
	public boolean userNameChecker(String input)
	{
		boolean validUsername = false;

		if (input != "" && input != null && input.indexOf("@") <= 0 && input.indexOf("@") >= 0 && !input.contains("@" + "@"))
		{
			validUsername = true;
		}
		return validUsername;
	}

	public boolean contentChecker(String contentCheck)
	{
		boolean validContent = false;

		if (contentCheck.contains(content))
		{
			validContent = true;
		}
		return validContent;
	}

	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean validMeme = false;

		if (!input.equals("pepe") && input.equals("pupper") || input.equals("otter") || input.equals("kittie"))
		{
			validMeme = true;
		}
		return validMeme;
	}

	public boolean shoppingListChecker(String shoppingItem)// clears the response to ensure that the item is valid
	{
		boolean validList = false;

		for (int index = 0; index < 11; index++)
		{
			if (shoppingItem.contains(shoppingList.get(index)))
			{
				validList = true;
			}
		}
		return validList;
	}

	public boolean movieTitleChecker(String title)
	{
		boolean validTitle = false;

		if (!title.equals("") && title.equals("Spiderman") || title.equals("Hidden Figures"))
		{
			validTitle = true;
		}

		return validTitle;
	}

	// public boolean movieGenreChecker(String genre)
	{
		// return null;
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
		/**
		 * This checks to see if the response given is just randomness
		 */
		boolean validKeyboard = false;

		if (sample.contains("sdf") || sample.contains("SDF") || sample.contains("dfg") || sample.contains("cvb") || sample.contains(",./") || sample.contains("kjh") || sample.contains("DFG")
				|| sample.contains("DFG") || sample.contains("CVB") || sample.contains("KJH"))
		{
			validKeyboard = true;
		}
		else if (sample.contains("S.D.F.") || sample.contains("derf"))
		{
			validKeyboard = false;
		}
		return validKeyboard;
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

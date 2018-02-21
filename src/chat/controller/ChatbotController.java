package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay; 
import chat.view.ChatFrame;

/**
 * Manages the chatbot app including the model and frame of view package
 * @author Connor Johnson
 * @version 21.11.17 Added Frame 1.3
 */

public class ChatbotController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Connor Johnson");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		display.displayText("Henlo");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}
//	public String ineractWithChatbot(String input)
	{
		
	public void handleErrors(Excepthon error)
{
	display.displayText(error.getMessage);
}
		
	}
	
	public String popupChat(String chat)

	{
		String chatbotSays = ""; //Gives a value to a variable that can be returned for the method.
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		//do all checkers except length and quit checker
		if(chatbot.shoppingListChecker(text))
		{
			response += "";
		}
		
		if(chatbot.keyboardMashChecker(text))
		{
			response += "I don't speak Italian.\n";
		}
		
		if(chatbot.userNameChecker(text))
		{
			response += "nifty username!.\n";
		}
		return response;
	}
	 
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
}

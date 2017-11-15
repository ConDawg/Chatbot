package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay; 
import chat.view.ChatFrame;

public class ChatController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatController()
	{
		chatbot = new Chatbot("Connor Johnson");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}
//	public String ineractWithChatbot(String input)
	{
		
	}
	
	public String popupChat(String chat)
	{
		String chatbotSays = ""; //Gives a value to a variable that can be returned for the method.
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}

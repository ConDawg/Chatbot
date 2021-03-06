package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPanel;
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		setupFrame();
	}

	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Chatting with BMO");
		this.setSize(600, 600);
		this.setVisible(true);
		
	}
	
	private void setupPanel()
	{
		
	}
	public ChatbotController getAppController()
	{
		return appController;
	}
}

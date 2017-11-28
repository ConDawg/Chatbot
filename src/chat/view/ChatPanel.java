package chat.view;

import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import chat.controller.ChatbotController;
import javax.swing.JLabel;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		infoLabel = new JLabel("Type to chat with BMO")
		checkerButton = new JButton("Check Me");

		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setBackground(new Color(0,152,152));
		this.setLayout(appLayout);
		
		//Initialize GUI data members
		chatButton = new JButton("chat");
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		this.add(checkerButton);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -36, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -6, SpringLayout.NORTH, inputField);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String userText = inputField.getText();
						String displayText = appController.interactWithChatbot(userText);
						chatArea.append(displayText);
						inputField.setText("");
					}
				});
		checkerButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String userText = inputField.getText();
						String displayText = appController.interactWithChatbot(userText);
						chatArea.append(displayText);
						inputField.setText("");
					}
				});
				checkerButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent click)
							{
								String userText = inputField.getText();
								String displayText = appController.useCheckers(userText);
								chatArea.append(displayText);
								inputField.setText("");
							}
						});
	}
}

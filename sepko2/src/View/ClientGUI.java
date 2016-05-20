package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.Controller;
import Domain.Model.Item;
import View.ServerGUI.OpenEditMenu;

public class ClientGUI extends JFrame {
	
	private JMenuBar topMenuBar;
	private JMenu topMenu;
	private JMenuItem menuItemEditMenu;
	private JTabbedPane menuTabs;
	private Controller controller;

	// JPANELS
	// *********************************************************************
	private JPanel mainPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel eastButtonPanel;
	private JPanel eastListPanel;
	private JPanel westButtonPanel;
	private JPanel westListPanel;
	private JPanel centerButtonPanel;
	private JPanel centerPanel;
	private JPanel plusButtonPanel;
	
	private JPanel porkPanel;
	private JPanel beefPanel;
	private JPanel chickenPanel;
	private JPanel soupPanel;
	private JPanel seaFood;
	private JPanel sideDish;
	private JPanel desert;
	private JPanel starter;
	private JPanel nonAlcoholicDrinks;
	private JPanel alcoholicDrinks;
	private JPanel minusButtonPanel;
	
	

	// JLABELS
	// *********************************************************************

	// JBUTTONS
	// *********************************************************************
	private JButton plusButton;
	private JButton orderButton;
	private JButton minusButton;
	private JButton callStaffButton;
	

	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<String> porkList;
	private JList<String> beefList;
	private JList<String> chickenList;
	private JList<String> soupList;
	private JList<String> seaFoodList;
	private JList<String> sideDishList;
	private JList<String> desertList;
	private JList<String> appetizerList;
	private JList<String> nonAlcoholicDrinksList;
	private JList<String> alcoholicDrinksList;
	private JList<String> listOfOrder;
	
	
	private DefaultListModel<String> porkModel;
	private DefaultListModel<String> beefModel;
	private DefaultListModel<String> chickenModel;
	private DefaultListModel<String> soupModel;
	private DefaultListModel<String> seaFoodModel;
	private DefaultListModel<String> sideDishModel;
	private DefaultListModel<String> dessertModel;
	private DefaultListModel<String> starterModel;
	private DefaultListModel<String> nonAlcoholicDrinksModel;
	private DefaultListModel<String> alcoholicDrinksModel;
	private DefaultListModel<String> modelOfOrders;

	public ClientGUI(Controller controller) throws Exception {
		this.controller = controller;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(topMenuBar);
		setTitle("SEP Restaurant System");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
		addActionListeners();
		plusButton.setPreferredSize(new Dimension(200, 125));
		minusButton.setPreferredSize(new Dimension(200, 125));
		pack();
	}

	private void setComponents() {

		// TOP MENU BAR
		// **********************************************************************
		topMenuBar = new JMenuBar();
		topMenu = new JMenu("Edit");
		menuItemEditMenu = new JMenuItem("Edit menu..");
		menuTabs = new JTabbedPane();

		// JPANELS
		// **********************************************************************
		westPanel = new JPanel();
		eastPanel = new JPanel();
		eastButtonPanel = new JPanel();
		mainPanel = new JPanel();
		eastListPanel = new JPanel();
		westButtonPanel = new JPanel();
		westListPanel = new JPanel();
		centerButtonPanel = new JPanel();
		centerPanel = new JPanel();
		plusButtonPanel = new JPanel();
		
		porkPanel = new JPanel();
		beefPanel = new JPanel();
		chickenPanel = new JPanel();
		soupPanel = new JPanel();
		seaFood = new JPanel();
		sideDish = new JPanel();
		desert = new JPanel();
		starter = new JPanel();
		nonAlcoholicDrinks = new JPanel();
		alcoholicDrinks = new JPanel();
		minusButtonPanel = new JPanel();

		// JBUTTONS
		// *********************************************************************
		minusButton = new JButton("-");
		plusButton = new JButton("+");
		orderButton = new JButton("Order");
		callStaffButton = new JButton("Call saff");

		// JLISTS & DEFAULT LIST MODELS
		porkModel = new DefaultListModel<String>();
		beefModel = new DefaultListModel<String>();
		chickenModel = new DefaultListModel<String>();
		soupModel = new DefaultListModel<String>();
		seaFoodModel = new DefaultListModel<String>();
		sideDishModel = new DefaultListModel<String>();
		dessertModel = new DefaultListModel<String>();
		starterModel = new DefaultListModel<String>();
		nonAlcoholicDrinksModel = new DefaultListModel<String>();
		alcoholicDrinksModel = new DefaultListModel<String>();
		modelOfOrders = new DefaultListModel<String>();
		
		porkList = new JList(porkModel);
		beefList = new JList(beefModel);
		chickenList = new JList(chickenModel);
		soupList = new JList(soupModel);
		seaFoodList = new JList(seaFoodModel); 
		sideDishList = new JList(sideDishModel);
		desertList = new JList(dessertModel);
		appetizerList = new JList(starterModel);
		nonAlcoholicDrinksList = new JList(nonAlcoholicDrinksModel);
		alcoholicDrinksList = new JList(alcoholicDrinksModel);
		listOfOrder = new JList(modelOfOrders);

		
		// JLABELS
		// **********************************************************************

	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		eastPanel.setBorder(BorderFactory.createTitledBorder("ORDERS"));
		menuTabs.setBorder(BorderFactory.createTitledBorder("MENU"));
		minusButtonPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));

	}

	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS
		// ***********************************************************
		mainPanel.setLayout(new GridLayout(1, 2));
		eastPanel.setLayout(new BorderLayout());
		westPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout());
		
		porkPanel.setLayout(new BorderLayout());
		beefPanel.setLayout(new BorderLayout());
		chickenPanel.setLayout(new BorderLayout());
		soupPanel.setLayout(new BorderLayout());
		seaFood.setLayout(new BorderLayout());
		sideDish.setLayout(new BorderLayout());
		desert.setLayout(new BorderLayout());
		starter.setLayout(new BorderLayout());
		nonAlcoholicDrinks.setLayout(new BorderLayout());
		alcoholicDrinks.setLayout(new BorderLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;	
		
		centerButtonPanel.setLayout(new GridBagLayout());
		eastButtonPanel.setLayout(new GridLayout(1, 6));
		eastListPanel.setLayout(new BorderLayout());
		westButtonPanel.setLayout(new GridLayout(1, 1));
		westListPanel.setLayout(new BorderLayout());

		// ADDING INTO PANELS
		// *********************************************************************
		menuTabs.add("Pork", porkPanel);
		menuTabs.add("Beef",beefPanel);
		menuTabs.add("Chicken",chickenPanel);
		menuTabs.add("Soup",soupPanel);
		menuTabs.add("Sea Food",seaFood);
		menuTabs.add("Side dish",sideDish);
		menuTabs.add("Desserts",desert);
		menuTabs.add("Starter",starter);
		menuTabs.add("Non-alcoholic drinks" , nonAlcoholicDrinks);
		menuTabs.add("Alcoholic drinks" , alcoholicDrinks);
		
		porkPanel.add(porkList, BorderLayout.CENTER);
		beefPanel.add(beefList, BorderLayout.CENTER);
		chickenPanel.add(chickenList, BorderLayout.CENTER);
		soupPanel.add(soupList, BorderLayout.CENTER);
		seaFood.add(seaFoodList, BorderLayout.CENTER);
		sideDish.add(sideDishList, BorderLayout.CENTER);
		desert.add(desertList, BorderLayout.CENTER);
		starter.add(appetizerList, BorderLayout.CENTER);
		nonAlcoholicDrinks.add(nonAlcoholicDrinksList, BorderLayout.CENTER);
		alcoholicDrinks.add(alcoholicDrinksList, BorderLayout.CENTER);
		
		
		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);

		eastListPanel.add(listOfOrder);
		westListPanel.add(menuTabs);

		eastButtonPanel.add(orderButton);
		eastButtonPanel.add(callStaffButton);
		
		minusButtonPanel.add(minusButton);
		plusButtonPanel.add(plusButton);
		
		centerButtonPanel.add(plusButtonPanel, gbc);
		centerButtonPanel.add(minusButtonPanel, gbc);
		

		eastPanel.add(eastButtonPanel, BorderLayout.SOUTH);
		eastPanel.add(eastListPanel, BorderLayout.CENTER);

		westPanel.add(westButtonPanel, BorderLayout.SOUTH);
		westPanel.add(westListPanel, BorderLayout.CENTER);
		westPanel.add(centerButtonPanel, BorderLayout.EAST);
		
		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);
		
		add(mainPanel, BorderLayout.CENTER);
		
		topMenuBar.add(topMenu);
		topMenu.add(menuItemEditMenu);
	}
	
	// ADDING FUNCTIONS
				// *********************************************************************
	
	class MenuByType implements ChangeListener{
		
		public void stateChanged(ChangeEvent arg0) {
			
			JTabbedPane sourceTabbedPane = (JTabbedPane) arg0.getSource();
	        int index = sourceTabbedPane.getSelectedIndex();
	        String temp = sourceTabbedPane.getTitleAt(index).toLowerCase();
	        
	        
	        switch(temp){
	        
	        case "pork":porkModel.clear();for(int i=0;i<controller.showMenuByType("pork").size();i++){					
						porkModel.addElement(controller.showMenuByType("pork").get(i).toString());}break;
						
	        case "chicken":chickenModel.clear();for(int i=0;i<controller.showMenuByType("chicken").size();i++){					
						chickenModel.addElement(controller.showMenuByType("chicken").get(i).toString());}break;
						
	        case "starter":starterModel.clear();for(int i=0;i<controller.showMenuByType("starter").size();i++){					
						starterModel.addElement(controller.showMenuByType("starter").get(i).toString());}break;
						
	        case "beef":beefModel.clear();for(int i=0;i<controller.showMenuByType("beef").size();i++){					
						beefModel.addElement(controller.showMenuByType("beef").get(i).toString());}break;
						
	        case "desserts":dessertModel.clear();for(int i=0;i<controller.showMenuByType("dessert").size();i++){					
						dessertModel.addElement(controller.showMenuByType("dessert").get(i).toString());}break;
						
	        case "soup":soupModel.clear();for(int i=0;i<controller.showMenuByType("soups").size();i++){					
						soupModel.addElement(controller.showMenuByType("soups").get(i).toString());}break;
						
	        case "sea food":seaFoodModel.clear();for(int i=0;i<controller.showMenuByType("seafood").size();i++){					
						seaFoodModel.addElement(controller.showMenuByType("seafood").get(i).toString());}break;
						
	        case "side dish":sideDishModel.clear();for(int i=0;i<controller.showMenuByType("sidedish").size();i++){					
						sideDishModel.addElement(controller.showMenuByType("sidedish").get(i).toString());}break;
						
	        case "alcoholic drinks":alcoholicDrinksModel.clear();for(int i=0;i<controller.showMenuByType("alcoholic").size();i++){					
						alcoholicDrinksModel.addElement(controller.showMenuByType("alcoholic").get(i).toString());}break;
						
	        case "non-alcoholic drinks":nonAlcoholicDrinksModel.clear();for(int i=0;i<controller.showMenuByType("nonalcoholic").size();i++){					
	        			nonAlcoholicDrinksModel.addElement(controller.showMenuByType("nonalcoholic").get(i).toString());}break;
	        
	        default:System.out.println("OUHA SOMETHING WENT WRONG");break;
	        
	        
	        
	        
	      }
		}
	}
	
	
			
		
		
		
		
		public void addActionListeners(){
			menuTabs.addChangeListener(new MenuByType());
			
			//Filling up pork on start because its first selected tab
	        for(int i=0;i<controller.showMenuByType("pork").size();i++){					
				porkModel.addElement(controller.showMenuByType("pork").get(i).toString());
				}
		}

	/*public static void main(String[] args) throws Exception {
		ClientGUI gui = new ClientGUI();
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}*/
}

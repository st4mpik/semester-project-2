package View;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.Controller;
import Domain.Mediator.Database;
import Domain.Mediator.ModelManager;
import Domain.Mediator.RmiServerInterface;
import Domain.Model.Drink;
import Domain.Model.Item;
import Domain.Model.Meal;

public class EditMenuGUI extends JFrame {

	private JTabbedPane menuTabs;
	private ModelManager manager;
	private Database database;
	private RmiServerInterface rmiService;

	// JPANELS
	// *********************************************************************
	private JPanel mainPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel eastButtonPanel;
	private JPanel eastContentPanel;
	private JPanel westButtonPanel;
	private JPanel westTextPanel;
	private JPanel porkPanel;
	private JPanel beefPanel;
	private JPanel chickenPanel;
	private JPanel soupPanel;
	private JPanel seaFood;
	private JPanel sideDish;
	private JPanel dessert;
	private JPanel starter;
	private JPanel pasta;
	private JPanel nonAlcoholicDrinks;
	private JPanel alcoholicDrinks;

	// JLABELS
	// *********************************************************************
	private JLabel productNameLabel;
	private JLabel productDescriptionLabel;
	private JLabel productPriceLabel;
	private JLabel productAmountLabel;
	private JLabel productTypeLabel;
	private JLabel itemTypeLabel;

	private JTextField productNameTextField;
	private JTextField productDescriptionTextField;
	private JTextField productPriceTextField;
	private JTextField productAmountTextField;
	private JTextField productTypeTextField;

	private JComboBox<String> productTypeComboBox;
	private JComboBox<String> productContentComboBox;
	private DefaultComboBoxModel<String> productTypeComboBoxModel;
	private DefaultComboBoxModel<String> productMealContentComboBoxModel;
	private DefaultComboBoxModel<String> productDrinkContentComboBoxModel;

	// JBUTTONS
	// *********************************************************************
	private JButton addButton;
	private JButton removeButton;
	private JButton editButton;

	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<Item> porkList;
	private JList<Item> beefList;
	private JList<Item> chickenList;
	private JList<Item> soupList;
	private JList<Item> seaFoodList;
	private JList<Item> sideDishList;
	private JList<Item> dessertList;
	private JList<Item> starterList;
	private JList<Item> pastaList;
	private JList<Item> nonAlcoholicDrinksList;
	private JList<Item> alcoholicDrinksList;

	private DefaultListModel<Item> porkModel;
	private DefaultListModel<Item> beefModel;
	private DefaultListModel<Item> chickenModel;
	private DefaultListModel<Item> soupModel;
	private DefaultListModel<Item> seaFoodModel;
	private DefaultListModel<Item> sideDishModel;
	private DefaultListModel<Item> dessertModel;
	private DefaultListModel<Item> starterModel;
	private DefaultListModel<Item> pastaModel;
	private DefaultListModel<Item> nonAlcoholicDrinksModel;
	private DefaultListModel<Item> alcoholicDrinksModel;

	private JScrollPane porkListScrollPane;
	private JScrollPane beefListScrollPane;
	private JScrollPane chickenListScrollPane;
	private JScrollPane soupListScrollPane;
	private JScrollPane seaFoodListScrollPane;
	private JScrollPane dessertListScrollPane;
	private JScrollPane sideDishListScrollPane;
	private JScrollPane starterListScrollPane;
	private JScrollPane pastaScrollPane;
	private JScrollPane nonAlcoholicScrollPane;
	private JScrollPane alcoholicScrollPane;

	public EditMenuGUI(Database database,ModelManager manager,
			RmiServerInterface rmiService) throws Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SEP Restaurant System - Edit Menu");
		this.database = database;
		this.rmiService = rmiService;
		this.manager = manager;
		setLayout(new BorderLayout());
		setComponents();
		fillFirstTab();
		addPanelsAndLayouts();
		addBorders();
		addActionListeners();
		pack();
	}

	private void setComponents() {

		menuTabs = new JTabbedPane();

		// JPANELS
		// **********************************************************************
		westPanel = new JPanel();
		eastPanel = new JPanel();
		eastButtonPanel = new JPanel();
		mainPanel = new JPanel();
		eastContentPanel = new JPanel();
		westButtonPanel = new JPanel();
		westTextPanel = new JPanel();
		porkPanel = new JPanel();
		beefPanel = new JPanel();
		chickenPanel = new JPanel();
		soupPanel = new JPanel();
		seaFood = new JPanel();
		sideDish = new JPanel();
		dessert = new JPanel();
		starter = new JPanel();
		pasta = new JPanel();
		nonAlcoholicDrinks = new JPanel();
		alcoholicDrinks = new JPanel();

		// JBUTTONS
		// *********************************************************************
		removeButton = new JButton("Remove..");
		addButton = new JButton("Add..");
		editButton = new JButton("Edit..");

		// JLISTS & DEFAULT LIST MODELS
		porkModel = new DefaultListModel<Item>();
		beefModel = new DefaultListModel<Item>();
		chickenModel = new DefaultListModel<Item>();
		soupModel = new DefaultListModel<Item>();
		seaFoodModel = new DefaultListModel<Item>();
		sideDishModel = new DefaultListModel<Item>();
		dessertModel = new DefaultListModel<Item>();
		starterModel = new DefaultListModel<Item>();
		pastaModel = new DefaultListModel<Item>();
		nonAlcoholicDrinksModel = new DefaultListModel<Item>();
		alcoholicDrinksModel = new DefaultListModel<Item>();

		starterList = new JList(starterModel);
		starterList.setFont(new Font("Arial", Font.BOLD, 18));

		soupList = new JList(soupModel);
		soupList.setFont(new Font("Arial", Font.BOLD, 18));

		porkList = new JList(porkModel);
		porkList.setFont(new Font("Arial", Font.BOLD, 18));

		beefList = new JList(beefModel);
		beefList.setFont(new Font("Arial", Font.BOLD, 18));

		chickenList = new JList(chickenModel);
		chickenList.setFont(new Font("Arial", Font.BOLD, 18));

		pastaList = new JList(pastaModel);
		pastaList.setFont(new Font("Arial", Font.BOLD, 18));

		seaFoodList = new JList(seaFoodModel);
		seaFoodList.setFont(new Font("Arial", Font.BOLD, 18));

		sideDishList = new JList(sideDishModel);
		sideDishList.setFont(new Font("Arial", Font.BOLD, 18));

		dessertList = new JList(dessertModel);
		dessertList.setFont(new Font("Arial", Font.BOLD, 18));

		nonAlcoholicDrinksList = new JList(nonAlcoholicDrinksModel);
		nonAlcoholicDrinksList.setFont(new Font("Arial", Font.BOLD, 18));

		alcoholicDrinksList = new JList(alcoholicDrinksModel);
		alcoholicDrinksList.setFont(new Font("Arial", Font.BOLD, 18));

		// JSCROLLPANES
		// *********************************************************************
		porkListScrollPane = new JScrollPane(porkList);
		beefListScrollPane = new JScrollPane(beefList);
		chickenListScrollPane = new JScrollPane(chickenList);
		soupListScrollPane = new JScrollPane(soupList);
		seaFoodListScrollPane = new JScrollPane(seaFoodList);
		sideDishListScrollPane = new JScrollPane(sideDishList);
		dessertListScrollPane = new JScrollPane(dessertList);
		starterListScrollPane = new JScrollPane(starterList);
		pastaScrollPane = new JScrollPane(pastaList);
		nonAlcoholicScrollPane = new JScrollPane(nonAlcoholicDrinksList);
		alcoholicScrollPane = new JScrollPane(alcoholicDrinksList);

		// JLABELS
		// **********************************************************************
		productNameLabel = new JLabel("Name of product:");
		productDescriptionLabel = new JLabel("Description of product:");
		productPriceLabel = new JLabel("Price of product:");
		productAmountLabel = new JLabel("Amount of product:");
		itemTypeLabel = new JLabel("Type of item:");
		productTypeLabel = new JLabel("Type of Product:");

		productNameTextField = new JTextField();
		productNameTextField.setFont(new Font("Arial", Font.BOLD, 18));

		productDescriptionTextField = new JTextField();
		productDescriptionTextField.setFont(new Font("Arial", Font.ITALIC, 18));

		productPriceTextField = new JTextField();
		productPriceTextField
				.setFont(new Font("Arial", Font.ROMAN_BASELINE, 18));

		productAmountTextField = new JTextField();
		productAmountTextField.setFont(new Font("Arial", Font.BOLD, 18));

		productTypeComboBoxModel = new DefaultComboBoxModel<String>(
				(new String[] { "Meal", "Drink" }));
		productMealContentComboBoxModel = new DefaultComboBoxModel<String>(
				new String[] { "Starter", "Soup", "Pork", "Beef", "Chicken",
						"Pasta", "Sea Food", "Side dish", "Dessert" });

		productDrinkContentComboBoxModel = new DefaultComboBoxModel<String>(
				new String[] { "Non-alcoholic", "Alcoholic" });

		productTypeComboBox = new JComboBox<String>(productTypeComboBoxModel);

		productContentComboBox = new JComboBox<String>();
		if (productTypeComboBox.getSelectedItem().equals("Meal")) {
			productContentComboBox.setModel(productMealContentComboBoxModel);
		} else
			productContentComboBox.setModel(productDrinkContentComboBoxModel);
	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		eastContentPanel.setBorder(BorderFactory
				.createTitledBorder("EDIT WINDOW"));
		menuTabs.setBorder(BorderFactory.createTitledBorder("MENU"));

	}

	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS
		// ***********************************************************
		mainPanel.setLayout(new GridLayout(1, 2));
		eastPanel.setLayout(new BorderLayout());
		westPanel.setLayout(new BorderLayout());

		porkPanel.setLayout(new BorderLayout());
		beefPanel.setLayout(new BorderLayout());
		chickenPanel.setLayout(new BorderLayout());
		soupPanel.setLayout(new BorderLayout());
		seaFood.setLayout(new BorderLayout());
		sideDish.setLayout(new BorderLayout());
		dessert.setLayout(new BorderLayout());
		starter.setLayout(new BorderLayout());
		nonAlcoholicDrinks.setLayout(new BorderLayout());
		alcoholicDrinks.setLayout(new BorderLayout());
		pasta.setLayout(new BorderLayout());

		eastContentPanel.setLayout(new GridLayout(7, 2));

		eastButtonPanel.setLayout(new GridLayout(1, 6));
		westButtonPanel.setLayout(new GridLayout(1, 2));
		westTextPanel.setLayout(new BorderLayout());

		// ADDING INTO PANELS
		// *********************************************************************
		menuTabs.add("Starter", starter);
		menuTabs.add("Soup", soupPanel);
		menuTabs.add("Pork", porkPanel);
		menuTabs.add("Beef", beefPanel);
		menuTabs.add("Chicken", chickenPanel);
		menuTabs.add("Pasta", pasta);
		menuTabs.add("Sea Food", seaFood);
		menuTabs.add("Side dish", sideDish);
		menuTabs.add("Desserts", dessert);
		menuTabs.add("Non-alcoholic drinks", nonAlcoholicDrinks);
		menuTabs.add("Alcoholic drinks", alcoholicDrinks);

		porkPanel.add(porkListScrollPane, BorderLayout.CENTER);
		beefPanel.add(beefListScrollPane, BorderLayout.CENTER);
		chickenPanel.add(chickenListScrollPane, BorderLayout.CENTER);
		soupPanel.add(soupListScrollPane, BorderLayout.CENTER);
		seaFood.add(seaFoodListScrollPane, BorderLayout.CENTER);
		sideDish.add(sideDishListScrollPane, BorderLayout.CENTER);
		dessert.add(dessertListScrollPane, BorderLayout.CENTER);
		starter.add(starterListScrollPane, BorderLayout.CENTER);
		nonAlcoholicDrinks.add(nonAlcoholicScrollPane, BorderLayout.CENTER);
		alcoholicDrinks.add(alcoholicScrollPane, BorderLayout.CENTER);
		pasta.add(pastaScrollPane, BorderLayout.CENTER);

		eastContentPanel.add(productNameLabel);
		eastContentPanel.add(productNameTextField);
		eastContentPanel.add(productDescriptionLabel);
		eastContentPanel.add(productDescriptionTextField);
		eastContentPanel.add(productPriceLabel);
		eastContentPanel.add(productPriceTextField);
		eastContentPanel.add(productAmountLabel);
		eastContentPanel.add(productAmountTextField);
		eastContentPanel.add(itemTypeLabel);
		eastContentPanel.add(productTypeComboBox);
		eastContentPanel.add(productTypeLabel);
		eastContentPanel.add(productContentComboBox);

		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);

		westTextPanel.add(menuTabs);

		eastButtonPanel.add(addButton);

		eastPanel.add(eastButtonPanel, BorderLayout.SOUTH);
		eastPanel.add(eastContentPanel, BorderLayout.CENTER);

		westButtonPanel.add(removeButton);
		westButtonPanel.add(editButton);

		westPanel.add(westButtonPanel, BorderLayout.SOUTH);
		westPanel.add(westTextPanel, BorderLayout.CENTER);

		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);

		add(mainPanel, BorderLayout.CENTER);

	}

	public void addActionListeners() {
		menuTabs.addChangeListener(new MenuByType());
		editButton.addActionListener(new addInfoToEditMenu());
		removeButton.addActionListener(new removeFromMenu());
		addButton.addActionListener(new addToMenu());
		productTypeComboBox.addActionListener(new updateComboBox());

	}

	public void getMenuByType() {
		pastaModel.clear();
		for (int i = 0; i < manager.getMenuByType("pasta").size(); i++) {
			pastaModel.addElement(manager.getMenuByType("pasta").get(i));
		}

		porkModel.clear();
		for (int i = 0; i < manager.getMenuByType("pork").size(); i++) {
			porkModel.addElement(manager.getMenuByType("pork").get(i));
		}

		chickenModel.clear();
		for (int i = 0; i < manager.getMenuByType("chicken").size(); i++) {
			chickenModel
					.addElement(manager.getMenuByType("chicken").get(i));
		}
		starterModel.clear();
		for (int i = 0; i < manager.getMenuByType("starter").size(); i++) {
			starterModel
					.addElement(manager.getMenuByType("starter").get(i));
		}

		beefModel.clear();
		for (int i = 0; i < manager.getMenuByType("beef").size(); i++) {
			beefModel.addElement(manager.getMenuByType("beef").get(i));
		}

		dessertModel.clear();
		for (int i = 0; i < manager.getMenuByType("dessert").size(); i++) {
			dessertModel
					.addElement(manager.getMenuByType("dessert").get(i));
		}

		soupModel.clear();
		for (int i = 0; i < manager.getMenuByType("soups").size(); i++) {
			soupModel.addElement(manager.getMenuByType("soups").get(i));
		}

		seaFoodModel.clear();
		for (int i = 0; i < manager.getMenuByType("seafood").size(); i++) {
			seaFoodModel
					.addElement(manager.getMenuByType("seafood").get(i));
		}

		sideDishModel.clear();
		for (int i = 0; i < manager.getMenuByType("sidedish").size(); i++) {
			sideDishModel.addElement(manager.getMenuByType("sidedish").get(
					i));
		}

		alcoholicDrinksModel.clear();
		for (int i = 0; i < manager.getMenuByType("alcoholic").size(); i++) {
			alcoholicDrinksModel.addElement(manager.getMenuByType(
					"alcoholic").get(i));
		}

		nonAlcoholicDrinksModel.clear();
		for (int i = 0; i < manager.getMenuByType("nonalcoholic").size(); i++) {
			nonAlcoholicDrinksModel.addElement(manager.getMenuByType(
					"nonalcoholic").get(i));
		}

	}

	class MenuByType implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {

			JTabbedPane sourceTabbedPane = (JTabbedPane) arg0.getSource();
			int index = sourceTabbedPane.getSelectedIndex();
			String temp = sourceTabbedPane.getTitleAt(index).toLowerCase();

			switch (temp) {
			case "pasta":
				pastaModel.clear();
				for (int i = 0; i < manager.getMenuByType("pasta").size(); i++) {
					pastaModel.addElement(manager.getMenuByType("pasta")
							.get(i));
				}
				break;

			case "pork":
				porkModel.clear();
				for (int i = 0; i < manager.getMenuByType("pork").size(); i++) {
					porkModel.addElement(manager.getMenuByType("pork").get(
							i));
				}
				break;

			case "chicken":
				chickenModel.clear();
				for (int i = 0; i < manager.getMenuByType("chicken").size(); i++) {
					chickenModel.addElement(manager
							.getMenuByType("chicken").get(i));
				}
				break;

			case "starter":
				starterModel.clear();
				for (int i = 0; i < manager.getMenuByType("starter").size(); i++) {
					starterModel.addElement(manager
							.getMenuByType("starter").get(i));
				}
				break;

			case "beef":
				beefModel.clear();
				for (int i = 0; i < manager.getMenuByType("beef").size(); i++) {
					beefModel.addElement(manager.getMenuByType("beef").get(
							i));
				}
				break;

			case "desserts":
				dessertModel.clear();
				for (int i = 0; i < manager.getMenuByType("dessert").size(); i++) {
					dessertModel.addElement(manager
							.getMenuByType("dessert").get(i));
				}
				break;

			case "soup":
				soupModel.clear();
				for (int i = 0; i < manager.getMenuByType("soups").size(); i++) {
					soupModel.addElement(manager.getMenuByType("soups")
							.get(i));
				}
				break;

			case "sea food":
				seaFoodModel.clear();
				for (int i = 0; i < manager.getMenuByType("seafood").size(); i++) {
					seaFoodModel.addElement(manager
							.getMenuByType("seafood").get(i));
				}
				break;

			case "side dish":
				sideDishModel.clear();
				for (int i = 0; i < manager.getMenuByType("sidedish")
						.size(); i++) {
					sideDishModel.addElement(manager.getMenuByType(
							"sidedish").get(i));
				}
				break;

			case "alcoholic drinks":
				alcoholicDrinksModel.clear();
				for (int i = 0; i < manager.getMenuByType("alcoholic")
						.size(); i++) {
					alcoholicDrinksModel.addElement(manager.getMenuByType(
							"alcoholic").get(i));
				}
				break;

			case "non-alcoholic drinks":
				nonAlcoholicDrinksModel.clear();
				for (int i = 0; i < manager.getMenuByType("nonalcoholic")
						.size(); i++) {
					nonAlcoholicDrinksModel.addElement(manager
							.getMenuByType("nonalcoholic").get(i));
				}
				break;

			default:
				System.out.println("OUHA SOMETHING WENT WRONG");
				break;
			}
		}
	}

	public void removeSelectedItemFromMenu(Item selectedElement) {
		try {
			database.removeFromMenu(selectedElement);
			manager.clearMenu();
			database.getMenu();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		getMenuByType();
		try {
			rmiService.updateMenuOfClients();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	class removeFromMenu implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int dialogButton = JOptionPane.showConfirmDialog(EditMenuGUI.this,
					"Do you really want to delete this item from menu?",
					"Confrim", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (dialogButton == JOptionPane.YES_OPTION) {
				JPanel tab = (JPanel) menuTabs.getSelectedComponent();
				JScrollPane ScrollPane = (JScrollPane) tab.getComponent(0);
				JViewport viewport = (JViewport) ScrollPane.getComponent(0);
				JList list = (JList) viewport.getComponent(0);
				try {
					Item selectedElement = (Item) list.getSelectedValue();
					if(list.getSelectedIndex() == -1){
						JOptionPane.showMessageDialog(EditMenuGUI.this,
								"First, select the item you want to remove");
					}
					removeSelectedItemFromMenu(selectedElement);
					resetProductFields();
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(EditMenuGUI.this,
							"First, select the item you want to remove");
				}
				JOptionPane.showMessageDialog(EditMenuGUI.this, "Item removed successfully");
			}
		}
	}

	class updateComboBox implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (productTypeComboBox.getSelectedItem().equals("Meal")) {
				productContentComboBox
						.setModel(productMealContentComboBoxModel);
			} else
				productContentComboBox
						.setModel(productDrinkContentComboBoxModel);
		}
	}

	class addInfoToEditMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int dialogButton = JOptionPane.showConfirmDialog(EditMenuGUI.this,
					"Do you really want to edit this menu item?", "Confrim",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogButton == JOptionPane.YES_OPTION) {
				JPanel tab = (JPanel) menuTabs.getSelectedComponent();
				JScrollPane ScrollPane = (JScrollPane) tab.getComponent(0);
				JViewport viewport = (JViewport) ScrollPane.getComponent(0);
				JList list = (JList) viewport.getComponent(0);
				try {
					Item selectedElement = (Item) list.getSelectedValue();
					productNameTextField.setText(selectedElement.getName());
					productDescriptionTextField.setText(selectedElement
							.getDescription());
					productPriceTextField.setText(""
							+ selectedElement.getPrice());
					productAmountTextField.setText(""
							+ (int) selectedElement.getAmount());
					if (selectedElement instanceof Meal) {
						productTypeComboBox.setSelectedIndex(0);
						productContentComboBox
								.setModel(productMealContentComboBoxModel);
						String temp = selectedElement.getType();
						switch (temp) {
						case "starter":
							productContentComboBox.setSelectedIndex(0);
							break;
						case "soups":
							productContentComboBox.setSelectedIndex(1);
							break;
						case "dessert":
							productContentComboBox.setSelectedIndex(8);
							break;
						case "beef":
							productContentComboBox.setSelectedIndex(3);
							break;
						case "chicken":
							productContentComboBox.setSelectedIndex(4);
							break;
						case "pork":
							productContentComboBox.setSelectedIndex(2);
							break;
						case "pasta":
							productContentComboBox.setSelectedIndex(5);
							break;
						case "seafood":
							productContentComboBox.setSelectedIndex(6);
							break;
						case "sidedish":
							productContentComboBox.setSelectedIndex(7);
							break;
						}

					} else {
						productTypeComboBox.setSelectedIndex(1);
						productContentComboBox
								.setModel(productDrinkContentComboBoxModel);
						if (selectedElement.getType().equals("nonalcoholic")) {
							productContentComboBox.setSelectedIndex(0);
						} else {
							productContentComboBox.setSelectedIndex(1);
						}

					}
					removeSelectedItemFromMenu(selectedElement);
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(EditMenuGUI.this,
							"First, select the item you want to edit");
				}
			}
		}

	}

	class addToMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(productNameTextField.getText().equals("")
					|| productDescriptionTextField.getText().equals("")
					|| productPriceTextField.getText().equals("")
					|| productAmountTextField.getText().equals("")){
				JOptionPane.showMessageDialog(EditMenuGUI.this, "You must fill in all information before pressing 'Add'");
			}
			else{
			String name = productNameTextField.getText();
			String description = productDescriptionTextField.getText();
			double price = Double.parseDouble(productPriceTextField.getText());
			if(productTypeComboBox.getSelectedIndex() == 0) {
				int amount = Integer.parseInt(productAmountTextField.getText());
				String type = (String) productContentComboBox.getSelectedItem();
				switch(type) {
					case "Starter": type = "starter"; break;
					case "Soup": type = "soups"; break;
					case "Pork": type = "pork"; break;
					case "Beef": type = "beef"; break;
					case "Chicken": type = "chicken"; break;
					case "Pasta": type = "pasta"; break;
					case "Sea Food": type = "seafood"; break;
					case "Side dish": type = "sidedish"; break;
					case "Dessert": type = "dessert"; break;
				}
				
				Meal meal = new Meal(name, description, price, amount, type);
				
				if(manager.isDuplicate(meal)) {
					JOptionPane.showMessageDialog(EditMenuGUI.this, "Item is already in menu, you can't add"
							+ " duplicates");
					return;
				}
				
				try {
					database.addToMenu(meal);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			} 
			else {
				double amount = Double.parseDouble(productAmountTextField.getText());
				String type = (String) productContentComboBox.getSelectedItem();
				productContentComboBox.setModel(productDrinkContentComboBoxModel);
				if(type.equals("Non-alcoholic")) {
					type = "nonalcoholic";
				} else {
					type = "alcoholic";
				}
				Drink drink = new Drink(name, description, price, amount, type);
				if(manager.isDuplicate(drink)) {
					JOptionPane.showMessageDialog(EditMenuGUI.this, "Item is already in menu, you can't add"
							+ " duplicates");
					return;
				}
				try {
					database.addToMenu(drink);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			try {
				manager.clearMenu();
				database.getMenu();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			getMenuByType();
			try {
				rmiService.updateMenuOfClients();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			resetProductFields();
		}
			JOptionPane.showMessageDialog(EditMenuGUI.this, "Item added successfully");
		}
	}

	public void resetProductFields() {
		productNameTextField.setText("");
		productDescriptionTextField.setText("");
		productAmountTextField.setText("");
		productPriceTextField.setText("");
	}

	private void fillFirstTab() {

		starterModel.clear();
		for (int i = 0; i < manager.getMenuByType("starter").size(); i++) {
			starterModel
					.addElement(manager.getMenuByType("starter").get(i));
		}
	}

}

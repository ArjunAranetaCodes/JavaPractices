import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Recipe {
    private String name;
    private ArrayList<String> ingredients;
    private String instructions;

    public Recipe(String name, ArrayList<String> ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }
}

class RecipeApp extends JFrame {
    private DefaultListModel<String> recipeListModel;
    private JList<String> recipeList;
    private JTextArea recipeDetailsArea;
    private JTextField searchField;
    private ArrayList<Recipe> recipes;

    public RecipeApp() {
        // Initialize data
        recipes = new ArrayList<>();
        initializeRecipes(); // You need to implement this method to add sample recipes

        // Initialize GUI components
        setTitle("Recipe App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        recipeListModel = new DefaultListModel<>();
        for (Recipe recipe : recipes) {
            recipeListModel.addElement(recipe.getName());
        }

        recipeList = new JList<>(recipeListModel);
        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        recipeList.addListSelectionListener(e -> displaySelectedRecipe());

        JScrollPane recipeListScrollPane = new JScrollPane(recipeList);

        recipeDetailsArea = new JTextArea();
        recipeDetailsArea.setEditable(false);
        JScrollPane recipeDetailsScrollPane = new JScrollPane(recipeDetailsArea);

        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchRecipes());

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search Recipe: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Layout
        setLayout(new BorderLayout());
        add(searchPanel, BorderLayout.NORTH);
        add(recipeListScrollPane, BorderLayout.WEST);
        add(recipeDetailsScrollPane, BorderLayout.CENTER);

        // Display the GUI
        setVisible(true);
    }

    private void displaySelectedRecipe() {
        int selectedIndex = recipeList.getSelectedIndex();
        if (selectedIndex != -1) {
            Recipe selectedRecipe = recipes.get(selectedIndex);
            StringBuilder details = new StringBuilder();
            details.append("Ingredients:\n");
            for (String ingredient : selectedRecipe.getIngredients()) {
                details.append("- ").append(ingredient).append("\n");
            }
            details.append("\nInstructions:\n").append(selectedRecipe.getInstructions());
            recipeDetailsArea.setText(details.toString());
        }
    }

    private void searchRecipes() {
        String searchKeyword = searchField.getText().toLowerCase();
        recipeListModel.clear();
        for (Recipe recipe : recipes) {
            if (recipe.getName().toLowerCase().contains(searchKeyword)) {
                recipeListModel.addElement(recipe.getName());
            }
        }
    }

    private void initializeRecipes() {
        // Add sample recipes
        recipes.add(new Recipe("Pasta Carbonara",
                new ArrayList<>(List.of("200g spaghetti", "100g pancetta", "2 eggs", "50g grated Pecorino cheese")),
                "1. Cook spaghetti according to package instructions.\n" +
                        "2. In a pan, cook pancetta until crispy.\n" +
                        "3. In a bowl, whisk together eggs and grated Pecorino cheese.\n" +
                        "4. Drain spaghetti and toss with egg mixture. Add pancetta."));
        // Add more recipes as needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RecipeApp());
    }
}

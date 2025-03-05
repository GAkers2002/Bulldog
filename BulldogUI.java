import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The BulldogUI class creates and manages the user interface for the Bulldog game.
 * It displays player information, current rolls, and game progress.
 */
public class BulldogUI {
    private JFrame frame;
    private JList<String> playerList;
    private DefaultListModel<String> playerListModel;
    private JLabel currentPlayerLabel;
    private JLabel currentScoreLabel;
    private JTextArea previousRollsArea;
    private JLabel currentRollLabel;
    
    /**
     * Constructs the BulldogUI and initializes the graphical components.
     * 
     * @param players The list of players in the game.
     */
    public BulldogUI(ArrayList<Player> players) {
        frame = new JFrame("Bulldog Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        
        // Left panel for player list
        playerListModel = new DefaultListModel<>();
        for (Player player : players) {
            playerListModel.addElement(player.getName() + " - " + player.getScore());
        }
        playerList = new JList<>(playerListModel);
        JScrollPane playerScrollPane = new JScrollPane(playerList);
        playerScrollPane.setPreferredSize(new Dimension(200, frame.getHeight()));
        frame.add(playerScrollPane, BorderLayout.WEST);
        
        // Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        
        // Top section for current player info
        JPanel topRightPanel = new JPanel(new GridLayout(2, 1));
        currentPlayerLabel = new JLabel("Current Player: ");
        currentScoreLabel = new JLabel("Score: 0");
        topRightPanel.add(currentPlayerLabel);
        topRightPanel.add(currentScoreLabel);
        rightPanel.add(topRightPanel, BorderLayout.NORTH);
        
        // Middle section for previous rolls
        previousRollsArea = new JTextArea(5, 20);
        previousRollsArea.setEditable(false);
        JScrollPane rollsScrollPane = new JScrollPane(previousRollsArea);
        rightPanel.add(rollsScrollPane, BorderLayout.CENTER);
        
        // Bottom section for current roll
        currentRollLabel = new JLabel("Current Roll: ", SwingConstants.CENTER);
        currentRollLabel.setFont(new Font("Arial", Font.BOLD, 18));
        rightPanel.add(currentRollLabel, BorderLayout.SOUTH);
        
        frame.add(rightPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    /**
     * Updates the UI to show the current player's name and score.
     * 
     * @param name  The name of the current player.
     * @param score The current score of the player.
     */
    public void updateCurrentPlayer(String name, int score) {
        currentPlayerLabel.setText("Current Player: " + name);
        currentScoreLabel.setText("Score: " + score);
    }
    
    /**
     * Updates the previous rolls section of the UI.
     * 
     * @param rolls A string representing the previous rolls.
     */
    public void updatePreviousRolls(String rolls) {
        previousRollsArea.setText(rolls);
    }
    
    /**
     * Updates the UI to display the current roll value.
     * 
     * @param roll The value of the current roll.
     */
    public void updateCurrentRoll(int roll) {
        currentRollLabel.setText("Current Roll: " + roll);
    }
    
    /**
     * Updates the player list in the UI to reflect current scores.
     * 
     * @param players The list of players with updated scores.
     */
    public void updatePlayerList(ArrayList<Player> players) {
        playerListModel.clear();
        for (Player player : players) {
            playerListModel.addElement(player.getName() + " - " + player.getScore());
        }
    }
    
    /**
     * Starts the game UI in the Swing event dispatch thread.
     * 
     * @param players The list of players in the game.
     */
    public static void startGameUI(ArrayList<Player> players) {
        SwingUtilities.invokeLater(() -> new BulldogUI(players));
    }
}

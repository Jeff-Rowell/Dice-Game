import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * A dialog-based user interface.
 * 
 * @author Jeff Rowell
 * @version 0.1 Fall(2015) JPIG
 */
public class DialogUserInterface implements UserInterface {
    /** Contents of the title bar */
    private String titleBarText = "";

    /** Icon for dialogs */
    private ImageIcon icon = new ImageIcon();

    /** 
     * Contructs user interface with specified title bar text.
     * @param title text to be displayed in the title bar
     */
    public DialogUserInterface(final String title) {
        this.titleBarText = title;
    }

    /**
     * Show message requiring user only to acknowledge
     * @param message the message to be shown
     */
    @Override
    public void showMessage(final String message) {
        JOptionPane.showMessageDialog(
            null,
            message,
            this.titleBarText,
            JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Asks a question and prompt with Yes or No buttons.
     * Returns <CODE>true</CODE> is user responds Yes;
     * <CODE>false</CODE> otherwise.
     * @param question the question to present to the user
     * @return <CODE>true</CODE> if and only if the user selects Yes.
     */
    @Override 
    public boolean askYesNoQuestion(final String question) {
        int response = JOptionPane.showConfirmDialog(
                null,
                question,
                this.titleBarText,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                this.icon
            );
        switch (response) {
            case 0: return true; // Chose yes
            case 1: return false; // Chose no
            case -1: return false; // Cancelled
            default: return false; // Error
        }
    }
    
    /**
     * Prompt then accept and return a user-entered string.
     * @param prompt message to show user
     * @return string entered by user
     */
    @Override
    public String requestString(final String prompt) {
        return JOptionPane.showInputDialog(
        null,
        prompt,
        this.titleBarText,
        JOptionPane.PLAIN_MESSAGE);
    }
}

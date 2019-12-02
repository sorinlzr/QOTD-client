import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuoteView extends JFrame {
    private JTextArea textArea;
    private JButton quoteButton;
    private JButton exitButton;
    private QuoteModel quoteModel;

    public QuoteView(QuoteModel quoteModel){
        setSize(new Dimension(450,150));
        setTitle("Random Quotes");
        setBackground(Color.LIGHT_GRAY);
        setResizable(false);

        this.quoteModel = quoteModel;

        textArea = new JTextArea(5,20);
        textArea.setText(this.quoteModel.getRandomQuote());
        textArea.setMargin(new Insets(5,10,5,10));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        quoteButton = new JButton("Random Quote");
        exitButton = new JButton("Quit");

        JPanel center1 = new JPanel(new BorderLayout());
        center1.add(new JLabel("Random quote of the day", JLabel.CENTER), "North");
        add(center1, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        JPanel south2 = new JPanel(new FlowLayout());
        south2.add(quoteButton);
        south2.add(exitButton);
        add(south2, BorderLayout.SOUTH);

        quoteButton.addActionListener(e -> textArea.setText(this.quoteModel.getRandomQuote()));
        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kyle on 3/15/15.
 */
public class BrowserPanel extends JPanel {

    BrowserFrame frame;
    PageContent pageContent;
    JTextArea textArea;
    JTextField urlTextField;
    JScrollPane scrollPane;

    public BrowserPanel()
    {
        super();
        setLayout(new BorderLayout());

        urlTextField = new JTextField();
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        scrollPane = new JScrollPane(textArea);

        urlTextField.addActionListener(new UrlTextFieldHandler());

        add(urlTextField, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setFrame(BrowserFrame frame) {
        this.frame = frame;
    }

    private class UrlTextFieldHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredText = urlTextField.getText();
            UrlRequest urlRequest = new UrlRequest();
            String rawHTML = urlRequest.downloadRawHtml(enteredText);
            pageContent = new PageContent(rawHTML);
            textArea.setText(pageContent.pageBody);
            frame.setTitle(pageContent.pageTitle);
        }
    }
}

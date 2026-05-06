package primeface.imputtext;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("inputTextView")
@RequestScoped
public class inputTextView {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
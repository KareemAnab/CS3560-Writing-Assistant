package model;

import java.util.ArrayList;
import java.util.List;

public class DocumentModel {

    public interface DocumentListener {
        void documentChanged(String inputText, String outputText);
    }

    private final List<DocumentListener> listeners = new ArrayList<>();
    private String inputText = "";
    private String outputText = "";

    public void setInputText(String text) {
        this.inputText = text;
        notifyListeners();
    }

    public void setOutputText(String text) {
        this.outputText = text;
        notifyListeners();
    }

    public String getInputText() {
        return inputText;
    }

    public String getOutputText() {
        return outputText;
    }

    public void addListener(DocumentListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (DocumentListener l : listeners) {
            l.documentChanged(inputText, outputText);
        }
    }
}

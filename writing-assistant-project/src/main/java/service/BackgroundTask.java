package service;

import javax.swing.SwingWorker;

public class BackgroundTask extends SwingWorker<String, Void> {

    public interface Callback {
        void onSuccess(String result);
        void onError(Exception e);
    }

    private final APIPromptService service;
    private final String inputText;
    private final Callback callback;

    public BackgroundTask(APIPromptService service, String inputText, Callback callback) {
        this.service = service;
        this.inputText = inputText;
        this.callback = callback;
    }

    @Override
    protected String doInBackground() throws Exception {
        return service.generateText(inputText);
    }

    @Override
    protected void done() {
        try {
            String result = get();
            callback.onSuccess(result);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}

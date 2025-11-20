package controller;

import model.DocumentModel;
import model.session.SessionManager;
import service.APIPromptService;
import service.BackgroundTask;
import view.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;

public class MainController {

    private final DocumentModel model;
    private final MainFrame view;
    private final APIPromptService service;
    private final SessionManager sessionManager;

    public MainController(DocumentModel model,
                          MainFrame view,
                          APIPromptService service) {
        this.model = model;
        this.view = view;
        this.service = service;
        this.sessionManager = new SessionManager(Path.of("session.txt"));

        model.addListener(view);

        wireEvents();
    }

    private void wireEvents() {
        view.getGenerateButton().addActionListener(e -> onGenerate());
        view.getSaveButton().addActionListener(e -> onSave());
        view.getLoadButton().addActionListener(e -> onLoad());
        view.getModeCombo().addActionListener(e -> onModeChanged());
    }

    private void onModeChanged() {
        String name = (String) view.getModeCombo().getSelectedItem();
        service.setMode(APIPromptService.strategyForName(name));
    }

    private void onGenerate() {
        String input = view.getInputText();
        view.setStatus("Calling API...");
        view.getGenerateButton().setEnabled(false);

        BackgroundTask task = new BackgroundTask(service, input, new BackgroundTask.Callback() {
            @Override
            public void onSuccess(String result) {
                SwingUtilities.invokeLater(() -> {
                    model.setInputText(input);
                    model.setOutputText(result);
                    view.setStatus("Done");
                    view.getGenerateButton().setEnabled(true);
                });
            }

            @Override
            public void onError(Exception e) {
                SwingUtilities.invokeLater(() -> {
                    view.setStatus("Error: " + e.getMessage());
                    JOptionPane.showMessageDialog(view,
                            "Error while calling API:\n" + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    view.getGenerateButton().setEnabled(true);
                });
            }
        });

        task.execute();
    }

    private void onSave() {
        try {
            sessionManager.save(model.getInputText(), model.getOutputText());
            view.setStatus("Session saved.");
        } catch (IOException ex) {
            view.setStatus("Failed to save session.");
        }
    }

    private void onLoad() {
        try {
            String[] pair = sessionManager.load();
            model.setInputText(pair[0]);
            model.setOutputText(pair[1]);
            view.setStatus("Session loaded.");
        } catch (IOException ex) {
            view.setStatus("Failed to load session.");
        }
    }
}

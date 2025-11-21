import controller.MainController;
import model.DocumentModel;
import service.APIPromptService;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            DocumentModel model = new DocumentModel();
            APIPromptService service = APIPromptService.fromConfig();
            MainFrame view = new MainFrame();
            new MainController(model, view, service);
            view.setVisible(true);
        });
    }
}

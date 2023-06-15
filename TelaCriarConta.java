import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCriarConta extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Criação dos elementos da tela de criação de conta
        Button btnVoltar = new Button("Voltar");

        VBox root = new VBox(btnVoltar);

        // Ação do botão Voltar
        btnVoltar.setOnAction(event -> {
            // Fecha a janela atual
            primaryStage.close();

            // Cria uma instância da tela inicial e exibe
            Main telaInicial = new Main();
            telaInicial.start(new Stage());
        });

        // Configuração da cena e exibição da janela
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

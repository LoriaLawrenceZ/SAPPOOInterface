import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Criação dos elementos da tela inicial
        Button btnAcessarConta = new Button("Acessar Conta");
        Button btnCriarConta = new Button("Criar Conta");
        Button btnSair = new Button("Sair");
        VBox root = new VBox(btnAcessarConta, btnCriarConta, btnSair);

        // Ação do botão Acessar Conta
        btnAcessarConta.setOnAction(event -> {
            //Fecha janela atual
            primaryStage.close();

            //Cria uma instância da tela pra acessar a conta e a exibe
            TelaValidarConta telaAcessarConta = new TelaValidarConta();
            telaAcessarConta.start(new Stage());
        });

        // Ação do botão Criar Conta
        btnCriarConta.setOnAction(event -> {
            // Fecha a janela atual
            primaryStage.close();

            // Cria uma instância da tela de criação de conta e exibe
            TelaCriarConta telaCriarConta = new TelaCriarConta();
            telaCriarConta.start(new Stage());
        });

        // Ação do botão Sair
        btnSair.setOnAction(event -> primaryStage.close());

        // Configuração da cena e exibição da janela
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaValidarConta extends Application {
    @Override
    public void start(Stage primaryStage) {
        Gerenciamento gerenciar = new Gerenciamento();

        // Criação dos elementos da tela de acesso à conta
        Label labelInstrucao = new Label("Informe o CPF/CNPJ ou NÚMERO DA CONTA");
        Label labelErro = new Label();
        TextField loginField = new TextField();
        Button btnValidar = new Button("Validar");
        Button btnVoltar = new Button("Voltar");

        VBox root = new VBox(labelInstrucao, labelErro, loginField, btnValidar, btnVoltar);

        // Ação do botão Validar
        btnValidar.setOnAction(event -> {
            String login = loginField.getText();

            if (gerenciar.Validacao(login)) {
                // Fechar a janela atual após validar o acesso à conta
                primaryStage.close();

                TelaConta telaConta = new TelaConta(gerenciar.getConta(login));
                telaConta.start(new Stage());
            } else {
                labelErro.setText("Conta não encontrada");
                loginField.clear();
            }
        });
        //Mesma coisa do botão validar, mas com ENTER
        loginField.setOnAction(event -> {
            String login = loginField.getText();

            if (gerenciar.Validacao(login)) {
                // Fechar a janela atual após validar o acesso à conta
                primaryStage.close();

                TelaConta telaConta = new TelaConta(gerenciar.getConta(login));
                telaConta.start(new Stage());
            } else {
                labelErro.setText("Conta não encontrada");
                loginField.clear();
            }
        });

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

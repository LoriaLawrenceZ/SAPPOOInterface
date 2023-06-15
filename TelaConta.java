import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaConta extends Application{
    @Override
    public void start(Stage primaryStage){
        Gerenciamento gerenciar = new Gerenciamento();

        // Criação dos elementos da tela de acesso à conta
        Button btnSaldo = new Button("SALDO");
        Label labelSaldo = new Label();
        Button btnSaque = new Button("SAQUE");
        Button btnDeposito = new Button("DEPÓSITO");
        Button btnEmprestimo = new Button("EMPRÉSTIMO");
        Button btnSair = new Button("Sair da Conta");

        VBox root = new VBox(btnSaldo, btnSaque, btnDeposito, btnEmprestimo, btnSair);

        
        //Ação btnSaldo
        btnSaldo.setOnAction(event -> {
            labelSaldo.setText(gerenciar.get);
        });
        //Ação btnSaque
        btnSaldo.setOnAction(event -> {
            
        });
        //Ação btnDeposito
        btnSaldo.setOnAction(event -> {
            
        });
        //Ação btnEmprestimo
        btnSaldo.setOnAction(event -> {
            
        });
        // Ação do botão Voltar
        btnSair.setOnAction(event -> {
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

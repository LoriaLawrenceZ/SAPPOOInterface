import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaConta extends Application{
    private Conta conta;

    public TelaConta(Conta conta){
        this.conta = conta;
    }
    
    @Override
    public void start(Stage primaryStage){
        // Criação dos elementos da tela de acesso à conta
        Button btnSaldo = new Button("INFORMAÇÕES");
        Button btnSaque = new Button("SAQUE");
        Button btnDeposito = new Button("DEPÓSITO");
        Button btnEmprestimo = new Button("EMPRÉSTIMO");
        Button btnSair = new Button("Sair da Conta");

        VBox root = new VBox(btnSaldo, btnSaque, btnDeposito, btnEmprestimo, btnSair);

        
        //Ação btnSaldo
        btnSaldo.setOnAction(event -> {
            // Fechar a janela atual após validar o acesso à conta
            primaryStage.close();

            TelaInfo telaInfo = new TelaInfo(conta);
            telaInfo.start(new Stage());
        });

        //Ação btnSaque
        btnSaque.setOnAction(event -> {
            // Fechar a janela atual após validar o acesso à conta
            primaryStage.close();
        });

        //Ação btnDeposito
        btnDeposito.setOnAction(event -> {
            // Fechar a janela atual após validar o acesso à conta
            primaryStage.close();
        });

        //Ação btnEmprestimo
        btnEmprestimo.setOnAction(event -> {
            // Fechar a janela atual após validar o acesso à conta
            primaryStage.close();
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

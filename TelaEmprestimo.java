import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaEmprestimo extends Application{
    private Conta conta;

    public TelaEmprestimo(Conta conta){
        this.conta = conta;
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Banco SAPPOO - "+ conta.getNome() +" - EMPRÉSTIMO");

        // Criação dos elementos da tela de acesso à conta
        Label lblInfo = new Label("Nome: "+ conta.getNome() +"\nCPF|CNPJ: "+ conta.getCpfCnpj() +"\nNúmero da conta: "+ conta.getNumeroConta() +"\nSaldo: "+ conta.getSaldo());
        Button btnSair = new Button("Voltar");

        VBox root = new VBox(lblInfo, btnSair);

        // Ação do botão Voltar
        btnSair.setOnAction(event -> {
            // Fecha a janela atual
            primaryStage.close();
            // Cria uma instância da tela inicial e exibe
            TelaConta telaConta = new TelaConta(conta);
            telaConta.start(new Stage());
        });

        // Configuração da cena e exibição da janela
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

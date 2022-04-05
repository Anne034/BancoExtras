import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
		banco.setNome("Itau");
		ArrayList<Conta> contas = new ArrayList<Conta>();
		banco.setContas(contas);
		Cliente edyane = new Cliente();
		edyane.setNome("Edyane");
		Cliente gabriel = new Cliente();
		gabriel.setNome("Gabriel");
		
		Conta cc = new ContaCorrente(edyane);
		Conta poupanca = new ContaPoupanca(gabriel);
		contas.add(cc);
		contas.add(poupanca);
		
		cc.depositar(100);
		
		if(cc.pagarConta(20)) {
			System.out.println("Conta paga com sucesso!");
		}
		if(!cc.pagarConta(90)) {
			System.out.println("Conta não paga!");
		}
		
		if(!cc.pegarEmprestimo(250)) {
			System.out.println("O valor 250 é muito alto para você. Só pode pedir até 3x o seu saldo em emprestimo!");
		}
		if(cc.pegarEmprestimo(240)) {
			System.out.println("Você fez um emprestimo de 240 reais!");
		}
		
		cc.transferir(50, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		banco.imprimirClientes();
	}

}

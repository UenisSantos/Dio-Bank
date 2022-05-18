
public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("uenis");

		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		cc.transferir(100, poupanca);
		cc.depositar(224);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}

}

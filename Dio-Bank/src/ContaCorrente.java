
public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente, true);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns(true);
	}

}

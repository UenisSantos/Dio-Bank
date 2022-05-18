import java.text.DecimalFormat;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 9637;
	private static int N_CONTA = 7418;
	private static int DIGITO = 0;
	private static int GERADOR_CONTA = 0;

	protected int agencia;
	protected double numero;
	protected double saldoESpecial;
	protected double saldo;
	protected Cliente cliente;
	private double cartaoCredito;

	public Conta(Cliente cliente, boolean conta) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = geradorConta();
		this.cliente = cliente;
		this.saldoESpecial = valorEspecial(conta);
	}

	private double valorEspecial(boolean tipoConta) {

		if (tipoConta) {
			this.cartaoCredito = 1542;
			this.saldo = this.saldoESpecial += 500;

			return saldo;

		} else {
			double saldo = this.saldoESpecial;

			return saldo;
		}

	}

	private double geradorConta() {
		Conta.DIGITO++;
		Conta.GERADOR_CONTA = N_CONTA + Conta.DIGITO;
		return GERADOR_CONTA;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public double getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns(boolean tipoConta) {

		if (tipoConta) {

			System.out.println(String.format("Titular: %s", this.cliente.getNome()));
			System.out.println(String.format("Agencia: %d", this.agencia));
			System.out.println(String.format("Numero: %.1f", this.numero));
			System.out.println(String.format("cheque especial : %.2f", this.saldoESpecial));
			System.out.println(String.format("Saldo total : %.2f", this.saldo));

			System.out.println(String.format("limite do cartao :%.2f ", cartaoCredito));

		} else {
			System.out.println(String.format("Titular: %s", this.cliente.getNome()));
			System.out.println(String.format("Agencia: %d", this.agencia));
			System.out.println(String.format("Numero: %.1f", this.numero));
			System.out.println(String.format("Saldo : %.3f", this.saldo));

		}

	}

}

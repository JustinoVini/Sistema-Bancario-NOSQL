package sistemabancario_aps;

public class Conta implements Metodos_Contas {

	private int numero;
	private String titular;
	private double saldo;
	private double limite;

	public Conta() {
	}

	public Conta(String pTitular) {
		this.titular = pTitular;
		this.saldo = 0;

	}

	public Conta(String pTitular, double limite, int numeroConta) {
		this.titular = pTitular;
		this.numero = numeroConta;
		this.saldo = 0;
		this.limite = limite;

	}

	@Override
	public void DadosBancario() {
		System.out.println("");
		System.out.println("-- Dados Bancarios -- ");
		System.out.println("- Numero da conta: " + this.numero);
		System.out.println("- Titular: " + this.titular);
		System.out.println("- Saldo: " + this.saldo);
		System.out.println("- Limite: " + this.limite);
		System.out.println("--- Fim dados bancarios --- ");
		System.out.println("");
	}

	@Override
	public void Depositar(double pValor) {
		System.out.println("");
		System.out.println("--- Realizando Depósito ---");
		System.out.println("- Saldo Anterior:" + this.saldo);

		this.saldo += pValor;

		System.out.println("- Saldo Posterior:" + this.saldo);
		System.out.println("--- fim do deposito ---");
		System.out.println("");
	}

	@Override
	public void Sacar(double pValor) {
		System.out.println("");
		System.out.println("--- Realizando Saque ---");
		System.out.println("- Saldo Anterior:" + this.saldo);

		if (pValor <= this.saldo) {
			this.saldo -= pValor;
			System.out.println("Saldo Posterior:" + this.saldo);
		} else {
			System.out.println("- Saldo Insuficiente ");
		}
		System.out.println("--- Fim do Saque ---");
		System.out.println("");
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}

package conta.model;

public class ContaPoupanca extends Conta
{
	private int aniversario;
	
	public ContaPoupanca(String titular, int numero, int agencia, int tipo, float saldo, int aniversario) {
		super(titular, numero, agencia, tipo, saldo);
		this.aniversario = aniversario;
	}

	public int getAniversario() 
	{
		return aniversario;
	}

	public void setAniversario(int aniversario) 
	{
		this.aniversario = aniversario;
	}
	
	@Override 
	public void print() 
	{
		super.print();
		System.out.println("Aniversário da conta: " + this.aniversario);
	}
}
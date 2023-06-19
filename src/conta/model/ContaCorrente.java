package conta.model;

public class ContaCorrente extends Conta
{
	private float limite;
	public ContaCorrente(String titular, int numero, int agencia, int tipo, float saldo, float limite) 
	{
		super(titular, numero, agencia, tipo, saldo);
		
	}
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) 
	{
		if(this.getSaldo() + this.getLimite() < valor) 
		{
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	@Override
	public void print() 
	{
		super.print();
		System.out.println("Limite de Crédito: " + this.limite);
		
	}
	
}
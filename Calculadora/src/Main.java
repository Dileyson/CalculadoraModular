import java.math.BigInteger;

public class Main {
	

	public static void main(String[] args) {

		CalculadoraModular calculadora = new CalculadoraModular();
		calculadora.calculadora();
		//calculadora.menu();
		/*System.out.println(factorial(new BigInteger("1")));
		}
		static BigInteger factorial(BigInteger n)
		{
		if (n.equals(BigInteger.ZERO))
		return BigInteger.ONE;
		else
		return n.multiply(factorial(n.subtract(BigInteger.ONE)));*/
		}

}
/*
 * public BigInteger inverso() { BigInteger contador=BigInteger.ZERO; BigInteger
 * inverso = valor2.multiply(contador).mod(modulo); int
 * comparadorInversos=inverso.compareTo(BigInteger.ONE); int comparadorZn =
 * contador.compareTo(modulo); System.out.print("contador "+contador+
 * "ComparadorZn " + comparadorZn + "comparadorInversos " + comparadorInversos);
 * while(comparadorZn!=0) { System.out.print("contador "+contador+
 * "ComparadorZn " + comparadorZn + "comparadorInversos " + comparadorInversos);
 * contador=contador.add(BigInteger.valueOf(1)); inverso =
 * (valor2.multiply(contador)).mod(modulo);
 * comparadorInversos=inverso.compareTo(BigInteger.ONE); comparadorZn =
 * contador.compareTo(modulo); if(comparadorInversos==0) {
 * listaInversos.add(contador); } } return contador; }
 */
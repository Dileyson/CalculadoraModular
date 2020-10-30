import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CalculadoraModular {

	private BigInteger valor1;
	private BigInteger valor2;
	private int exponente;
	private BigInteger modulo;
	private BigInteger resultado;
	private BigInteger moduloNegativo;
	private ArrayList<BigInteger> listaInversos = new ArrayList<BigInteger>();
	private int signoResultado;
	private int signoValor1;
	private int signoValor2;
	private int signoModulo;
	private String resultadoInvertible;
	
	public CalculadoraModular(BigInteger valor1, BigInteger valor2, BigInteger modulo) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.modulo = modulo;

	}

	public CalculadoraModular(){}

	public void calculadora() {
		int opcion = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		valor1 = new BigInteger(JOptionPane.showInputDialog("Ingresar valor 1: "));
		
		valor2 = new BigInteger(JOptionPane.showInputDialog("Ingresar valor 2: "));
		
		modulo = new BigInteger(JOptionPane.showInputDialog("Ingresar modulo: "));
		signoModulo = modulo.signum();
		if(signoModulo == -1) {
			modulo = new BigInteger(JOptionPane.showInputDialog("El modulo debe ser positivo. Ingrese de nuevo el modulo: "));
		}
		MODULO();
		String menu="";
	            
		do {
			menu=" ";
			menu+="1. Suma \n";
			menu+="2. Resta \n";
			menu+="3. Multiplicacion \n";
			menu+="4. Division \n";
			menu+="5. Inversos \n";
			menu+="6. Exponencial \n";
			menu+="7. Raiz \n";
			menu+="8. Cuadrado Perfecto \n";
			menu+="9. Salir ";
			
			opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
			System.out.println(opcion);
           
			switch (opcion){
			case 1:
				JOptionPane.showMessageDialog(null, "La suma es "+ suma());
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "La resta es "+ resta());
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "La multiplicacion es "+ multiplicacion());
				break;
			case 4:
				division();
				break;
			case 5:
				inverso();
				break;
			case 6:
				exponente = Integer.parseInt(JOptionPane.showInputDialog("Ingresar exponente: "));
				JOptionPane.showMessageDialog(null, "El exponencial es: "+exponencial());
				break;
			case 7:
				JOptionPane.showMessageDialog(null, "La raiz es: "+ raiz());
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Los cuadrados perfectos son: "+ cuadradoPerfecto());
				break;

			}
		}
		while (opcion !=9);
       }

   public void menu() {
	   
   }
   
   public BigInteger suma()
   {
	   resultado=valor1.add(valor2);
	   return resultado.mod(modulo);
   }

   public BigInteger resta()
   {
	   resultado = valor1.subtract(valor2);
	   signoResultado= resultado.signum();
	   if(signoResultado == -1) {
		   moduloNegativo= resultado.mod(modulo);
	    	   moduloNegativo=moduloNegativo.abs().add(BigInteger.ONE);
	    	   resultado=(moduloNegativo.multiply(modulo)).subtract(resultado);    	   
	       }else {
	    	   resultado = resultado.mod(modulo);
	       }
	   return resultado;
	  
   }
   
   public void MODULO()
   {   
	   signoValor1 = valor1.signum();
	   signoValor2 = valor2.signum();
       if(signoValor1 == -1) {
    	   moduloNegativo= valor1.mod(modulo);
    	   moduloNegativo=moduloNegativo.abs().add(BigInteger.ONE);
    	   valor1=(moduloNegativo.multiply(modulo)).subtract(valor1);    	   
       }else {
    	   valor1 = valor1.mod(modulo);
       }
       
       if(signoValor2 == -1) {
    	   moduloNegativo= valor2.mod(modulo);
    	   moduloNegativo=moduloNegativo.abs().add(BigInteger.ONE);
    	   valor2=(moduloNegativo.multiply(modulo)).subtract(valor2);    	   
       }else {
	   valor2 = valor2.mod(modulo);
	   }
   }
   
   public BigInteger multiplicacion()
   {
	   	return (valor1.multiply(valor2)).mod(modulo);
	   	   		   	
   }
   
   public void inverso()
   {
	   if (valor2.gcd(modulo).compareTo(BigInteger.ONE) == 0)
	   {
		   BigInteger resultado2;
		   resultado= valor2.modInverse(modulo);
		   listaInversos.add(resultado);
		  // resultado2= (valor1.multiply(resultado)).mod(modulo);
		   JOptionPane.showMessageDialog(null, "el inverso es: "+ resultado);  
	   }
	   else {
		   
		   JOptionPane.showMessageDialog(null, "El inverso no existe"); 
	   }
		   
	}
   
   
   
   public String imprimirInversos() {
	   String cadenaInversos = "";
		   for(BigInteger in: listaInversos) {
			   cadenaInversos.concat(in.toString());
		   }
		   return cadenaInversos;
   }
   
   public void division()
   {   
	   if (valor2.gcd(modulo).compareTo(BigInteger.ONE) == 0)
	   {
		   BigInteger resultado2;
		   resultado= valor2.modInverse(modulo);
		   resultado2 =(valor1.multiply(resultado).mod(modulo));
		   JOptionPane.showMessageDialog(null, "El inverso es: "+ resultado2);  
	   }
	   else {
		   
		   JOptionPane.showMessageDialog(null, "El inverso no existe"); 
	   }
	   }
   
   public BigInteger exponencial() {
	   return (valor1.pow(Integer.valueOf(exponente))).mod(modulo);
   }
   
   public String raiz() {
	   String cadena = " ";
	   BigInteger multiplicacion;
	   int index =0;
	   for(BigInteger i = BigInteger.valueOf(0); i.compareTo(modulo) < 0; i = i.add(BigInteger.ONE)) {
		   multiplicacion = i.multiply(i);
		   if(multiplicacion.mod(modulo).equals(valor1)) {			  
			   cadena = cadena+" "+i;
			   index++;
		   }
		  
	   }
	   
	   return cadena;
   }
   
   public String cuadradoPerfecto() {
	   String cadena = " ";
	   BigInteger multiplicacion = null;
	   
	   int index =0;
	   for(BigInteger i = BigInteger.valueOf(0); i.compareTo(modulo) < 0; i = i.add(BigInteger.ONE)) {
		   multiplicacion = i.multiply(i).mod(modulo);
		   int comparador = multiplicacion.mod(modulo).compareTo(BigInteger.ZERO);
		   if(comparador != 0) {			  
			   cadena = cadena+" "+multiplicacion;
			   index++;
		   }
		  
	   }
	   
	   return cadena;
   }
}

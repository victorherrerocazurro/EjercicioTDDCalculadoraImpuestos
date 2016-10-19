package com.ejemplo.tdd.calculadora;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implementacion de los casos de prueba:
 * 	1-Si el ingreso es de 0, el impuesto es 0
 * @author Victor
 *
 */
public class LimitesPrecisionUT {

	/**
	 * Caso de prueba 1-Si el ingreso es de 0, el impuesto es 0
	 */
	@Test
	public void limiteDePrecisionCorrectoCasoDePrueba1() {
		
		//Datos de prueba
		BigDecimal ingreso = BigDecimal.valueOf(0.195d);
		BigDecimal impuestoEsperado = BigDecimal.valueOf(0);
		
		//Definicion de SUT
		CalculadoraImpuestos sut = new CalculadoraImpuestos();
		
		//Ejecución del codigo
		BigDecimal impuestoObtenido = sut.calcularImpuestosDeIngresos(ingreso);
		
		//Validacion
		Assert.assertEquals(impuestoEsperado, impuestoObtenido);
	}

	/**
	 * Caso de prueba 2-Si el ingreso es de 9.999.999.999.999.999, el impuesto es de 1.950.000.000.000.000
	 */
	
	@Test
	public void limiteDePrecisionCorrectoCasoDePrueba2() {

		//Datos de prueba
		BigDecimal ingreso = BigDecimal.valueOf(9_999_999_999_999_999d);
		
		//Con la precisión float, no se consigue la precision adecuada,
		//ya que la representacion del numero es 1.949999977988096E15,
		//asi que pasamos a double, como hay problemas con double, debemos pasar a BigDecimal
		
		//setScale será necesario si queremos que la comparacion con equals no de problemas
		
		BigDecimal impuestoEsperado = BigDecimal.valueOf(1_950_000_000_000_000d);//.setScale(2);
		
		//Definicion de SUT
		CalculadoraImpuestos sut = new CalculadoraImpuestos();
		
		//Ejecución del codigo
		BigDecimal impuestoObtenido = sut.calcularImpuestosDeIngresos(ingreso);
		
		//Validacion
		//Assert.assertEquals(impuestoEsperado, impuestoObtenido);
		
		//Alternativa a definir el scale, que emplea compareTo, en lugar de equals.
		Assert.assertTrue(impuestoEsperado.compareTo(impuestoObtenido) == 0);
	}
	
}

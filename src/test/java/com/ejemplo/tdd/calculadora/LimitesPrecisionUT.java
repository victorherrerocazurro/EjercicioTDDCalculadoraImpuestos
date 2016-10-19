package com.ejemplo.tdd.calculadora;

import static org.junit.Assert.fail;

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
		float ingreso = 0;
		float impuestoEsperado = 0;
		
		//Definicion de SUT
		CalculadoraImpuestos sut = new CalculadoraImpuestos();
		
		//Ejecución del codigo
		float impuestoObtenido = sut.calcularImpuestosDeIngresos(ingreso);
		
		//Validacion
		Assert.assertEquals(impuestoEsperado, impuestoObtenido, 0.001);
	}

	/**
	 * Caso de prueba 2-Si el ingreso es de 9.999.999.999.999.999, el impuesto es de 1.950.000.000.000.000
	 */
	
	@Test
	public void limiteDePrecisionCorrectoCasoDePrueba2() {

		//Datos de prueba
		float ingreso = 9_999_999_999_999_999f;
		
		//Con la precisión float, no se consigue la precision adecuada, 
		//asi que se necesita que sea double
		double impuestoEsperado = 1_950_000_000_000_000d;
		
		//Definicion de SUT
		CalculadoraImpuestos sut = new CalculadoraImpuestos();
		
		//Ejecución del codigo
		float impuestoObtenido = sut.calcularImpuestosDeIngresos(ingreso);
		
		//Validacion
		Assert.assertEquals(impuestoEsperado, impuestoObtenido, 0.001);
	}
	
}

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
	public void limiteDePrecisionCorrecto() {
		
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

}

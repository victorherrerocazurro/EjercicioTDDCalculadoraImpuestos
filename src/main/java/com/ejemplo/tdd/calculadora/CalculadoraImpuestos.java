package com.ejemplo.tdd.calculadora;

import java.math.BigDecimal;

public class CalculadoraImpuestos {

	public BigDecimal calcularImpuestosDeIngresos(BigDecimal ingreso) {
		
		if(ingreso.compareTo(BigDecimal.valueOf(8000)) <= 0){
			return BigDecimal.valueOf(0);
		} else if(ingreso.compareTo(BigDecimal.valueOf(25000)) > 0){
			//La precision de la operacion con doubles, no es correcta, deberia dar
			//1.95E15 y da 1.9500000531500238E15, por lo que debemos trabajar con BigDecimal
			//return ingreso * 0.195d;
			
			//setScale será necesario si queremos que la comparacion con equals no de problemas
			
			return ingreso.multiply(BigDecimal.valueOf(0.195d));//.setScale(2);
		}
		//Segun se implementa esta linea, que es necesaria para que compile
		//la clase, nos damos cuenta de que hay que tener pruebas que validen
		//cuando no se esta en los rangos, de no haberse incluido hasta ahora
		//este seria el momento para hacerlo
		return BigDecimal.valueOf(0);
	}

}

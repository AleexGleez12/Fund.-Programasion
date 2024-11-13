Algoritmo MultiplosDe3y5
    Definir contador Como Entero
    contador <- 0
	
    Para i <- 1 Hasta 999 Con Paso 1 Hacer
        Si i % 3 = 0 Y i % 5 = 0 Entonces
            contador <- contador + 1
        FinSi
    FinPara
	
    Escribir "Cantidad de números menores de 1000 que son múltiplos de 3 y 5: ", contador
FinAlgoritmo
Algoritmo Mayordecinco
    Definir num, may Como Entero
    may <- -9999
	
    Para i <- 1 Hasta 5 Con Paso 1 Hacer
        Escribir "Introduce un número: "
        Leer num
		
        Si num > may Entonces
            may <- num
        FinSi
    FinPara
	
    Escribir "El numero mayor es: ", may
FinAlgoritmo
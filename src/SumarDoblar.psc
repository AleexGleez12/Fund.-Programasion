Algoritmo SumarDoblar
    Definir numero, suma, dobleSuma Como Entero
    suma <- 0
	
    Escribir "Introduce un n�mero menor a 100: "
    Leer numero
	
    Si numero < 100 Entonces
        Para i <- 1 Hasta numero Con Paso 1 Hacer
            suma <- suma + i
        FinPara
		
        dobleSuma <- 2 * suma
        Escribir "El doble de la suma de los n�meros entre 1 y ", numero, " es: ", dobleSuma
    Sino
        Escribir "El n�mero debe ser menor a 100."
    FinSi
FinAlgoritmo

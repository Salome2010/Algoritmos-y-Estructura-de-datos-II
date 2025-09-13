# ejercicio 1 
sueldo_empleado_por_mes = [300, 300, 300, 300, 300, 300, 500, 500, 500, 500, 700, 700]

# Función para calcular el sueldo promedio
def sueldo_promedio_juan(lista: [int]) -> float:
    suma = sum(lista)  
    promedio = suma / len(lista)
    return promedio

# Función para determinar el tipo de sueldo basado en el sueldo promedio
def tipo_sueldo(promedio: float) -> str:
    if promedio < 300:
        return "Juan cobra un sueldo bajo"
    elif 300 <= promedio <= 900:
        return "Juan cobra un sueldo normal"
    else: 
        return "Juan cobra un sueldo mejor de lo normal"


promedio = sueldo_promedio_juan(sueldo_empleado_por_mes)
# Imprimir resultados
print(f"Sueldo promedio de Juan: {promedio:.2f} dolares")
print(tipo_sueldo(promedio))

    
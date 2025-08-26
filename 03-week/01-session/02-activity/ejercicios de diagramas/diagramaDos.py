import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("BMW sales data (2010-2024).csv", encoding='latin-1')

# Convertir ventas a numérico
df['Sales_Volume'] = pd.to_numeric(df['Sales_Volume'], errors='coerce')

# Agrupar por año y sumar ventas
ventas_por_anio = df.groupby('Year')['Sales_Volume'].sum()

# Graficar
plt.figure(figsize=(10, 6))
plt.plot(ventas_por_anio.index, ventas_por_anio.values, marker='o')
plt.title('Ventas de BMW por Año (2010-2024)')
plt.xlabel('Año')
plt.ylabel('Ventas Totales')
plt.grid(True)
plt.tight_layout()
plt.show()

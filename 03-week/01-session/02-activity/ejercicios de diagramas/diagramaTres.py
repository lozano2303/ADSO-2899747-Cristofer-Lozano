import pandas as pd
import matplotlib.pyplot as plt

# 1. Leer el archivo CSV
df = pd.read_csv("electric_vehicles_dataset.csv", encoding='latin-1')

# 2. Convertir las unidades vendidas a número
df['Units_Sold_2024'] = pd.to_numeric(df['Units_Sold_2024'], errors='coerce')

# 3. Agrupar por fabricante y sumar las ventas
sales_by_brand = df.groupby('Manufacturer')['Units_Sold_2024'].sum()

# 4. Ordenar y tomar las 10 más altas
top_10_sales = sales_by_brand.sort_values(ascending=False).head(10)

# 5. Crear diagrama de barras
plt.figure(figsize=(10, 6))
top_10_sales.plot(kind='bar')
plt.title('Top 10 Marcas de Vehículos Eléctricos (Ventas 2024)')
plt.xlabel('Fabricante')
plt.ylabel('Unidades Vendidas en 2024')
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

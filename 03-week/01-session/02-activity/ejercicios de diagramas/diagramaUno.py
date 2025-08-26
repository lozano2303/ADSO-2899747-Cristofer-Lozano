import pandas as pd
import matplotlib.pyplot as plt

# 1. Leer el archivo CSV
df = pd.read_csv("Cars_Datasets_2025.csv", encoding='latin-1')

# 2. Convertir la columna de asientos a número
df['Seats'] = pd.to_numeric(df['Seats'], errors='coerce')

# 3. Agrupar por compañía y calcular el promedio
seat_avg = df.groupby('Company Names')['Seats'].mean().sort_values(ascending=False).head(10)

# 4. Crear el diagrama de barras
plt.figure(figsize=(10, 6))
seat_avg.plot(kind='bar')
plt.title('Promedio de Asientos por Compañía (Top 10)')
plt.xlabel('Compañía')
plt.ylabel('Promedio de Asientos')
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

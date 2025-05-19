# 📚 DXPLORER - Sistema de Traspasos Vehiculares

**Proyecto Java con interfaz gráfica Swing para gestión de traspasos vehiculares**

[![Licencia MIT](https://img.shields.io/badge/Licencia-MIT-green.svg)](https://opensource.org/licenses/MIT)
[![Java-17](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Maven](https://img.shields.io/badge/Maven-3.8.6+-orange.svg)](https://maven.apache.org)

## 👨‍💻 Autor

**Juan José Basto González**
[![GitHub](https://img.shields.io/badge/GitHub-Profile-blue?logo=github)](https://github.com/JuanJoseBastoGonzalez)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue?logo=linkedin)](https://www.linkedin.com/in/juan-jose-basto-gonzalez-49945023a)

## 🚀 Características principales

- **Gestión completa de traspasos vehiculares**
- **Doble opción de ingreso de datos**:
  - Carga desde archivo JSON
  - Formulario manual con validación
- **Almacenamiento en**:
  - Base de datos MySQL en Clever Cloud
  - Archivo Excel (XLSX)
- **Interfaz gráfica intuitiva con Swing**
- **Conexión segura a base de datos remota**

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **Maven**
- **Swing (GUI)**
- **Apache POI** (manejo de Excel)
- **MySQL Connector/J**
- **org.json** (procesamiento JSON)

## 📦 Estructura del proyecto

```
DXPLORER/
├── src/
│   ├── main/
│   │   ├── java/com/mycompany/prueba/
│   │   │   ├── ConexionBD.java         # Conexión a MySQL
│   │   │   ├── DatosManuales.java      # Formulario manual
│   │   │   ├── ExcelCRUD.java          # Operaciones Excel
│   │   │   ├── Menu_principal.java     # Menú principal
│   │   │   ├── Prueba.java             # Clase principal
│   │   │   └── TestConexionVehiculos.java
│   │   └── resources/
│   └── test/
├── target/
│   ├── datos.json                      # Plantilla JSON
│   └── datos.xlsx                      # Datos exportados
├── pom.xml
└── README.md
```

## ⚙️ Configuración

### Requisitos

- **JDK 17+**
- **Maven 3.8.6+**
- **Conexión a internet** (para base de datos Clever Cloud)

### Configuración de la base de datos

Los parámetros de conexión ya están preconfigurados en `ConexionBD.java` con:

java

```
private static final String URL = "jdbc:mysql://bqgpttoye7cwyfbwj17y-mysql.services.clever-cloud.com:3306/bqgpttoye7cwyfbwj17y";
private static final String USER = "uh38nsrbk9dddgj7";
private static final String PASSWORD = "rsbmmu02dn60A11h6WTd";
```

## 🖥️ Uso

La aplicación presenta un menú principal con opciones:

1. **Cargar datos desde JSON** - Importa datos desde archivo JSON
2. **Ingreso manual de datos** - Abre formulario gráfico
3. **Exportar a Excel** - Genera/actualiza archivo datos.xlsx
4. **Salir** - Cierra la aplicación

## 📝 Licencia

Este proyecto está bajo la licencia **MIT**. Ver el archivo [LICENSE](https://LICENSE) para más detalles.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor abre un **issue** o envía un **pull request**.

## 📬 Contacto

Para cualquier consulta:

- [GitHub](https://github.com/JuanJoseBastoGonzalez)
- [LinkedIn](https://www.linkedin.com/in/juan-jose-basto-gonzalez-49945023a)

------

bash

```
# Comandos para ejecutar el proyecto
mvn clean install      # Compilar y empaquetar
mvn exec:java          # Ejecutar directamente
java -jar target/TestConexionVehiculos-1.0-SNAPSHOT.jar  # Ejecutar JAR
```
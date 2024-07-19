# Grocery Store Application

This is a simple console-based Java application for calculating grocery bills after applying various promotions and taxes. The application supports promotions like "buy-one-get-one-free" and percentage discounts.

## Project Structure

- `src/` - Source code directory
  - `model/` - Contains model classes (`Item`, `Promotion`)
  - `service/` - Contains service classes (`PromotionService`)
  - `test/` - Contains test classes (`PromotionServiceTest`, `BillingServiceTest`)
- `lib/` - Contains external libraries (JUnit, Hamcrest)
- `out/` - Compiled class files

## Setup

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure JDK 11 or higher is installed.
2. **VS Code**: Recommended for Java development with the Java Extension Pack.
3. **JUnit**: The project uses JUnit 4 for testing.

### Project Setup

1. **Clone the Repository**

   ```bash
   git clone <repository-url>
   cd <repository-directory>

2. **Download Dependencies**
<repository-directory>/
├── lib/
│   ├── junit-4.13.2.jar
│   └── hamcrest-core-1.3.jar

3. **Compile the Project**
javac -d out/ -sourcepath src/ -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" src/model/*.java src/service/*.java src/test/*.java

4. **Run the Tests**
java -cp "out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.PromotionServiceTest test.BillingServiceTest

5. **To Run Test On Console**
java -cp "out" main.GroceryStoreApp


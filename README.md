# Rally Solver

The Rally Solver is a Java-based repository that provides a solution for optimizing rally routes. This repository contains the code for the `SolucionadorRally` class, which generates random stop points for a rally and determines the optimal solution for completing the rally within certain distance constraints.

## Features

- Generates random stop points for a rally based on user-defined parameters.
- Ensures the generated points adhere to the specified constraints, such as the maximum distance between adjacent points.
- Determines if it is possible to complete the rally with the given set of stop points.
- Returns the optimal solution in the form of a list of points, considering the distance constraints.

## Usage

To use the Rally Solver, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/rally-solver.git`
2. Open the project in your preferred Java development environment.
3. Navigate to the `SolucionadorRally.java` file.
4. Adjust the parameters for the rally (number of points, maximum distance, and total distance) in the `main` method.
5. Run the program.
6. View the output, which includes the generated points, execution time, optimal solution, and the number of days required to complete the rally.

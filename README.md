# Statistical Analysis of a Numerical Sequence

## Overview

This project implements a program that calculates the **mean (average)** and **standard deviation** of a sequence of numbers provided via standard input. The program adheres to a predefined interface, **StatsInterface**, and is implemented in the **Stats** class. The main logic will be executed in the `Start` class.

## Requirements

- Compute **mean** and **standard deviation** for every 10 numbers in the input sequence.
- Print results **formatted to three decimal places** (`"%.3f %.3f"`).
- Handle input errors gracefully:
  - If a line contains **a non-numeric value**, print an **error message** to standard error in the format:
    ```
    A number has not been parsed from line X
    ```
    where `X` is the line number.
  - If there are fewer than 10 numbers at the end of the input, compute and display the statistics for the available numbers.
- The program **must print results to standard output and errors to standard error**.

![image](https://github.com/user-attachments/assets/3b1e1b25-9afb-4218-b819-7efe25bf1d6b)



## 🛠️ Installation & Setup

1. Clone this repository:
   ```sh
   git clone https://github.com/02ionova/Statistics-sequence.git
   cd Statistics-sequence
   ```
2. Open the project in **IntelliJ IDEA** or any other Java IDE that supports Maven.
3. Ensure that you have JDK 21 installed and configured.

## 🚀 Running the Application

- The main logic is inside `StatsInterface.java`, but this project does not include a main execution method. You can create a custom test inside `Main.java` or run unit tests.

## ✅ Running Tests

- To run tests in **IntelliJ IDEA**, open `CircularArrayQueuePublicTest.java` and click **Run**.
- Or use **Maven** in the terminal:
  ```sh
  mvn test
  ```

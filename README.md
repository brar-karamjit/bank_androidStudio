## Project Overview

This project is a banking application developed using Android Studio as part of the EECS 1022 course. It demonstrates the implementation of core Android development concepts, including:

- **Model-View-Controller (MVC) Architecture**: Separation of concerns between the user interface, business logic, and data management.
- **Interactive User Interface**: Features such as text fields, spinners, and buttons for user interaction.
- **Banking Operations**: Supports functionalities like adding new accounts, deposits, withdrawals, transfers, and generating account statements.
- **Unit Testing**: Includes JUnit tests to ensure the correctness of the application's business logic.

## Features

- Model-View-Controller (MVC) Architecture: Separation of concerns between the user interface, business logic, and data management.
- Interactive User Interface: Features such as text fields, spinners, and buttons for user interaction.
- Banking Operations:
  - Add new accounts.
  - Perform deposits, withdrawals, and transfers.
  - Generate account statements.
- Unit Testing: Includes JUnit tests to ensure the correctness of the application's business logic.
- Error Handling: Provides detailed error messages for invalid operations, such as:
  - Non-positive deposit or withdrawal amounts.
  - Exceeding the maximum number of accounts.
  - Attempting transactions on non-existent accounts.

The application is designed to provide a hands-on experience in building Android apps while reinforcing object-oriented programming principles.

## Project Structure

bank_androidStudio/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/eecs1022/lab7/bank/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── model/
│   │   │   │   │   ├── Bank.java
│   │   │   │   │   ├── Client.java
│   │   │   │   │   ├── Transaction.java
│   │   │   ├── res/
│   │   │       ├── values/
│   │   │       │   ├── strings.xml
│   │   │       ├── values-night/
│   │   │       │   ├── themes.xml
│   ├── build.gradle
│   ├── proguard-rules.pro
├── gradle/
│   ├── wrapper/
│       ├── gradle-wrapper.properties
├── build.gradle
├── settings.gradle

## How to Run

### Prerequisites
- Android Studio installed on your system.
- Java Development Kit (JDK) 8 or higher.

### Steps
1. Clone the repository:
   git clone https://github.com/your-repo-url.git
   cd bank_androidStudio
2. Open the project in Android Studio.
3. Build the project to download dependencies.
4. Run the application on an emulator or a physical Android device.

## Testing

Unit tests are provided in the app/src/test/java/eecs1022/lab7/bank/Tests.java file. These tests cover various scenarios, including:
- Valid and invalid transactions.
- Error handling for edge cases.
- Account management operations.

To run the tests:
1. Open the project in Android Studio.
2. Navigate to the Tests.java file.
3. Right-click and select "Run Tests".

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgments

- Developed as part of the EECS 1022 course at York University.
- Special thanks to the course instructors for their guidance.
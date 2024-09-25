
# Bank Challenge

This project is a simple banking account management system where users can check their balance, deposit, and transfer funds. The purpose of this challenge is to demonstrate different approaches to code implementation, ranging from a simpler and more straightforward approach (junior) to a more structured and pattern-oriented approach (senior).

Please note that testing is not part of the objectives of this challenge.
## Project Structure

The project is divided into three implementation approaches:

1. **Junior Approach**:
    - The code is written simply, with little separation of responsibilities.
    - All functionalities are concentrated in a single class, making the code difficult to maintain and scale.
    - No exception handling.

2. **Mid-Level Approach**:
    - The code is more organized, with responsibilities separated into different methods.
    - The use of enums and interfaces enhances code readability and maintainability.
    - Exceptions are handled more carefully, improving the robustness of the system.
    - The business logic is clearer but can still be improved in terms of extensibility and maintainability. 

3. **Senior Approach**:
    - The code uses the Strategy design pattern to separate account operations into different classes, following the single responsibility principle.


## Features

- **Check Balance**: Users can check the current balance of their account.
- **Deposit Funds**: Users can deposit an amount into their account, provided it is a positive value.
- **Transfer Funds**: Users can transfer an amount to another account, provided they have sufficient balance.
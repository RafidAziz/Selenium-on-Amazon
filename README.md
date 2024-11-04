# Selenium-on-Amazon
This repository showcases my automation testing capabilities on Amazon's web application. 

It is an ongoing work in progress.

## Testing Concepts Applied
- Page Object Model (POM)
- Behaviour-Driven Development (BDD)
- Test-Driven Development (TDD)

## Tech Stack
- Cucumber
- Selenium
- TestNG
- Java
- Gherkins

## Code Architecture Diagram
<img width="600" alt="image" src="https://github.com/user-attachments/assets/443d2ae9-d270-4432-b767-47347901e314">

## Test Cases Automated
- Valid login
- Invalid login
- Log out
- Search product
- View product details
- Add product to cart
- Remove product from cart
- Create shopping list
- Delete shopping list
- Verify registry categories links
- Create wedding registry
- Delete wedding registry
- Change language
- Change currency
- Cancel language changes
- Cancel currency changes
- Change product quantity in product page
- Change product quantity in cart page
- Verify product details > 'Buy Now' function
- Verify product details > 'Sold By' link > Seller name
- Verify returns popup
- Verify payment popup
- Verify 'report an issue' function
- Verify page sections in product details page
- Verify navigation header in product details page
- Verify navigation footer headings and links in product details page
- Verify product variations in product details page

## Execution Demo
https://github.com/RafidAziz/Selenium-on-Amazon/assets/167278169/870879d0-7aee-4ddd-835b-a499aee7626f

<img width="500" alt="image" src="https://github.com/user-attachments/assets/9d7b034d-9c89-4108-952e-51f359037f55">

## Test Reports
### Cucumber Test Report: [Cucumber Test Report.pdf](https://github.com/user-attachments/files/16229646/Cucumber.Test.Report.pdf)

<img width="500" alt="image" src="https://github.com/user-attachments/assets/c78e34de-985b-42a6-a5ae-88d9c118f3f5">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/5e2cd836-64f4-4a58-ab19-515b5a8fa958">

### TestNG Test Report: [TestNG Test Report.pdf](https://github.com/user-attachments/files/16229675/TestNG.Test.Report.pdf)

<img width="500" alt="image" src="https://github.com/user-attachments/assets/9690a487-6433-4161-9eb1-97f43c611a3d">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/75789080-8d66-42e4-8ce1-6ad26bef97e4">

## Execution Instructions
- To run the program, execute 'RunAll.java' in Eclipse as a 'Java Application'.
- To run parallel execution, execute 'RunAllParallel.java' in Eclipse as a 'Java Application'.

## Backlog (Subject to Changes)
- 

## Current Task 
- Automating test case: Verify product price on the product detail page matches the price in the cart
  - Stopped at writing page object class methods > assertPriceInCartEqualsPriceInProdPage() > Set cart item price

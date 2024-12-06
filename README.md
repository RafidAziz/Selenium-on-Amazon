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
- Verify product price on the product detail page matches the price in the cart


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
1. Search Functionality

	•	Verify filters (e.g., category, brand, price range) refine search results as expected.
	•	Verify the “Sort by” feature (e.g., price, popularity, ratings) works correctly.
	•	Verify the search suggestions dropdown populates as the user types.

2. Login and Signup

	•	Verify a user can sign up with valid credentials.
	•	Verify error messages are displayed for invalid inputs (e.g., incorrect email format or missing fields).
	•	Verify a user can log in with valid credentials.
	•	Verify “Forgot Password” functionality sends a reset link to the user.

3. Product Details Page

	•	Verify the product title, description, and price are displayed.
	•	Verify product images update when variations (e.g., size, color) are selected.
	•	Verify the “Add to Cart” and “Buy Now” buttons are functional.
	•	Verify user reviews and ratings are displayed.
	•	Verify availability status (e.g., “In Stock” or “Out of Stock”) is correct.

4. Cart and Checkout

	•	Verify a product is successfully added to the cart.
	•	Verify the quantity of products in the cart can be updated.
	•	Verify the cart reflects the total price correctly.
	•	Verify removing a product updates the cart subtotal.
	•	Verify applying promo codes adjusts the price accordingly.
	•	Verify the checkout process works end-to-end with valid payment details.

5. Navigation and UI

	•	Verify the homepage loads successfully with all main elements.
	•	Verify all main menu links navigate to the correct pages.
	•	Verify footer links (e.g., “Customer Service,” “Careers”) navigate correctly.
	•	Verify responsiveness on different screen sizes (desktop, mobile, tablet).

6. Wishlist

	•	Verify a user can add and remove products from the wishlist.
	•	Verify wishlist items persist across sessions after logging in.
	•	Verify clicking a wishlist item navigates to its product details page.

7. Payment

	•	Verify available payment methods are displayed.
	•	Verify a user can successfully complete a purchase using valid payment details.
	•	Verify an error message is displayed for invalid payment methods (e.g., expired card).
	•	Verify the “Save this card for future use” option retains card details securely.

8. User Account

	•	Verify order history is displayed correctly in the user account.
	•	Verify a user can update personal details (e.g., address, phone number).
	•	Verify saved payment methods are listed under “Payment Options.”
	•	Verify the “Sign Out” button logs the user out successfully.

9. Customer Support

	•	Verify the “Contact Us” page loads successfully.
	•	Verify help topics are displayed for common queries.
	•	Verify live chat, email, or call support options work as intended.

10. Performance and Security

	•	Verify pages load within an acceptable timeframe.
	•	Verify user sessions expire after a period of inactivity.
	•	Verify sensitive data (e.g., passwords, payment info) is encrypted. 

## Current Task 
- Automate test case: Verify filters (e.g., category, brand, price range) refine search results as expected
  - Write BDD steps in feature file
    

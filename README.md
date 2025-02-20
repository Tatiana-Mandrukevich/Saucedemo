1. LoginTest:
1.1. Login on site with empty username
1.2. Login on site with empty password
1.3. Login on site with empty username and password
1.4. Login on site with incorrect data in fields
1.5. Login on site with correct data in fields
1.6. Close error message by clicking on the cross
1.7. Clearing the field username by clicking on the cross
1.8. Clearing the field password by clicking on the cross
1.9. Check login title
2. HeaderTest:
2.1. Check app title
2.2. Open menu
2.3. Close menu
2.4. Open cart
2.5. Adding a product to the cart: check that the cart icon displays the count of added products
3. ProductTest:
3.1. Check page title
3.2. Check that there are 6 products displayed on the page
3.3. Check a product name for each product 
3.4. Check a product description for each product
3.5. Check a product price for each product
3.5. Check that a product picture is displayed for each product
3.6. Check that "Add to cart" button is displayed for each product
3.7. Adding a product to the cart: check that the "Add to cart" button is not displayed for the added product
3.8. Adding a product to the cart: check that the "Remove" button is displayed for the added product

1 задание:
Команда для автоматического обновления всех версий библиотек в проекте: mvn versions:use-latest-versions
Результат в Terminal:
tatiana@MacBook-Air-Tatana Saucedemo % mvn versions:use-latest-versions
[INFO] Scanning for projects...
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-metadata.xml
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-metadata.xml (14 kB at 24 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/maven-metadata.xml (21 kB at 34 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/versions-maven-plugin/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/versions-maven-plugin/maven-metadata.xml (1.3 kB at 12 kB/s)
[INFO]
[INFO] -----------------------< org.example:Saucedemo >------------------------
[INFO] Building Saucedemo 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- versions:2.18.0:use-latest-versions (default-cli) @ Saucedemo ---
Downloading from central: https://repo.maven.apache.org/maven2/org/seleniumhq/selenium/selenium-java/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/seleniumhq/selenium/selenium-java/maven-metadata.xml (5.7 kB at 50 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/testng/testng/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/testng/testng/maven-metadata.xml (3.1 kB at 27 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/io/github/bonigarcia/webdrivermanager/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/io/github/bonigarcia/webdrivermanager/maven-metadata.xml (3.2 kB at 28 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/hamcrest/hamcrest/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/hamcrest/hamcrest/maven-metadata.xml (577 B at 5.2 kB/s)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.728 s
[INFO] Finished at: 2025-02-20T20:31:47+03:00
[INFO] ------------------------------------------------------------------------

2 задание:
Команда для удаления временных файлов и запуска всех тестов: mvn clean test
Результат в Terminal:
tatiana@MacBook-Air-Tatana Saucedemo % mvn clean test
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< org.example:Saucedemo >------------------------
[INFO] Building Saucedemo 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- clean:3.2.0:clean (default-clean) @ Saucedemo ---
[INFO] Deleting /Users/tatiana/Все мои файлы/Тестирование/Автоматизированное тестирование на Java/18. Selenium WebDriver - локаторы/Saucedemo/target
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ Saucedemo ---
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ Saucedemo ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 9 source files with javac [debug target 23] to target/classes
[INFO] /Users/tatiana/Все мои файлы/Тестирование/Автоматизированное тестирование на Java/18. Selenium WebDriver - локаторы/Saucedemo/src/main/java/pages/LoginPage.java: /Users/tatiana/Все мои файлы/Тестирование/Автоматизированное тестирование на Java/18. Selenium WebDriver - локаторы/Saucedemo/src/main/java/pages/LoginPage.java uses or overrides a deprecated API.
[INFO] /Users/tatiana/Все мои файлы/Тестирование/Автоматизированное тестирование на Java/18. Selenium WebDriver - локаторы/Saucedemo/src/main/java/pages/LoginPage.java: Recompile with -Xlint:deprecation for details.
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ Saucedemo ---
[INFO] Copying 6 resources from src/test/resources to target/test-classes
[INFO]
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ Saucedemo ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 9 source files with javac [debug target 23] to target/test-classes
[INFO] /Users/tatiana/Все мои файлы/Тестирование/Автоматизированное тестирование на Java/18. Selenium WebDriver - локаторы/Saucedemo/src/test/java/tests/BaseTest.java: /Users/tatiana/Все мои файлы/Тестирование/Автоматизированное тестирование на Java/18. Selenium WebDriver - локаторы/Saucedemo/src/test/java/tests/BaseTest.java uses or overrides a deprecated API.
[INFO] /Users/tatiana/Все мои файлы/Тестирование/Автоматизированное тестирование на Java/18. Selenium WebDriver - локаторы/Saucedemo/src/test/java/tests/BaseTest.java: Recompile with -Xlint:deprecation for details.
[INFO]
[INFO] --- surefire:3.5.2:test (default-test) @ Saucedemo ---
[INFO] Using auto detected provider org.apache.maven.surefire.testng.TestNGProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
февр. 20, 2025 9:00:18 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkQuantityTest ========================================
======================================== FINISHED TEST checkQuantityTest Duration: 0s ========================================
февр. 20, 2025 9:00:19 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkAppTitle ========================================
======================================== FINISHED TEST checkAppTitle Duration: 0s ========================================
февр. 20, 2025 9:00:21 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkCountOfAddedProductsOnCart ========================================
======================================== FINISHED TEST checkCountOfAddedProductsOnCart Duration: 0s ========================================
февр. 20, 2025 9:00:23 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST closeMenu ========================================
======================================== FINISHED TEST closeMenu Duration: 20s ========================================
февр. 20, 2025 9:00:44 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST openCart ========================================
======================================== FINISHED TEST openCart Duration: 0s ========================================
февр. 20, 2025 9:00:46 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST openMenu ========================================
======================================== FINISHED TEST openMenu Duration: 0s ========================================
февр. 20, 2025 9:00:48 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkLoginTitle ========================================
======================================== FINISHED TEST checkLoginTitle Duration: 0s ========================================
февр. 20, 2025 9:00:49 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST closeErrorMessage ========================================
======================================== FINISHED TEST closeErrorMessage Duration: 20s ========================================
февр. 20, 2025 9:01:11 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST loginWithEmptyFieldsTest ========================================
======================================== FINISHED TEST loginWithEmptyFieldsTest Duration: 0s ========================================
февр. 20, 2025 9:01:12 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST loginWithEmptyPasswordTest ========================================
======================================== FINISHED TEST loginWithEmptyPasswordTest Duration: 0s ========================================
февр. 20, 2025 9:01:14 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST loginWithEmptyUsernameTest ========================================
======================================== FINISHED TEST loginWithEmptyUsernameTest Duration: 0s ========================================
февр. 20, 2025 9:01:15 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST loginWithIncorrectFieldsTest ========================================
======================================== FINISHED TEST loginWithIncorrectFieldsTest Duration: 0s ========================================
февр. 20, 2025 9:01:17 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST successLoginTest ========================================
======================================== FINISHED TEST successLoginTest Duration: 0s ========================================
февр. 20, 2025 9:01:18 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkAddToCartButtonIsNotDisplayedForAddedProduct ========================================
======================================== FINISHED TEST checkAddToCartButtonIsNotDisplayedForAddedProduct Duration: 20s ========================================
февр. 20, 2025 9:01:40 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkAddToCartButtonsCount ========================================
======================================== FINISHED TEST checkAddToCartButtonsCount Duration: 0s ========================================
февр. 20, 2025 9:01:41 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkPageTitle ========================================
======================================== FINISHED TEST checkPageTitle Duration: 0s ========================================
февр. 20, 2025 9:01:43 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkProductDescription ========================================
======================================== FINISHED TEST checkProductDescription Duration: 0s ========================================
февр. 20, 2025 9:01:45 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkProductPicturesCount ========================================
======================================== FINISHED TEST checkProductPicturesCount Duration: 0s ========================================
февр. 20, 2025 9:01:46 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkProductPrice ========================================
======================================== FINISHED TEST checkProductPrice Duration: 0s ========================================
февр. 20, 2025 9:01:48 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkProductsCount ========================================
======================================== FINISHED TEST checkProductsCount Duration: 0s ========================================
февр. 20, 2025 9:01:49 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkProductsNames ========================================
======================================== FINISHED TEST checkProductsNames Duration: 0s ========================================
февр. 20, 2025 9:01:51 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST checkRemoveButtonIsDisplayedForAddedProduct ========================================
======================================== FINISHED TEST checkRemoveButtonIsDisplayedForAddedProduct Duration: 0s ========================================
февр. 20, 2025 9:01:52 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 133, returning the closest version; found: 132; Please update to a Selenium version that supports CDP version 133
======================================== STARTING TEST isAddToCartButtonDisplayedTest ========================================
======================================== FINISHED TEST isAddToCartButtonDisplayedTest Duration: 0s ========================================
[INFO] Tests run: 23, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 96.91 s -- in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 23, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:38 min
[INFO] Finished at: 2025-02-20T21:01:54+03:00
[INFO] ------------------------------------------------------------------------
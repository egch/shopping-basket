# shopping-basket
A simple program that calculates the price of a shopping basket.
## How to build it
Requires java 8(or higher) and maven 3.6.0

*$ mvn clean install*
## How to execute it
With maven:

*$ mvn exec:java*

With JDK:

*$ java -jar target/shopping-basket.jar*
## Example of usage
Items are shown in the same order as declared in Fruit (ordinal).

```json
shopping-basket$ java -jar target/shopping-basket.jar 

Quantity of Apples: 2

Quantity of Oranges: 3

Quantity of Bananas: 1

Quantity of Papayas: 4

************************
2	Apple	0.5
3	Orange	0.9
1	Banana	0.15
4	Papaya	1.5
************************
Total: 3.05



```


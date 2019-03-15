# Retail Store Discounts
------------

An application to calculate net payable amount after applying discounts based on various user types and categories.

## Installation

### Requirements
* Java 8
* Maven

### Installing dependencies and Building the app
```
$ mvn clean install 
```

### How to run the App
```
$ java -jar -Dapple.awt.UIElement="true" target/invoice-generator-1.0-SNAPSHOT.jar -h
```

### How to run Unit Tests on the App
```
$ mvn test
```

### How to generate coverage reports
```
$ mvn cobertura:cobertura
```
To view Coverage reports, navigate to target/site/cobertura/index.html in your Finder/Windows Explorer. 

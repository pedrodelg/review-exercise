# Code Review / Refactoring exercise

This is the review of the code snippet

# Review

1- It's necesary to remove the variable "initialized" because it's not used.

2- The variable "dbParams" is a Map an it should be parameterized.

3- The variables logger, logError, logMessage, logWarning, logToDatabase, logToFile, logToConsole, dbParams, dbParamsMap, assigning a value to a `static` field in a constructor could cause unreliable behavior at runtime, it should remove private and static modifiers.

4- The code is using generic exception, it's better create custom exceptions in order to get an error message more clear

5- It makes a trim to the variable "messageText" but it does not return the response in a variable.

6- It should validate if the variable "messageText" is null before make trim not after that.

7- It validate if lenght of String "messageText" is true, but we can do it better with the method isEmpty()

8- The variable l is define as null and after that it concatenates with other objects, the variable will always have null in the bigining

9- It's not necesary declare the conection null from the begining, it's better create directly Connection connection =  DriverManager.getConnection...

10- Database close conection is needed

11- It should check if logs dir exist

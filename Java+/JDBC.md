**JDBC - Table of Contents**
- [JDBC driver classes](#jdbc-driver-classes)
- [Driver manager](#driver-manager)
- [Connection object](#connection-object)
- [Statement object and execution](#statement-object-and-execution)
	- [Normal Statement and execution](#normal-statement-and-execution)
	- [Preapared Statement and execution](#preapared-statement-and-execution)
- [SQL injection](#sql-injection)
- [Result set](#result-set)
	- [Simple result set](#simple-result-set)
	- [Scrollable result set](#scrollable-result-set)
	- [Updatable-result-set](#updatable-result-set)
- [Callable statement](#callable-statement)
- [JDBC Metadata](#jdbc-metadata)
- [Data source objects](#data-source-objects)
- [A usable example](#a-usable-example)


---


# JDBC driver classes
- the driver classes are implementaions of JDBC interface for various DB providers as follows
  - org.postgresql.Driver - for PostgreSQL
  - com.mysql.jdbc.Driver - for MySQL
  - org.sqlite.JDBC for 	- for SQLite 


---


# Driver manager
- A service for managing a set of JDBC drivers in an application 
- 2 ways to **register**
  - `Class.forName("org.postgresql.Driver");` // preferred as variable name can be used
  - `DriverManager.registerDriver(new org.postgresql.Driver());` 


---


# Connection object
- Connection object remains a link between application and DBMS.
- All requests to DBMS are routed through Connection Object.
- Its primary responsibilities are
  - To create “Statement” objects for executing SQL statements
  - To control “transaction” behavior
- Connection object require closing when not used. 
- opening connection and getting connection object
	````java
	public class DBConfig {
		String DB_DRIVER = "org.postgresql.Driver";
		String DB_URL = "jdbc:postgresql://localhost/postgres";
		String DB_USER = "postgres";
		String DB_PWD = "postgres";
	}

	//... inside a singleton class that returns the connection object
	Class.forName( DBConfig.DB_DRIVER ); 
	connectionObj = DriverManager.getConnection(
						DBConfig.DB_URL, // + "?searchpath=company",
						DBConfig.DB_USER, 
						DBConfig.DB_PWD 
					);
	//...

	````
- refer to [jdbc.pdf](https://drive.google.com/open?id=1sWHWVkPUsY8UQr0No79qb-gqCHEBvTXy) pg no. **18** for common connection methods.


---


# Statement object and execution
## Normal Statement and execution
- Statement Objects are used for executing SQL statements on connected DBMS.
- query execution methods
	- `boolean execute (String SQL)`  
		- Returns a boolean value of true if a ResultSet object can be retrieved; otherwise, it returns false.
		- Use this method to execute SQL DDL statements or when you need to use truly dynamic SQL.

	- `int executeUpdate (String SQL)`
		- Returns the number of rows affected by the execution of the SQL statement.
		- Use this method to execute SQL statements for which you expect to get a number of rows affected - for example, an INSERT, UPDATE, or DELETE statement.

	- `ResultSet executeQuery (String SQL)`
		- Returns a ResultSet object.
		- Use this method when you expect to get a result set, as you would with a SELECT statement.

- query execution example
	```java
	try{
		// Create a Statement Object Statement
		stmt = connectionObj.createStatement();
		// Call appropriate “execute” method
		result = stmt.execute*("<your_query>");
	}
	catch(){}	// some exception catching
	finally{
		// close connection
		stmt.close();
	}
	````

## Preapared Statement and execution
- Prepared here implies preparation of “query plan”;
- query plan is created once, and statement is executed multiple times.
- Advantages of prepared statement
	- One of the main technique of **avoiding SQL injections** 
	- Faster execution - as queries are pre-compiled and execution plan is also made beforehand
	- Avoids many run-time errors that may occur if queries are created by string concatenation.
- example
	````java
	String sql = "UPDATE Employees set age=? WHERE id=?";
	stmt = conn.prepareStatement(sql);

	// Bind values into the parameters.
	stmt.setInt(1, 35);  // This would set age
	stmt.setInt(2, 102); // This would set ID

	// Let us update age of the record with ID = 102;
	int affectedRows = stmt.executeUpdate();
	````
- refer to [jdbc.pdf](https://drive.google.com/open?id=1sWHWVkPUsY8UQr0No79qb-gqCHEBvTXy) pg no. **32** for common prepared statement methods.


---


# SQL injection
- example
	````java
	usr = "<user_input>";
	pwd = "<user_input>"; 
	// what if pwd is inputted as "abc' OR TRUE" translates to  'abc' OR TRUE' in case of which the where condition will always be true 
	// instead of selecting specific user it would select all user
	String sql_str = "SELECT * FROM user where uid = '" + usr + "' passwd='" + pwd + "'";
	stat.executeUpdate(sql_str);
	````


---


# Result set
## Simple result set
- Primarily works as iterator on set of rows returned by a SELECT query.
- Wraps collection of rows returned by a SELECT SQL statement.
- Resultset object iteratable and updatable.
	We have get*() methods for fetching data from current row of resultset object 
- example
	```java
	// inside the try block where result was fetched in previous example
	while(result.next)
	{
		System.out.println(result.getString ("<col-name>"));
		System.out.println(result.getDouble ("<col-name>"));
		System.out.println(result.getDate ("<col-name>"));
	}
	````
- refer to [jdbc.pdf](https://drive.google.com/open?id=1sWHWVkPUsY8UQr0No79qb-gqCHEBvTXy) pg no. **25** for common resultset methods.

## Scrollable result set
- this type of result set can be scrolled programmatically using provided functions.
- example
	````java
	// inside try catch
	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,     ResultSet.CONCUR_READ_ONLY);
	String query = “select … “;
	ResultSet result = stmt.executeQuery(query);
	result.previous();  // go back in the RS (not possible in JDBC 1…)
	result.relative(-5); // go 5 records back 
	result.relative(7); // go 7 records forward 
	result.absolute(100); // go to 100th record
	````

## Updatable-result-set
- this type of result set can be read as well as be updated
- example
	````java
	// inside try catch
	Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
	String query = " select SSN, SALARY from EMPLOYEE where dno=4";
	ResultSet result = stmt.executeQuery(query);
	while (result.next())
	{
		double salary = result.getInt(“SALARY”);
		result.updateDouble(“SALARY”, salary*1.1);
		result.updateRow();
	}  
	````


---


# Callable statement
- Callable Statements are used to execute SQL stored procedures. 
- example
	````java
	String sql = "{call getEmpName (?, ?)}";
	stmt = conn.prepareCall(sql);

	// Bind IN parameter first, then bind OUT parameter
	int empID = 102;
	stmt.setInt(1, empID); // This would set ID as 102

	// Because second parameter is OUT so register it
	stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

	// Use execute method to run stored procedure.
	System.out.println("Executing stored procedure..." );
	stmt.execute();
	````


---


# JDBC Metadata
- to be made


---


# Data source objects
- to be made


---


# A usable example
- to be made

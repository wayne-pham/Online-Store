# Java Online Store

The intent of the Online Store project is to demonstrate the powerful capabilites of software design patterns and methodolgies that were learned in CSCI-45000 Principles of Software Engineering.

The structure of the project starts by separating client-side and server-side components into their respective directories. This allows us to debug and maintain the code base more easily. For example, if there exist a ticket to make a change on the client-side of the Online Store, modifications on the client-side should not affect the server-side of the application. With the separation of responsibilities present in the application by design, making changes like these are possible.


## NOTE: The original instructions below are meant to be ran on IUPUI's custom Linux distros called Tesla and rrpc. This is here for archiving purposes. Please do not follow these commands.

### online-store-v2
This version of the online store will utilize design patterns.

### steps to run the program

1. ssh into rrpc01 and set the rmi port to 2020

2. run 'make' inside of the base directory. Base directory is called 'online-store-v2'

3. run 'make serverside' to start up RMI

4. open up a different terminal and ssh into rrpc02 

5. Be sure to move (cd) into the base directory. 

6. run 'make clientside' to run the program. 

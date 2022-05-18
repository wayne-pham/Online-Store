


## NOTE: The text below is meant to be ran on IUPUI's custom Linux distros called Tesla and rrpc. This is here for archiving purposes. Please do not follow these commands (or do so at your own risk) 

### online-store-v2
This version of the online store will utilize design patterns.

### steps to run the program

1. ssh into rrpc01 and set the rmi port to 2020

2. run 'make' inside of the base directory. Base directory is called 'online-store-v2'

3. run 'make serverside' to start up RMI

4. open up a different terminal and ssh into rrpc02 

5. Be sure to move (cd) into the base directory. 

6. run 'make clientside' to run the program. 

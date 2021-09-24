JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	client/controllers/AdminController.java \
	client/controllers/CustomerController.java \
	client/frontController/FrontController.java \
	client/views/AdminView.java \
	client/views/CustomerView.java \
	server/common/AccountType.java \
	server/common/ProductType.java \
	server/database/AccountsDatabase.java \
	server/database/Inventory.java \
	server/endpoints/RemoteDAO.java \
	server/endpoints/RemoteDAOImpl.java \
	server/models/Account.java \
	server/models/Product.java \
	Program.java

default: all

all: $(CLASSES:.java=.class)

serverside: 
	java server/endpoints/RemoteDAOImpl

clientside: 
	java Program

clean:
	rm client/controllers/AdminController.class
	rm client/controllers/CustomerController.class
	rm client/frontController/FrontController.class
	rm client/views/AdminView.class
	rm client/views/CustomerView.class
	rm server/common/AccountType.class
	rm server/common/ProductType.class
	rm server/database/AccountsDatabase.class
	rm server/database/Inventory.class
	rm server/endpoints/RemoteDAO.class
	rm server/endpoints/RemoteDAOImpl.class
	rm server/models/Account.class
	rm server/models/Product.class
	rm Program.class

jar: ${CLASSES}
	jar cf online-store ${CLASSES}
# TransactionAnalyser

Input Format:

Files input.properties and fileName.csv should be in the data folder.


input.properties Format:

fileName=fileName.csv
fromDate="DD/MM/YYYY hh:mm:ss"
toDate="DD/MM/YYYY hh:mm:ss"
merchant=merchant-name
reportFileName=reportFileName.txt


fileName.csv example:

ID, Date, Amount, Merchant, Type, Related Transaction
WLMFRDGD, 20/08/2018 12:45:33, 59.99, Kwik-E-Mart, PAYMENT,
YGXKOEIA, 20/08/2018 12:46:17, 10.95, Kwik-E-Mart, PAYMENT,
LFVCTEYM, 20/08/2018 12:50:02, 5.00, MacLaren, PAYMENT,
SUOVOISP, 20/08/2018 13:12:22, 5.00, Kwik-E-Mart, PAYMENT,
AKNBVHMN, 20/08/2018 13:14:11, 10.95, Kwik-E-Mart, REVERSAL, YGXKOEIA
JYAPKZFZ, 20/08/2018 14:07:10, 99.50, MacLaren, PAYMENT,



0. Build:
from the project folder run maven install
````
mvn clean install
````

1. Start:
From the target folder run
````
java -jar TransactionAnalyser.jar
````

Result (or report) will be in the reportFileName.txt file.
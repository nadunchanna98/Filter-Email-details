# Filter-Email-details
Email Filter using java Pattern matching with regular expressions, and parsing structured data.


 Consider you have 10 emails (About different lab reschedules for different courses written by
students to the instructors) saved in 10 files. The email body will differ in format. Sender
emailID can be in any format and the receiver email ID is provided by the faculty. Implement a
Java class FilterDetails to filter the details from the emails following the given steps from a to c.

Sample email:

From: Student name<emailID>
Sent: Monday, September 26, 2022 4:28:38 PM
To: Instructor name < emailID >
Subject: Lab Reschedule
Good morning, I’m writing this to request for a lab reschedule for EC5080. It is for lab04, “Pattern matching with regular expressions”. Thank you


a) It has a method to read a file. (Includes necessary Exceptions). 

b) It has a method to filter and return the following details from an email. Sender name, Sender email ID, Receiver name, Receiver email ID, Email date, Course code,     Semester, Lab no, and Lab name. You need to use the appropriate Java regular
expressions and necessary String methods. E.g., you can't extract the email IDs
considering the <…> symbols. 

c) It has a method to save the b.’s outputs of all emails in a file


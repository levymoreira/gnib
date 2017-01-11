# GNIB find dates  
  
This is a simple program to find a GNIB appointment date using the same API of the website: [https://burghquayregistrationoffice.inis.gov.ie/](https://burghquayregistrationoffice.inis.gov.ie/).

### Configurations 
Is necessary configure in the class MailSender.java, a email that will be used to send the email of alert.

### How to run
```
mvn package 
cd target
java -jar gnib-1.0-SNAPSHOT.jar
```

If you want keep the logs in a file just execute
```
java -jar gnib-1.0-SNAPSHOT.jar > logs.txt
```

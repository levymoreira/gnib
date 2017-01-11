package com.levymoreira;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

public class Runner {

    String appsNear = "https://burghquayregistrationoffice.inis.gov.ie/Website/AMSREG/AMSRegWeb.nsf/(getAppsNear)?openpage=&cat=Study&sbcat=All&typ=New&_=1480868892295";
    String byDateBegin = "https://burghquayregistrationoffice.inis.gov.ie/Website/AMSREG/AMSRegWeb.nsf/(getApps4DT)?openpage&dt=";
    String byDateEnd = "&cat=Study&sbcat=All&typ=New&_=1480868892296";
    String empty = "{\"empty\":\"TRUE\"}\n";

    MailSender mailSender = new MailSender();
    Rest rest = new Rest();

    public void run() throws Exception {
        while(true) {

            String response;

            //response = rest.get(appsNear); //apps near is disabled because the website of the of inis is with a bug in this functionality
            //checkResponseAndSendMail(!response.equals(empty), "Apps near!");

            LocalDate day = new LocalDate(); //vai nos proximos 30 dias
            for(int i=0; i<30; i++) {
                String formattedDay = day.toString("dd/MM/yyyy");
                response = rest.get( byDateBegin + formattedDay + byDateEnd);
                checkResponseAndSendMail(!response.equals(empty), "Day: " + formattedDay);

                day = day.plusDays(1);
            }
        }
    }

    private void checkResponseAndSendMail(Boolean validResponse, String datails) {
        if(validResponse)
            mailSender.sendMail(datails);
        else
            System.out.print("Fail (" + new LocalDateTime().toString("dd/MM/yyyy hh:mm:ss") + ") to date " + datails);
    }

}




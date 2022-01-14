package com.skatz;

import java.net.URL;
import java.util.Map;

public class Main {
    private static final String url = "https://egov.uscis.gov/casestatus/mycasestatus.do";
    private static final String errorResponseXpath = "//div[@id='formErrorMessages']";
    private static final String successfulResponseXpath = "//div[@class='rows text-center']";

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("Case status must be provided");
        }

        Map<String, String> parameters = Map.of(
                "changeLocale", "",
                "completedActionsCurrentPage", "",
                "upcomingActionsCurrentPage", "",
                "appReceiptNum", args[0],
                "caseStatusSearchBtn", "CHECK+STATUS"
        );

        // Send HTTP request
        Http http = new Http(new URL(url));
        String response = http.postRequest(parameters);

        // Parse response
        String errorResponse = HtmlParser.Parse(response, errorResponseXpath);
        if (!errorResponse.equals("")) {
            System.out.printf("Error received: %s", errorResponse);
            return;
        }

        String successfulResponse = HtmlParser.Parse(response, successfulResponseXpath);
        System.out.printf("Case status: %s", successfulResponse);
    }
}

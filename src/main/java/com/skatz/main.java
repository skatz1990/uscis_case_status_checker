package com.skatz;

import java.net.URL;
import java.util.Map;

public class Main {
    private static final String url = "https://egov.uscis.gov/casestatus/mycasestatus.do";

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

        Http http = new Http(new URL(url));
        String response = http.postRequest(parameters);
        System.out.printf("USCIS response: %n", response);
    }
}

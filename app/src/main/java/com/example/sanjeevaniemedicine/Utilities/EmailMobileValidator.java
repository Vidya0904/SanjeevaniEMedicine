package com.example.sanjeevaniemedicine.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMobileValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailMobileValidator(){
        pattern=Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(final String email)
    {
        matcher=pattern.matcher(email);
        return matcher.matches();
    }
    public boolean mobvalidate(String phone)
    {
        boolean check = false;
        if (phone.length() == 10)
        {
            check = true;
        }
        else
        {
            check = false;
        }
        return check;
    }

}

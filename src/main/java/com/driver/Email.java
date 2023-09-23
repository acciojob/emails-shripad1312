package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        int ct=0;
        boolean isupper=false;
        boolean islower=false;
        boolean isnum=false;
        boolean isspecial=false;
        if(oldPassword.equals(newPassword)){
            for (int i = 0; i < newPassword.length(); i++) {
                int ch=newPassword.charAt(i);

                //this is for avoiding whitespaces
                if(ch==32){
                  //  continue;
                    isupper=false;
                    islower=false;
                    isnum=false;
                    isspecial=false;
                    return;
                }
                if(ch>=65&&ch<=90){
                  isupper=true;
                }
                if(ch>=97&&ch<=122){
                    islower=true;
                }
                if(ch>=48&&ch<=57){
                    isnum=true;
                }
                if((ch>=32&&ch<=47)||(ch>=58&&ch<=64)||(ch>=91&&ch<=96)||(ch>=123&&ch<=126)){
                    isspecial=true;
                }
                ct++;
            }

            if(islower==true&&isupper==true&&isnum==true&&isspecial==true&&ct==8){
                setPassword(newPassword);
            }
        }
    }
}

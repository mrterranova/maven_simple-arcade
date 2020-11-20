package com.github.curriculeon.arcade;

import com.github.curriculeon.Arcade;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager {

    private List<ArcadeAccount> arcadeAccountList = new ArrayList<>();
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
        try {
            return arcadeAccountList
                    .stream()
                    .filter(account -> {
                        String currentAccountName = account.getAccountName();
                        String currentAccountPassword = account.getAccountPassword();
                        boolean validName = currentAccountName.equals(accountName);
                        boolean validPassword = currentAccountPassword.equals(accountPassword);
                            boolean validLogin = validName && validPassword;
                            return validLogin;
                    }).findFirst().get();
                    } catch( NoSuchElementException ex){
            System.out.print("You are not logged in yet: "+ ex);
            throw new NoSuchElementException(String.format("This does not match any account and password combo"));
        }
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount createAccount(String accountName, String accountPassword) {
        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String currentClassName = getClass().getName();
        ArcadeAccount arcadeAccount = new ArcadeAccount(accountName, accountPassword);
        return  arcadeAccount;
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        arcadeAccountList.add(arcadeAccount);


//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }
}

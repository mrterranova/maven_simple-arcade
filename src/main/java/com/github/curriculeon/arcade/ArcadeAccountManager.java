package com.github.curriculeon.arcade;

import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager {
    private List<ArcadeAccount> arcadeAccountList;

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        for(ArcadeAccount arcadeAccount : arcadeAccountList) {
            String currentAccountName = arcadeAccount.getUsername();
            String currentAccountPassword = arcadeAccount.getPassword();
            Boolean isValidAccountName = currentAccountName.equals(accountName);
            Boolean isValidAccountPassword = currentAccountPassword.equals(accountPassword);
            Boolean isValidLogin = isValidAccountName && isValidAccountPassword;
            if(isValidLogin) {
                return arcadeAccount;
            }
        }
        String errorMessage = "Unable to find account with name [ %s ] and password [ %s ]";
        throw new RuntimeException(String.format(errorMessage, accountName, accountPassword));
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount createAccount(String accountName, String accountPassword) {
        return new ArcadeAccount(accountName, accountPassword);
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        this.arcadeAccountList.add(arcadeAccount);
    }
}

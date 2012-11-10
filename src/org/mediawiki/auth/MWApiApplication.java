package org.mediawiki.auth;

import org.mediawiki.api.MWApi;

import android.accounts.Account;

public interface MWApiApplication {
    MWApi getApi();
    Account getCurrentAccount();
    void setCurrentAccount(Account account);
}

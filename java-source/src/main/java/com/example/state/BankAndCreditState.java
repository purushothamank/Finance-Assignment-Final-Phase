package com.example.state;

import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import net.corda.core.serialization.CordaSerializable;

import java.io.Serializable;
import java.util.List;

@CordaSerializable
public class BankAndCreditState implements LinearState,Serializable
{
    private Party bank;
    private Party creditRatingAgency;
    private boolean loanEligibleFlag;
    private String companyName;
    private int amount;
    private final UniqueIdentifier linearId;

    @ConstructorForDeserialization
    public BankAndCreditState(Party bank, Party creditRatingAgency, boolean loanEligibleFlag,String companyName, int amount, UniqueIdentifier linearId)
    {
        this.bank = bank;
        this.creditRatingAgency = creditRatingAgency;
        this.loanEligibleFlag = loanEligibleFlag;
        this.companyName = companyName;
        this.amount = amount;
        this.linearId = linearId;
    }


    public BankAndCreditState(UniqueIdentifier linearId)
    {
        this.linearId = linearId;
    }

    public Party getbank()
    {
        return bank;
    }

    public Party getCreditRatingAgency()
    {
        return creditRatingAgency;
    }

    public boolean getLoanEligibleFlag()
    {
        return loanEligibleFlag;
    }

    public void setLoanEligibleFlag(boolean loanEligibleFlag)
    {
        this.loanEligibleFlag = loanEligibleFlag;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public int getAmount()
    {
        return amount;
    }

    public Party getBank() {
        return bank;
    }

    public boolean isLoanEligibleFlag() {
        return loanEligibleFlag;
    }

    public void setBank(Party bank) {
        this.bank = bank;
    }

    public void setCreditRatingAgency(Party creditRatingAgency) {
        this.creditRatingAgency = creditRatingAgency;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public UniqueIdentifier getLinearId()
    {
        return linearId;
    }
    @Override
    public List<AbstractParty> getParticipants()
    {
        return ImmutableList.of(bank,creditRatingAgency);
    }
}

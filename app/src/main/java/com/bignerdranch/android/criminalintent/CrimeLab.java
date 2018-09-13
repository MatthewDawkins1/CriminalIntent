package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimelab;

    private List<Crime> mCrimes;

    public CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i =0; i <100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #"+i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);
        }
    }

    public static CrimeLab get(Context context){
        if(sCrimelab == null){
            sCrimelab = new CrimeLab(context);
        }
        return sCrimelab;
    }

    public List<Crime> getmCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime : mCrimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}

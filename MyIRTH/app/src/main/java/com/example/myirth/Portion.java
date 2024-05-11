package com.example.myirth;


import com.example.myirth.Deceased;
import com.example.myirth.Person;

public final class Portion {

    //-------------------------------------DAUGHTERS---------------------------------------

    public static double daughters(Deceased deceased){
        double daughterportion = 0.0;
        double remainingportion = 0.0;
        if (deceased.getDaughtersno() == 0){
            daughterportion = 0.0;
        }
        else if (deceased.getSonsno() == 0){
            if (deceased.getDaughtersno() == 1){
                daughterportion = deceased.getLegacy() / 2.0 ;
            } else if (deceased.getDaughtersno() > 1) {
                daughterportion = deceased.getLegacy() * 2.0 / 3.0;
            }
        }else {
            double fatherportion = 0.0;
            double motherportion = 0.0;
            double brothersportion = 0.0;
            double sistersportion = 0.0;
            double grandfatherportion = 0.0;
            double grandmotherportion = 0.0;
            double wivesportion = 0.0;
            double husbandportion = 0.0;

            if (deceased.Hasafather() == true){
                fatherportion = fatherportion + Portion.father(deceased);
            }
            if (deceased.Hasamother() == true){
                motherportion = motherportion + Portion.mother(deceased);
            }
            if (deceased.isHasahusband() == true){
                husbandportion = husbandportion + Portion.husband(deceased);
            }
            if (deceased.getWivesno() > 0){
                wivesportion = wivesportion + Portion.wives(deceased);
            }
            if (deceased.isHasagrandfather() == true){
                grandfatherportion = grandfatherportion + Portion.grandfather(deceased);
            }
            if (deceased.isHasagrandmother() == true){
                grandmotherportion = grandmotherportion + Portion.grandmother(deceased);
            }
            if (deceased.getBrothersno() >= 1){
                brothersportion = brothersportion + Portion.brothers(deceased);
            }
            if (deceased.getSistersno() >= 1){
                sistersportion = sistersportion +Portion.sisters(deceased);
            }


            if (deceased.getGender() == Person.MALE){
                remainingportion = deceased.getLegacy() - (fatherportion + motherportion + wivesportion + grandfatherportion + grandmotherportion + brothersportion + sistersportion);
            } else if (deceased.getGender() == Person.FEMALE) {
                remainingportion = deceased.getLegacy() - (fatherportion + motherportion + husbandportion + grandfatherportion + grandmotherportion + brothersportion + sistersportion);
            }

            daughterportion = remainingportion / (deceased.getDaughtersno() + (2 * deceased.getSonsno()));
        }

        return daughterportion;
    }

    //-------------------------------------SONS---------------------------------------

    public static double sons(Deceased deceased){
        double sonsportion = 0.0;
        double daughterportion = 0.0;
        double remainingportion = 0.0;
     //   if (deceased.getSonsno() > 0 && deceased.getDaughtersno() == 0 ){
   //         sonsportion = deceased.getLegacy();
 //       } else
            if (deceased.getSonsno() > 0 ) {
            double fatherportion = 0.0;
            double motherportion = 0.0;
            double brothersportion = 0.0;
            double sistersportion = 0.0;
            double grandfatherportion = 0.0;
            double grandmotherportion = 0.0;
            double wivesportion = 0.0;
            double husbandportion = 0.0;

            if (deceased.Hasafather() == true){
                fatherportion = fatherportion + Portion.father(deceased);
            }
            if (deceased.Hasamother() == true){
                motherportion = motherportion + Portion.mother(deceased);
            }
            if (deceased.isHasahusband() == true){
                husbandportion = husbandportion + Portion.husband(deceased);
            }
            if (deceased.getWivesno() > 0){
                wivesportion = wivesportion + Portion.wives(deceased);
            }
            if (deceased.isHasagrandfather() == true){
                grandfatherportion = grandfatherportion + Portion.grandfather(deceased);
            }
            if (deceased.isHasagrandmother() == true){
                grandmotherportion = grandmotherportion + Portion.grandmother(deceased);
            }
            if (deceased.getBrothersno() >= 1){
                brothersportion = brothersportion + Portion.brothers(deceased);
            }
            if (deceased.getSistersno() >= 1){
                sistersportion = sistersportion +Portion.sisters(deceased);
            }


            if (deceased.getGender() == Person.MALE){
                remainingportion = deceased.getLegacy() - (fatherportion + motherportion + wivesportion + grandfatherportion + grandmotherportion + brothersportion + sistersportion);
            } else if (deceased.getGender() == Person.FEMALE) {
                remainingportion = deceased.getLegacy() - (fatherportion + motherportion + husbandportion + grandfatherportion + grandmotherportion + brothersportion + sistersportion);
            }

            daughterportion = remainingportion / (deceased.getDaughtersno() + (2 * deceased.getSonsno()));
            sonsportion = 2 * daughterportion;
        }
        return sonsportion;
    }

    //-------------------------------------HUSBAND---------------------------------------

    public static double husband(Deceased deceased){
        double husbandportion = 0.0;
        if (!deceased.isHasahusband()){
            husbandportion = 0.0;
        } else if (deceased.getSonsno() > 0 || deceased.getDaughtersno() > 0 ){
            husbandportion = deceased.getLegacy() / 4.0;
        } else if (deceased.getSonsno() == 0 || deceased.getDaughtersno() == 0) {
            husbandportion = deceased.getLegacy() / 2.0;
        }
        return husbandportion;
    }

    //-------------------------------------WIVES---------------------------------------

    public static double wives(Deceased deceased){
        double wivesportion = 0.0;
        if (deceased.getWivesno() == 0){
            wivesportion = 0.0;
        } else if (deceased.getSonsno() > 0 || deceased.getDaughtersno() > 0 ){
            wivesportion = deceased.getLegacy() / 8.0 * deceased.getWivesno();
        } else if (deceased.getSonsno() == 0 || deceased.getDaughtersno() == 0) {
            if (deceased.getWivesno() == 1){
                wivesportion = deceased.getLegacy() / 4.0;
            } else if (deceased.getWivesno() > 1 ) {
                wivesportion = deceased.getLegacy() * 2.0 / 3.0;
            }
        }
        return wivesportion;
    }

    //-------------------------------------FATHER---------------------------------------

    public static double father(Deceased deceased){
        double fatherportion = 0.0;
        double remainingportion = 0.0;
        if (!deceased.Hasafather()){
            fatherportion = 0.0;
        } else if (deceased.getSonsno() > 0 || deceased.getDaughtersno() > 0){
            fatherportion = deceased.getLegacy() / 6.0;
        } else if (deceased.getSonsno() == 0 || deceased.getDaughtersno() == 0) {
            double motherportion = 0.0;
            double wivesportion = 0.0;
            double husbandportion = 0.0;
            if (deceased.Hasamother() == true){
                motherportion = motherportion + Portion.mother(deceased);
            }
            if (deceased.isHasahusband() == true){
                husbandportion = husbandportion + Portion.husband(deceased);
            }
            if (deceased.getWivesno() > 0){
                wivesportion = wivesportion + Portion.wives(deceased);
            }


            if (deceased.getGender() == Person.MALE){
                remainingportion = deceased.getLegacy() - (fatherportion + motherportion + wivesportion );
            } else if (deceased.getGender() == Person.FEMALE) {
                remainingportion = deceased.getLegacy() - (fatherportion + motherportion + husbandportion );
            }

            fatherportion = remainingportion;
        }
        return fatherportion;
    }

    //-------------------------------------MOTHER---------------------------------------

    public static double mother(Deceased deceased){
        double motherportion = 0.0;
        double remainingportion = 0.0;
        if (!deceased.Hasamother()){
            motherportion = 0.0;
        } else if ((deceased.getSonsno() == 0 && deceased.getDaughtersno() == 0) && !deceased.hasMultipleSiblings() && !deceased.Hasafather() && deceased.getWivesno() == 0 ){
            motherportion = deceased.getLegacy() / 3.0;
        } else if ((deceased.getSonsno() > 0 || deceased.getDaughtersno() > 0) || deceased.hasMultipleSiblings() ) {
            motherportion = deceased.getLegacy() / 6.0;
        } else if (deceased.getSonsno() == 0 && deceased.getDaughtersno() == 0 && !deceased.hasMultipleSiblings() && deceased.Hasafather() && (deceased.isHasahusband() || deceased.getWivesno() > 0)) {
            double wivesportion = 0.0;
            double husbandportion = 0.0;

            wivesportion = wivesportion + Portion.wives(deceased);
            husbandportion = husbandportion + Portion.husband(deceased);

            if (deceased.getGender() == Person.FEMALE){
                remainingportion = deceased.getLegacy() - husbandportion;
            } else if (deceased.getGender() == Person.MALE) {
                remainingportion = deceased.getLegacy() - wivesportion;
            }
            motherportion = remainingportion / 3.0;
        }
        return motherportion;
    }

    //-------------------------------------BROTHERs---------------------------------------

    public static double brothers(Deceased deceased){
        double brotherportion = 0.0;
        double remainingportion = 0.0;
        if (deceased.getSonsno() > 0 || deceased.Hasafather() || deceased.isHasagrandfather() || deceased.getBrothersno() == 0 ){
            brotherportion = 0.0;
        } else if (deceased.getSonsno() == 0 || !deceased.Hasafather() || !deceased.isHasagrandfather()) {
            double daughterportion = 0.0;
            double motherportion = 0.0;
            double sisterportion = 0.0;
            double grandmotherportion = 0.0;
            double wivesportion = 0.0;
            double husbandportion = 0.0;

            if (deceased.Hasamother() == true){
                motherportion = motherportion + Portion.mother(deceased);
            }
            if (deceased.isHasahusband() == true){
                husbandportion = husbandportion + Portion.husband(deceased);
            }
            if (deceased.getWivesno() > 0){
                wivesportion = wivesportion + Portion.wives(deceased);
            }
            if (deceased.getDaughtersno() > 0){
                daughterportion = daughterportion + Portion.daughters(deceased);
            }
            if (deceased.isHasagrandmother()){
                grandmotherportion = grandmotherportion + Portion.grandmother(deceased);
            }

            if (deceased.getGender() == Person.MALE){
                remainingportion = deceased.getLegacy() - (motherportion + wivesportion + daughterportion + grandmotherportion);
            } else if (deceased.getGender() == Person.FEMALE) {
                remainingportion = deceased.getLegacy() - (motherportion + husbandportion + daughterportion + grandmotherportion);
            }

            sisterportion = remainingportion / (deceased.getSistersno() + (2 * deceased.getBrothersno()));

            brotherportion = 2 * sisterportion;

        }


        return brotherportion;
    }

    //-------------------------------------SISTERS---------------------------------------

    public static double sisters(Deceased deceased){
        double sistersportion = 0.0;
        double remainingportion = 0.0;
        if (deceased.getSonsno() > 0  || deceased.Hasafather() || deceased.getSistersno() == 0 ){
            sistersportion = 0.0;
        } else if (deceased.getSistersno() == 1 && deceased.getSonsno() == 0 && deceased.getDaughtersno() == 0 && !deceased.Hasamother() && !deceased.Hasafather() && (deceased.getWivesno() == 0 || !deceased.isHasahusband()) && deceased.getBrothersno() == 0 && !deceased.isHasagrandfather() && !deceased.isHasagrandmother()) {
            sistersportion = deceased.getLegacy();
        } else if (deceased.getSistersno() == 1 && deceased.getBrothersno() == 0 && deceased.getDaughtersno() == 0) {
            sistersportion = deceased.getLegacy() / 2.0;
        } else if (deceased.getSistersno() > 1 && deceased.getBrothersno() == 0 && deceased.getDaughtersno() == 0) {
            sistersportion = deceased.getLegacy() * 2.0 / 3.0;
        } else if (deceased.getBrothersno() > 0) {
            double daughterportion = 0.0;
            double motherportion = 0.0;
            double grandmotherportion = 0.0;
            double wivesportion = 0.0;
            double husbandportion = 0.0;
            double grandfatherportio = 0.0;

            if (deceased.Hasamother() == true){
                motherportion = motherportion + Portion.mother(deceased);
            }
            if (deceased.isHasahusband() == true){
                husbandportion = husbandportion + Portion.husband(deceased);
            }
            if (deceased.getWivesno() > 0){
                wivesportion = wivesportion + Portion.wives(deceased);
            }
            if (deceased.getDaughtersno() > 0){
                daughterportion = daughterportion + Portion.daughters(deceased);
            }
            if (deceased.isHasagrandmother()){
                grandmotherportion = grandmotherportion + Portion.grandmother(deceased);
            }
            if (deceased.isHasagrandfather()){
                grandfatherportio = grandfatherportio + Portion.grandfather(deceased);
            }

            if (deceased.getGender() == Person.MALE){
                remainingportion = deceased.getLegacy() - (motherportion + wivesportion + daughterportion + grandmotherportion + grandfatherportio);
            } else if (deceased.getGender() == Person.FEMALE) {
                remainingportion = deceased.getLegacy() - (motherportion + husbandportion + daughterportion + grandmotherportion + grandfatherportio);
            }

            sistersportion = remainingportion / (deceased.getSistersno() + (2 * deceased.getBrothersno()));


        }

        return sistersportion;
    }

    //-------------------------------------GRANDFATHER---------------------------------------

    public static double grandfather(Deceased deceased){
        double grandfatherportion = 0.0;
        double remainingportion1 = 0.0;
        double remainingportion2 = 0.0;
        if(!deceased.isHasagrandfather() || deceased.Hasafather()){
            grandfatherportion = 0.0;
        } else if (!deceased.Hasafather() && (deceased.getSonsno() > 0 || deceased.getBrothersno() > 0)) {
            grandfatherportion = deceased.getLegacy() / 6;
        } else if ( deceased.getBrothersno() == 0 && deceased.getSonsno() == 0 && !deceased.Hasafather() ) {
            double daughterportion = 0.0;
            double motherportion = 0.0;
            double sisterportion = 0.0;
            double grandmotherportion = 0.0;
            double wivesportion = 0.0;
            double husbandportion = 0.0;
            remainingportion1 = deceased.getLegacy() / 6;

            if (deceased.getDaughtersno() > 0){
                daughterportion = daughterportion + Portion.daughters(deceased);
            }
            if (deceased.Hasamother()) {
                motherportion = motherportion + Portion.mother(deceased);
            }
            if (deceased.getSistersno() > 0) {
                sisterportion = sisterportion + Portion.sisters(deceased);
            }
            if (deceased.isHasagrandmother()){
                grandmotherportion = grandmotherportion + Portion.grandmother(deceased);
            }
            if (deceased.getWivesno() > 0){
                wivesportion = wivesportion + Portion.wives(deceased);
            }
            if (deceased.isHasahusband()){
                husbandportion = husbandportion + Portion.husband(deceased);
            }

            if (deceased.getGender() == Person.MALE){
                remainingportion2 = deceased.getLegacy() - (wivesportion + daughterportion + sisterportion + motherportion + grandmotherportion);
            } else if (deceased.getGender() == Person.FEMALE) {
                remainingportion2 = deceased.getLegacy() - (husbandportion + daughterportion + sisterportion + motherportion + grandmotherportion);

            }

            grandfatherportion = remainingportion1 + remainingportion2;
        }

        return grandfatherportion;
    }

    //-------------------------------------GRANDMOTHER---------------------------------------

    public static double grandmother(Deceased deceased){
        double grandmotherportion = 0.0;
        if (!deceased.isHasagrandmother() || deceased.Hasamother() || deceased.Hasafather()){
            grandmotherportion = 0.0;
        } else {
            grandmotherportion = deceased.getLegacy() / 6;
        }
        return grandmotherportion;
    }
}

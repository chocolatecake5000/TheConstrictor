package theconstrictorpackagemod.util;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.blue.GeneticAlgorithm;
import com.megacrit.cardcrawl.cards.colorless.Madness;
import theconstrictorpackagemod.cards.RustyKnife;

import static com.megacrit.cardcrawl.helpers.CardLibrary.getCard;

public class ritualfix {
    public static AbstractCard getCopy(String key, int upgradeTime, int misc) {
        AbstractCard source = getCard(key);// 994
        AbstractCard retVal = null;// 995
        if (source == null) {// 997
            retVal = getCard(Madness.ID).makeCopy();// 998
        } else {
            retVal = getCard(key).makeCopy();// 1000
        }

        for(int i = 0; i < upgradeTime; ++i) {// 1003
            retVal.upgrade();// 1004
        }

        retVal.misc = misc;// 1007
        if (misc != 0) {// 1008
            if (retVal.cardID.equals(GeneticAlgorithm.ID)) {// 1009
                retVal.block = misc;// 1010
                retVal.baseBlock = misc;// 1011
                retVal.initializeDescription();// 1012
            }

            if (retVal.cardID.equals(RustyKnife.ID)) {// 1014
                retVal.damage = misc;// 1015
                retVal.baseDamage = misc;// 1016
                retVal.initializeDescription();// 1017
            }
        }

        return retVal;// 1020
    }
}
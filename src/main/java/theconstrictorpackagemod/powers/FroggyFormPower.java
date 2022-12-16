package theconstrictorpackagemod.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theconstrictorpackagemod.cards.DustyShiv;


import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class FroggyFormPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("FroggyFormPower");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public FroggyFormPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }



    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        this.flash();
        this.addToBot(new ApplyPowerAction(this.owner, this.owner,new StrengthPower(this.owner, amount)));
        this.addToBot(new ApplyPowerAction(this.owner, this.owner,new DexterityPower(this.owner, amount)));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
    }


    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new FroggyFormPower(owner, amount);
    }

}

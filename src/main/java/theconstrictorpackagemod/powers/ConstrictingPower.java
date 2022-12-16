package theconstrictorpackagemod.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;


import static theconstrictorpackagemod.theconstrictormod.makeID;

public class ConstrictingPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("ConstrictingPower");
    private static final AbstractPower.PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = true;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public ConstrictingPower(AbstractCreature owner, AbstractCreature abstractCreature, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
        canGoNegative=true;
    }

    public void atEndOfTurn(boolean isPlayer) {
        this.addToBot(new DamageAction(this.owner, new DamageInfo(this.source, this.amount, DamageInfo.DamageType.THORNS)));

    }


    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }


    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new ConstrictingPower(owner, this.owner, amount);
    }

}

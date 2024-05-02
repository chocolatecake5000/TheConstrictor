package theconstrictorpackagemod.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;


import static theconstrictorpackagemod.theconstrictormod.makeID;

public class ConstrictingPower extends BasePower implements CloneablePowerInterface,HealthBarRenderPower {
    public static final String POWER_ID = makeID("ConstrictingPower");
    private static final AbstractPower.PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = true;

    public ConstrictingPower(AbstractCreature owner, AbstractCreature abstractCreature, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
        canGoNegative=true;

    }

    public void atEndOfTurn(boolean isPlayer) {
        if (this.amount >= 1) {
            this.addToBot(new DamageAction(this.owner, new DamageInfo(this.source, this.amount, DamageInfo.DamageType.THORNS)));
        }
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }


    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new ConstrictingPower(owner, this.owner, amount);
    }

    @Override
    public int getHealthBarAmount() {
        // Only show a health bar preview if the amount is at least 1
        if (this.amount >= 1) {
            return amount;
        } else {
            return 0; // Return 0 to prevent the health bar from extending in the negative direction
        }
    }


    @Override
    public Color getColor() {
        return Color.valueOf(("#2c971d"));
    }
}

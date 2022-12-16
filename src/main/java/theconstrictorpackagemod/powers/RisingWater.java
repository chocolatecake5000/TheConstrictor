package theconstrictorpackagemod.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;


import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class RisingWater extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("RisingWater");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public RisingWater(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }



    public void atEndOfTurn(boolean isPlayer) {
        if (isPlayer) {
            this.flash();
            Iterator var2 = AbstractDungeon.getMonsters().monsters.iterator();

            this.addToBot(new ApplyPowerAction(this.owner, this.owner, new RisingWater(this.owner, 1), 1));
            this.addToBot(new DamageAllEnemiesAction((AbstractCreature)null, DamageInfo.createDamageMatrix(this.amount + 1, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE, true));
        }

    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }


    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new RisingWater(owner, amount);
    }

}

package theconstrictorpackagemod.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;


import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class NotNoxious extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("NotNoxious");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;
    //The only thing this controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if they're a buff or debuff.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public NotNoxious(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }



    public void atStartOfTurnPostDraw() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();
            Iterator var1 = AbstractDungeon.getMonsters().monsters.iterator();

            while(var1.hasNext()) {
                AbstractMonster m = (AbstractMonster)var1.next();
                if (!m.isDead && !m.isDying) {
                    this.addToBot(new ApplyPowerAction(m, this.owner, new ConstrictingPower(m, this.owner, this.amount), this.amount));
                }
            }
        }

    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }


    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new NotNoxious(owner, amount);
    }

}

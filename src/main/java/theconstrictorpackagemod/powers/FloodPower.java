package theconstrictorpackagemod.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.OnReceivePowerPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class FloodPower extends BasePower implements OnReceivePowerPower {
    public static final String POWER_ID = makeID("FloodPower");

    public FloodPower(AbstractCreature owner, int amount) {
        super(POWER_ID, PowerType.BUFF, false, owner, amount);
    }

    @Override
    public void updateDescription() {
            description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }

    @Override
    public boolean onReceivePower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if (power.ID.equals(RisingWater.POWER_ID)) {
            flash();
            power.amount += this.amount;
        }
        return true;
    }

    @Override
    public int onReceivePowerStacks(AbstractPower power, AbstractCreature target, AbstractCreature source, int stackAmount) {
        if (power.ID.equals(RisingWater.POWER_ID)) {
            flash();
            return stackAmount + this.amount;
        }
        return stackAmount;
    }
}

package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.theconstrictormod;
import theconstrictorpackagemod.util.CardInfo;

public class Flow extends BaseCard {
    private static final CardInfo cardInfo;
    public static final String ID;

    public Flow() {
        super(cardInfo);
        this.baseBlock = 6;
        this.magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, p, this.block));

        AbstractPower conPower = AbstractDungeon.player.getPower(ConstrictingPower.POWER_ID);
        if (conPower != null && conPower.amount > 0) {
            this.addToBot(new GainEnergyAction(1));
            this.addToBot(new DrawCardAction(1));
        }
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(3);
        }

    }

    static {
        cardInfo = new CardInfo("Flow", 1, CardType.SKILL, CardTarget.SELF, CardRarity.UNCOMMON, MyCharacter.Enums.CARD_COLOR);
        ID = theconstrictormod.makeID(cardInfo.baseId);
    }
}

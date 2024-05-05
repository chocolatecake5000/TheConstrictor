package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.theconstrictormod;
import theconstrictorpackagemod.util.CardInfo;

public class StickyPenny extends BaseCard {
    private static final CardInfo cardInfo;
    public static final String ID;

    public StickyPenny() {
        super(cardInfo);
        this.magicNumber = 0;
        this.exhaust = true;
        this.tags.add(CardTags.HEALING);
        this.upgRetain = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DrawCardAction(this.magicNumber));
        AbstractDungeon.player.gainGold(10);
    }

    public void applyPowers() {
        AbstractPower ConPower = AbstractDungeon.player.getPower(ConstrictingPower.POWER_ID);
        if (ConPower != null) {
            if (ConPower.amount > 0) {
                this.setMagic(3);
            }

            if (ConPower.amount < 0) {
                this.setMagic(0);
            }

            if (ConPower.amount == 0) {
                this.setMagic(0);
            }
        }

        super.applyPowers();
    }

    public void calculateCardDamage(AbstractMonster mo) {
        AbstractPower ConPower = AbstractDungeon.player.getPower(ConstrictingPower.POWER_ID);
        if (ConPower != null) {
            if (ConPower.amount > 0) {
                this.setMagic(3);
            }

            if (ConPower.amount < 0) {
                this.setMagic(0);
            }

            if (ConPower.amount == 0) {
                this.setMagic(0);
            }
        }

        super.applyPowers();
    }

    static {
        cardInfo = new CardInfo("StickyPenny", 0, CardType.SKILL, CardTarget.SELF, CardRarity.RARE, MyCharacter.Enums.CARD_COLOR);
        ID = theconstrictormod.makeID(cardInfo.baseId);
    }
}

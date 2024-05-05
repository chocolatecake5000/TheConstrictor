package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.VerticalImpactEffect;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class Flow extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Flow",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public Flow() {
        super(cardInfo);
        this.baseBlock = 6;
        this.magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p,p,this.block));
        addToBot(new DrawCardAction(magicNumber));
        addToBot(new GainEnergyAction(magicNumber));
    }
    public void applyPowers() {
        AbstractPower ConPower = AbstractDungeon.player.getPower(ConstrictingPower.POWER_ID);

        if (ConPower != null) {
            if (ConPower.amount > 0) {
                setMagic(1);
            }
            if (ConPower.amount < 0) {
                setMagic(0);
            }
            if (ConPower.amount == 0) {
                setMagic(0);
            }


        }
        super.applyPowers();
    }

    public void calculateCardDamage(AbstractMonster mo) {
        AbstractPower ConPower = AbstractDungeon.player.getPower(ConstrictingPower.POWER_ID);

        if (ConPower != null) {
            if (ConPower.amount > 0) {
                setMagic(1);
            }
            if (ConPower.amount < 0) {
                setMagic(0);
            }
            if (ConPower.amount == 0) {
                setMagic(0);
            }


        }
        super.applyPowers();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(3);
        }

    }
}
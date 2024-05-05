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

public class StickyPenny extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "StickyPenny",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public StickyPenny() {
        super(cardInfo);
        this.magicNumber = 0;
        this.exhaust = true;
        tags.add(CardTags.HEALING);
        upgRetain = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DrawCardAction(magicNumber));
        AbstractDungeon.player.gainGold(10);
    }
    public void applyPowers() {
        AbstractPower ConPower = AbstractDungeon.player.getPower(ConstrictingPower.POWER_ID);

        if (ConPower != null) {
            if (ConPower.amount > 0) {
                setMagic(3);
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
                setMagic(3);
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



}
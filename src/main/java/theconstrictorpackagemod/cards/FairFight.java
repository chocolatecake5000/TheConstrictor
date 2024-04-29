package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.VerticalImpactEffect;
import theconstrictorpackagemod.powers.RisingWater;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class FairFight extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FairFight",
            2,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);



    public FairFight() {
        super(cardInfo);
        this.baseDamage = 0;
        this.baseMagicNumber = (4);
        this.magicNumber = this.baseMagicNumber;
        isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new RisingWater(AbstractDungeon.player,magicNumber)));
        if (m != null) {
            this.addToBot(new VFXAction(new VerticalImpactEffect(m.hb.cX + m.hb.width / 4.0F, m.hb.cY - m.hb.height / 4.0F)));
        }

        this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
    }
    public void applyPowers() {
        AbstractPower WaterPower = AbstractDungeon.player.getPower(RisingWater.POWER_ID);
        int actualBaseDamage = this.baseDamage;
        if (WaterPower != null) {
            this.baseDamage += WaterPower.amount + magicNumber;
        }
        else{
            this.baseDamage += magicNumber;
        }

        super.applyPowers();
        this.baseDamage = actualBaseDamage;
        this.isDamageModified = this.baseDamage != this.damage;



    }

    public void calculateCardDamage(AbstractMonster mo) {
        AbstractPower WaterPower = AbstractDungeon.player.getPower(RisingWater.POWER_ID);
        int actualBaseDamage = this.baseDamage;
        if (WaterPower != null) {
            this.baseDamage += WaterPower.amount + magicNumber;
        }
        else{
            this.baseDamage += magicNumber;
        }

        super.calculateCardDamage(mo);
        this.baseDamage = actualBaseDamage;
        this.isDamageModified = this.baseDamage != this.damage;

    }
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(2);
        }

    }

}


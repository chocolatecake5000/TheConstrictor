package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.VerticalImpactEffect;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static java.lang.Math.abs;
import static theconstrictorpackagemod.theconstrictormod.makeID;

public class StrangledStrike extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "StrangledStrike",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    public StrangledStrike() {
        super(cardInfo);
        tags.add(CardTags.STRIKE);
        this.setDamage(6, 4);
        this.baseMagicNumber = (1);
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m != null) {
            this.addToBot(new VFXAction(new VerticalImpactEffect(m.hb.cX + m.hb.width / 4.0F, m.hb.cY - m.hb.height / 4.0F)));
        }

        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
    }
    public void applyPowers() {
        AbstractPower ConPower = AbstractDungeon.player.getPower(ConstrictingPower.POWER_ID);
        int actualBaseDamage = this.baseDamage;
        if (ConPower != null) {
            this.baseDamage += abs(ConPower.amount) * this.magicNumber;
        }

        super.applyPowers();
        this.baseDamage = actualBaseDamage;
        this.isDamageModified = this.baseDamage != this.damage;



    }

    public void calculateCardDamage(AbstractMonster mo) {
        AbstractPower ConPower = AbstractDungeon.player.getPower(ConstrictingPower.POWER_ID);
        int actualBaseDamage = this.baseDamage;
        if (ConPower != null) {
            this.baseDamage += abs(ConPower.amount) * this.magicNumber;
        }

        super.calculateCardDamage(mo);
        this.baseDamage = actualBaseDamage;
        this.isDamageModified = this.baseDamage != this.damage;

    }


}


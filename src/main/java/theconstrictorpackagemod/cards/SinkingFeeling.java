package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.GraveField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;

import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class SinkingFeeling extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SinkingFeeling",
            2,
            CardType.ATTACK,
            CardTarget.ALL,
            CardRarity.BASIC,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    public SinkingFeeling() {
        super(cardInfo);
        setMagic(2, 1);
        GraveField.grave.set(this, true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        Iterator<AbstractMonster> var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        while (var3.hasNext()) {
            AbstractMonster mo = var3.next();
            if (mo.hasPower(ConstrictingPower.POWER_ID)) {
                int constrictAmount = mo.getPower(ConstrictingPower.POWER_ID).amount;
                int damage = constrictAmount * 2;
                this.addToBot(new DamageAction(mo, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            }
        }
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(1);
        }

    }

}


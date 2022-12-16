package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.SkewerAction;
import com.megacrit.cardcrawl.cards.green.Skewer;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class SwordfishSlam extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SwordfishSlam",
            -1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    public SwordfishSlam() {
        super(cardInfo);
        setDamage(9,2);

    }


    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new SkewerAction(p, m, this.damage, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));
    }

    public AbstractCard makeCopy() {
        return new SwordfishSlam();
    }




}


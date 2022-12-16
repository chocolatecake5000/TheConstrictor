
package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.powers.CorpseExplosionPower;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class ChumInTheWater extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ChumInTheWater",
            2,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);



    public ChumInTheWater() {
        super(cardInfo);
        setMagic(6,3);


    }
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(m, p, new ConstrictingPower(m, p, this.magicNumber), this.magicNumber));
        this.addToBot(new ApplyPowerAction(m, p, new CorpseExplosionPower(m), 1, AbstractGameAction.AttackEffect.POISON));

    }
}


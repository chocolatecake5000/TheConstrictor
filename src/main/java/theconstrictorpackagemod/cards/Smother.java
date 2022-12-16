
package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.powers.WeakPower;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class Smother extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Smother",
            1,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);



    public Smother() {
        super(cardInfo);
        setMagic(2,1);


    }
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
        this.addToBot(new ApplyPowerAction(m, p, new ConstrictingPower(m, p, this.magicNumber), this.magicNumber));


    }
}


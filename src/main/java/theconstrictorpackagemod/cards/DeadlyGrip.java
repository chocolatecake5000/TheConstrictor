
package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.powers.ChokePower;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class DeadlyGrip extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DeadlyGrip",
            1,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);



    public DeadlyGrip() {
        super(cardInfo);
        setMagic(3,1);


    }
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(m, p, new ChokePower(m, this.magicNumber), this.magicNumber));
        this.addToBot(new ApplyPowerAction(m, p, new ConstrictingPower(m, p, this.magicNumber), this.magicNumber));


    }
}


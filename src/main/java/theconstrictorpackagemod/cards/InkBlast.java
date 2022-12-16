
package theconstrictorpackagemod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class InkBlast extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "InkBlast",
            1,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);



    public InkBlast() {
        super(cardInfo);
        setMagic(1,1);


    }
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, 1, false), this.magicNumber));
        this.addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, 1, false), this.magicNumber));
        this.addToBot(new DrawCardAction(magicNumber));


    }
}


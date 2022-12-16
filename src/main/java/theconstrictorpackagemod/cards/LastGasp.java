package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class LastGasp extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LastGasp",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);



    public LastGasp() {
        super(cardInfo,true);
        this.exhaust = true;
        setInnate(false, true);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DrawCardAction(2));
        addToBot(new GainEnergyAction(1));

    }


}


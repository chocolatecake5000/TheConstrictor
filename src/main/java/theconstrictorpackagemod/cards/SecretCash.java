package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class SecretCash extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SecretCash",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);




    public SecretCash() {
        super(cardInfo);
        this.cardsToPreview = new DustyShiv();
        setMagic(2,1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new MakeTempCardInHandAction(new DustyShiv(), this.magicNumber));

    }
}
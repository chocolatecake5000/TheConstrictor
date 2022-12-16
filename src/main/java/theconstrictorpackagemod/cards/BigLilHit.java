package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class BigLilHit extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BigLilHit",
            4,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);




    public BigLilHit() {
        super(cardInfo);
        this.exhaust = true;
        this.cardsToPreview = new MyCard();
        setMagic(5);
    }
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(3);
        }

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new MakeTempCardInHandAction(new MyCard(), this.magicNumber));

    }
}
package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class FishyShield extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FishyShield",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            MyCharacter.Enums.CARD_COLOR);


    public static final String ID = makeID(cardInfo.baseId);


    private static final int BLOCK = 2;
    private static final int UPG_BLOCK = 2;

    public FishyShield() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        this.cardsToPreview = new DustyShiv();
        setMagic(1,1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToBot(new MakeTempCardInHandAction(new DustyShiv(), this.magicNumber));

    }
}
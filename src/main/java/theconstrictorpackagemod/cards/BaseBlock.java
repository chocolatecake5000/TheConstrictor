package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class BaseBlock extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BaseBlock",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);


    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;


    public BaseBlock() {
        super(cardInfo);
        tags.add(CardTags.STARTER_DEFEND); //This tag marks it as a basic Strike

        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
    }
}
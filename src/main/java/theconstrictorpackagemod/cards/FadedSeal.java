
package theconstrictorpackagemod.cards;


import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class FadedSeal extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FadedSeal",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);


    public FadedSeal() {
        super(cardInfo);
        setBlock(10,3);
        upgRetain = true;
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        this.cantUseMessage = "This card is unplayable!";
        return false;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    public void triggerOnExhaust() {
        this.addToBot(new GainBlockAction(AbstractDungeon.player,AbstractDungeon.player,block));
    }
}

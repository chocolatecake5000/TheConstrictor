package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.theconstrictormod;
import theconstrictorpackagemod.util.CardInfo;

public class FadedSeal extends BaseCard {
    private static final CardInfo cardInfo;
    public static final String ID;

    public FadedSeal() {
        super(cardInfo);
        this.setBlock(10, 3);
        this.upgRetain = true;
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        this.cantUseMessage = "This card is unplayable!";
        return false;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
    }

    public void triggerOnExhaust() {
        this.addToBot(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, this.block));
    }

    static {
        cardInfo = new CardInfo("FadedSeal", -2, CardType.SKILL, CardTarget.SELF, CardRarity.COMMON, MyCharacter.Enums.CARD_COLOR);
        ID = theconstrictormod.makeID(cardInfo.baseId);
    }
}

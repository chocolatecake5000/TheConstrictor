
package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.powers.InfiniteDustPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class InfiniteDust extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "InfiniteDust",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public InfiniteDust() {
        super(cardInfo);
        setMagic(1);
        this.cardsToPreview = new DustyShiv();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new InfiniteDustPower(AbstractDungeon.player,magicNumber)));
        if (this.upgraded)this.addToBot(new MakeTempCardInHandAction(new DustyShiv(), this.magicNumber));
    }

}
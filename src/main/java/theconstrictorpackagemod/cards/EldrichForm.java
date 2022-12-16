
package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.RegenPower;
import theconstrictorpackagemod.powers.EldrichFormPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class EldrichForm extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "EldrichForm",
            3,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public EldrichForm() {
        super(cardInfo);
        setMagic(1);
        this.cardsToPreview = new EldrichBlast();
setInnate(false,true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new EldrichFormPower(AbstractDungeon.player,magicNumber)));
    }

}
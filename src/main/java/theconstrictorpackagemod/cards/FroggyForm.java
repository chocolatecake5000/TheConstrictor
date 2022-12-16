
package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.RegenPower;
import theconstrictorpackagemod.powers.FroggyFormPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class FroggyForm extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FroggyForm",
            3,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public FroggyForm() {
        super(cardInfo);
        setEthereal(true, false);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new FroggyFormPower(AbstractDungeon.player,1)));
    }
}
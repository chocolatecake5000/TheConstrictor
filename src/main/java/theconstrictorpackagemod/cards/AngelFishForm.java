
package theconstrictorpackagemod.cards;

import basemod.helpers.BaseModCardTags;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.EchoPower;
import com.megacrit.cardcrawl.powers.RegenPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class AngelFishForm extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AngelFishForm",
            3,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    public AngelFishForm() {
        super(cardInfo);
        setInnate(false, true);
        tags.add(BaseModCardTags.FORM);
    }


    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new EchoPower(p, 1), 1));
    }

}
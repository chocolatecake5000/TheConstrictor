
package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.RegenPower;
import com.megacrit.cardcrawl.powers.SadisticPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class Sadistic extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Sadistic",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public Sadistic() {
        super(cardInfo);
        setMagic(4,2);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new SadisticPower(AbstractDungeon.player,magicNumber)));
    }
}
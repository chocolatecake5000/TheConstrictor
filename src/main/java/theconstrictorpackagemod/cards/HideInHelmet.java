
package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.MetallicizePower;
import com.megacrit.cardcrawl.powers.RegenPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class HideInHelmet extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HideInHelmet",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public HideInHelmet() {
        super(cardInfo);
        setMagic(3,1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new MetallicizePower(AbstractDungeon.player,magicNumber)));
    }
}
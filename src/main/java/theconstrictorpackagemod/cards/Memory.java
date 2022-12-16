
package theconstrictorpackagemod.cards;

import basemod.helpers.dynamicvariables.MagicNumberVariable;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.BetterDiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class Memory extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Memory",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);



    public Memory() {
        super(cardInfo);
        this.exhaust = true;
        setMagic(2,1);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new BetterDiscardPileToHandAction(magicNumber));
    }
}
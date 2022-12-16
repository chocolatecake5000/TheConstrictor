
package theconstrictorpackagemod.cards;

import basemod.helpers.dynamicvariables.MagicNumberVariable;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import com.megacrit.cardcrawl.powers.ThornsPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class CoolOff extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "CoolOff",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);


    private static final int BLOCK = 7;
    private static final int UPG_BLOCK = 3;


    public CoolOff() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, 1), 1));
    }
}
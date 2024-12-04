
package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.powers.RisingWater;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class RoleReversal extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RoleReversal",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);
    private static final int BLOCK = 11;
    private static final int UPG_BLOCK = 3;


    public RoleReversal() {
        super(cardInfo);

        setMagic(2,1);
        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new RisingWater(AbstractDungeon.player, magicNumber), magicNumber));
    }
}
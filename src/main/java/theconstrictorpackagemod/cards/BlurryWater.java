
package theconstrictorpackagemod.cards;

import basemod.helpers.dynamicvariables.MagicNumberVariable;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;
import com.megacrit.cardcrawl.powers.ThornsPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class BlurryWater extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BlurryWater",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);


    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;


    public BlurryWater() {
        super(cardInfo);
        setMagic(1);
        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BlurPower(AbstractDungeon.player,magicNumber)));
    }
}
package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class NotIntoIt extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "NotIntoIt",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);


    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 3;

    public NotIntoIt() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(4,2);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ConstrictingPower(AbstractDungeon.player, p, -magicNumber), -magicNumber));
    }
}
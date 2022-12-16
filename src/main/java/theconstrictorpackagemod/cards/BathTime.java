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

public class BathTime extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BathTime",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);



    public BathTime() {
        super(cardInfo);
        this.exhaust = true;
        setInnate(true);
        setMagic(4,2);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ConstrictingPower(AbstractDungeon.player, p, -magicNumber), -magicNumber));
    }
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(0);
            this.upgradeMagicNumber(2);
        }

    }
}
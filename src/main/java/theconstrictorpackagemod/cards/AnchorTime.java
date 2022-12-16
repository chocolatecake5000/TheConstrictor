package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.unique.ApplyBulletTimeAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class AnchorTime extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AnchorTime",
            3,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);


    public AnchorTime() {
        super(cardInfo);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ConstrictingPower(AbstractDungeon.player, p, 4), 4));
        this.addToBot(new ApplyBulletTimeAction());
    }
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(2);
        }

    }
}
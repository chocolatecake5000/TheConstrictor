
package theconstrictorpackagemod.cards;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NoxiousFumesPower;
import theconstrictorpackagemod.powers.ConstrictingPower;
import theconstrictorpackagemod.powers.NotNoxious;
import theconstrictorpackagemod.util.CardInfo;

import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class SmellyFish extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SmellyFish",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);


    public SmellyFish() {
        super(cardInfo);
        setMagic(2, 1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new NotNoxious(p, this.magicNumber), this.magicNumber));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }
}
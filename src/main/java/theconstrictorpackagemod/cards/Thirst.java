
package theconstrictorpackagemod.cards;

import basemod.patches.com.megacrit.cardcrawl.helpers.PotionLibrary.PotionHelperGetPotion;
import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.potions.DuplicationPotion;
import com.megacrit.cardcrawl.powers.RegenPower;
import theconstrictorpackagemod.util.CardInfo;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class Thirst extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Thirst",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            MyCharacter.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);




    public Thirst() {
        super(cardInfo);
        this.exhaust = true;
        this.tags.add(CardTags.HEALING);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ObtainPotionAction(new DuplicationPotion()));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(0);
        }

    }
}
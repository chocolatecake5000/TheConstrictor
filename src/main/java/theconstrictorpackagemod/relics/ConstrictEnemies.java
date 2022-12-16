package theconstrictorpackagemod.relics;

import characterclass.MyCharacter;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theconstrictorpackagemod.powers.ConstrictingPower;

import java.util.Iterator;

import static theconstrictorpackagemod.theconstrictormod.makeID;

public class ConstrictEnemies extends BaseRelic {
    private static final String NAME = "ConstrictEnemies"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.SHOP; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.
    private static final int POISON_AMT = 4;

    public ConstrictEnemies() {
        super(ID, NAME, MyCharacter.Enums.CARD_COLOR, RelicTier.SHOP, LandingSound.CLINK);
    }

    public void atBattleStart() {
        this.flash();
        Iterator var1 = AbstractDungeon.getMonsters().monsters.iterator();

        while(var1.hasNext()) {
            AbstractMonster m = (AbstractMonster)var1.next();
            if (!m.isDead && !m.isDying) {
                this.addToBot(new ApplyPowerAction(m, AbstractDungeon.player, new ConstrictingPower(m, m, 4), 4));
            }
        }

    }
    @Override
    public String getUpdatedDescription() {
        return String.format(DESCRIPTIONS[0]);
    }
}
package me.hiro3.tentacle;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle.DustOptions;
import org.bukkit.entity.Player;

import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.ability.AddonAbility;
import com.projectkorra.projectkorra.ability.AirAbility;
import com.projectkorra.projectkorra.ability.ComboAbility;
import com.projectkorra.projectkorra.ability.util.ComboManager.AbilityInformation;
import com.projectkorra.projectkorra.util.ClickType;

public class TentacleTest extends AirAbility implements AddonAbility, ComboAbility {


	private Tentacle tentacle;
	
	private long duration;
	
	public TentacleTest(Player player) {
		super(player);
		
		if (bPlayer.isOnCooldown(this)) {
			return;
		}
		
		if (!bPlayer.canBendIgnoreBindsCooldowns(this)) {
			return;
		}
		
		this.duration = 20000;
		
		this.tentacle = new Tentacle(player.getEyeLocation(), 10, 100, 1, new DustOptions(Color.RED, 0.35F));
		this.tentacle.setAttached(false);
		
		bPlayer.addCooldown(this);
		start();
	}

	@Override
	public void progress() {
		
		if (System.currentTimeMillis() > getStartTime() + this.duration) {
			remove();
			return;
		}
		
		if (System.currentTimeMillis() > getStartTime() + this.duration / 2) {
			this.tentacle.setAttached(true);
		}
		
		//this.tentacle.setLength(this.tentacle.getLength() - 0.05);
		this.tentacle.reach(player.getEyeLocation().add(player.getLocation().getDirection().multiply(7)));
		this.tentacle.display();
	}
	
	@Override
	public long getCooldown() {
		return this.duration;
	}

	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public String getName() {
		return "TentacleTest";
	}

	@Override
	public boolean isHarmlessAbility() {
		return false;
	}
	
	@Override
	public boolean isSneakAbility() {
		return false;
	}

	@Override
	public Object createNewComboInstance(Player player) {
		return new TentacleTest(player);
	}

	@Override
	public ArrayList<AbilityInformation> getCombination() {
		ArrayList<AbilityInformation> combination = new ArrayList<>();
		combination.add(new AbilityInformation("AirShield", ClickType.LEFT_CLICK));

		return combination;
	}

	@Override
	public String getAuthor() {
		return "Hiro3";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void load() {
		ProjectKorra.log.info("Succesfully enabled " + getName() + " by " + getAuthor());
	}

	@Override
	public void stop() {
		ProjectKorra.log.info("Successfully disabled " + getName() + " by " + getAuthor());
		super.remove();
	}
}

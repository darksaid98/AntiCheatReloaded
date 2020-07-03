/*
 * AntiCheatReloaded for Bukkit and Spigot.
 * Copyright (c) 2012-2015 AntiCheat Team
 * Copyright (c) 2016-2020 Rammelkast
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.rammelkast.anticheatreloaded.config.holders.yaml;

import com.rammelkast.anticheatreloaded.AntiCheatReloaded;
import com.rammelkast.anticheatreloaded.check.CheckType;
import com.rammelkast.anticheatreloaded.config.Configuration;
import com.rammelkast.anticheatreloaded.config.ConfigurationFile;
import com.rammelkast.anticheatreloaded.config.providers.Checks;

public class YamlChecksHolder extends ConfigurationFile implements Checks {

    public static final String FILENAME = "checks.yml";

    public YamlChecksHolder(AntiCheatReloaded plugin, Configuration config) {
        super(plugin, config, FILENAME);
    }

    @Override
    public void open() {
 
    }

	@Override
	public boolean getBoolean(CheckType checkType, String subcheck, String name) {
		return this.getConfigFile().getConfigurationSection(checkType.name().toLowerCase()).getConfigurationSection(subcheck)
				.getBoolean(name);
	}

	@Override
	public boolean isSubcheckEnabled(CheckType checkType, String subcheck) {
		return this.getBoolean(checkType, subcheck, "enabled");
	}

	@Override
	public double getDouble(CheckType checkType, String subcheck, String name) {
		return this.getConfigFile().getConfigurationSection(checkType.name().toLowerCase()).getConfigurationSection(subcheck)
				.getDouble(name);
	}

	@Override
	public int getInteger(CheckType checkType, String subcheck, String name) {
		return this.getConfigFile().getConfigurationSection(checkType.name().toLowerCase()).getConfigurationSection(subcheck)
				.getInt(name);
	}

	@Override
	public boolean getBoolean(CheckType checkType, String name) {
		return this.getConfigFile().getConfigurationSection(checkType.name().toLowerCase()).getBoolean(name);
	}

	@Override
	public double getDouble(CheckType checkType, String name) {
		return this.getConfigFile().getConfigurationSection(checkType.name().toLowerCase()).getDouble(name);
	}

	@Override
	public int getInteger(CheckType checkType, String name) {
		return this.getConfigFile().getConfigurationSection(checkType.name().toLowerCase()).getInt(name);
	}

	@Override
	public boolean isEnabled(CheckType checkType) {
		// If the root of a check has no enabled or disabled option, it has to be configured on a subcheck basis
		if (!this.getConfigFile().getConfigurationSection(checkType.name().toLowerCase()).contains("enabled"))
			return true;
		return this.getConfigFile().getConfigurationSection(checkType.name().toLowerCase()).getBoolean("enabled");
	}
}

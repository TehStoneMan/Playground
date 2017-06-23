package io.github.tehstoneman.playground.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDigitalMiner extends Block
{
	/*
	 * Separate the Digital Miner from the machine blocks to facilitate support for standard Minecraft blockstates and models
	 */
	public BlockDigitalMiner()
	{
		super( Material.IRON );
		setHardness(3.5F);
		setResistance(16F);
	}
}

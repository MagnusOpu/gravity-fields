package net.magnusopu.gravityfields.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * Copyright (C) 2016 MagnusOpu.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * <p>
 * Contact me at zacharydsturtz@gmail.com
 */
public class ContainerBase extends Container {

    protected final IInventory tileBase;
    protected final int sizeInventory;

    public ContainerBase(InventoryPlayer inventoryPlayer, IInventory inventory){
        System.out.println("ContainerBase constructor()");

        tileBase = inventory;
        sizeInventory = tileBase.getSizeInventory();

        int i;

        for(i=0;i<3;i++){
            for(int j=0;j<9;j++){
                addSlotToContainer(new Slot(inventoryPlayer, j+i*9+9, 8+j*18, 84+i*18));
            }
        }

        for(i = 0; i < 9; i++){
            addSlotToContainer(new Slot(inventoryPlayer, i, 8+i*18, 142));
        }
    }

    @Override
    public void addListener(IContainerListener listener){
        super.addListener(listener);
        listener.sendAllWindowProperties(this, tileBase);
    }

    @Override
    public void updateProgressBar(int id, int data){
        tileBase.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn){
        return tileBase.isUseableByPlayer(playerIn);
    }

}

import React, { useEffect, useState } from 'react';
import inventoryService from '../services/inventoryService';

const InventoryPage = () => {
    const [inventories, setInventories] = useState([]);

    useEffect(() => {
        const fetchInventories = async () => {
            const response = await inventoryService.getAllInventories();
            setInventories(response.data);
        };
        fetchInventories();
    }, []);
    const handleUpdate = async (inventory) => {
        try {
            const updatedInventory = { ...inventory, availableQuantity: inventory.availableQuantity - 1 };
            await inventoryService.updateInventory(updatedInventory);
            setInventories(inventories.map(inv => inv.id === inventory.id ? updatedInventory : inv));
        } catch (error) {
            console.error('Error updating inventory:', error);
        }
    };

    return (
        <div>
            <h1>Inventory</h1>
            <ul>
                {inventories.map(inventory => (
                    <li key={inventory.id}> {inventory.locationNumber} - {inventory.materialId} - {inventory.availableQuantity}
                        <button onClick={() => handleUpdate(inventory)}>Update</button></li>
                ))}
            </ul>
        </div>
    );
};

export default InventoryPage;

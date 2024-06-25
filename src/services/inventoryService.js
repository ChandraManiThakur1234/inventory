import axios from 'axios';

const API_URL = 'http://localhost:8080/api/inventory';

const getAllInventories = () => {
    return axios.get(API_URL);
};

const updateInventory = (inventory) => {
    return axios.put(API_URL, inventory);
};

export default {
    getAllInventories,
    updateInventory
};

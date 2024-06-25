import axios from 'axios';

const API_URL = 'http://localhost:8080/api/orders/';

const createOrder = (order) => {
    return axios.post(API_URL, order);
};

const getAllOrders = () => {
    return axios.get(API_URL);
};

export default {
    createOrder,
    getAllOrders
};

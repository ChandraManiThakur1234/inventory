import axios from 'axios';

const API_URL = 'http://localhost:8080/api/users/';

const register = (username, email, password,isAdmin) => {
    return axios.post(API_URL + 'register', {
        username,
        email,
        password,
        isAdmin
    });
};

const login = (username, password) => {
    return axios.post(API_URL + 'login', {
        username,
        password
    });
};

export default {
    register,
    login
};

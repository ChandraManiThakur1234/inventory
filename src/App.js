import React from 'react';
import { Routes, Route } from 'react-router-dom';
import LoginPage from './components/Login';
import RegisterPage from './components/Register';
import InventoryPage from './components/Inventory';
import AdminPage from './components/AdminPage';
import UserPage from './components/UserPage';
import OrderPage from './components/OrderPage';

function App() {
    return (
        <Routes>
            <Route path="/login" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage />} />
            <Route path="/inventory" element={<InventoryPage />} />
            <Route path="/admin" element={<AdminPage />} />
            <Route path="/user" element={<UserPage />} />
            <Route path="/orders" element={<OrderPage />} />
            <Route path="/" element={<LoginPage />} />
        </Routes>
    );
}

export default App;

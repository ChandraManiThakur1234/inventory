import React, { useState } from 'react';
import authService from '../services/authService';

const RegisterPage = () => {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [isAdmin, setIsAdmin] = useState(false);

    const handleRegister = async (e) => {
        e.preventDefault();
        try {
            const response = await authService.register({ username, email, password, isAdmin });
            console.log(response.data);
            // Redirect to login or dashboard
        } catch (error) {
            console.error('Registration failed');
        }
    };

    return (
        <form onSubmit={handleRegister}>
            <input 
                type="text" 
                placeholder="Username" 
                value={username} 
                onChange={(e) => setUsername(e.target.value)} 
            />
            <input 
                type="email" 
                placeholder="Email" 
                value={email} 
                onChange={(e) => setEmail(e.target.value)} 
            />
            <input 
                type="password" 
                placeholder="Password" 
                value={password} 
                onChange={(e) => setPassword(e.target.value)} 
            />
            <div>
                <label>
                    <input
                        type="checkbox"
                        checked={isAdmin}
                        onChange={(e) => setIsAdmin(e.target.checked)}
                    />
                    I am an admin
                </label>
            </div>
            <button type="submit">Register</button>
        </form>
    );
};

export default RegisterPage;

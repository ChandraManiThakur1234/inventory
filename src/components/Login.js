import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import authService from '../services/authService';

const LoginPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [isAdminChecked, setIsAdminChecked] = useState(false);
    const [adminPassword, setAdminPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await authService.login(username, password);
            const user = response.data;
            console.log(user);

            if (isAdminChecked) {
                if (user.admin) {
                    const hardcodedAdminPassword = 'hardcodedAdminPassword';
                    if (adminPassword === hardcodedAdminPassword) {
                        navigate('/inventory');
                    } else {
                        setError('Invalid admin password');
                    }
                } else {
                    setError('User is not an admin');
                }
            } else {
                navigate('/inventory');
            }
        } catch (error) {
            setError('Invalid credentials');
        }
    };

    return (
        <div>
            <form onSubmit={handleLogin}>
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
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
                            checked={isAdminChecked}
                            onChange={(e) => setIsAdminChecked(e.target.checked)}
                        />
                        I am an admin
                    </label>
                </div>
                {isAdminChecked && (
                    <input
                        type="password"
                        placeholder="Admin Password"
                        value={adminPassword}
                        onChange={(e) => setAdminPassword(e.target.value)}
                    />
                )}
                <button type="submit">Login</button>
            </form>
            {error && <p style={{ color: 'red' }}>{error}</p>}
        </div>
    );
};

export default LoginPage;

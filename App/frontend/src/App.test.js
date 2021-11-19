import { render, screen } from '@testing-library/react';
import App from './App';
import Register from "./Components/Register.jsx";

test('renders navigation bar', () => {
    render(<NavigationBar />);
    expect(screen.getByText(/register)).toBeInTheDocument();
});
